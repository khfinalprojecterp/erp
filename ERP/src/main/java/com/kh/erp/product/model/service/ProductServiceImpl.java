package com.kh.erp.product.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product.model.dao.ProductDao;
import com.kh.erp.product.model.vo.Product;
@Service
public class ProductServiceImpl implements ProductService {
private ProductDao productdao;
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
