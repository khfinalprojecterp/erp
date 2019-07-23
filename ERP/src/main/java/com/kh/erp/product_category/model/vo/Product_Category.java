package com.kh.erp.product_category.model.vo;

import java.io.Serializable;

public class Product_Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1100L;
	//물품 분류
	
	
	private int PCATE; // 분류코드
	private String PCNAME; // 분류명
	
	
	public Product_Category() {
		
	}


	public Product_Category(int pCATE, String pCNAME) {
		super();
		PCATE = pCATE;
		PCNAME = pCNAME;
	}


	@Override
	public String toString() {
		return "Product_Category [PCATE=" + PCATE + ", PCNAME=" + PCNAME + "]";
	}


	public int getPCATE() {
		return PCATE;
	}


	public void setPCATE(int pCATE) {
		PCATE = pCATE;
	}


	public String getPCNAME() {
		return PCNAME;
	}


	public void setPCNAME(String pCNAME) {
		PCNAME = pCNAME;
	}





}
