package com.kh.erp.sale.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Partner implements Serializable {
	
	private int partnerC;
	private int eCode;
	private String parName;
	private String parSts;
	
	public Partner() {}

	public Partner(int partnerC, int eCode, String parName, String parSts) {
		super();
		this.partnerC = partnerC;
		this.eCode = eCode;
		this.parName = parName;
		this.parSts = parSts;
	}

	public int getPartnerC() {
		return partnerC;
	}

	public void setPartnerC(int partnerC) {
		this.partnerC = partnerC;
	}

	public int geteCode() {
		return eCode;
	}

	public void seteCode(int eCode) {
		this.eCode = eCode;
	}

	public String getParName() {
		return parName;
	}

	public void setParName(String parName) {
		this.parName = parName;
	}

	public String getParSts() {
		return parSts;
	}

	public void setParSts(String parSts) {
		this.parSts = parSts;
	}

	@Override
	public String toString() {
		return "Partner [partnerC=" + partnerC + ", eCode=" + eCode + ", parName=" + parName + ", parSts=" + parSts
				+ "]";
	}

	
	
	

	
}
