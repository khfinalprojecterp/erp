package com.kh.erp.production.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;



@Component
public class Job_order implements Serializable{

   private static final long serialVersionUID = 132103L;
      
      private int workcode;
      private String idCode; // FK_사원번호
      private String pCode; // FK_물품코드
      private String productea;
      private String sCode; // FK_창고위치
      private Date orderdate;
      private String jostatus;
      
      // 임시변수 
      private String wname;
      private String pname; 
      private String sname;

   
    public Job_order() {}


	public Job_order(String idCode, String pCode, String productea, String sCode) {
	super();
	this.idCode = idCode;
	this.pCode = pCode;
	this.productea = productea;
	this.sCode = sCode;
	}

	public Job_order(int workcode, String idCode, String pCode, String productea, String sCode, String jostatus) {
		super();
		this.workcode = workcode;
		this.idCode = idCode;
		this.pCode = pCode;
		this.productea = productea;
		this.sCode = sCode;
		this.jostatus = jostatus;
	}


	public Job_order(int workcode, String idCode, String pCode, String productea, String sCode, Date orderdate,
			String jostatus, String wname, String pname, String sname) {
		super();
		this.workcode = workcode;
		this.idCode = idCode;
		this.pCode = pCode;
		this.productea = productea;
		this.sCode = sCode;
		this.orderdate = orderdate;
		this.jostatus = jostatus;
		this.wname = wname;
		this.pname = pname;
		this.sname = sname;
	}


	public int getWorkcode() {
		return workcode;
	}


	public void setWorkcode(int workcode) {
		this.workcode = workcode;
	}


	public String getIdCode() {
		return idCode;
	}


	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public String getProductea() {
		return productea;
	}


	public void setProductea(String productea) {
		this.productea = productea;
	}


	public String getsCode() {
		return sCode;
	}


	public void setsCode(String sCode) {
		this.sCode = sCode;
	}


	public Date getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}


	public String getJostatus() {
		return jostatus;
	}


	public void setJostatus(String jostatus) {
		this.jostatus = jostatus;
	}


	public String getWname() {
		return wname;
	}


	public void setWname(String wname) {
		this.wname = wname;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getsname() {
		return sname;
	}


	public void setsname(String sname) {
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Job_order [workcode=" + workcode + ", idCode=" + idCode + ", pCode=" + pCode + ", productea="
				+ productea + ", sCode=" + sCode + ", orderdate=" + orderdate + ", jostatus=" + jostatus + ", wname="
				+ wname + ", pname=" + pname + ", sname=" + sname + "]";
	}


}