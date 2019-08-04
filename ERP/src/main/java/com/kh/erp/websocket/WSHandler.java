package com.kh.erp.websocket;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.LoggerFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kh.erp.employee.model.vo.Employee;
import com.kh.erp.enterprise.model.vo.Enterprise;
import com.kh.erp.websocket.model.service.WebSocketService;
import com.kh.erp.websocket.model.service.WebSocketServiceImpl;
import com.kh.erp.websocket.model.vo.Chat;
@Controller
public class WSHandler extends TextWebSocketHandler {
	
	
	// 웹 소켓에서 특정 사용자가 데이터를 주고 받을 수 있게
	// 세션을 연결해주는 클래스
	
	// 접속 사용자 리스트
	//private List<WebSocketSession> sessionList
	//  = new ArrayList<>();
	//WebSocketServiceImpl websocketService = new WebSocketServiceImpl();
	
	@Autowired
	WebSocketService websocketService;
	
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<>();
	
	// 에러났을 때, 혹은 디버깅을 대비한 logger 객체 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 총 세개의 메소드 Override 가 가능하다.
	
	// 사용자 연결 후 실행할 내용을 구현하는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// **  WebSocket의 Session은 httpSession과 다르다!!  **
		
		// 1. 사용자 정보 저장하기
		// 2. session에 담긴 사용자 정보 가져오기
		Employee loginMember = (Employee)session.getAttributes().get("employee");
		users.put(loginMember.getwName(), session);
		
		// 3. 채팅방에 입장한 자기 자신에게 지난 메세지를 전달하기
		for (WebSocketSession ws : users.values()) {
			if(ws.getAttributes().get("room").equals(session.getAttributes().get("room"))) {
				if(ws == session) {
					String roomNo = (String) session.getAttributes().get("room");
					ArrayList<Map<String, String>> chatlist 
						= new ArrayList<>(websocketService.chatList(roomNo));
					for(Map<String, String> map : chatlist) {
						System.out.println(map.get("chatDetail"));
						String msg = map.get("chatDetail");
						ws.sendMessage(new TextMessage(msg));
					}
				}
			}
		}
		
		//super.afterConnectionEstablished(session);
	}

	// 사용자 메세지 전달 시 접속한 사람들에게 메세지를 전달하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 전달한 내용을 구분자를 이용해 쪼개어 보내는 사람, 받는사람을 구분지어 송신한다.
		
		Employee loginMember = (Employee)session.getAttributes().get("employee");
		
		String roomNo = (String) session.getAttributes().get("room");
		System.out.println("roomNo = " + roomNo);
		String msg = session.getId() + "|" +
				message.getPayload() + "|" +
				session.getRemoteAddress() + "|" +
				loginMember.getwName();
		//DB 에 저장
		Chat chat = new Chat(roomNo,loginMember.getIdCode(),msg);
		websocketService.insertChMessage(chat);
		 
		for (WebSocketSession ws : users.values()) {

			if(ws.getAttributes().get("room").equals(session.getAttributes().get("room"))) {				
				// WEBSOCKET 전송
				ws.sendMessage(new TextMessage(msg));
			}
		}
		
		//super.handleTextMessage(session, message);
	}

	// 사용자 접속 종료시  특정 내용을 실행하는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		System.out.println("퇴장");
		// 1. 기존 사용자 목록에서 제거 
		users.remove(session);
		
		// 2. 퇴장할 사용자 정보 추출
		Employee logoutMember = (Employee)session.getAttributes().get("employee");
		//super.afterConnectionClosed(session, status);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
