package com.mycompany.webapp.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Diagnosis;
import com.mycompany.webapp.dto.DiagnosisInspection;
import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.dto.State;
import com.mycompany.webapp.mqtt.MqttTemplate;
import com.mycompany.webapp.service.InspectService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/inspection")
public class InspectController {
	private final Logger logger = LoggerFactory.getLogger(InspectController.class);

	@Autowired
	private InspectService inspectService;
	
	@Autowired
	private MqttTemplate mqttTemplate;

	@GetMapping("")
	public List<Patient> list() {
		List<Patient> list = inspectService.getPateintList();
		return list;
	}

	@GetMapping("/inspectList")
	public List<DiagnosisInspection> Inspectlist(String pno, String did) {
		List<DiagnosisInspection> list = inspectService.getInspectList(pno, did);
		return list;
	}

	@PutMapping("/updateInspect/{changeValue}")
	@ResponseBody
	public void updateInspect(@RequestBody DiagnosisInspection inspection, @PathVariable String changeValue ) {
		logger.info(inspection.getPatientId());
		inspectService.UpdateInspect(inspection.getiId(), inspection.getBundleCode(),inspection.getPatientId(), changeValue);

	}
	
	@PutMapping("/updateInspectResult/")
	@ResponseBody
	public Map<String,String> updateInspectResult(@RequestBody DiagnosisInspection inspection) {	
		Map<String, String> map = new HashMap<>();		
		if(inspection.getiResult()=="") {
			map.put("result", "failed");
			return map;
	}
		inspectService.UpdateInspectResult(inspection.getiId(), inspection.getBundleCode(),inspection.getPatientId(), inspection.getiResult());
		map.put("result", "success");
		return map;
	}

	@PutMapping("/updatePinspect/")
	@ResponseBody
	public void UpdatePinspect(@RequestBody Diagnosis diagnosis) {
		inspectService.UpdatePatientStatus(diagnosis.getdId(), diagnosis.getTotalIstatus());
	}
	


}