package com.mycompany.webapp.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Diagnosis;
import com.mycompany.webapp.dto.DiagnosisHasInspection;
import com.mycompany.webapp.dto.Inspection;
import com.mycompany.webapp.dto.Medicine;
import com.mycompany.webapp.dto.MedicineHasDiagnosis;
import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.mqtt.MqttTemplate;
import com.mycompany.webapp.service.DiagnosisService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
	private final Logger logger = LoggerFactory.getLogger(DiagnosisController.class);
	
	@Autowired
	private DiagnosisService diagnosisService;

	@Autowired
	private MqttTemplate mqttTemplate;
	
	@RequestMapping("/home")
	public String test(){
		return "home";	   
	}

	@GetMapping("/medicines")
	public List<Medicine> medicineList(){
		List<Medicine> list = diagnosisService.getMedicineList();
		return list;
	}
	
	@GetMapping("/inspectionlist")
	public List<Inspection> inspectionList(){
		List<Inspection> list = diagnosisService.getInspectionList();
		return list;
	}
	
	@GetMapping("/inspections")
	public List<Inspection> inspectionAllList(){
		List<Inspection> list = diagnosisService.getInspectionAllList();
		return list;
	}
	
	@GetMapping("/patientlist")
	public List<Patient> patientList(String day){
		List<Patient> list = diagnosisService.getPatientList(day);
		
		return list;
	}
	
	@GetMapping("/pastrecord")
	public List<Diagnosis> pastRecordList(@RequestParam(defaultValue = "")String pId){
		List<Diagnosis> list = diagnosisService.getRecordList(pId);

		return list;
	}
	
	@GetMapping("/selectpatient")
	public Patient selectPatient(@RequestParam(defaultValue = "") String pId){
		Patient patient = diagnosisService.getPatient(pId);
		return patient;
	}
	
	@PostMapping("/pushdiagnosis")
	@ResponseBody
	public void add(@RequestBody Diagnosis diagnosis) {
		
		
		
		Calendar dDate  = Calendar.getInstance();
		dDate.setTime(new Date());
		Calendar iDate  = Calendar.getInstance();
		iDate.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df2 = new SimpleDateFormat("yyMMddHHmmssSSS");
		
		iDate.add(Calendar.MINUTE, 30);
		
		Diagnosis d = new Diagnosis();
		
		d.setdId(df2.format(new Date()));
		d.setdDate(df.format(dDate.getTime()));
		if(diagnosis.getInspectionList().size() != 0) {
			d.setiDate(df.format(iDate.getTime()));
			d.setdStatus("완료");
		}else {
			d.setdStatus("대기");
		}
		d.setComment(diagnosis.getComment());
		d.setTotalIstatus("대기");
		d.setReceptionId(diagnosis.getReceptionId());
		System.out.println(diagnosis.getReceptionId());
		diagnosisService.addDiagnosis(d);
		
		String currentDid = diagnosisService.getCurrentDid();
		
		
		for(int i=0; i<diagnosis.getInspectionList().size(); i++) {
			DiagnosisHasInspection di = new DiagnosisHasInspection();
			di.setiId(diagnosis.getInspectionList().get(i).getiId());
			di.setdId(currentDid);
			di.setiStatus("대기");
			di.setpId(diagnosis.getPatientId());
			di.setBundleCode(diagnosis.getInspectionList().get(i).getBundleCode());
			diagnosisService.addInspection(di);
		}
		
		for(int i=0; i<diagnosis.getMedicineList().size(); i++) {
			MedicineHasDiagnosis md = new MedicineHasDiagnosis();
			md.setmId(diagnosis.getMedicineList().get(i).getmId());
			md.setdId(currentDid);
			md.setpId(diagnosis.getPatientId());
			diagnosisService.addMedicine(md);
		}
		
		
	}
	
	@GetMapping("pastrecordilist")
	public List<Diagnosis> pastRecordIlist(@RequestParam(defaultValue = "")String pId, @RequestParam(defaultValue = "")String day){
		List<Diagnosis> list = diagnosisService.getPastRecordIlist(pId, day);
		return list;
		
	}
	
	@GetMapping("pastrecordmlist")
	public List<Diagnosis> pastRecordMlist(@RequestParam(defaultValue = "")String pId, @RequestParam(defaultValue = "")String day){
		List<Diagnosis> list = diagnosisService.getPastRecordMlist(pId, day);
		return list;
		
	}
	
	@GetMapping("pastrecordmemo")
	public Diagnosis pastRecordMemo(@RequestParam(defaultValue = "")String pId, @RequestParam(defaultValue = "")String day){
		Diagnosis diagnosis = diagnosisService.getPastRecordMemo(pId, day);
				
		return diagnosis;
		
	}
	
}
