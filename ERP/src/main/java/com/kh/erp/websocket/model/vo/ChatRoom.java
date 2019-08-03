package com.kh.erp.websocket.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ChatRoom implements Serializable{

	private static final long serialVersionUID = 54351L;
	private int chCode;
	private String chName;
	
	private String idCode;

	public ChatRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatRoom(int chCode, String chName, String idCode) {
		super();
		this.chCode = chCode;
		this.chName = chName;
		this.idCode = idCode;
	}

	@Override
	public String toString() {
		return "ChatRoom [chCode=" + chCode + ", chName=" + chName + ", idCode=" + idCode + "]";
	}

	public int getChCode() {
		return chCode;
	}

	public void setChCode(int chCode) {
		this.chCode = chCode;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public ChatRoom(String chName, String idCode) {
		super();
		this.chName = chName;
		this.idCode = idCode;
	}

	
}
