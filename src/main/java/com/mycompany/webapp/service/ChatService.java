package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ChatDAO;
import com.mycompany.webapp.dto.Chat;
import com.mycompany.webapp.dto.User;

@Service
public class ChatService {
	
	@Autowired
	private ChatDAO chatDAO;
	
	public List<User> getUserList(String uid) {
		List<User> list = chatDAO.userListAll(uid); 
		return list;
	}

	public int addChat(Chat chat) {
		int result = chatDAO.addChat(chat);
		return result;
	}

	public List<Chat> getChatList(String uid, String userId) {
		List<Chat> list = chatDAO.chatList(uid, userId); 
		return list;
	}
}
