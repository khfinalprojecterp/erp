package com.kh.erp.storage.dao;

import java.util.List;

import com.kh.erp.storage.vo.StorageDetail;

public interface StorageDetailDao {

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
	StorageDetail selectOneStorageDetail(int sCode);
	
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
	int deleteStorageDetail(int sCode);
}
