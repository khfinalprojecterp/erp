package com.kh.erp.m_storage.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.m_storage.model.vo.M_storage;



public interface M_storageService {
	
		
		/**
		 * 게시글 목록 조회용 메소드
		 * @param cPage
		 * @param limit
		 * @return
		 */
		List<M_storage> selectM_storageList();
		
		
		/**
		 * 게시글 추가 메소드
		 * @param board
		 * @param attachList
		 * @return
		 */
		int insertM_storage(M_storage m_storage );
		
		/**
		 * 게시글 내용 조회 메소드
		 * @param boardNo
		 * @return
		 */
		M_storage selectOneM_storage(int IDCODE); 
		
		
		/**
		 * 게시글 수정 메소드
		 * @param board
		 * @param attachList
		 * @return
		 */
		int updateM_storage(M_storage m_storage);
		
		/**
		 * 게시글 삭제 메소드
		 * @param boardNo
		 * @return
		 */
		int deleteM_storage(int IDCODE);
		
		/**
		 * 파일 한 개 삭제 메소드
		 * @param attNo
		 * @return
		 */
		
	}
