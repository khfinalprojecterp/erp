package com.kh.erp.materials.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.erp.materials.model.vo.MaterialsCategory;

public interface MaterialsCategoryDao {
	
	/**
	 * 기자재 리스트 조회 메소드
	 * @return
	 */
	List<Map<String, String>> materialsCategoryList();
	
	/**
	 * 기자재 분류 추가 메소드
	 * @param mcName
	 * @return
	 */
	int insertMaterialsCategory(String mcName);
	
	/**
	 * 기자재 분류 선택 메소드
	 * @param mCate
	 * @return
	 */
	MaterialsCategory selectOneMaterialsCategory(int mCate); 

	/**
	 * 기자재 분류 수정 메소드
	 * @param materialsCategory
	 * @return
	 */
	int updateMaterialsCategory(MaterialsCategory materialsCategory);
	
	/**
	 * 기자재 분류 삭제 메소드
	 * @param mCate
	 * @return
	 */
	int deleteMaterialsCategory(int mCate);
}
