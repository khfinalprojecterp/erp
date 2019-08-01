package com.kh.erp.buy.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Purchase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1023L;
	private int buy_code;
	private int sCode;
	private String mCode;
	private String pCode;
	private int idCode;
	private int buy_amount;
	private int buy_origin;
	private int buy_price;
	private String buy_status;
	private int buy_discount;
	private String sddivi;
	
	
	public Purchase() {}


	public Purchase(int buy_code, int sCode, String mCode, String pCode, int idCode, int buy_amount, int buy_origin,
			int buy_price, String buy_status, int buy_discount, String sddivi) {
		super();
		this.buy_code = buy_code;
		this.sCode = sCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.idCode = idCode;
		this.buy_amount = buy_amount;
		this.buy_origin = buy_origin;
		this.buy_price = buy_price;
		this.buy_status = buy_status;
		this.buy_discount = buy_discount;
		this.sddivi = sddivi;
	}


	public int getBuy_code() {
		return buy_code;
	}


	public void setBuy_code(int buy_code) {
		this.buy_code = buy_code;
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


	public int getIdCode() {
		return idCode;
	}


	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}


	public int getBuy_amount() {
		return buy_amount;
	}


	public void setBuy_amount(int buy_amount) {
		this.buy_amount = buy_amount;
	}


	public int getBuy_origin() {
		return buy_origin;
	}


	public void setBuy_origin(int buy_origin) {
		this.buy_origin = buy_origin;
	}


	public int getBuy_price() {
		return buy_price;
	}


	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}


	public String getBuy_status() {
		return buy_status;
	}


	public void setBuy_status(String buy_status) {
		this.buy_status = buy_status;
	}


	public int getBuy_discount() {
		return buy_discount;
	}


	public void setBuy_discount(int buy_discount) {
		this.buy_discount = buy_discount;
	}


	public String getSddivi() {
		return sddivi;
	}


	public void setSddivi(String sddivi) {
		this.sddivi = sddivi;
	}


	@Override
	public String toString() {
		return "Purchase [buy_code=" + buy_code + ", sCode=" + sCode + ", mCode=" + mCode + ", pCode=" + pCode
				+ ", idCode=" + idCode + ", buy_amount=" + buy_amount + ", buy_origin=" + buy_origin + ", buy_price="
				+ buy_price + ", buy_status=" + buy_status + ", buy_discount=" + buy_discount + ", sddivi=" + sddivi
				+ "]";
	}


	

	
	
	
}
