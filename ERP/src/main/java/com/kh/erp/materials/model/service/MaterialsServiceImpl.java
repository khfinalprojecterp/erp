package com.kh.erp.materials.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.materials.model.dao.MaterialsDao;
import com.kh.erp.materials.model.vo.Materials;

@Service
public class MaterialsServiceImpl implements MaterialsService {

	@Autowired
	private MaterialsDao materialsDao;

	@Override
	public List<Map<String, String>> materialsList() {
		// TODO Auto-generated method stub
		return materialsDao.materialsList();
	}

	@Override
	public int insertMaterials(Materials materials) {
		
		return materialsDao.insertMaterials(materials);
	}

	@Override
	public Materials selectOneMaterials(int mCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMaterials(Materials materials) {
		
		return materialsDao.updateMaterials(materials);
	}

	@Override
	public int deleteMaterials(int mCode) {
		return materialsDao.deleteMaterials(mCode);
	}
}
