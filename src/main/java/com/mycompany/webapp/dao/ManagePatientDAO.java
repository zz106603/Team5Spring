package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Doctor;
import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.dto.Reception;

@Mapper
public interface ManagePatientDAO {
	public List<Patient> patientList();
	public int updatePatient(Patient patient);
}
