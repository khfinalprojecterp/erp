package com.kh.erp.materials.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Materials implements Serializable {

	private static final long serialVersionUID = 50001L;
	
	private int mCode;		// materialsCode
	private int mCate;  // materialsCategory
	private String mName;	// materialsName
	
	public Materials() { }

	public Materials(int mCode, int mCate, String mName) {
		this.mCode = mCode;
		this.mCate = mCate;
		this.mName = mName;
	}

	public int getMCode() {
		return mCode;
	}

	public void setMCode(int mCode) {
		this.mCode = mCode;
	}

	public int getMCate() {
		return mCate;
	}

	public void setMCate(int mCate) {
		this.mCate = mCate;
	}

	public String getMName() {
		return mName;
	}

	public void setMName(String mName) {
		this.mName = mName;
	}

	@Override
	public String toString() {
		return "Materials [mCode=" + mCode + ", mCate=" + mCate + ", mName=" + mName + "]";
	}
	
	
	
}
