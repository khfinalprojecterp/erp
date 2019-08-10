package com.kh.erp.storage.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class StorageDetail implements Serializable{

	private static final long serialVersionUID = 50004L;
	
	private int sdCode; // 창고 디테일 PK
	private int sCode;  // 창고 정보 FK
	private int eCode;  // 소유 회사 정보 FK
	private int idCode; // 담당 사원 정보 FK
	private String mCode;  // 기자재 코드 FK
	private String pCode;  // 물품 코드 FK
	private int in_Code; // 입고 코드 FK
	private int sdStock; // 재고
	private int sdCost;  // 생산비용
	private int sdPrice; // 판매 희망 비용
	private Date sdDate;  // 입고날
	
	private String sEname; // 회사명
	private String sWname; // 사원명
	private String mName;  // 기자재명
	private String pName;  // 품목명
	
	
	public StorageDetail() { }


	public StorageDetail(int sdCode, int sCode, int eCode, int idCode, String mCode, String pCode, int in_Code, int sdStock,
			int sdCost, int sdPrice, Date sdDate) {
		super();
		this.sdCode = sdCode;
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.in_Code = in_Code;
		this.sdStock = sdStock;
		this.sdCost = sdCost;
		this.sdPrice = sdPrice;
		this.sdDate = sdDate;
	}


	public StorageDetail(int sdCode, int sCode, int eCode, int idCode, String mCode, String pCode, int in_Code, int sdStock,
			int sdCost, int sdPrice, Date sdDate, String sEname, String sWname) {
		super();
		this.sdCode = sdCode;
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.in_Code = in_Code;
		this.sdStock = sdStock;
		this.sdCost = sdCost;
		this.sdPrice = sdPrice;
		this.sdDate = sdDate;
		this.sEname = sEname;
		this.sWname = sWname;
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


	public int geteCode() {
		return eCode;
	}


	public void seteCode(int eCode) {
		this.eCode = eCode;
	}


	public int getIdCode() {
		return idCode;
	}


	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}


	public String getmCode() {
		return mCode;
	}


	public void setmCode(String mCode) {
		this.mCode = mCode;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public int getIn_Code() {
		return in_Code;
	}


	public void setIn_Code(int in_Code) {
		this.in_Code = in_Code;
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


	public String getsEname() {
		return sEname;
	}


	public void setsEname(String sEname) {
		this.sEname = sEname;
	}


	public String getsWname() {
		return sWname;
	}


	public void setsWname(String sWname) {
		this.sWname = sWname;
	}

	
	

	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	@Override
	public String toString() {
		return "StorageDetail [sdCode=" + sdCode + ", sCode=" + sCode + ", eCode=" + eCode + ", idCode=" + idCode
				+ ", mCode=" + mCode + ", pCode=" + pCode + ", in_Code=" + in_Code + ", sdStock=" + sdStock
				+ ", sdCost=" + sdCost + ", sdPrice=" + sdPrice + ", sdDate=" + sdDate + ", sEname=" + sEname
				+ ", sWname=" + sWname + ", mName=" + mName + ", pName=" + pName + "]";
	}


	public StorageDetail(int sdCode, int sCode, int eCode, int idCode, String mCode, String pCode, int in_Code, int sdStock,
			int sdCost, int sdPrice, Date sdDate, String sEname, String sWname, String mName, String pName) {
		super();
		this.sdCode = sdCode;
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.in_Code = in_Code;
		this.sdStock = sdStock;
		this.sdCost = sdCost;
		this.sdPrice = sdPrice;
		this.sdDate = sdDate;
		this.sEname = sEname;
		this.sWname = sWname;
		this.mName = mName;
		this.pName = pName;
	}


	public StorageDetail(int sCode, int eCode, int idCode, String mCode, String pCode, int sdStock, int sdCost, int sdPrice) {
		super();
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.sdStock = sdStock;
		this.sdCost = sdCost;
		this.sdPrice = sdPrice;
	}
	public StorageDetail(int sCode, int eCode, int idCode,String mCode, String pCode, int sdStock, int sdCost, int sdPrice, int in_Code) {
		super();
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.sdStock = sdStock;
		this.sdCost = sdCost;
		this.sdPrice = sdPrice;
		this.in_Code = in_Code;
	}
	
	public StorageDetail(int sdCode, int sCode, int eCode, int idCode, String mCode, String pCode, int sdStock, int sdCost, int sdPrice) {
		super();
		this.sdCode = sdCode;
		this.sCode = sCode;
		this.eCode = eCode;
		this.idCode = idCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.sdStock = sdStock;
		this.sdCost = sdCost;
		this.sdPrice = sdPrice;
	}
		
}
