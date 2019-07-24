package com.kh.erp.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kh.erp.board.model.dao.BoardDao;
import com.kh.erp.board.model.exception.BoardException;
import com.kh.erp.board.model.vo.Attachment;
import com.kh.erp.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Map<String, String>> selectBoardList(int cPage, int limit) {
		
		return boardDao.selectBoardList(cPage, limit);
	}

	@Override
	public int selectBoardTotalContents() {

		return boardDao.selectBoardTotalContents();
	}

	@Override
	// @Transactional(propagation=Propagation.REQUIRED,
	//               isolation=Isolation.READ_COMMITTED)
	public int insertBoard(Board board, List<Attachment> attachList) {
		int result = BOARD_SRV_ERROR;
		
		result = boardDao.insertBoard(board);
		if(result == BOARD_SRV_ERROR) throw new BoardException();
		
		// 현재 첨부파일은 게시글 번호가 없기 때문에
		// insertBoard를 통해 전달하거나
		// insertAttachment에서 selectKey로 값을 즉석으로 처리해야 한다.
		
		if(attachList.size() > 0) {
			
			for(Attachment at : attachList) {
				// 1. at.setBoardNo(board.getBoardNo());
				result = boardDao.insertAttachment(at);

				if(result == BOARD_SRV_ERROR) throw new BoardException();
				
				// :확인 완료!
				// result = BOARD_SRV_ERROR; // 강제 비정상 실행을 생성하여
							// 트랜잭션 테스트 하기
				// throw new BoardException("트랜잭션 처리 테스트");
			}
		}
		
		return result;
	}

	@Override
	public Board selectOneBoard(int boardNo) {
		
		return boardDao.selectOneBoard(boardNo);
	}

	@Override
	public List<Attachment> selectAttachmentList(int boardNo) {
		
		return boardDao.selectAttachmentList(boardNo);
	}

	@Override
	public int updateBoard(Board board, List<Attachment> attachList) {
		
		int result = BOARD_SRV_ERROR;
		
		List<Attachment> originList
		  = boardDao.selectAttachmentList(board.getBoardNo());
		
		result = boardDao.updateBoard(board);
		if(result == BOARD_SRV_ERROR) throw new BoardException();
		
		if(originList.size() > 0) {
			
			result = boardDao.deleteAttachment(board.getBoardNo());
			if(result == BOARD_SRV_ERROR) throw new BoardException();
		}
		
		if(attachList.size() > 0) {
			
			for(Attachment at : attachList) {
				
				result = boardDao.updateAttachment(at);
				if(result == BOARD_SRV_ERROR) throw new BoardException();
			}
		}
		
		return result;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int result = boardDao.deleteBoard(boardNo);
		
		if(result > BOARD_SRV_ERROR 
				&& boardDao.selectAttachmentList(boardNo).size() > 0) {
			result = boardDao.deleteAttachment(boardNo);
		} else if(result > BOARD_SRV_ERROR) {
			result = BOARD_SRV_COMP;
		} else {
			throw new BoardException("게시글 삭제 실패!");
		}
		
		return result;
	}

	@Override
	public int deleteFile(int attNo) {
		
		return boardDao.deleteFile(attNo);
	}

}
