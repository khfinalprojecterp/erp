package com.kh.erp.materials.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.materials.model.vo.Materials;

@Repository
public class MaterialsDaoImpl implements MaterialsDao {

	@Autowired
	SqlSessionTemplate sqlSession;

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
