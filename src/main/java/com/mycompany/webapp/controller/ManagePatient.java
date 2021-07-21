package com.mycompany.webapp.controller;


import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.service.ManagePatientService;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/managePatient")
public class ManagePatient {
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ManagePatientService managePatientService;
	
	@GetMapping("/patientList")
	public List<Patient> plist(){
		List<Patient> list = managePatientService.getPatientList();
		return list;
	}

	@PutMapping("/update")
	@ResponseBody
	public void updateReception(@RequestBody Patient patient) {
		managePatientService.updatePatient(patient);
	}
	
	@PostMapping("/registration")
	@ResponseBody
	public void registration(@RequestBody Patient patientRegister) {
		String insertId = managePatientService.getLastId();
		int newId =  Integer.parseInt(insertId);
		newId++;
		String setId = Integer.toString(newId);
		boolean flag = true;
		while(flag) {
			setId = 0+setId;
			if(setId.length() == 5) {
				flag = false;
			}
		}
		patientRegister.setPatientId(setId);
		managePatientService.registerPatient(patientRegister);
	}
}
