package com.kh.erp.department.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1005L;
	
	private int dCode;
	private int eCode;
	private String dTitle;
	
	public Department() {
	
	}

	public Department(int dCode, int eCode, String dTitle) {
		this.dCode = dCode;
		this.eCode = eCode;
		this.dTitle = dTitle;
	}

	public int getdCode() {
		return dCode;
	}

	public void setdCode(int dCode) {
		this.dCode = dCode;
	}

	public int geteCode() {
		return eCode;
	}

	public void seteCode(int eCode) {
		this.eCode = eCode;
	}

	public String getdTitle() {
		return dTitle;
	}

	public void setdTitle(String dTitle) {
		this.dTitle = dTitle;
	}

	@Override
	public String toString() {
		return "Department [dCode=" + dCode + ", eCode=" + eCode + ", dTitle=" + dTitle + "]";
	}
	
	
	
	
}
