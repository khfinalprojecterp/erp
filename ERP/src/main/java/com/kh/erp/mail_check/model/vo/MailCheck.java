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
	private String idCode;
	private String userMail;
	private String userPass;
	private String key;
	
	
	private int eCode;
	
	
	public MailCheck() {}


	public MailCheck(int ms_code, String idCode, String userMail, String userPass, int eCode, String key) {
		super();
		this.ms_code = ms_code;
		this.idCode = idCode;
		this.userMail = userMail;
		this.userPass = userPass;
		this.key = key;

		this.eCode = eCode;
	}


	public int getMs_code() {
		return ms_code;
	}


	public void setMs_code(int ms_code) {
		this.ms_code = ms_code;
	}


	public String getIdCode() {
		return idCode;
	}


	public void setIdCode(String idCode) {
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
	
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
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
				+ userPass + ", key=" + key + ", eCode=" + eCode + "]";
	}
	


	


	
}
