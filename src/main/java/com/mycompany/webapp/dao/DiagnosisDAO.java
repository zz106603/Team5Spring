package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Diagnosis;
import com.mycompany.webapp.dto.DiagnosisHasInspection;
import com.mycompany.webapp.dto.Inspection;
import com.mycompany.webapp.dto.Medicine;
import com.mycompany.webapp.dto.MedicineHasDiagnosis;
import com.mycompany.webapp.dto.Patient;

@Mapper
public interface DiagnosisDAO {
	public List<Medicine> medicineSelectAll();
	public List<Inspection> inspectionSelectAll();
	public List<Inspection> inspectionListAll();
	public List<Patient> patientList(String day);
	public List<Diagnosis> pastRecordList(String pId);
	public Patient selectPatient(String pId);
	public List<Diagnosis> pastRecordIlist(@Param("pId")String pId, @Param("day")String day);
	public List<Diagnosis> pastRecordMlist(@Param("pId")String pId, @Param("day")String day);
	public Diagnosis pastRecordMemo(@Param("pId")String pId, @Param("day")String day);
	public int addDiagnosis(Diagnosis diagnosis);
	public String getCurrentDid();
	public int addInspection(DiagnosisHasInspection di);
	public int addMedicine(MedicineHasDiagnosis md);

	
	
}
