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
      private Date orderdate;
      private String jostatus;
      
      // 임시변수 
      private String wname;
      private String pname; 

   
    public Job_order() {}


	public Job_order(String idCode, String pCode) {
	super();
	this.idCode = idCode;
	this.pCode = pCode;
	}

	
	

	public Job_order(int workcode, String idCode, String pCode, String jostatus) {
		super();
		this.workcode = workcode;
		this.idCode = idCode;
		this.pCode = pCode;
		this.jostatus = jostatus;
	}


	public Job_order(int workcode, String idCode, String pCode, Date orderdate, String jostatus, String wname,
			String pname) {
		super();
		this.workcode = workcode;
		this.idCode = idCode;
		this.pCode = pCode;
		this.orderdate = orderdate;
		this.jostatus = jostatus;
		this.wname = wname;
		this.pname = pname;
	}



	public int getWorkcode() {
		return workcode;
	}


	public void setWorkcode(int workcode) {
		this.workcode = workcode;
	}


	public String getIdcode() {
		return idCode;
	}


	public void setIdcode(String idcode) {
		this.idCode = idcode;
	}


	public String getPcode() {
		return pCode;
	}


	public void setPcode(String pcode) {
		this.pCode = pcode;
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


	@Override
	public String toString() {
		return "Job_order [workcode=" + workcode + ", idCode=" + idCode + ", pCode=" + pCode + ", orderdate="
				+ orderdate + ", jostatus=" + jostatus + ", wname=" + wname + ", pname=" + pname + "]";
	}

	
		
}