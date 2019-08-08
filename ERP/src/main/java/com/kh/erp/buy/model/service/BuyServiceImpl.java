package com.kh.erp.buy.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.buy.model.dao.BuyDao;
import com.kh.erp.buy.model.vo.Purchase;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	private BuyDao buydao;
	 
	@Override
	public List<Map<String, String>> purchaseList() {
		// TODO Auto-generated method stub
		return buydao.purchaseList();
	}
	
	@Override
	public List<Map<String, String>> mList() {
		// TODO Auto-generated method stub
		return buydao.mList();
	}
	
	@Override
	public List<Map<String, String>> pList() {
		// TODO Auto-generated method stub
		return buydao.pList();
	}
	
	@Override
	public List<Map<String, String>> ptList() {
		// TODO Auto-generated method stub
		return buydao.ptList();
	}
	
	@Override
	public List<Map<String, String>> sList() {
		// TODO Auto-generated method stub
		return buydao.sList();
	}
	
	@Override
	public List<Map<String, String>> eList() {
		// TODO Auto-generated method stub
		return buydao.eList();
	}

	@Override
	public Purchase selectOnePurchase(int buy_code) {
		// TODO Auto-generated method stub
		return buydao.selectOnePurchase(buy_code);
	}

	@Override
	public int insertPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return buydao.insertPurchase(purchase);
	}
	
	@Override
	public int insertPurchaseS(Purchase purchase) {
		// TODO Auto-generated method stub
		return buydao.insertPurchaseS(purchase);
	}

	@Override
	public int updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return buydao.updatePurchase(purchase);
	}
	
	@Override
	public int updatePurchaseS(Purchase purchase) {
		// TODO Auto-generated method stub
		return buydao.updatePurchaseS(purchase);
	}

	@Override
	public int deletePurchase(int buy_code) {
		// TODO Auto-generated method stub
		return buydao.deletePurchase(buy_code);
	}

}
