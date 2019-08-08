package com.kh.erp.websocket.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Chat implements Serializable{


	private static final long serialVersionUID = 34531L;
	private String chCode;
	private int idCode;
	private String chatDetail;
	private Date chatTime;
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chat(String chCode, int idCode, String chatDetail, Date chatTime) {
		super();
		this.chCode = chCode;
		this.idCode = idCode;
		this.chatDetail = chatDetail;
		this.chatTime = chatTime;
	}
	public String getChCode() {
		return chCode;
	}
	public void setChCode(String chCode) {
		this.chCode = chCode;
	}
	public int getIdCode() {
		return idCode;
	}
	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}
	public String getChatDetail() {
		return chatDetail;
	}
	public void setChatDetail(String chatDetail) {
		this.chatDetail = chatDetail;
	}
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	@Override
	public String toString() {
		return "Chat [chCode=" + chCode + ", idCode=" + idCode + ", chatDetail=" + chatDetail + ", chatTime=" + chatTime
				+ "]";
	}
	public Chat(String chCode, int idCode, String chatDetail) {
		super();
		this.chCode = chCode;
		this.idCode = idCode;
		this.chatDetail = chatDetail;
	}
	public Chat(String chCode, int idCode) {
		super();
		this.chCode = chCode;
		this.idCode = idCode;
	}
	
	
	
}
