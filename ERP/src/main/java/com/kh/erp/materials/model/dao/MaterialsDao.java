package com.kh.erp.materials.model.dao;

import java.util.List;

import com.kh.erp.materials.model.vo.Materials;

public interface MaterialsDao {
	/**
	 * 기자재 리스트 조회 메소드
	 * @return
	 */
	List<Materials> materialsList();
	
	/**
	 * 기자지 추가 메소드
	 * @param materials
	 * @return
	 */
	int insertMaterials(Materials materials);
	
	/**
	 * 기자재 하나 선택 메소드
	 * @param mCode
	 * @return
	 */
	Materials selectOneMaterials(int mCode);
	
	/**
	 * 기자재 수정 메소드
	 * @param materials
	 * @return
	 */
	int updateMaterials(Materials materials);
	
	/**
	 * 기자재 삭제 메소드
	 * @param mCode
	 * @return
	 */
	int deleteMaterials(int mCode);
}
