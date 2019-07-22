package com.kh.erp.field.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Field implements Serializable  {
	
	private static final long serialVersionUID = 1006L;
private int eCode;
private int dCode;
private String fName;
private String fArea;
private int fPart;



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
	return "Field [eCode=" + eCode + ", dCode=" + dCode + ", fName=" + fName + ", fArea=" + fArea + ", fPart=" + fPart
			+ "]";
}

	
	
	
	
}
