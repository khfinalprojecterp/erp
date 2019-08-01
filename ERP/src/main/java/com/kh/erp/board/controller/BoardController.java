package com.kh.erp.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.erp.board.model.service.BoardService;
import com.kh.erp.board.model.vo.Attachment;
import com.kh.erp.board.model.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/boardList.do")
	public String selectBoardList(Model model) {
		
		ArrayList<Map<String, String>> list
		 = new ArrayList<>(boardService.selectBoardList());
		
		model.addAttribute("list", list);
		
		return "board/boardList";
		
	}
	
	@RequestMapping("/board/boardForm.do")
	public void boardForm() {
		// view 이름이 정해지지 않았을 경우
		// ViewNameTranslator 객체가 url 경로를
		// 유추하여 결정한다. (.do --> .jsp)
		// 직접 명시하지 않았기 때문에 명확한 전달을
		// 표현하지 못해 권장하는 방식은 아니다.
	}
	
	@RequestMapping("/board/boardFormEnd.do")
	public String insertBoard(Board board, Model model, 
			                  HttpSession session, 
			                  @RequestParam(value="upFile", required=false)
								MultipartFile[] upFile) {
		
		// 1. 파일 저장 경로 생성
		String saveDir
		   = session.getServletContext().getRealPath("/resources/upload");
		
		List<Attachment> list = new ArrayList<>();
		
		// 2. 폴더 생성 확인 후 파일 업로드 시작하기
		
		if(new File(saveDir).exists()) {
			
			// 3. 파일 업로드 시작
			for(MultipartFile f : upFile) {
				
				if(!f.isEmpty()) {
					// 원본 이름 가져오기
					String originalName
					   = f.getOriginalFilename();
					String ext
					   = originalName.substring(originalName.lastIndexOf(".")+1);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
					
					int rndNum = (int)(Math.random() * 1000);
					
					// 서버에 저장하여 관리할 이름
					String renamedName = sdf.format(new Date())+"_"+rndNum+"."+ext;
					// sample.png --> 2019718_145400_123.png
					
					// 파일 저장
					try {
					
						f.transferTo(new File(saveDir + "/" + renamedName));
						
					} catch (IllegalStateException | IOException e) {
						
						e.printStackTrace();
						
					}
					
					Attachment at = new Attachment();
					at.setOriginalFileName(originalName);
					at.setRenamedFileName(renamedName);
					
					list.add(at);
				}
			}
		}
		
		int result;
		
		result = boardService.insertBoard(board, list);
		
		String loc = "/board/boardList.do";
		String msg = "";
		
		if( result > 0) {
			msg = "등록 성공!";
			
		} else {
			msg = "게시글 작성 실패!";
		}
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";		
	}
	
	@RequestMapping("/board/boardView.do")
	public String selectOneBoard(@RequestParam int no, Model model) {
		
		model.addAttribute("board", boardService.selectOneBoard(no))
		.addAttribute("attachmentList", boardService.selectAttachmentList(no));
		
		return "board/boardView";
	}
	
	@RequestMapping("/board/boardUpdateView.do")
	public void boardUpdateView(@RequestParam int boardNo, Model model) {
		
		model.addAttribute("board", 
				boardService.selectOneBoard(boardNo))
		.addAttribute("attachmentList", 
				boardService.selectAttachmentList(boardNo));
		
	}
	
	@RequestMapping("/board/boardUpdate.do")
	public String boardUpdate(Board board, HttpSession session, Model model, 
			        		  @RequestParam(value="upFile", required=false)
								MultipartFile[] upFiles) {
		
		int boardNo = board.getBoardNo();
		
		// 원본 게시글 조회하여 특정 부분 수정하기
		Board originBoard = boardService.selectOneBoard(boardNo);
		originBoard.setBoardTitle(board.getBoardTitle());
		originBoard.setBoardContent(board.getBoardContent());
		
		// 1. 파일 저장 기능 구현하기
		
		// 저장 경로 생성
		String saveDir
		  = session.getServletContext().getRealPath("/resources/upload");
		
		List<Attachment> list = boardService.selectAttachmentList(boardNo);
		if(list == null) list = new ArrayList<Attachment>();
		
		// 저장할 폴더 확인 후 없으면 만들기
		File dir = new File(saveDir);
		
		if(dir.exists() == false) dir.mkdirs();
		
		// 파일 업로드 시작!!
		
		int idx = 0;
		for(MultipartFile f : upFiles) {
			
			Attachment at = null;
			
			if(!f.isEmpty()) {
				// 원본 파일 (변경 전 파일) 삭제
				
				if(list.size() > idx) {
				
					boolean isDeleted = 
							new File(saveDir+"/"+list.get(idx).getRenamedFileName()).delete();
				
					at = list.get(idx);
					
				} else {
					
					at = new Attachment();
					at.setBoardNo(boardNo);
					
					list.add(at);					
				}
				
				// 파일 이름 변경 후 업로드하기
				String originName = f.getOriginalFilename();
				String ext = originName.substring(originName.lastIndexOf(".") + 1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
				
				int rndNum = (int)(Math.random() * 1000);
				
				// 변경할 이름으로 서버에 저장하기
				String renamedName
				   = sdf.format(new Date()) + "_" + rndNum + "." + ext;
				
					try {
						
						f.transferTo(new File(saveDir + "/" + renamedName));
						
					} catch (IllegalStateException | IOException e) {
						
						e.printStackTrace();
						
					}
					
					// 파일 저장 후 기존의 내용을 비교하여
					// 기존 첨부 파일 정보 덮어쓰기
					at.setOriginalFileName(originName);
					at.setRenamedFileName(renamedName);
					
					list.set(idx, at);
			}
			
			idx++;
		}
		
		int result = boardService.updateBoard(originBoard, list);
		
		String loc = "/board/boardList.do";
		String msg = "";
		
		if(result > 0) {
			
			msg = "게시글 수정 성공!";
			
		} else {
			
			msg = "게시글 수정 실패!";
			
		}
		
		model.addAttribute("loc", loc)
		.addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping("/board/boardDelete.do")
	public String boardDelete(@RequestParam int boardNo,
			HttpSession session, Model model) {
		
		List<Attachment> list 
		    = boardService.selectAttachmentList(boardNo);
		String saveDir
		    = session.getServletContext().getRealPath("/resources/upload");
		
		// 첨부파일 목록 조회 후 각각 삭제
		if(list != null) {
			for(Attachment at : list) {
				
				new File(saveDir + "/" + at.getRenamedFileName()).delete();
				
			}
		}
		
		int result = boardService.deleteBoard(boardNo);
		
		String loc = "/board/boardList.do";
		String msg = "";
		
		if( result > 0) {
			msg = "게시글 삭제 성공!!";
		} else {
			msg = "게시글 삭제 실패 ㅠㅜ";
		}
		
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
		
	}
	
	@RequestMapping("/board/fileDelete.do")
	@ResponseBody
	public boolean fileDelete(@RequestParam int attNo,
							  @RequestParam String rName,	
			                  HttpSession session) {
		
		String saveDir
		   = session.getServletContext().getRealPath("/resources/upload");
		
		boolean check = boardService.deleteFile(attNo) != 0 ? true : false;
		
		
		if(check) new File(saveDir +"/" + rName).delete();
		
		return check;
	}
	
	// download 태그로 대체 가능하나
	// 만약을 위해 구현하는 방법도 익히고 있어야 한다. 
	@RequestMapping("/board/fileDownload.do")
	public void fileDownload(@RequestParam String oName,
							   @RequestParam String rName,
							   HttpServletRequest request,
							   HttpServletResponse response){
		
		//파일저장디렉토리
		String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload");	
	
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
			 
		try {
			sos = response.getOutputStream();
			File savedFile = new File(saveDirectory + "/" + rName);
			response.setContentType("application/octet-stream; charset=utf-8");

			// 한글 파일 명 처리 : 브라우져에 따른 인코딩 처리 선택
			String resFilename = "";
			boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1 
						  || request.getHeader("user-agent").indexOf("Trident") != -1;
			System.out.println("isMSIE="+isMSIE);
			if(isMSIE){
				// ie는 utf-8 인코딩을 명시적으로 선언 해줘야 한다. 
				// 또한 공백을 의미하는 ' '기호가 +로 변하기 때문에, 이를 %20로 치환해준다.
				// 그럼 '+'는...?? ==> '+'기호는 그에 맞는 유니코드로 치환되기 때문에 상관 X
				resFilename = URLEncoder.encode(oName, "UTF-8");
				System.out.println("ie : "+resFilename);//ie : %EC%97%AC%EB%9F%AC%EB%B6%84+%ED%99%94%EC%9D%B4%ED%8C%85.txt
									
				resFilename = resFilename.replaceAll("\\+", "%20");
				System.out.println("ie : "+resFilename);//ie : %EC%97%AC%EB%9F%AC%EB%B6%84+%ED%99%94%EC%9D%B4%ED%8C%85.txt
			} else {
				// 다른 웹 브라우저 중 ISO-8859-1(EUC-KR)로 되어 있는 경우 인코딩 진행
				resFilename = new String(oName.getBytes("UTF-8"),"ISO-8859-1");
				System.out.println("not ie : "+resFilename);
				
			}
			response.addHeader("Content-Disposition",
					"attachment; filename=\"" + resFilename + "\"");

			//파일크기지정
			response.setContentLength((int)savedFile.length());

			FileInputStream fis = new FileInputStream(savedFile);
			bis = new BufferedInputStream(fis);
			int read = 0;

			while ((read = bis.read()) != -1) {
				sos.write(read);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				sos.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
	

	
}
