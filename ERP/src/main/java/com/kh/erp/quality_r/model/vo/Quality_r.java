package com.kh.erp.quality_r.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Quality_r implements Serializable{
// 품질관리 요청
	/**
	 * 
	 */
	private static final long serialVersionUID = 1004L;

	private int QRCODE; //품질관리 코드
	private int IDCODE; //사원 코드
	private int SCODE; //창고 코드
	private int PCODE;//물품코드
	private int IN_CODE;//생산 입고 코드
	
	
	private int ECODE; //기업코드
	private String QRCHECK;//검사구분
	
	private String QRNOTE;//적요
	private int QRSTOCK;// 수량 
	private String QRSTATUS;// 진행 사항
	
	//가상 변수
	private String WNAME;
	private String SADDR;
	private String PNAME;
	private String ENAME;
	
	
	
	
	
	
	public Quality_r(int qRCODE, int iDCODE, int sCODE, int pCODE, int iN_CODE, int eCODE, String qRCHECK,
			String qRNOTE, int qRSTOCK, String qRSTATUS, String wNAME, String sADDR, String pNAME, String eNAME) {
		super();
		QRCODE = qRCODE;
		IDCODE = iDCODE;
		SCODE = sCODE;
		PCODE = pCODE;
		IN_CODE = iN_CODE;
		ECODE = eCODE;
		QRCHECK = qRCHECK;
		QRNOTE = qRNOTE;
		QRSTOCK = qRSTOCK;
		QRSTATUS = qRSTATUS;
		WNAME = wNAME;
		SADDR = sADDR;
		PNAME = pNAME;
		ENAME = eNAME;
	}


	public String getWNAME() {
		return WNAME;
	}


	public void setWNAME(String wNAME) {
		WNAME = wNAME;
	}


	public String getSADDR() {
		return SADDR;
	}


	public void setSADDR(String sADDR) {
		SADDR = sADDR;
	}


	public String getPNAME() {
		return PNAME;
	}


	public void setPNAME(String pNAME) {
		PNAME = pNAME;
	}


	public String getENAME() {
		return ENAME;
	}


	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}


	public Quality_r() {
		
	}
	
	
	public Quality_r(int qRCODE, int iDCODE, int sCODE, int pCODE, int iN_CODE, int eCODE, String qRCHECK,
			String qRNOTE, int qRSTOCK, String qRSTATUS) {
		super();
		QRCODE = qRCODE;
		IDCODE = iDCODE;
		SCODE = sCODE;
		PCODE = pCODE;
		IN_CODE = iN_CODE;
		ECODE = eCODE;
		QRCHECK = qRCHECK;
		QRNOTE = qRNOTE;
		QRSTOCK = qRSTOCK;
		QRSTATUS = qRSTATUS;
	}
	
	
	public Quality_r(int iDCODE, int sCODE, int pCODE, int eCODE, String qRCHECK, String qRNOTE,
			int qRSTOCK, String qRSTATUS) {
		super();
		IDCODE = iDCODE;
		SCODE = sCODE;
		PCODE = pCODE;
		
		ECODE = eCODE;
		QRCHECK = qRCHECK;
		QRNOTE = qRNOTE;
		QRSTOCK = qRSTOCK;
		QRSTATUS = qRSTATUS;
	}


	public Quality_r(int qRCODE, int iDCODE, int sCODE, int pCODE, int eCODE, String qRCHECK, String qRNOTE,
			int qRSTOCK, String qRSTATUS) {
		super();
		QRCODE = qRCODE;
		IDCODE = iDCODE;
		SCODE = sCODE;
		PCODE = pCODE;
		ECODE = eCODE;
		QRCHECK = qRCHECK;
		QRNOTE = qRNOTE;
		QRSTOCK = qRSTOCK;
		QRSTATUS = qRSTATUS;
	}
	@Override
	public String toString() {
		return "Quality_r [QRCODE=" + QRCODE + ", IDCODE=" + IDCODE + ", SCODE=" + SCODE + ", PCODE=" + PCODE
				+ ", IN_CODE=" + IN_CODE + ", ECODE=" + ECODE + ", QRCHECK=" + QRCHECK + ", QRNOTE=" + QRNOTE
				+ ", QRSTOCK=" + QRSTOCK + ", QRSTATUS=" + QRSTATUS + ", WNAME=" + WNAME + ", SADDR=" + SADDR
				+ ", PNAME=" + PNAME + ", ENAME=" + ENAME + "]";
	}
	public int getQRCODE() {
		return QRCODE;
	}
	public void setQRCODE(int qRCODE) {
		QRCODE = qRCODE;
	}
	public int getIDCODE() {
		return IDCODE;
	}
	public void setIDCODE(int iDCODE) {
		IDCODE = iDCODE;
	}
	public int getSCODE() {
		return SCODE;
	}
	public void setSCODE(int sCODE) {
		SCODE = sCODE;
	}
	public int getPCODE() {
		return PCODE;
	}
	public void setPCODE(int pCODE) {
		PCODE = pCODE;
	}
	public int getIN_CODE() {
		return IN_CODE;
	}
	public void setIN_CODE(int iN_CODE) {
		IN_CODE = iN_CODE;
	}
	public String getQRCHECK() {
		return QRCHECK;
	}
	public void setQRCHECK(String qRCHECK) {
		QRCHECK = qRCHECK;
	}
	public String getQRNOTE() {
		return QRNOTE;
	}
	public void setQRNOTE(String qRNOTE) {
		QRNOTE = qRNOTE;
	}
	public int getQRSTOCK() {
		return QRSTOCK;
	}
	public void setQRSTOCK(int qRSTOCK) {
		QRSTOCK = qRSTOCK;
	}
	public String getQRSTATUS() {
		return QRSTATUS;
	}
	public void setQRSTATUS(String qRSTATUS) {
		QRSTATUS = qRSTATUS;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getECODE() {
		return ECODE;
	}
	public void setECODE(int eCODE) {
		ECODE = eCODE;
	}
	
	
	
}
