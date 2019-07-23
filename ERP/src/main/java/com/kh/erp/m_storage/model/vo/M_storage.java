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
	private int MCOE; // 기자재 코드
	private int SCODE;//반출 창고 코드
	private int MSMSTOCK;// 수량
	private Date MSDATE;//신청일
	private int MSPRICE;//납품원가
	private String MSSTATUS;//(신청 거절,완료)
	
	public M_storage() {
		
	}

	public M_storage(int iDCODE, int mCOE, int sCODE, int mSMSTOCK, Date mSDATE, int mSPRICE, String mSSTATUS) {
		super();
		IDCODE = iDCODE;
		MCOE = mCOE;
		SCODE = sCODE;
		MSMSTOCK = mSMSTOCK;
		MSDATE = mSDATE;
		MSPRICE = mSPRICE;
		MSSTATUS = mSSTATUS;
	}

	@Override
	public String toString() {
		return "M_STORAGE [IDCODE=" + IDCODE + ", MCOE=" + MCOE + ", SCODE=" + SCODE + ", MSMSTOCK=" + MSMSTOCK
				+ ", MSDATE=" + MSDATE + ", MSPRICE=" + MSPRICE + ", MSSTATUS=" + MSSTATUS + "]";
	}

	public int getIDCODE() {
		return IDCODE;
	}

	public void setIDCODE(int iDCODE) {
		IDCODE = iDCODE;
	}

	public int getMCOE() {
		return MCOE;
	}

	public void setMCOE(int mCOE) {
		MCOE = mCOE;
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

	
}
