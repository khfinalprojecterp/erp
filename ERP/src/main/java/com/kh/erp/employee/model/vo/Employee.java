package com.kh.erp.employee.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

import com.kh.erp.department.model.vo.Department;


@Component
public class Employee implements Serializable {

	private static final long serialVersionUID = 1006L;
	
	
	private int idCode;
	private int dCode;
	private String wPwd;
	private String wName;
	private String position;
	private Date enrollDate;
	private char wStatus;
	private Date retireDate;
	
	
	// 가상변수
	private int eCode;
	private String dTitle;

	
	
	
	public Employee(int idCode, int dCode, String wPwd, String wName, String position, Date enrollDate, char wStatus,
			Date retireDate, int eCode, String dTitle) {
		super();
		this.idCode = idCode;
		this.dCode = dCode;
		this.wPwd = wPwd;
		this.wName = wName;
		this.position = position;
		this.enrollDate = enrollDate;
		this.wStatus = wStatus;
		this.retireDate = retireDate;
		this.eCode = eCode;
		this.dTitle = dTitle;
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

	public Employee() {
	
	}

	public Employee(int idCode, int dCode, String wPwd, String wName, String position, Date enrollDate, char wStatus,
			Date retireDate) {
	
		this.idCode = idCode;
		this.dCode = dCode;
		this.wPwd = wPwd;
		this.wName = wName;
		this.position = position;
		this.enrollDate = enrollDate;
		this.wStatus = wStatus;
		this.retireDate = retireDate;
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

	public String getwPwd() {
		return wPwd;
	}

	public void setwPwd(String wPwd) {
		this.wPwd = wPwd;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getwStatus() {
		return wStatus;
	}

	public void setwStatus(char wStatus) {
		this.wStatus = wStatus;
	}

	public Date getRetireDate() {
		return retireDate;
	}

	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}

	@Override
	public String toString() {
		return "Employee [idCode=" + idCode + ", dCode=" + dCode + ", wPwd=" + wPwd + ", wName=" + wName + ", position="
				+ position + ", enrollDate=" + enrollDate + ", wStatus=" + wStatus + ", retireDate=" + retireDate
				+ ", eCode=" + eCode + ", dTitle=" + dTitle + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
