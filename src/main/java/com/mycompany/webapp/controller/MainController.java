package com.mycompany.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Board;
import com.mycompany.webapp.dto.MainBoard;
import com.mycompany.webapp.service.BoardService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/boards")
public class MainController {
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private BoardService boardService;
	
	   @GetMapping("/main")
	      public List<MainBoard> mainlist() {
	         List<MainBoard> list = boardService.getMainBoard();
	         return list;
	      }
	 	
	   @GetMapping("")
	   public List<Board> list(){
	      List<Board> list = boardService.getBoardList();
	     
	      return list;
	   }
		
}
