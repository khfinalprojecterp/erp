package com.kh.erp.product_category.model.service;

import java.util.List;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product_category.model.vo.Product_Category;

public interface Product_CategoryService {
	
	List<Product_Category> selectProduct_CategoryList();
	
/**
 * 
 * @param m_storage
 * @return
 */
	int insertProduct_Category(Product_Category product_category );
	
	/**
	 * 게시글 내용 조회 메소드
	 * @param boardNo
	 * @return
	 */
	M_storage selectOneProduct_Category(int PCATE); 
	
	
	/**
	 * 게시글 수정 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int updateProduct_Category(Product_Category product_category);
	
	/**
	 * 게시글 삭제 메소드
	 * @param boardNo
	 * @return
	 */
	int deleteProduct_Category(int PCATE);
	
	/**
	 * 파일 한 개 삭제 메소드
	 * @param attNo
	 * @return
	 */
	
}
