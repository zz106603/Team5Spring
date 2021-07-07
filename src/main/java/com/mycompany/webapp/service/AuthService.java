package com.mycompany.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.AuthDAO;

@Service
public class AuthService {
	@Autowired
	private AuthDAO authDao;
	
	public String getRole(String uId) {
		String role = authDao.getRole(uId); 
		return role;
	}

	public int loginCheck(String hId, String uId) {
		int check = authDao.checkLogin(hId, uId);
		return check;
	}
}
