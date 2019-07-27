package com.kh.erp.field.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Field implements Serializable  {
	
	private static final long serialVersionUID = 1006L;
private int fCode;
private int eCode;
private int dCode;
private String fName;
private String fArea;
private int fPart;

// 가상변수 //
private String dTitle;





public Field(int fCode) {
	this.fCode = fCode;
}



public Field(int fCode, int eCode, int dCode, String fName, String fArea, int fPart, String dTitle) {
	super();
	this.fCode = fCode;
	this.eCode = eCode;
	this.dCode = dCode;
	this.fName = fName;
	this.fArea = fArea;
	this.fPart = fPart;
	this.dTitle = dTitle;
}



public int getfCode() {
	return fCode;
}



public void setfCode(int fCode) {
	this.fCode = fCode;
}



public Field(int eCode, int dCode, String fName, String fArea, int fPart, String dTitle) {
	super();
	this.eCode = eCode;
	this.dCode = dCode;
	this.fName = fName;
	this.fArea = fArea;
	this.fPart = fPart;
	this.dTitle = dTitle;
}



public String getdTitle() {
	return dTitle;
}



public void setdTitle(String dTitle) {
	this.dTitle = dTitle;
}



public void setfArea(String fArea) {
	this.fArea = fArea;
}



public Field() {

}



public Field(int eCode, int dCode, String fName, String fArea, int fPart) {

	this.eCode = eCode;
	this.dCode = dCode;
	this.fName = fName;
	this.fArea = fArea;
	this.fPart = fPart;
}



public int geteCode() {
	return eCode;
}



public void seteCode(int eCode) {
	this.eCode = eCode;
}



public int getdCode() {
	return dCode;
}



public void setdCode(int dCode) {
	this.dCode = dCode;
}



public String getfName() {
	return fName;
}



public void setfName(String fName) {
	this.fName = fName;
}



public String getfArea() {
	return fArea;
}



public void setArea(String fArea) {
	this.fArea = fArea;
}



public int getfPart() {
	return fPart;
}



public void setfPart(int fPart) {
	this.fPart = fPart;
}



@Override
public String toString() {
	return "Field [fCode=" + fCode + ", eCode=" + eCode + ", dCode=" + dCode + ", fName=" + fName + ", fArea=" + fArea
			+ ", fPart=" + fPart + ", dTitle=" + dTitle + "]";
}




	
	
	
}
