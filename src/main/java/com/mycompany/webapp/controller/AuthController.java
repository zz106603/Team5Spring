package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.security.JwtUtil;
import com.mycompany.webapp.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Resource(name="daoAuthenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/login")
	public Map<String, String> userlogin(@RequestBody Map<String, String> user) {
		String uid = user.get("uid");
		String upassword = user.get("upassword");
		String hid = user.get("hid");
		
		//사용자 인증하기
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(uid, upassword);
	    Authentication authentication = authenticationManager.authenticate(authReq);
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    securityContext.setAuthentication(authentication);
	    
	    //JWT 토큰 생성
	    String authToken = JwtUtil.createToken(uid);
		
	    //권한 가져오기
	    String role = authService.getRole(uid);
	    
	    String name = authService.getUserName(uid);
	    
	    Map<String, String> map = new HashMap<>();
	    int loginCheck = authService.loginCheck(hid, uid);
	    
	    if(loginCheck == 1) {
	    	map.put("userid", uid);
			map.put("authToken", authToken);
			map.put("role", role);
			map.put("name", name);
			
	    }
	    
		return map;
		
			
	}
}
