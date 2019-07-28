package com.kh.erp.sale.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.materials.model.vo.Materials;
import com.kh.erp.product.model.vo.Product;
import com.kh.erp.sale.model.dao.SaleDao;
import com.kh.erp.sale.model.vo.Partner;
import com.kh.erp.sale.model.vo.Sale;
import com.kh.erp.sale.model.vo.SaleItem;
import com.kh.erp.storage.model.vo.Storage;
import com.kh.erp.storage.model.vo.StorageDetail;
@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleDao saledao;
	
	@Override
	public int registPartner(Partner partner) {
		return saledao.registPartner(partner);
	}//	거래처를 지정한 이름으로 등록


	@Override
	public int checkPartner(Partner partner) {
		return saledao.checkPartner(partner);
	}//	거래처가 존재하는지 확인	


	@Override
	public int changeParSts(Partner partner) {
		return saledao.changeParSts(partner);
	}//	거래처의 거래상태를 변경(삭제 (t or s))


	@Override
	public int changeParName(Partner partner) {
		return saledao.changeParName(partner);
	}//	거래처의 이름을 변경

//	거래처, 자재, 물품, 창고 목록 조회용 메소드
	@Override
	public List<Partner> selectPartner(int eCode){
		return saledao.selectPartner(eCode);
	}
	
	@Override
	public List<Materials> selectMaterial() {
		return saledao.selectMaterial();
	}

	@Override
	public List<Product> selectProduct() {
		return saledao.selectProduct();
	}

	@Override
	public List<Storage> selectStorage(int ecode) {
		return saledao.selectStorage(ecode);
	}

	@Override
	public List<StorageDetail> selectDetailList(int ecode) {
		return saledao.selectDetailList(ecode);
	}//	창고 상세를 전부 받아오기
	
	@Override
	public List<Employee> selectEmployeeList(int eCode){
		return saledao.selectEmployeeList(eCode);
	}


	@Override
	public int saleItem(List<StorageDetail> itemList) {
		return saledao.saleItem(itemList);
	}//	controller에서 foreach로 팔 물건의 리스트를(sdstock에는 판매할 갯수가 지정되야함) 
//	보고 dao에서 판매처리

	@Override
	public int saleRegist(Sale sale, List<SaleItem> itemList) {
		return saledao.saleRegist(sale, itemList);
	}//	판매 기록을 남기는 메서드, jsp에서 판매기록을 받아 저장하고
//	성공하면 리스트로 받은 창고물품도 가져가 판매물품으로 같이 등록한다

	
//	ecode에 해당되는 모든 판매 목록과 모든 판매물품들을 불러옴 (SELECT * FROM ~~)
	@Override
	public List<Sale> saleHistory(int ecode) {
		return saledao.saleHistory(ecode);
	}

	@Override
	public List<SaleItem> itemHistory(int ecode) {
		return saledao.itemHistory(ecode);
	}


	@Override
	public String selectItemName(String itemCode, String type) {
		return saledao.selectItemName(itemCode, type);
	}

}
