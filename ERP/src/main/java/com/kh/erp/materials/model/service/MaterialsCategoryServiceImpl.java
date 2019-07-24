package com.kh.erp.materials.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.materials.model.dao.MaterialsCategoryDao;
import com.kh.erp.materials.model.dao.MaterialsCategoryDaoImpl;
import com.kh.erp.materials.model.vo.MaterialsCategory;

@Service
public class MaterialsCategoryServiceImpl implements MaterialsCategoryService {

	@Autowired
	private MaterialsCategoryDao materialsCategoryDao;

	@Override
	public List<Map<String, String>> materialsCategoryList() {
		
		return materialsCategoryDao.materialsCategoryList();
	}

	@Override
	public int insertMaterialsCategory(String mcName) {
		
		return materialsCategoryDao.insertMaterialsCategory(mcName);
	}

	@Override
	public MaterialsCategory selectOneMaterialsCategory(int mCate) {
		
		return materialsCategoryDao.selectOneMaterialsCategory(mCate);
	}

	@Override
	public int updateMaterialsCategory(MaterialsCategory materialsCategory) {
		
		return materialsCategoryDao.updateMaterialsCategory(materialsCategory);
	}

	@Override
	public int deleteMaterialsCategory(int mCate) {
		
		return materialsCategoryDao.deleteMaterialsCategory(mCate);
	}
}
