package com.kh.erp.board.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Board implements Serializable{

	private static final long serialVersionUID = 3000L;
	
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private int boardIdcode;
	private String boardContent;
	private Date boardDate;
	private int readCount;
	// 가상 컬럼 변수 추가
	private int fileCount;	// 첨부파일 다운로드 횟수
	// 첨부파일 리스트 변수 추가
	private List<Attachment> files = new ArrayList<>();
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Board(int boardNo, String boardTitle, int boardIdcode, String boardWriter, String boardContent, Date boardDate, int readCount,
			int fileCount, List<Attachment> files) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.setBoardIdcode(boardIdcode);
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.readCount = readCount;
		this.fileCount = fileCount;
		this.files = files;
	}

	// 첨부파일이 없는 생성자
	public Board(int boardNo, String boardTitle, int boardIdcode, String boardWriter, String boardContent, Date boardDate, int readCount,
			int fileCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.setBoardIdcode(boardIdcode);
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.readCount = readCount;
		this.fileCount = fileCount;
	}

	// 롬복(lombok) 라이브러리를 사용하면
	// getter와 setter도 어노테이션으로 처리할 수 있다.
	// @Getter / @Setter
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	public List<Attachment> getFiles() {
		return files;
	}

	public void setFiles(List<Attachment> files) {
		this.files = files;
	}


	public int getBoardIdcode() {
		return boardIdcode;
	}

	public void setBoardIdcode(int boardIdcode) {
		this.boardIdcode = boardIdcode;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardIdcode=" + boardIdcode
				+ ", boardWriter=" + boardWriter + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", readCount=" + readCount + ", fileCount=" + fileCount + ", files=" + files + "]";
	}
	

}
