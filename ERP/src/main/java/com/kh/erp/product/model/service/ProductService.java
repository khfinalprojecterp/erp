package com.kh.erp.product.model.service;

import java.util.List;

import com.kh.erp.m_storage.model.vo.M_storage;
import com.kh.erp.product.model.vo.Product;

public interface ProductService {
	
	List<Product> selectProductList();
	
	
	/**
	 * 게시글 추가 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int insertProduct(Product product );
	
	/**
	 * 게시글 내용 조회 메소드
	 * @param boardNo
	 * @return
	 */
	M_storage selectProduct(int PCODE); 
	
	
	/**
	 * 게시글 수정 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int updateProduct(Product product);
	
	/**
	 * 게시글 삭제 메소드
	 * @param boardNo
	 * @return
	 */
	int deleteProduct(int PCODE);
	
	/**
	 * 파일 한 개 삭제 메소드
	 * @param attNo
	 * @return
	 */
	
}
