package com.kh.erp.employee.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Pmanagement {

	private static final long serialVersionUID = 1007L;

	private int idCode;
	private int dCode;
	private String payment;
	private int mincome;
	private int count;

	private int eCode;
	private String wName;
	private String dTitle;

	public Pmanagement(int idCode, int dCode, String payment, int mincome, int count, int eCode, String wName,
			String dTitle) {
		super();
		this.idCode = idCode;
		this.dCode = dCode;
		this.payment = payment;
		this.mincome = mincome;
		this.count = count;
		this.eCode = eCode;
		this.wName = wName;
		this.dTitle = dTitle;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Pmanagement(int idCode, int dCode, String payment, int mincome, int eCode, String wName, String dTitle) {
		super();
		this.idCode = idCode;
		this.dCode = dCode;
		this.payment = payment;
		this.mincome = mincome;
		this.eCode = eCode;
		this.wName = wName;
		this.dTitle = dTitle;
	}

	public int geteCode() {
		return eCode;
	}

	public void seteCode(int eCode) {
		this.eCode = eCode;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getdTitle() {
		return dTitle;
	}

	public void setdTitle(String dTitle) {
		this.dTitle = dTitle;
	}

	public Pmanagement() {

	}

	public Pmanagement(int idCode, int dCode, String payment, int mincome) {

		this.idCode = idCode;
		this.dCode = dCode;
		this.payment = payment;
		this.mincome = mincome;
	}

	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public int getdCode() {
		return dCode;
	}

	public void setdCode(int dCode) {
		this.dCode = dCode;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getMincome() {
		return mincome;
	}

	public void setMincome(int mincome) {
		this.mincome = mincome;
	}

	@Override
	public String toString() {
		return "Pmanagement [idCode=" + idCode + ", dCode=" + dCode + ", payment=" + payment + ", mincome=" + mincome
				+ "]";
	}

}
