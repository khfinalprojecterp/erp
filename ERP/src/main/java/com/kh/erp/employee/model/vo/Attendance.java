package com.kh.erp.employee.model.vo;


import org.springframework.stereotype.Component;

@Component
public class Attendance {


	private int idCode;
	private int dCode;
	private char vStatus;
	private int absence;
	
	public Attendance() {
		
	}

	public Attendance(int idCode, int dCode, char vStatus, int absence) {
		this.idCode = idCode;
		this.dCode = dCode;
		this.vStatus = vStatus;
		this.absence = absence;
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

	public char getvStatus() {
		return vStatus;
	}

	public void setvStatus(char vStatus) {
		this.vStatus = vStatus;
	}

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}

	@Override
	public String toString() {
		return "Attendance [idCode=" + idCode + ", dCode=" + dCode + ", vStatus=" + vStatus + ", absence=" + absence
				+ "]";
	}

	
	
	
	
	
	
	
}
