package com.kh.erp.materials.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.materials.model.dao.MaterialsDao;
import com.kh.erp.materials.model.vo.Materials;

@Service
public class MaterialsServiceImpl implements MaterialsService {

	@Autowired
	private MaterialsDao materialsDao;

	@Override
	public List<Materials> materialsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMaterials(Materials materials) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Materials selectOneMaterials(int mCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMaterials(Materials materials) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMaterials(int mCode) {
		// TODO Auto-generated method stub
		return 0;
	}
}
