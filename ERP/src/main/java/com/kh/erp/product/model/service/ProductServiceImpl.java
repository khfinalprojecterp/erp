package com.kh.erp.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product.model.dao.ProductDao;
import com.kh.erp.product.model.vo.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productdao;
	
@Override
public int insertProduct(Product product) {
	// TODO Auto-generated method stub
	return productdao.insertProduct(product);
}



@Override
	public List<Product> selectProductList() {
		// TODO Auto-generated method stub
		return productdao.selectProductList();
	}

	

	@Override
	public M_storage selectProduct(int PCODE) {
		// TODO Auto-generated method stub
		return productdao.selectOneProduct(PCODE);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productdao.updateProduct(product);
	}

	@Override
	public int deleteProduct(int PCODE) {
		// TODO Auto-generated method stub
		return productdao.deleteProduct(PCODE);
	}

}
