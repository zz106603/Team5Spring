package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.BoardDAO;
import com.mycompany.webapp.dto.Board;
import com.mycompany.webapp.dto.MainBoard;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public List<Board> getBoardList() {
		List<Board> list = boardDAO.selectAll(); 

		return list;
	}

	public List<MainBoard> getMainBoard() {
		List<MainBoard> list = boardDAO.selectMainNotice();
		return list;
	}


}
