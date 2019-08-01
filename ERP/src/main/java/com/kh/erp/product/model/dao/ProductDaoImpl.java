package com.kh.erp.product.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product.model.vo.Product;
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SqlSessionTemplate SqlSession;
	@Override
	public List<Product> selectProductList() {
		// TODO Auto-generated method stub
		return SqlSession.selectList("product.selectProductList");
	}

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return SqlSession.insert("product.insertProduct",product);
	}

	@Override
	public M_storage selectOneProduct(int PCODE) {
		// TODO Auto-generated method stub
		return SqlSession.selectOne("product.selectOneproduct",PCODE);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return SqlSession.update("product.updateProduct",product);
	}

	@Override
	public int deleteProduct(int PCODE) {
		// TODO Auto-generated method stub
		return SqlSession.delete("product.delectProduct",PCODE);
	}

}
