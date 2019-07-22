package com.kh.erp.materials.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MaterialsCategory implements Serializable {
	
	private static final long serialVersionUID = 50002L;
	
	private int mCate; // materialsCategory
	private String mcName; // materialsCategoryName;
	
	public MaterialsCategory() { }

	public MaterialsCategory(int mCate, String mCName) {
		this.mCate = mCate;
		this.mcName = mCName;
	}

	public int getMCate() {
		return mCate;
	}

	public void setMCate(int mCate) {
		this.mCate = mCate;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mCName) {
		this.mcName = mCName;
	}

	@Override
	public String toString() {
		return "MaterialsCategory [mCate=" + mCate + ", mcName=" + mcName + "]";
	}



	
	
}
