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
      private char wstatus;
      
      // 임시변수 
      private String pname; 

   
   public Job_order() {}


   public Job_order(int workcode, int idcode, int pcode, Date orderdate, char wstatus, String pname) {
		super();
		this.workcode = workcode;
		this.idcode = idcode;
		this.pcode = pcode;
		this.orderdate = orderdate;
		this.wstatus = wstatus;
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
		return wstatus;
	}
	
	
	public void setWstatus(char wstatus) {
		this.wstatus = wstatus;
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
				+ orderdate + ", wstatus=" + wstatus + ", pname=" + pname + "]";
	}
	
}