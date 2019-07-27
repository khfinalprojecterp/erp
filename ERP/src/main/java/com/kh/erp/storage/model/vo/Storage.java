package com.kh.erp.storage.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Storage implements Serializable{

	private static final long serialVersionUID = 50003L;
	
	private int sCode;		// storageCode
	private int eCode;		// enterpriseCode
	private int idCode;		// 사원 번호
	private String sCate;	// storageCategory
	private String sPhone;	// storagePhone
	private String sAddr;	// storageAddress
	private String sStatus;	// storageStatus
	
	private String sEname;
	private String sWname;
	public Storage() {	}

	public Storage(int sCode, int eCode, int idCode, String sCate, String sPhone, String sAddr, String sStatus) {
		super();
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.sCate = sCate;
		this.sPhone = sPhone;
		this.sAddr = sAddr;
		this.sStatus = sStatus;
	}
	

	public Storage(int eCode, int idCode, String sCate, String sPhone, String sAddr) {
		super();
		this.eCode = eCode;
		this.idCode = idCode;
		this.sCate = sCate;
		this.sPhone = sPhone;
		this.sAddr = sAddr;
	}

	public int getsCode() {
		return sCode;
	}

	public void setsCode(int sCode) {
		this.sCode = sCode;
	}

	public int geteCode() {
		return eCode;
	}

	public void seteCode(int eCode) {
		this.eCode = eCode;
	}

	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public String getsCate() {
		return sCate;
	}

	public void setsCate(String sCate) {
		this.sCate = sCate;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getsStatus() {
		return sStatus;
	}

	public void setsStatus(String sStatus) {
		this.sStatus = sStatus;
	}

	public String getsEname() {
		return sEname;
	}

	public void setsEname(String sEname) {
		this.sEname = sEname;
	}

	public String getsWname() {
		return sWname;
	}

	public void setsWname(String sWname) {
		this.sWname = sWname;
	}

	public Storage(int sCode, int eCode, int idCode, String sCate, String sPhone, String sAddr, String sStatus,
			String sEname, String sWname) {
		super();
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.sCate = sCate;
		this.sPhone = sPhone;
		this.sAddr = sAddr;
		this.sStatus = sStatus;
		this.sEname = sEname;
		this.sWname = sWname;
	}

	@Override
	public String toString() {
		return "Storage [sCode=" + sCode + ", eCode=" + eCode + ", idCode=" + idCode + ", sCate=" + sCate + ", sPhone="
				+ sPhone + ", sAddr=" + sAddr + ", sStatus=" + sStatus + ", sEname=" + sEname + ", sWname=" + sWname
				+ "]";
	}
	


	
}
