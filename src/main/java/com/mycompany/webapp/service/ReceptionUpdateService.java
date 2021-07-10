package com.mycompany.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.controller.MainController;

import com.mycompany.webapp.dao.ReceptionUpdateDAO;
import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.dto.Reception;
import com.mycompany.webapp.dto.Doctor;

@Service
public class ReceptionUpdateService {
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ReceptionUpdateDAO receptionUpdateDAO;
	
	//환자 리스트 가져오기
	public List<Patient> getPatientList() {
		List<Patient> list = receptionUpdateDAO.patientList();	
		return list;
	}
	
	//의사 리스트 가져오기 
	public List<Doctor> getDoctorList() {
		List<Doctor> list = receptionUpdateDAO.doctorList();	
		return list;
	}
	
	public List<Reception> receptionListByDate(String r_date){
		List<Reception> list = receptionUpdateDAO.receptionListByDate(r_date);
		return list;
	}
	
	public void addReception(Reception reception) {
		receptionUpdateDAO.insertReception(reception);
	}
	
	public List<Reception> receptionListByDoctor(String doctor_id, String r_date){
		List<Reception> list = receptionUpdateDAO.receptionListByDoctor(doctor_id, r_date);
		return list;
	}
	
	public void updateReception(Reception reception) {
		receptionUpdateDAO.updateReception(reception);
	}
} 
