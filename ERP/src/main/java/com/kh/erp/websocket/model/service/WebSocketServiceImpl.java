package com.kh.erp.websocket.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.erp.websocket.model.dao.WebSocketDao;
import com.kh.erp.websocket.model.vo.Chat;
import com.kh.erp.websocket.model.vo.ChatRoom;
import com.kh.erp.websocket.model.vo.RoomMember;

@Service
public class WebSocketServiceImpl implements WebSocketService {

	@Autowired
	private WebSocketDao websocketDao;
	
	@Override
	public List<Map<String, String>> roomList(int idCode) {
		
		return websocketDao.roomList(idCode);
	}

	@Override
	public int insertRoom(ChatRoom chatRoom) {
		
		return websocketDao.insertRoom(chatRoom);
	}

	@Override
	public int updateRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRoom(String chCode) {
		
		return websocketDao.deleteRoom(chCode);
	}

	@Override
	public List<Map<String, String>> memberList() {

		return websocketDao.memberList();
	}

	@Override
	public int insertChMember(RoomMember roomMember) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateChMember(RoomMember roomMember) {
		// TODO Auto-generated method stub
		return websocketDao.updateChMember(roomMember);
	}

	@Override
	public int deleteChMember(RoomMember roomMember) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, String>> chatList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertChMessage(Chat chat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateChMessage(Chat chat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteChMessage(Chat chat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, String>> emList(int idCode) {
		
		return websocketDao.emList(idCode);
	}




}
