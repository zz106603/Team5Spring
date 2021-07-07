package com.mycompany.webapp.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InspectPatient {
	private String patientId;
	private String patientName;
	private String patientSex;
	private int PatientAge;
	
	private String iDate;
	private String totalIstatus;
	private String dId;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public int getPatientAge() {
		return PatientAge;
	}
	public void setPatientAge(int patientAge) {
		PatientAge = patientAge;
	}
	public String getiDate() {
		return iDate;
	}
	public void setiDate(String iDate) {
		this.iDate = iDate;
	}
	
	public String getTotalIstatus() {
		return totalIstatus;
	}
	public void setTotalIstatus(String totalIstatus) {
		this.totalIstatus = totalIstatus;
	}
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	
}
