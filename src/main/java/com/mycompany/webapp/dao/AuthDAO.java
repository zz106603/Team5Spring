package com.mycompany.webapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthDAO {
	public String getRole(String uId);
	public int checkLogin(@Param("hId")String hId, @Param("uId")String uId);
}
