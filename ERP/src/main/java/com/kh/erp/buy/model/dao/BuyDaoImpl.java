package com.kh.erp.buy.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.buy.model.vo.Purchase;
 
@Repository
public class BuyDaoImpl implements BuyDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, String>> purchaseList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("buy.selectBuyList");
	}
	
	@Override
	public List<Map<String, String>> mList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("buy.selectM");
	}
	
	@Override
	public List<Map<String, String>> pList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("buy.selectP");
	}
	
	@Override
	public List<Map<String, String>> sList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("buy.selectS");
	}
	
	@Override
	public List<Map<String, String>> eList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("buy.selectE");
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
	public int insertPurchaseS(Purchase purchase) {
		// TODO Auto-generated method stub
		return sqlSession.insert("buy.insertBuyStorage", purchase);
	}

	@Override
	public int updatePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return sqlSession.update("buy.updateBuyItem", purchase);
	}
	
	@Override
	public int updatePurchaseS(Purchase purchase) {
		// TODO Auto-generated method stub
		return sqlSession.update("buy.updateBuyStorage", purchase);
	}

	@Override
	public int deletePurchase(int buy_code) {
		// TODO Auto-generated method stub
		return sqlSession.delete("buy.deleteBuyItem",buy_code);
	}

}
