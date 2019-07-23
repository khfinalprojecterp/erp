package com.kh.erp.buy.purchase;

public class Purchase {

	private int buy_code;
	private int scode;
	private int mcode;
	private int pcode;
	private int buy_amount;
	private int buy_origin;
	private int buy_price;
	private String buy_status;
	private int buy_discount;
	
	
	public Purchase() {}


	public Purchase(int buy_code, int scode, int mcode, int pcode, int buy_amount, int buy_origin, int buy_price,
			String buy_status, int buy_discount) {
		super();
		this.buy_code = buy_code;
		this.scode = scode;
		this.mcode = mcode;
		this.pcode = pcode;
		this.buy_amount = buy_amount;
		this.buy_origin = buy_origin;
		this.buy_price = buy_price;
		this.buy_status = buy_status;
		this.buy_discount = buy_discount;
	}


	public int getBuy_code() {
		return buy_code;
	}


	public void setBuy_code(int buy_code) {
		this.buy_code = buy_code;
	}


	public int getScode() {
		return scode;
	}


	public void setScode(int scode) {
		this.scode = scode;
	}


	public int getMcode() {
		return mcode;
	}


	public void setMcode(int mcode) {
		this.mcode = mcode;
	}


	public int getPcode() {
		return pcode;
	}


	public void setPcode(int pcode) {
		this.pcode = pcode;
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


	@Override
	public String toString() {
		return "Purchase [buy_code=" + buy_code + ", scode=" + scode + ", mcode=" + mcode + ", pcode=" + pcode
				+ ", buy_amount=" + buy_amount + ", buy_origin=" + buy_origin + ", buy_price=" + buy_price
				+ ", buy_status=" + buy_status + ", buy_discount=" + buy_discount + "]";
	}
	
	
	
	
}
