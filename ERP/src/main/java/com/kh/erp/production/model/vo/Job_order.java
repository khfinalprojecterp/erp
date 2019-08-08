package com.kh.erp.production.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;



@Component
public class Job_order implements Serializable{

   private static final long serialVersionUID = 132103L;
      
      private int workcode;
      private int idcode; // FK_사원번호
      private int pcode; // FK_물품코드
      private Date orderdate;
      private char jostatus;
      
      // 임시변수 
      private String wname;
      private String pname; 

   
   public Job_order() {}


	public Job_order(int workcode, int idcode, int pcode) {
	super();
	this.workcode = workcode;
	this.idcode = idcode;
	this.pcode = pcode;
	}


	public Job_order(int workcode, int idcode, int pcode, Date orderdate, char jostatus, String wname, String pname) {
	super();
	this.workcode = workcode;
	this.idcode = idcode;
	this.pcode = pcode;
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
	
	
	
	public int getIdcode() {
		return idcode;
	}
	
	
	
	public void setIdcode(int idcode) {
		this.idcode = idcode;
	}
	
	
	
	public int getPcode() {
		return pcode;
	}
	
	
	
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	
	
	
	public Date getOrderdate() {
		return orderdate;
	}
	
	
	
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	
	
	public char getWstatus() {
		return jostatus;
	}
	
	
	
	public void setWstatus(char jostatus) {
		this.jostatus = jostatus;
	}
	
	
	
	public String getEname() {
		return wname;
	}
	
	
	
	public void setEname(String ename) {
		this.wname = ename;
	}
	
	
	
	public String getPname() {
		return pname;
	}
	
	
	
	public void setPname(String pname) {
		this.pname = pname;
	}



	@Override
	public String toString() {
		return "Job_order [workcode=" + workcode + ", idcode=" + idcode + ", pcode=" + pcode + ", orderdate="
				+ orderdate + ", jostatus=" + jostatus + ", wname=" + wname + ", pname=" + pname + "]";
	}
	

	
}