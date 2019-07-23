package com.kh.erp.quality_r.model.dao;

import com.kh.erp.quality_r.model.vo.Quality_r;

public interface Quality_rDao {

	

	
	int selectQuality_r(Quality_r quality_r );
	
	/**
	 * 게시글 추가 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int insertQulity_r(Quality_r quality_r);
	
	/**
	 * 게시글 내용 조회 메소드
	 * @param boardNo
	 * @return
	 */
	Quality_r selectOneQuality_r(int QRCODE); 
	

	/**
	 * 게시글 수정 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int updateQuality_r(Quality_r quality_r);
	
	/**
	 * 게시글 삭제 메소드
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(int QRCODE);
	
	
}



