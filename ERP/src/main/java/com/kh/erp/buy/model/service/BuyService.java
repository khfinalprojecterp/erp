package com.kh.erp.buy.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.buy.model.vo.Purchase;

 

public interface BuyService {
	
	/**
	 * 구매 목록
	 * @return
	 */
	List<Map<String, String>> purchaseList();
	
	/**
	 * 품목 리스트
	 * @return
	 */
	List<Map<String, String>> mList();
	
	List<Map<String, String>> pList();
	
	List<Map<String, String>> sList();
	
	List<Map<String, String>> eList();
	
	List<Map<String, String>> ptList();
	
	
	/**
	 * 구매 목록 하나 상세보기
	 * @param buy_code
	 * @return
	 */
	Purchase selectOnePurchase(int buy_code);
	
	
	/**
	 * 구매 등록
	 * @param purchase
	 * @return
	 */
	int insertPurchase(Purchase purchase);
	
	
	/**
	 * 구매 창고 입고
	 * @param purchase
	 * @return
	 */
	int insertPurchaseS(Purchase purchase);
	
	/**
	 * 구매 수정
	 * @param purchase
	 * @return
	 */
	int updatePurchase(Purchase purchase);
	
	/**
	 * 구매 확정
	 * @param purchase
	 * @return
	 */
	int updatePurchaseS(Purchase purchase);
	
	/**
	 * 구매 삭제
	 * @param buy_code
	 * @return
	 */
	int deletePurchase(int buy_code);
	
}
