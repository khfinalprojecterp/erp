package com.kh.erp.materials.model.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MaterialsCategory implements Serializable {
	
	private static final long serialVersionUID = 50002L;
	
	private int mCate; // materialsCategory
	private String mcName; // materialsCategoryName;
	
	public MaterialsCategory() { }

	public MaterialsCategory(int mCate, String mcName) {
		super();
		this.mCate = mCate;
		this.mcName = mcName;
	}

	public int getmCate() {
		return mCate;
	}

	public void setmCate(int mCate) {
		this.mCate = mCate;
	}

	public String getMcName() {
		return mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}

	@Override
	public String toString() {
		return "MaterialsCategory [mCate=" + mCate + ", mcName=" + mcName + "]";
	}


	
	
}
