package com.kh.erp.sale.model.dao;

import java.util.List;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.materials.model.vo.Materials;
import com.kh.erp.product.model.vo.Product;
import com.kh.erp.sale.model.vo.Partner;
import com.kh.erp.sale.model.vo.Sale;
import com.kh.erp.sale.model.vo.SaleItem;
import com.kh.erp.storage.model.vo.Storage;
import com.kh.erp.storage.model.vo.StorageDetail;

public interface SaleDao {

//	--------------------------------거래처 관리페이지
//	거래처를 지정한 이름으로 등록
	int registPartner(Partner partner);
//	거래처가 존재하는지 확인	
	int checkPartner(Partner partner);
//	거래처의 거래상태를 변경(삭제 (t or s))
	int changeParSts(Partner partner);
//	거래처의 이름을 변경
	int changeParName(Partner partner);
//	--------------------------------거래처 페이지 종료

	
	
//	--------------------------------판매 페이지	
//	거래처, 자재, 물품, 창고 목록 조회용 메소드
	List<Partner> selectPartner(int eCode);
	
	List<Materials> selectMaterial();
	
	List<Product> selectProduct();
	
	List<Storage> selectStorage(int ecode);
	
	List<Employee> selectEmployeeList(int eCode);
	
//	창고 상세를 전부 받아오기
	List<StorageDetail> selectDetailList(int ecode);
	
//	controller에서 foreach로 팔 물건의 리스트를(sdstock에는 판매할 갯수가 지정되야함) 
//	보고 dao에서 판매처리
	int saleItem(List<StorageDetail> itemList);
	
//	판매 기록을 남기는 메서드, jsp에서 판매기록을 받아 저장하고
//	성공하면 리스트로 받은 창고물품도 가져가 판매물품으로 같이 등록한다
	int saleRegist(Sale sale,List<SaleItem> itemList);
//	---------------------------------판매 페이지 종료
	
	
	
//	---------------------------------판매기록 페이지
//	ecode에 해당되는 모든 판매 목록과 모든 판매물품들을 불러옴 (SELECT * FROM ~~)
	List<Sale> saleHistory(int ecode);
	List<SaleItem> itemHistory(int ecode);
	
	String selectItemName(String itemCode, String type);
	
	int itemDelivery(int statusIdx);
}
