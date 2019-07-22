package com.kh.erp.quality_ch.model.service;

import com.kh.erp.quality_ch.model.vo.Quality_ch;
import com.kh.erp.quality_r.model.vo.Quality_r;

public interface Quality_chService {
	int selectQuality_ch(Quality_ch quality_ch );
	
	/**
	 * 게시글 추가 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int insertQuality_ch(Quality_ch quality_ch);
	
	/**
	 * 게시글 내용 조회 메소드
	 * @param boardNo
	 * @return
	 */
	Quality_r selectOneQuality_ch(int QRCODE); 
	

	/**
	 * 게시글 수정 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int updateQuality_ch(Quality_ch quality_ch);
	
	/**
	 * 게시글 삭제 메소드
	 * @param boardNo
	 * @return
	 */
	int deleteQuality_ch(int QRCODE);
	
	
}



