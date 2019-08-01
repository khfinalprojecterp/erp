package com.kh.erp.product.model.vo;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1101L;
	//물품
	
	private int PCODE; // 물품코드
	private String PCATE;//분류코드
	private String PNAME;//물품명
	private String PSIZE;//규격명
	private int PBARCODE;//바코드
	public Product() {
		
	}
	
	
	public Product(String pNAME, String pSIZE, int pBARCODE) {
		super();
		PNAME = pNAME;
		PSIZE = pSIZE;
		PBARCODE = pBARCODE;
	}


	public Product(int pCODE, String pCATE, String pNAME, String pSIZE, int pBARCODE) {
		super();
		PCODE = pCODE;
		PCATE = pCATE;
		PNAME = pNAME;
		PSIZE = pSIZE;
		PBARCODE = pBARCODE;
	}
	@Override
	public String toString() {
		return "Product [PCODE=" + PCODE + ", PCATE=" + PCATE + ", PNAME=" + PNAME + ", PSIZE=" + PSIZE + ", PBARCODE="
				+ PBARCODE + "]";
	}
	public int getPCODE() {
		return PCODE;
	}
	public void setPCODE(int pCODE) {
		PCODE = pCODE;
	}
	public String getPCATE() {
		return PCATE;
	}
	public void setPCATE(String pCATE) {
		PCATE = pCATE;
	}
	public String getPNAME() {
		return PNAME;
	}
	public void setPNAME(String pNAME) {
		PNAME = pNAME;
	}
	public String getPSIZE() {
		return PSIZE;
	}
	public void setPSIZE(String pSIZE) {
		PSIZE = pSIZE;
	}
	public int getPBARCODE() {
		return PBARCODE;
	}
	public void setPBARCODE(int pBARCODE) {
		PBARCODE = pBARCODE;
	}



}
