package com.kh.erp.materials.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Materials implements Serializable {

	private static final long serialVersionUID = 50001L;
	
	private int mCode;		// materialsCode
	private int mCate;  // materialsCategory
	private String mName;	// materialsName
	private String mcName; // materialsCategoryName;
	
	public Materials() { }
	

	public Materials(int mCode, int mCate, String mName, String mcName) {
		super();
		this.mCode = mCode;
		this.mCate = mCate;
		this.mName = mName;
		this.mcName = mcName;
	}

	
	public Materials(int mCode, int mCate, String mName) {
		super();
		this.mCode = mCode;
		this.mCate = mCate;
		this.mName = mName;
	}
	
	public Materials(int mCate, String mName) {
		super();
		this.mCate = mCate;
		this.mName = mName;
	}


	public int getmCode() {
		return mCode;
	}

	public void setmCode(int mCode) {
		this.mCode = mCode;
	}

	public int getmCate() {
		return mCate;
	}

	public void setmCate(int mCate) {
		this.mCate = mCate;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}


	@Override
	public String toString() {
		return "Materials [mCode=" + mCode + ", mCate=" + mCate + ", mName=" + mName + ", mcName=" + mcName + "]";
	}
		
	
}
