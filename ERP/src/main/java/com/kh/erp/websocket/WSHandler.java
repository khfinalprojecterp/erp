package com.kh.erp.websocket;

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


public class WSHandler extends TextWebSocketHandler {
	
	// 웹 소켓에서 특정 사용자가 데이터를 주고 받을 수 있게
	// 세션을 연결해주는 클래스
	
	// 접속 사용자 리스트
	//private List<WebSocketSession> sessionList
	//  = new ArrayList<>();

	private Map<String, WebSocketSession> users = new ConcurrentHashMap<>();
	
	// 에러났을 때, 혹은 디버깅을 대비한 logger 객체 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 총 세개의 메소드 Override 가 가능하다.
	
	// 사용자 연결 후 실행할 내용을 구현하는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// **  WebSocket의 Session은 httpSession과 다르다!!  **
		
		// 1. 사용자 정보 저장하기
		System.out.println("연결 "+session);
		//sessionList.add(session);
		System.out.println(session.getAttributes().get("host"));
		System.out.println(session.getAttributes().get("room"));
		// 2. session에 담긴 사용자 정보 가져오기
		Employee loginMember = (Employee)session.getAttributes().get("employee");
		users.put(loginMember.getwName(), session);
		
		// 3. 채팅방에 입장한 다른 사용자들에게 입장 메세지 송신하기
		for (WebSocketSession ws : users.values()) {
			//for(WebSocketSession ws : sessionList) {
			if(ws.getAttributes().get("room") == session.getAttributes().get("room")) {
				if(ws == session) continue;
				String msg = loginMember.getwName() + "님이 입장 하셨습니다.";
				ws.sendMessage(new TextMessage(msg));
			}
		}
		
		//super.afterConnectionEstablished(session);
	}

	// 사용자 메세지 전달 시 접속한 사람들에게 메세지를 전달하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 전달한 내용을 구분자를 이용해 쪼개어 보내는 사람, 받는사람을 구분지어 송신한다.
		
		Employee loginMember = (Employee)session.getAttributes().get("employee");
		System.out.println(session.getAttributes().get("host"));
		System.out.println(session.getAttributes().get("room"));
		
		for (WebSocketSession ws : users.values()) {
			if(ws.getAttributes().get("room").equals(session.getAttributes().get("room"))) {
		//for(WebSocketSession ws : sessionList) {
				String msg = session.getId() + "|" +
						message.getPayload() + "|" +
						session.getRemoteAddress() + "|" +
						loginMember.getwName();
				
				//DB 에 저장
				
				
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
		
		// 3. 채칭 방 퇴장 메세지 전송
		for (WebSocketSession ws : users.values()) {
		//for(WebSocketSession ws : sessionList) {
			if(ws.getAttributes().get("room") == session.getAttributes().get("room")) {
				if(ws == session) continue;
				String msg = logoutMember.getwName() + "님이 퇴장하였습니다.";
				ws.sendMessage(new TextMessage(msg));
			}
		}
		
		
		//super.afterConnectionClosed(session, status);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
