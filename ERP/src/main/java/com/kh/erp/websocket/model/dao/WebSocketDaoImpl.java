package com.kh.erp.websocket.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.erp.websocket.model.vo.Chat;
import com.kh.erp.websocket.model.vo.ChatRoom;
import com.kh.erp.websocket.model.vo.RoomMember;

@Repository
public class WebSocketDaoImpl implements WebSocketDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, String>> roomList(int idCode) {
		
		return sqlSession.selectList("chat.selectChatRoomList", idCode);
	}

	@Override
	public int insertRoom(ChatRoom chatRoom) {
		
		sqlSession.insert("chat.insertChatRoom", chatRoom);
		
		return sqlSession.insert("chat.insertChatRoomMember", chatRoom);
	}

	@Override
	public int updateRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRoom(String chCode) {
		
		return sqlSession.delete("chat.deleteChatRoom", chCode);
	}

	@Override
	public List<Map<String, String>> memberList() {

		return sqlSession.selectList("chat.selectRoomMemberList");
	}

	@Override
	public int insertChMember(RoomMember roomMember) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateChMember(RoomMember roomMember) {

		return sqlSession.insert("chat.insertRoomMember", roomMember);
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
		
		return sqlSession.selectList("chat.selectEmMemberList", idCode);
	}

}
