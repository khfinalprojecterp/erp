package com.kh.erp.websocket.model.service;

import java.util.List;
import java.util.Map;

import com.kh.erp.websocket.model.vo.Chat;
import com.kh.erp.websocket.model.vo.ChatRoom;
import com.kh.erp.websocket.model.vo.RoomMember;

public interface WebSocketService {

	List<Map<String, String>> roomList(int idCode);

	int insertRoom(ChatRoom chatRoom);
	
	int updateRoom(ChatRoom chatRoom);
	
	int deleteRoom(String chCode);
	
	List<Map<String, String>> memberList();
	
	int insertChMember(RoomMember roomMember);

	int updateChMember(RoomMember roomMember);
	
	int deleteChMember(RoomMember roomMember);
	
	List<Map<String, String>> chatList(Chat chat);
	
	int insertChMessage(Chat chat);
	
	int updateChMessage(Chat chat);
	
	int deleteChMessage(Chat chat);

	List<Map<String, String>> emList(int idCode);
	
	List<Map<String, String>> roomMemberList(String chCode);
	
	List<Map<String, String>> allMemberList();
}
