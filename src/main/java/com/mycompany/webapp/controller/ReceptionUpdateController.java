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
import com.mycompany.webapp.dto.Reception;
import com.mycompany.webapp.dto.Doctor;
import com.mycompany.webapp.service.ReceptionUpdateService;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/receptionUpdate")
public class ReceptionUpdateController {
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ReceptionUpdateService receptionUpdateService;
	
	@GetMapping("/patientList")
	public List<Patient> plist(){
		List<Patient> list = receptionUpdateService.getPatientList();
		return list;
	}
	
	@GetMapping("/doctorList")
	public List<Doctor> dList(){
		List<Doctor> list = receptionUpdateService.getDoctorList();
		return list;
	}

	@PostMapping("/insertReception")
	@ResponseBody
	public void insertReception(@RequestBody Reception reception) {
		receptionUpdateService.addReception(reception);	
	}
	
	@GetMapping("/receptionListByDoc")
	public List<Reception> rList(String doctor_id, String r_date){
		List<Reception> list = receptionUpdateService.receptionListByDoctor(doctor_id, r_date);
		return list;
	}
	
	@PutMapping("/update")
	@ResponseBody
	public void updateReception(@RequestBody Reception reception) {
		receptionUpdateService.updateReception(reception);
	}
}
