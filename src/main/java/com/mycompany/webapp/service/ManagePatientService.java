package com.mycompany.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.controller.MainController;

import com.mycompany.webapp.dao.ManagePatientDAO;
import com.mycompany.webapp.dto.Patient;

@Service
public class ManagePatientService {
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ManagePatientDAO managePatientDAO;
	
	//환자 리스트 가져오기
	public List<Patient> getPatientList() {
		List<Patient> list = managePatientDAO.patientList();	
		return list;
	}
	
	public void updatePatient(Patient patient) {
		managePatientDAO.updatePatient(patient);
	}
	
	public String getLastId() {
		String lastId = managePatientDAO.getLastId();
		return lastId;
	}
	
	public void registerPatient(Patient patientRegister) {
		managePatientDAO.registerPatient(patientRegister);
	}

} 
