package com.kh.erp.product_category.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product_category.model.vo.Product_Category;
@Repository
public class Product_CategoryDaoImpl implements Product_CategoryDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public List<Product_Category> selectProduct_CategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertProduct_Category(Product_Category product_category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public M_storage selectOneProduct_Category(int PCATE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct_Category(Product_Category product_category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct_Category(int PCATE) {
		// TODO Auto-generated method stub
		return 0;
	}

}
