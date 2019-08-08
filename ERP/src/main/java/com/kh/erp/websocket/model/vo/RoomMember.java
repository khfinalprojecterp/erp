package com.kh.erp.websocket.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class RoomMember implements Serializable {

	private static final long serialVersionUID = 645561L;
	private int chCode;
	private int idCode;
	private String wName;
	private Date upTime;
	public RoomMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomMember(int chCode, int idCode, String wName, Date upTime) {
		super();
		this.chCode = chCode;
		this.idCode = idCode;
		this.wName = wName;
		this.upTime = upTime;
	}
	@Override
	public String toString() {
		return "RoomMember [chCode=" + chCode + ", idCode=" + idCode + ", wName=" + wName + ", upTime=" + upTime + "]";
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
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	public RoomMember(int chCode, int idCode) {
		super();
		this.chCode = chCode;
		this.idCode = idCode;
	}
	
	
}
