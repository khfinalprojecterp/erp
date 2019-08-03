package com.kh.erp.websocket;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.websocket.model.service.WebSocketService;
import com.kh.erp.websocket.model.vo.ChatRoom;
import com.kh.erp.websocket.model.vo.RoomMember;

@Controller
public class WebsocketController {
	
	@Autowired
	WebSocketService websocketService;
	
	// 채팅방 목록 연결
	@RequestMapping("/chattingRoom.do")   
	public String chatting(Model model, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		int idCode= employee.getIdCode();
		int eCode= employee.geteCode();

		//String idCode= (Employee) session.getAttribute("employee").;
		//ArrayList<Map<String, String>> list = new ArrayList<>(websocketService.roomList());
		
		
		ArrayList<Map<String, String>> list = new ArrayList<>(websocketService.roomList(idCode));
		ArrayList<Map<String, String>> mlist = new ArrayList<>(websocketService.memberList());
		ArrayList<Map<String, String>> elist = new ArrayList<>(websocketService.emList(eCode));
		session.setAttribute("elist", elist);
		model.addAttribute("list", list);
		session.setAttribute("mlist", mlist);
		//session.setAttribute("elist", elist);
		
		return "chat/chattingRoom";
	}
	
	// 채팅방 생성
	@RequestMapping("/roomcreate.do")
	public String chattingRoomCreate(Model model, @RequestParam String chName ,@RequestParam String idCode) {
		
		ChatRoom chatroom = new ChatRoom(chName, idCode);
		
		int result = websocketService.insertRoom(chatroom);
		
		/*
		 * String msg=""; if( result > 0) { msg="등록 성공!"; } else { msg="등록 실패!"; }
		 */
		
		String loc="/chattingRoom.do";
		model.addAttribute("loc", loc);
		//model.addAttribute("msg", msg);
		
		return "common/loc";		
	}
	
	// 채팅방 삭제
	@RequestMapping("/roomdelete.do")
	public String chattingRoomDelete(Model model, @RequestParam String chCode) {
		
		websocketService.deleteRoom(chCode);
		
		return "common/close";
		
	}

	// 대화상대 추가
	@RequestMapping("/updateMember.do")
	public String chattingUpdateMem(Model model, @RequestParam String idCode, @RequestParam String chCode) {
		
		RoomMember roomMember = new RoomMember(Integer.parseInt(chCode), Integer.parseInt(idCode));
		
		int result = websocketService.updateChMember(roomMember);
		
		String msg=""; if( result > 0) { msg="추가 성공!"; } else { msg="추가 실패!"; }

		return "chat/chattingView";
		
	}
	
	// 대화상대를 사번을 통해 추가
	
	@RequestMapping("/updateMemberbyid.do")
	public String chattingUpdateMembyId(Model model, @RequestParam String idCode, @RequestParam String chCode) {
		
		RoomMember roomMember = new RoomMember(Integer.parseInt(chCode), Integer.parseInt(idCode));
		
		int result = websocketService.updateChMember(roomMember);
		
		String msg=""; if( result > 0) { msg="추가 성공!"; } else { msg="추가 실패!"; }

		return "chat/chattingView";
		
	}
	
	// 채팅창 연결 역할
	@RequestMapping("/chatting.do")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	public String chatting(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam String chCode) {
		
		// 웹 소켓에 접속하여 사용자로 추가된 ip 저장하기
		// -- 차후 사용자 구분을 위함
		//model.addAttribute("host", request.getRemoteAddr()); // model에 ip 저장
		//model.addAttribute("room", "1");

		session.setAttribute("host", request.getRemoteAddr()); // model에 ip 저장
		session.setAttribute("room", chCode);
		
		return "chat/chattingView";
	}

}
