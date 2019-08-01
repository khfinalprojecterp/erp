package com.kh.erp.sale.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class SaleItem implements Serializable {
	
	private int sal_Code;
	private int sCode;
	private String mCode;
	private String pCode;
	private String sal_Name;
	private int sal_Amount;
	private int sal_Price;
	private int sal_Profit;
	private String sal_Status;
	private int sal_Discount;
	
	public SaleItem() {}

	public SaleItem(int sal_Code, int sCode, String mCode, String pCode, String sal_Name, int sal_Amount, int sal_Price,
			int sal_Profit, String sal_Status, int sal_Discount) {
		super();
		this.sal_Code = sal_Code;
		this.sCode = sCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.sal_Name = sal_Name;
		this.sal_Amount = sal_Amount;
		this.sal_Price = sal_Price;
		this.sal_Profit = sal_Profit;
		this.sal_Status = sal_Status;
		this.sal_Discount = sal_Discount;
	}

	public int getSal_Code() {
		return sal_Code;
	}

	public void setSal_Code(int sal_Code) {
		this.sal_Code = sal_Code;
	}

	public int getsCode() {
		return sCode;
	}

	public void setsCode(int sCode) {
		this.sCode = sCode;
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

	public String getSal_Name() {
		return sal_Name;
	}

	public void setSal_Name(String sal_Name) {
		this.sal_Name = sal_Name;
	}

	public int getSal_Amount() {
		return sal_Amount;
	}

	public void setSal_Amount(int sal_Amount) {
		this.sal_Amount = sal_Amount;
	}

	public int getSal_Price() {
		return sal_Price;
	}

	public void setSal_Price(int sal_Price) {
		this.sal_Price = sal_Price;
	}

	public int getSal_Profit() {
		return sal_Profit;
	}

	public void setSal_Profit(int sal_Profit) {
		this.sal_Profit = sal_Profit;
	}

	public String getSal_Status() {
		return sal_Status;
	}

	public void setSal_Status(String sal_Status) {
		this.sal_Status = sal_Status;
	}

	public int getSal_Discount() {
		return sal_Discount;
	}

	public void setSal_Discount(int sal_Discount) {
		this.sal_Discount = sal_Discount;
	}

	@Override
	public String toString() {
		return "SaleItem [sal_Code=" + sal_Code + ", sCode=" + sCode + ", mCode=" + mCode + ", pCode=" + pCode
				+ ", sal_Name=" + sal_Name + ", sal_Amount=" + sal_Amount + ", sal_Price=" + sal_Price + ", sal_Profit="
				+ sal_Profit + ", sal_Status=" + sal_Status + ", sal_Discount=" + sal_Discount + "]";
	}
	
	
	
}
