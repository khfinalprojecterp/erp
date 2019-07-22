package com.kh.erp.materials.service;

import java.util.List;

import com.kh.erp.materials.vo.Materials;

public interface MaterialsService {
	/* 일괄 수정 , 삭제 추가 구현 요망 */
	static final int MATE_SRV_ERROR = 0; // 에러
	static final int MATE_SRV_COMPL = 1; // 성공
	
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
