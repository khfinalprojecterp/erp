package com.kh.erp.sale.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.materials.model.vo.Materials;
import com.kh.erp.product.model.vo.Product;
import com.kh.erp.sale.model.exception.SaleException;
import com.kh.erp.sale.model.vo.Partner;
import com.kh.erp.sale.model.vo.Sale;
import com.kh.erp.sale.model.vo.SaleItem;
import com.kh.erp.storage.model.vo.Storage;
import com.kh.erp.storage.model.vo.StorageDetail;

@Repository
public class SaleDaoImpl implements SaleDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int registPartner(Partner partner) {
		return sqlSession.insert("sales.registPartner", partner);
	}// 거래처를 지정한 이름으로 등록

	@Override
	public int checkPartner(Partner partner) {
		return sqlSession.selectOne("sales.checkPartner", partner);
	}// 거래처가 존재하는지 확인 => 등록시 check

	@Override
	public int changeParSts(Partner partner) {
		return sqlSession.update("sales.changeParSts", partner);
	}// 거래처의 거래상태를 변경(삭제 (t or s))

	@Override
	public int changeParName(Partner partner) {
		return sqlSession.update("sales.changeParName", partner);
	}// 거래처의 이름을 변경

	
//	거래처, 자재, 물품, 창고 , 창고내물품 조회용 메소드
	@Override
	public List<Partner> selectPartner(int eCode){
		return sqlSession.selectList("sales.selectPartner",eCode);
	}
	@Override
	public List<Materials> selectMaterial() {
		return sqlSession.selectList("sales.selectMaterial");
	}

	@Override
	public List<Product> selectProduct() {
		return sqlSession.selectList("sales.selectProduct");
	}

	@Override
	public List<Storage> selectStorage(int ecode) {
		return sqlSession.selectList("sales.selectStorage", ecode);
	}

	@Override
	public List<StorageDetail> selectDetailList(int ecode) {
		return sqlSession.selectList("sales.selectDetailList", ecode);
	}// 창고 상세를 전부 받아오기
	
	@Override
	public 	List<Employee> selectEmployeeList(int eCode) {
		return sqlSession.selectList("sales.selectEmployeeList",eCode);
	}

	
	@Override
	public int saleItem(List<StorageDetail> itemList) {
//		service 에서 가져온 list itemList(판매할 물건)를
//		해체해서  한번씩 update 수행
		int result = 1;
		int maxnum = 0;
		if (!itemList.isEmpty())
			for (StorageDetail sdi : itemList) {

//			현재 itemList의 SDSTOCK은 판매할 갯수로 변경된 상태
//			그러므로 STORAGE_DETAIL의 정보와 비교해서
//			갯수가 다르면 (최대수량보다 판매량이 적으면)
//			UPDATE를
//			갯수가 같으면 (판매수량이 최대수량이면)
//			DELETE를 실행해 창고내에서 물건 현황을 변동시킨다.
				maxnum = sqlSession.selectOne("sales.itemMaxnum", sdi.getSdCode());// 창고에 존재하는 어떤 물건의 현재갯수를 구함
				if (maxnum <= 0)
					throw new SaleException("maxnum is "+maxnum+"(물품이 존재하지 않음)");
				else if (maxnum > sdi.getSdStock()) {
					if (sqlSession.update("sales.saleItem", sdi) <= 0) {//maxnum - 판매갯수를 갯수로 update
						result = 0;
						sqlSession.rollback();
						throw new SaleException("판매 등록중 오류가 발생했습니다.(1)");
					}
				} else if (maxnum == sdi.getSdStock()) {// 판매하는 물건이 최대갯수면
					if (sqlSession.delete("sales.deleteItem", sdi.getSdCode()) <= 0) {
						result = 0;
						sqlSession.rollback();
						throw new SaleException("판매 등록중 오류가 발생했습니다.(2)");
					}
				}

			} // end for
		else {
			sqlSession.rollback();
			throw new SaleException("판매할 자재/물건을 선택하지 않았습니다.");
		}

		return result;
//		이 쿼리의 결과로 saleRegist 수행(1일때);
	}// 판매 기능 수행시 직접적으로 창고 물건을 지우거나 갯수를 수정하는 메서드
//	(sdstock에는 판매할 갯수가 지정되야함)

	@Override
	public int saleRegist(Sale sale, List<SaleItem> itemList) {
		int result = 1;
		if (sale != null) {
			result = sqlSession.insert("sales.saleRegist", sale);
			if (result > 0) {
				for (SaleItem it : itemList)
					result = sqlSession.insert("sales.itemRegist", it);
				if (result < 1) {
					sqlSession.rollback();
					throw new SaleException("SaleItem insert fail");
				}
			} else {
				sqlSession.rollback();
				throw new SaleException("sale insert fail");
			}
		} else {
			sqlSession.rollback();
			throw new SaleException("sale Data is null (SaleDaoImpl)");
		}

		return result;
	}// 판매 기록과 판매물품을 insert하는 메서드, jsp에서 판매기록을 받아 저장하고
//	성공하면 리스트로 받은 창고물품도 가져가 판매물품으로 같이 등록한다

//	ecode에 해당되는 모든 판매 목록과 모든 판매물품들을 불러옴 (SELECT * FROM ~~)
	@Override
	public List<Sale> saleHistory(int eCode) {
		return sqlSession.selectList("sales.saleHistory", eCode);
	}

	@Override
	public List<SaleItem> itemHistory(int eCode) {
		return sqlSession.selectList("sales.itemHistory", eCode);
	}

	@Override
	public String selectItemName(String itemCode, String type) {
		String name = "";
		
		if(type.equals("M")) {
			name = sqlSession.selectOne("sales.selectMaterialName",Integer.parseInt(itemCode));
		}
		else if(type.equals("P")) {
			name = sqlSession.selectOne("sales.selectProductName",Integer.parseInt(itemCode));
		} else {
			System.out.println("selectItemName(SaleDaoImpl) error");
			name = "error";
		}
		return name;
	}

	@Override
	public int itemDelivery(int statusIdx) {
		return sqlSession.update("sales.itemDelivery",statusIdx);
	}

}
