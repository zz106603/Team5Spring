package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Board;
import com.mycompany.webapp.dto.MainBoard;

@Mapper
public interface BoardDAO {
	public List<Board> selectAll();
	  public List<MainBoard> selectMainNotice();
}
