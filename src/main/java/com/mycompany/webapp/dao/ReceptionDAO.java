package com.mycompany.webapp.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.dto.Reception;

@Mapper
public interface ReceptionDAO {
	public List<Reception> selectAll(String day);
	public void deletePatient(int cancelId);
	public void changePatient(int changeId);
	public int countWating(String day);
	public int countComplete(String day);
	public void registerPatient(Patient patientRegister);
	public String getLastId();
	public int countRday(String day);	
}
