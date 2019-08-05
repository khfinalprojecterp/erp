package com.kh.erp.websocket.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RoomMember implements Serializable {

	private static final long serialVersionUID = 645561L;
	private int chCode;
	private int idCode;
	private String wName;
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	@Override
	public String toString() {
		return "RoomMember [chCode=" + chCode + ", idCode=" + idCode + ", wName=" + wName + "]";
	}
	public RoomMember(int chCode, int idCode, String wName) {
		super();
		this.chCode = chCode;
		this.idCode = idCode;
		this.wName = wName;
	}
	public RoomMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomMember(int chCode, int idCode) {
		super();
		this.chCode = chCode;
		this.idCode = idCode;
	}
	public int getChCode() {
		return chCode;
	}
	public void setChCode(int chCode) {
		this.chCode = chCode;
	}
	public int getIdCode() {
		return idCode;
	}
	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}
	
}
