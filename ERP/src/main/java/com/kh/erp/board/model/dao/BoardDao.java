package com.kh.erp.board.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.erp.board.model.vo.Attachment;
import com.kh.erp.board.model.vo.Board;


public interface BoardDao {
	
	List<Map<String, String>> selectBoardList(int cPage, int limit);
	
	int selectBoardTotalContents();
	
	int insertBoard(Board board);
	
	int insertAttachment(Attachment att);
	
	Board selectOneBoard(int boardNo);
	
	List<Attachment> selectAttachmentList(int boardNo);
	
	int updateBoard(Board board);
	
	int updateAttachment(Attachment att);
	
	int deleteBoard(int boardNo);
	
	int deleteAttachment(int boardNo);
	
	int deleteFile(int attNo);
}
