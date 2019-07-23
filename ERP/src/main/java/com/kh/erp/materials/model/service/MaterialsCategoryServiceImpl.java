package com.kh.erp.materials.model.service;

import java.util.List;

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
	public List<MaterialsCategory> materialsCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMaterialsCategory(MaterialsCategory materialsCategory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MaterialsCategory selectOneMaterialsCategory(int mCate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMaterialsCategory(MaterialsCategory materialsCategory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMaterialsCategory(int mCate) {
		// TODO Auto-generated method stub
		return 0;
	}
}
