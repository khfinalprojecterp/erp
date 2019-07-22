package com.kh.erp.storage.service;

import java.util.List;

import com.kh.erp.storage.vo.StorageDetail;

public interface StorageDetailService {
	static final int STDT_SRV_ERROR = 0; // 에러
	static final int STDT_SRV_COMPL = 1; // 성공
	
	/**
	 * 창고 디테일 품목 조회 메소드
	 * @return
	 */
	List<StorageDetail> storageDetailList();
	
	/**
	 * 창고디테일 항목 추가 메소드
	 * @param storageDetail
	 * @return
	 */
	int insertStorageDetail(StorageDetail storageDetail);
	
	/**
	 * 창고 디테일 품목 하나 선택 메소드
	 * @param sCode
	 * @return
	 */
	StorageDetail selectOneStorageDetail(int sdCode);
	
	/**
	 * 창고 디테일 품목 수정 메소드
	 * @param storageDetail
	 * @return
	 */
	int updateStorageDetail(StorageDetail storageDetail);
	
	/**
	 * 창고 디테일 품목 삭제 메소드
	 * @param sCode
	 * @return
	 */
	int deleteStorageDetail(int sdCode);
}
