package com.kh.erp.quality_ch.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Quality_ch implements Serializable{
//품질 관리 처리
	/**
	 * 
	 */
	private static final long serialVersionUID = 1005L;

	private int QRCODE;// 품질관리코드
	/*
	 * private int IN_CODE;// 생산 입고 코드
	 */	private int IDCODE; //사원코드
	private int ECODE; //기업코드
	private int QCHT;// 적격
	private int QCHF;//부적격
	
	private String QCHCHECK;//불/합격
	private String QCHSTATUS;
	//가상 변수
	private String ENAME;   //기업명
	private String WNAME;  // 사원명
	
	
	
	
	public Quality_ch(int qRCODE, int iDCODE, int eCODE, int qCHT, int qCHF, String qCHCHECK, String qCHSTATUS,
			String eNAME, String wNAME) {
		super();
		QRCODE = qRCODE;
		IDCODE = iDCODE;
		ECODE = eCODE;
		QCHT = qCHT;
		QCHF = qCHF;
		QCHCHECK = qCHCHECK;
		QCHSTATUS = qCHSTATUS;
		ENAME = eNAME;
		WNAME = wNAME;
	}
	public Quality_ch(int qRCODE, int qCHT, int qCHF, String qCHCHECK, String qCHSTATUS, String eNAME, String wNAME) {
		super();
		QRCODE = qRCODE;
		QCHT = qCHT;
		QCHF = qCHF;
		QCHCHECK = qCHCHECK;
		QCHSTATUS = qCHSTATUS;
		ENAME = eNAME;
		WNAME = wNAME;
	}
	public String getENAME() {
		return ENAME;
	}
	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}
	public Quality_ch(int qRCODE, int iDCODE, int eCODE, int qCHT, int qCHF, String qCHCHECK,
			String qCHSTATUS, String eNAME) {
		super();
		QRCODE = qRCODE;
		
		IDCODE = iDCODE;
		ECODE = eCODE;
		QCHT = qCHT;
		QCHF = qCHF;
		QCHCHECK = qCHCHECK;
		QCHSTATUS = qCHSTATUS;
		ENAME = eNAME;
	}
	public int getIDCODE() {
		return IDCODE;
	}
	public void setIDCODE(int iDCODE) {
		IDCODE = iDCODE;
	}
	public int getECODE() {
		return ECODE;
	}
	public void setECODE(int eCODE) {
		ECODE = eCODE;
	}
	public Quality_ch(int qRCODE, int iDCODE, int qCHT, int qCHF, String qCHCHECK, String qCHSTATUS, String eNAME) {
		super();
		QRCODE = qRCODE;
		IDCODE = iDCODE;
		QCHT = qCHT;
		QCHF = qCHF;
		QCHCHECK = qCHCHECK;
		QCHSTATUS = qCHSTATUS;
		ENAME = eNAME;
	}
	public Quality_ch(int qRCODE, int iDCODE, int eCODE, int qCHT, int qCHF, String qCHCHECK,
			String qCHSTATUS) {
		super();
		QRCODE = qRCODE;
		
		IDCODE = iDCODE;
		ECODE = eCODE;
		QCHT = qCHT;
		QCHF = qCHF;
		QCHCHECK = qCHCHECK;
		QCHSTATUS = qCHSTATUS;
	}
	
	public Quality_ch() {
	
	}
	public Quality_ch(int qRCODE, int qCHT, int qCHF, String qCHCHECK, String qCHSTATUS) {
		super();
		QRCODE = qRCODE;
		
		QCHT = qCHT;
		QCHF = qCHF;
		QCHCHECK = qCHCHECK;
		QCHSTATUS = qCHSTATUS;
	}
	@Override
	public String toString() {
		return "Quality_ch [QRCODE=" + QRCODE  + ", IDCODE=" + IDCODE + ", ECODE=" + ECODE
				+ ", QCHT=" + QCHT + ", QCHF=" + QCHF + ", QCHCHECK=" + QCHCHECK + ", QCHSTATUS=" + QCHSTATUS
				+ ", ENAME=" + ENAME + "]";
	}
	public int getQRCODE() {
		return QRCODE;
	}
	public void setQRCODE(int qRCODE) {
		QRCODE = qRCODE;
	}

	public int getQCHT() {
		return QCHT;
	}
	public void setQCHT(int qCHT) {
		QCHT = qCHT;
	}
	public int getQCHF() {
		return QCHF;
	}
	public void setQCHF(int qCHF) {
		QCHF = qCHF;
	}
	public String getQCHCHECK() {
		return QCHCHECK;
	}
	public void setQCHCHECK(String qCHCHECK) {
		QCHCHECK = qCHCHECK;
	}
	public String getQCHSTATUS() {
		return QCHSTATUS;
	}
	public void setQCHSTATUS(String qCHSTATUS) {
		QCHSTATUS = qCHSTATUS;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
