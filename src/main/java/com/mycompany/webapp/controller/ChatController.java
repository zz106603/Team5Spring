package com.mycompany.webapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Chat;
import com.mycompany.webapp.dto.User;
import com.mycompany.webapp.service.ChatService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	@GetMapping("/userlist")
	public List<User> getUserList(String uid){
		List<User> list = chatService.getUserList(uid);
		return list;
	}
	
	
	
	@PostMapping("/addchat")
	@ResponseBody
	public void addChat(@RequestBody Chat chat) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		chat.setMessageDate(df.format(new Date()));
		
		chatService.addChat(chat);
		
	}
	
	@GetMapping("/chatroom")
	public List<Chat> getChatRoom(String uid, String userId){

		List<Chat> list = chatService.getChatList(uid, userId);
		
		return list;
	}
	
}
