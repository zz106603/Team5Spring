package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Chat;
import com.mycompany.webapp.dto.User;

@Mapper
public interface ChatDAO {
	public List<User> userListAll(String uid);
	public int addChat(Chat chat);
	public List<Chat> chatList(@Param("uId")String uid, @Param("userId")String userId);
}
