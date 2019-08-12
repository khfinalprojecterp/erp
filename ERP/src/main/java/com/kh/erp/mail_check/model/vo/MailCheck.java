package com.kh.erp.mail_check.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MailCheck implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1088L;
	private int ms_code;
	private int idCode;
	private String userMail;
	private String userPass;
	
	
	private int eCode;
	
	
	public MailCheck() {}


	public MailCheck(int ms_code, int idCode, String userMail, String userPass, int eCode) {
		super();
		this.ms_code = ms_code;
		this.idCode = idCode;
		this.userMail = userMail;
		this.userPass = userPass;

		this.eCode = eCode;
	}


	public int getMs_code() {
		return ms_code;
	}


	public void setMs_code(int ms_code) {
		this.ms_code = ms_code;
	}


	public int getIdCode() {
		return idCode;
	}


	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public int geteCode() {
		return eCode;
	}


	public void seteCode(int eCode) {
		this.eCode = eCode;
	}


	@Override
	public String toString() {
		return "MailCheck [ms_code=" + ms_code + ", idCode=" + idCode + ", userMail=" + userMail + ", userPass="
				+ userPass + ", eCode=" + eCode + "]";
	}


	
}
