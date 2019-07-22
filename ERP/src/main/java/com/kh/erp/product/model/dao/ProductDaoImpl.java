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
		return null;
	}

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public M_storage selectOneProduct(int PCODE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int PCODE) {
		// TODO Auto-generated method stub
		return 0;
	}

}
