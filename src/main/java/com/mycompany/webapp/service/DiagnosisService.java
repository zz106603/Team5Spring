package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.DiagnosisDAO;
import com.mycompany.webapp.dto.Diagnosis;
import com.mycompany.webapp.dto.DiagnosisInspection;
import com.mycompany.webapp.dto.Inspection;
import com.mycompany.webapp.dto.Medicine;
import com.mycompany.webapp.dto.MedicineDiagnosis;
import com.mycompany.webapp.dto.Patient;

@Service
public class DiagnosisService {
	
	@Autowired
	private DiagnosisDAO diagnosisDAO;
	
	public List<Medicine> getMedicineList() {
		List<Medicine> list = diagnosisDAO.medicineSelectAll(); 
		return list;
	}
	
	public List<Inspection> getInspectionList() {
		List<Inspection> list = diagnosisDAO.inspectionSelectAll(); 
		return list;
	}
	
	public List<Inspection> getInspectionAllList() {
		List<Inspection> list = diagnosisDAO.inspectionListAll(); 
		return list;
	}
	
	public List<Patient> getPatientList(String day) {
		List<Patient> list = diagnosisDAO.patientList(day); 
		return list;
	}
	
	public List<Diagnosis> getRecordList(String pId) {
		List<Diagnosis> list = diagnosisDAO.pastRecordList(pId); 
		return list;
	}

	public Patient getPatient(String pId) {
		Patient patient = diagnosisDAO.selectPatient(pId);
		return patient;
	}

	public List<Diagnosis> getPastRecordIlist(String pId, String day) {
		List<Diagnosis> list = diagnosisDAO.pastRecordIlist(pId, day); 
		return list;
	}

	
	public List<Diagnosis> getPastRecordMlist(String pId, String day) {
		List<Diagnosis> list = diagnosisDAO.pastRecordMlist(pId, day); 
		return list;
	}
	
	public Diagnosis getPastRecordMemo(String pId, String day) {
		Diagnosis diagnosis = diagnosisDAO.pastRecordMemo(pId, day);
		return diagnosis;
	}

	public int addDiagnosis(Diagnosis d) {
		int result = diagnosisDAO.addDiagnosis(d);
		return result;
	}

	public String getCurrentDid() {
		String result = diagnosisDAO.getCurrentDid();
		return result;
	}

	public int addInspection(DiagnosisInspection di) {
		int result = diagnosisDAO.addInspection(di);
		return result;
	}

	public int addMedicine(MedicineDiagnosis md) {
		int result = diagnosisDAO.addMedicine(md);
		return result;
		
	}

	public List<DiagnosisInspection> getInspectCompareList() {
		List<DiagnosisInspection> list = diagnosisDAO.inspectCompareList(); 
		return list;
	}


}
