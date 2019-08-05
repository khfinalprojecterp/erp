package com.kh.erp.board.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.board.model.vo.Attachment;
import com.kh.erp.board.model.vo.Board;

public interface BoardService {
	// -------------------------------------------------//
	// 수행되지 않은 일에 커밋을 방지하기 위해 실행하는게 트랜젝션이다.  //
	// -1, 0, 1과 같은 숫자들을 상수화 시킨다.                  //
	//-------------------------------------------------//
	// 만약 작은 수들을 특정 옵션이나 상태값으로 사용할 경우 숫자 그대로   //
	// 사용하면 자칫 연산 처리를 수행하게 될 수도 있기 때문에 상수를 통한  //
	// 명칭을 정하여 연산하는 실수를 줄일 수 있다.                 //
	// like Enum(명칭)                                  //
	//-------------------------------------------------//
	static final int BOARD_SRV_ERROR = 0;
	static final int BOARD_SRV_COMP = 1;
	
	/**
	 * 게시글 목록 조회용 메소드
	 * @param cPage
	 * @param limite
	 * @return
	 */
	List<Map<String, String>> selectBoardList();
	
	/**
	 * 페이지 처리를 위한 게시글 총 갯수
	 * @return
	 */
	int selectBoardTotalContents();
	
	/**
	 * 게시글 추가메소드
	 * @param board
	 * @param attchList
	 * @return
	 */
	int insertBoard(Board board, List<Attachment> attachList);
	
	/**
	 * 게시글 내용 조회 메소드
	 * @param boardNo
	 * @return
	 */
	Board selectOneBoard(int boardNo);
	
	/**
	 * 해당 게시글의 첨부 파일 목록 조회 메소드
	 * @param boardNo
	 * @return
	 */
	List<Attachment> selectAttachmentList(int boardNo);
	
	/**
	 * 게시글 수정 메소드
	 * @param board
	 * @param attachList
	 * @return
	 */
	int updateBoard(Board board, List<Attachment> attachList);
	
	/**
	 * 게시글 삭제 메소드
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(int boardNo);
	
	/**
	 * 파일 한개 삭제 메소드
	 * @param attNo
	 * @return
	 */
	int deleteFile(int attNo);
	
}
