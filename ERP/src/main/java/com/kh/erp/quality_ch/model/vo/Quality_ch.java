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
	private int IN_CODE;// 생산 입고 코드
	private int QCHT;// 적격
	private int QCHF;//부적격
	private String QCHCHECK;//불/합격
	private String QCHSTATUS;
	public Quality_ch() {
	
	}
	public Quality_ch(int qRCODE, int iN_CODE, int qCHT, int qCHF, String qCHCHECK, String qCHSTATUS) {
		super();
		QRCODE = qRCODE;
		IN_CODE = iN_CODE;
		QCHT = qCHT;
		QCHF = qCHF;
		QCHCHECK = qCHCHECK;
		QCHSTATUS = qCHSTATUS;
	}
	@Override
	public String toString() {
		return "Quality_ch [QRCODE=" + QRCODE + ", IN_CODE=" + IN_CODE + ", QCHT=" + QCHT + ", QCHF=" + QCHF
				+ ", QCHCHECK=" + QCHCHECK + ", QCHSTATUS=" + QCHSTATUS + "]";
	}
	public int getQRCODE() {
		return QRCODE;
	}
	public void setQRCODE(int qRCODE) {
		QRCODE = qRCODE;
	}
	public int getIN_CODE() {
		return IN_CODE;
	}
	public void setIN_CODE(int iN_CODE) {
		IN_CODE = iN_CODE;
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
