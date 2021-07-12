package com.mycompany.webapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.dto.Reception;
import com.mycompany.webapp.service.ReceptionService;

@CrossOrigin(origins="*", allowedHeaders = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/reception")
public class ReceptionController {
	private final Logger logger = LoggerFactory.getLogger(ReceptionController.class);
	
	@Autowired
	private ReceptionService receptionService;
	
	@GetMapping("")
  	public List<Reception> list(String day) throws Exception{
		List<Reception> list = receptionService.getReceptionList(day);
		
		System.out.println(list.get(0).getrDate());
		System.out.println(list.get(0).getPatientSex());
		System.out.println(list.get(0).getDoctorName());
		System.out.println(list.get(0).getDoctorOffice());
		System.out.println(list.get(0).getPatientName());
		System.out.println(list.get(0).getPatientId());
		System.out.println(list.get(0).getPatientPhone());
		System.out.println(list.get(0).getPatientSsn1());
		
		
		return list;
	}	
	
	@PostMapping("/registration")
	@ResponseBody
	public void registration(@RequestBody Patient patientRegister) {
		String insertId = receptionService.getLastId();
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
		receptionService.registerPatient(patientRegister);
	}
	
	@DeleteMapping("/cancelReception")
  	public void delList(int cancelId) throws Exception{
		receptionService.deletePatient(cancelId);
	}
	
	@GetMapping("/changeReception")
  	public void changeList(int changeId){
		receptionService.changePatient(changeId);
	}
	
	@GetMapping("/countReception")
	public int[] countList(String day) {
		int countWating = receptionService.countWating(day);
		int countComplete = receptionService.countComplete(day);
		int countList[] = new int[2];
		countList[0] = countWating;
		countList[1] = countComplete;
		return countList;
	}
	
	@GetMapping("/countDay")
	public int[] countDay(String day, String day1, String day2, String day3, String day4, String day5) {		
		int[] countList = {
			receptionService.countRday(day),	
			receptionService.countRday(day1),
			receptionService.countRday(day2),
			receptionService.countRday(day3),
			receptionService.countRday(day4),
			receptionService.countRday(day5)
		};
		System.out.println(countList);		
		return countList;
	}
}
