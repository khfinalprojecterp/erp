package com.kh.erp.production.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.production.model.vo.Production;



public interface ProductionService {
	/* 일괄 수정 , 삭제 추가 구현 요망 */
	static final int MATE_SRV_ERROR = 0; // 에러
	static final int MATE_SRV_COMPL = 1; // 성공
	
	/**
	 * 생상품 리스트 조회 메소드
	 * @return
	 */
	List<Map<String, String>> productionList();
	
	/**
	 * 생산품 추가 메소드
	 * @param materials
	 * @return
	 */
	int insertMaterials();
	
	/**
	 * 생산품 하나 선택 메소드
	 * @param mCode
	 * @return
	 */
	Production selectOneMaterials();
	
	/**
	 * 생산품 수정 메소드
	 * @param materials
	 * @return
	 */
	int updateMaterials(Production production);
	
	/**
	 * 생산품삭제 메소드
	 * @param mCode
	 * @return
	 */
	int deleteMaterials();
}
