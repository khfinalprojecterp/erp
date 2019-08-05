package com.kh.erp.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.board.model.vo.Attachment;
import com.kh.erp.board.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, String>> selectBoardList() {
		return sqlSession.selectList("board.selectBoardList");
	}

	@Override
	public int selectBoardTotalContents() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.selectBoardTotalContents");
	}

	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.insertBoard", board);
	}

	@Override
	public int insertAttachment(Attachment att) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.insertAttachment", att);
	}

	@Override
	public Board selectOneBoard(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.selectOneBoard",boardNo);
	}

	@Override
	public List<Attachment> selectAttachmentList(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectAttachmentList",boardNo);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update("board.updateBoard",board);
	}

	@Override
	public int updateAttachment(Attachment att) {
		// TODO Auto-generated method stub
		return sqlSession.update("boar.updateAttachment",att);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("board.deleteBoard",boardNo);
	}

	@Override
	public int deleteAttachment(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("board.deleteAttachment",boardNo);
	}

	@Override
	public int deleteFile(int attNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("board.deleteFile",attNo);
	}

}
