package com.kh.erp.buy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.buy.model.dao.BuyDao;
import com.kh.erp.buy.model.vo.Purchase;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	private BuyDao buydao;
	
	@Override
	public List<Purchase> purchaseList() {
		// TODO Auto-generated method stub
		return buydao.purchaseList();
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
	public int updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return buydao.updatePurchase(purchase);
	}

	@Override
	public int deletePurchase(int buy_code) {
		// TODO Auto-generated method stub
		return buydao.deletePurchase(buy_code);
	}

}
