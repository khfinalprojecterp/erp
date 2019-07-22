package com.kh.erp.materials.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.materials.model.vo.MaterialsCategory;


public interface MaterialsCategoryService {
	static final int MACA_SRV_ERROR = 0; // 에러
	static final int MACA_SRV_COMPL = 1; // 성공
	
	/**
	 * 기자재 분류 리스트 조회 메소드
	 * @return
	 */
	List<MaterialsCategory> materialsCategoryList();
	
	/**
	 * 기자재 분류 추가 메소드
	 * @param materialsCategory
	 * @return
	 */
	int insertMaterialsCategory(MaterialsCategory materialsCategory);
	
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
