package com.kh.erp.materials.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.materials.model.vo.MaterialsCategory;

@Repository
public class MaterialsCategoryDaoImpl implements MaterialsCategoryDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> materialsCategoryList() {
		
		return sqlSession.selectList("materials.selectMaterialsCateList");
	}

	@Override
	public int insertMaterialsCategory(String mcName) {
		
		return sqlSession.insert("materials.insertMaterialsCate" , mcName);
	}

	@Override
	public MaterialsCategory selectOneMaterialsCategory(int mCate) {
		
		return sqlSession.selectOne("materials.selectMaterialsCateOne", mCate);
	}

	@Override
	public int updateMaterialsCategory(MaterialsCategory materialsCategory) {
		
		return sqlSession.update("materials.updateMaterialsCate", materialsCategory);
	}

	@Override
	public int deleteMaterialsCategory(int mCate) {
		
		return sqlSession.delete("materials.deleteMaterialsCate", mCate);
	}
}
