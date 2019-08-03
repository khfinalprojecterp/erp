package com.kh.erp.m_storage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class M_storage implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1102L;
//발주요청
	private int IDCODE;// 사원코드
	private int MCODE; // 기자재 코드
	private int SCODE;//반출 창고 코드
	private int MSMSTOCK;// 수량
	private Date MSDATE;//신청일
	private int MSPRICE;//납품원가
	private String MSSTATUS;//(신청 거절,완료)
	private int MSNO; // 발주 번호
	//
	public M_storage() {
		
	
	
}
	
	
	public M_storage(int mSMSTOCK, int mSPRICE) {
		super();
		MSMSTOCK = mSMSTOCK;
		MSPRICE = mSPRICE;
	}


	public M_storage(int mSNO) {
		super();
		MSNO = mSNO;
	}


	public M_storage(int mSMSTOCK, int mSPRICE, int mSNO) {
		super();
		MSMSTOCK = mSMSTOCK;
		MSPRICE = mSPRICE;
		MSNO = mSNO;
	}


	public M_storage(int iDCODE, int mSMSTOCK, int mSPRICE, int mSNO) {
		super();
		IDCODE = iDCODE;
		MSMSTOCK = mSMSTOCK;
		MSPRICE = mSPRICE;
		MSNO = mSNO;
	}

	public M_storage(int iDCODE, int mCODE, int sCODE, int mSMSTOCK, Date mSDATE, int mSPRICE, String mSSTATUS) {
		super();
		IDCODE = iDCODE;
		MCODE = mCODE;
		SCODE = sCODE;
		MSMSTOCK = mSMSTOCK;
		MSDATE = mSDATE;
		MSPRICE = mSPRICE;
		MSSTATUS = mSSTATUS;
	}
	public M_storage(int iDCODE, int mCODE, int sCODE, int mSMSTOCK, Date mSDATE, int mSPRICE, String mSSTATUS,
			int mSNO) {
		super();
		IDCODE = iDCODE;
		MCODE = mCODE;
		SCODE = sCODE;
		MSMSTOCK = mSMSTOCK;
		MSDATE = mSDATE;
		MSPRICE = mSPRICE;
		MSSTATUS = mSSTATUS;
		MSNO = mSNO;
	}
	@Override
	public String toString() {
		return "M_storage [IDCODE=" + IDCODE + ", MCODE=" + MCODE + ", SCODE=" + SCODE + ", MSMSTOCK=" + MSMSTOCK
				+ ", MSDATE=" + MSDATE + ", MSPRICE=" + MSPRICE + ", MSSTATUS=" + MSSTATUS + ", MSNO=" + MSNO + "]";
	}
	public int getIDCODE() {
		return IDCODE;
	}
	public void setIDCODE(int iDCODE) {
		IDCODE = iDCODE;
	}
	public int getMCODE() {
		return MCODE;
	}
	public void setMCODE(int mCODE) {
		MCODE = mCODE;
	}
	public int getSCODE() {
		return SCODE;
	}
	public void setSCODE(int sCODE) {
		SCODE = sCODE;
	}
	public int getMSMSTOCK() {
		return MSMSTOCK;
	}
	public void setMSMSTOCK(int mSMSTOCK) {
		MSMSTOCK = mSMSTOCK;
	}
	public Date getMSDATE() {
		return MSDATE;
	}
	public void setMSDATE(Date mSDATE) {
		MSDATE = mSDATE;
	}
	public int getMSPRICE() {
		return MSPRICE;
	}
	public void setMSPRICE(int mSPRICE) {
		MSPRICE = mSPRICE;
	}
	public String getMSSTATUS() {
		return MSSTATUS;
	}
	public void setMSSTATUS(String mSSTATUS) {
		MSSTATUS = mSSTATUS;
	}
	public int getMSNO() {
		return MSNO;
	}
	public void setMSNO(int mSNO) {
		MSNO = mSNO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}