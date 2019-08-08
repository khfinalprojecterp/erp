package com.kh.erp.sale.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Sale implements Serializable {
	
	private int sal_Code;
	private int eCode; 
	private int idCode; 
	private int partnerC;
	private Date salDay;
	
	public Sale() {}

	public Sale(int sal_Code, int eCode, int idCode, int partnerC, Date salDay) {
		super();
		this.sal_Code = sal_Code;
		this.eCode = eCode;
		this.idCode = idCode;
		this.partnerC = partnerC;
		this.salDay = salDay;
	}

	public int getSal_Code() {
		return sal_Code;
	}

	public void setSal_Code(int sal_Code) {
		this.sal_Code = sal_Code;
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

	public int getPartnerC() {
		return partnerC;
	}

	public void setPartnerC(int partnerC) {
		this.partnerC = partnerC;
	}

	public Date getSalDay() {
		return salDay;
	}

	public void setSalDay(Date salDay) {
		this.salDay = salDay;
	}

	@Override
	public String toString() {
		return "Sale [sal_Code=" + sal_Code + ", eCode=" + eCode + ", idCode=" + idCode + ", partnerC=" + partnerC
				+ ", salDay=" + salDay + "]";
	}
	
	
	
}
