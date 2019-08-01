package com.kh.erp.materials.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.materials.model.vo.Materials;

@Repository
public class MaterialsDaoImpl implements MaterialsDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> materialsList() {

		return sqlSession.selectList("materials.selectMaterialList");
	}

	@Override
	public int insertMaterials(Materials materials) {
		
		return sqlSession.insert("materials.insertMaterial", materials);
	}

	@Override
	public Materials selectOneMaterials(int mCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMaterials(Materials materials) {
		
		return sqlSession.update("materials.updateMaterial", materials);
	}

	@Override
	public int deleteMaterials(int mCode) {
		
		return sqlSession.delete("materials.deleteMaterial", mCode);
	}
}
