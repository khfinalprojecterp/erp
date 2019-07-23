package com.kh.erp.product_category.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product_category.model.dao.Product_CategoryDao;
import com.kh.erp.product_category.model.vo.Product_Category;
@Service
public class Product_CategoryServiceImpl implements Product_CategoryService {
@Autowired
private Product_CategoryDao product_categorydao;
	
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
