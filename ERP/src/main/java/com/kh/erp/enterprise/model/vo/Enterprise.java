package com.kh.erp.enterprise.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Enterprise implements Serializable {

	private static final long serialVersionUID = 1004L;
	
private int eCode;
private String eId;
private String ePwd;
private String eName;
private int eNo;
private String eEmail;
private String eAddress;
private String ePhone;
private String eDivision;
private String eStatus;
private Date ent_out_date;


// 아이디중복검사용 가상변수
 private int idcheck;


 
 
 
 
public Enterprise(int eCode, String eId, String ePwd, String eName, int eNo, String eEmail, String eAddress,
		String ePhone, String eDivision, String eStatus, Date ent_out_date, int idcheck) {
	super();
	this.eCode = eCode;
	this.eId = eId;
	this.ePwd = ePwd;
	this.eName = eName;
	this.eNo = eNo;
	this.eEmail = eEmail;
	this.eAddress = eAddress;
	this.ePhone = ePhone;
	this.eDivision = eDivision;
	this.eStatus = eStatus;
	this.ent_out_date = ent_out_date;
	this.idcheck = idcheck;
}


public int getIdcheck() {
	return idcheck;
}


public void setIdcheck(int idcheck) {
	this.idcheck = idcheck;
}


public Enterprise() {
}


public Enterprise(String eId, String ePwd) {
	
	this.eId = eId;
	this.ePwd = ePwd;
}


public Enterprise(int eCode, String eId, String ePwd, String eName, int eNo, String eEmail, String eAddress,
		String ePhone, String eDivision, String eStatus, Date ent_out_date) {
	
	this.eCode = eCode;
	this.eId = eId;
	this.ePwd = ePwd;
	this.eName = eName;
	this.eNo = eNo;
	this.eEmail = eEmail;
	this.eAddress = eAddress;
	this.ePhone = ePhone;
	this.eDivision = eDivision;
	this.eStatus = eStatus;
	this.ent_out_date = ent_out_date;
}


public int geteCode() {
	return eCode;
}


public void seteCode(int eCode) {
	this.eCode = eCode;
}


public String geteId() {
	return eId;
}


public void seteId(String eId) {
	this.eId = eId;
}


public String getePwd() {
	return ePwd;
}


public void setePwd(String ePwd) {
	this.ePwd = ePwd;
}


public String geteName() {
	return eName;
}


public void seteName(String eName) {
	this.eName = eName;
}


public int geteNo() {
	return eNo;
}


public void seteNo(int eNo) {
	this.eNo = eNo;
}


public String geteEmail() {
	return eEmail;
}


public void seteEmail(String eEmail) {
	this.eEmail = eEmail;
}


public String geteAddress() {
	return eAddress;
}


public void seteAddress(String eAddress) {
	this.eAddress = eAddress;
}


public String getePhone() {
	return ePhone;
}


public void setePhone(String ePhone) {
	this.ePhone = ePhone;
}


public String geteDivision() {
	return eDivision;
}


public void seteDivision(String eDivision) {
	this.eDivision = eDivision;
}


public String geteStatus() {
	return eStatus;
}


public void seteStatus(String eStatus) {
	this.eStatus = eStatus;
}


public Date getEnt_out_date() {
	return ent_out_date;
}


public void setEnt_out_date(Date ent_out_date) {
	this.ent_out_date = ent_out_date;
}


@Override
public String toString() {
	return "Enterprise [eCode=" + eCode + ", eId=" + eId + ", ePwd=" + ePwd + ", eName=" + eName + ", eNo=" + eNo
			+ ", eEmail=" + eEmail + ", eAddress=" + eAddress + ", ePhone=" + ePhone + ", eDivision=" + eDivision
			+ ", eStatus=" + eStatus + ", ent_out_date=" + ent_out_date + "]";
}
	


	
	
}
