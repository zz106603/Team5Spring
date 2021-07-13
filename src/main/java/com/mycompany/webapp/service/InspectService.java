package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.InspectDAO;
import com.mycompany.webapp.dto.DiagnosisInspection;
import com.mycompany.webapp.dto.Patient;

@Service
public class InspectService {
	@Autowired
	private InspectDAO inspectDao;
	
	public List<Patient> getPateintList() {
		List<Patient> list = inspectDao.IpatientList(); 
		
		return list;
	}
	
	public List<DiagnosisInspection> getInspectList(String pno,String did) {
		List<DiagnosisInspection> list = inspectDao.InspectList(pno,did); 
		
		return list;
	}
	
	public void UpdateInspect(String i_id,String bundle_code,String patient_id,String changeValue) {
		inspectDao.updateInspectStatus(i_id, bundle_code,patient_id,changeValue);
	}
	
	public void UpdatePatientStatus(String d_id,String total_i_status) {
		inspectDao.updateInspectPstatus(d_id, total_i_status);
	}
}
