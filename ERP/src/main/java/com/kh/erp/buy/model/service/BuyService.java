package com.kh.erp.buy.model.service;

import java.util.List;

import com.kh.erp.buy.model.vo.Purchase;



public interface BuyService {
	
	/**
	 * 구매 목록
	 * @return
	 */
	List<Purchase> purchaseList();
	
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
	 * 구매 수정
	 * @param purchase
	 * @return
	 */
	int updatePurchase(Purchase purchase);
	
	/**
	 * 구매 삭제
	 * @param buy_code
	 * @return
	 */
	int deletePurchase(int buy_code);
	
}
