package com.kh.erp.materials.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.materials.vo.MaterialsCategory;

@Repository
public class MaterialsCategoryDaoImpl implements MaterialsCategoryDao {

	@Autowired
	SqlSessionTemplate sqlSession;

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
