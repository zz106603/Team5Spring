package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Doctor;
import com.mycompany.webapp.dto.Patient;
import com.mycompany.webapp.dto.Reception;

@Mapper
public interface ReceptionUpdateDAO {
	public List<Patient> patientList();
	public List<Doctor> doctorList();
	public int insertReception(Reception reception);
	public List<Reception> receptionListByDoctor(@Param("doctorId") String doctor_id, @Param("rDate") String r_date);
	public int updateReception(Reception reception);
}
