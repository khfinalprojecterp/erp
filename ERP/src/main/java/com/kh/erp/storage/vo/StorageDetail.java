package com.kh.erp.storage.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class StorageDetail implements Serializable{

	private static final long serialVersionUID = 50004L;
	
	private int sdCode;		// 구분자(시퀀스) 사용자에게는 보이지 않음
	private int sCode;		// storageCode
	private int mCode;		// materialsCode
	private int pCode;		// produectCode
	private int in_Code;	// 생산입고 코드
	private int idCode;		// 사원코드
	private int sdStock;	// storagedetailStock
	private int sdCost;		// storagedetailCost
	private String sdDivi;	// storagedetailDivision
	private int sdPrice;	// storageDetailPrice
	private Date sdDate;	// 수정날짜
	
	public StorageDetail() { }

	public StorageDetail(int sdCode, int sCode, int mCode, int pCode, int in_Code, int idCode, int sdStock, int sdCost,
			String sdDivi, int sdPrice, Date sdDate) {
		super();
		this.sdCode = sdCode;
		this.sCode = sCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.in_Code = in_Code;
		this.idCode = idCode;
		this.sdStock = sdStock;
		this.sdCost = sdCost;
		this.sdDivi = sdDivi;
		this.sdPrice = sdPrice;
		this.sdDate = sdDate;
	}

	public int getSdCode() {
		return sdCode;
	}

	public void setSdCode(int sdCode) {
		this.sdCode = sdCode;
	}

	public int getsCode() {
		return sCode;
	}

	public void setsCode(int sCode) {
		this.sCode = sCode;
	}

	public int getmCode() {
		return mCode;
	}

	public void setmCode(int mCode) {
		this.mCode = mCode;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public int getIn_Code() {
		return in_Code;
	}

	public void setIn_Code(int in_Code) {
		this.in_Code = in_Code;
	}

	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public int getSdStock() {
		return sdStock;
	}

	public void setSdStock(int sdStock) {
		this.sdStock = sdStock;
	}

	public int getSdCost() {
		return sdCost;
	}

	public void setSdCost(int sdCost) {
		this.sdCost = sdCost;
	}

	public String getSdDivi() {
		return sdDivi;
	}

	public void setSdDivi(String sdDivi) {
		this.sdDivi = sdDivi;
	}

	public int getSdPrice() {
		return sdPrice;
	}

	public void setSdPrice(int sdPrice) {
		this.sdPrice = sdPrice;
	}

	public Date getSdDate() {
		return sdDate;
	}

	public void setSdDate(Date sdDate) {
		this.sdDate = sdDate;
	}

	@Override
	public String toString() {
		return "StorageDetail [sdCode=" + sdCode + ", sCode=" + sCode + ", mCode=" + mCode + ", pCode=" + pCode
				+ ", in_Code=" + in_Code + ", idCode=" + idCode + ", sdStock=" + sdStock + ", sdCost=" + sdCost
				+ ", sdDivi=" + sdDivi + ", sdPrice=" + sdPrice + ", sdDate=" + sdDate + "]";
	}

	
	
	
}
