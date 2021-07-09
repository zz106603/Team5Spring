package com.mycompany.webapp.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ReceptionDAO;
import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.dto.Reception;

@Service
public class ReceptionService {
	@Autowired
	private ReceptionDAO receptionDAO;
	
	public List<Reception> getReceptionList(String day){
		List<Reception> list = receptionDAO.selectAll(day);
		return list; 
	}
	
	public void deletePatient(int cancelId) {
		receptionDAO.deletePatient(cancelId);
	}

	public void changePatient(int changeId) {
		receptionDAO.changePatient(changeId);
	}

	public int countWating(String day) {
		int countWating = receptionDAO.countWating(day);
		return countWating;
	}

	public int countComplete(String day) {
		int countComplete = receptionDAO.countComplete(day);
		return countComplete;
	}

	public void registerPatient(Patient patientRegister) {
		receptionDAO.registerPatient(patientRegister);
	}

	public String getLastId() {
		String lastId = receptionDAO.getLastId();
		return lastId;
	}

	public int countRday(String day) {
		int rDay = receptionDAO.countRday(day);
		return rDay;		
	}

}
