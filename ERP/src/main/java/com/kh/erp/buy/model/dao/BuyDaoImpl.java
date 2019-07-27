package com.kh.erp.buy.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.buy.model.vo.Purchase;

@Repository
public class BuyDaoImpl implements BuyDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Purchase> purchaseList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("buy.selectBuyList");
	}

	@Override
	public Purchase selectOnePurchase(int buy_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("buy.selectBuyItemOne", buy_code);
	}

	@Override
	public int insertPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return sqlSession.insert("buy.insertBuyItem", purchase);
	}

	@Override
	public int updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return sqlSession.update("buy.updateBuyItem", purchase);
	}

	@Override
	public int deletePurchase(int buy_code) {
		// TODO Auto-generated method stub
		return sqlSession.delete("buy.deleteBuyItem",buy_code);
	}

}
