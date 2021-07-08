package com.mycompany.webapp.dto;

import java.util.Date;

public class Reception {
	private int rId;
	private String rDate;
	private String rTime;
	private String rStatus;
	private String doctorId;
	private String patientId; 
	private String patientName;
	private String patientSsn1; 
	private String patientPhone;
	private String rRole;
	
	public String getrRole() {
		return rRole;
	}
	public void setrRole(String rRole) {
		this.rRole = rRole;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSsn1() {
		return patientSsn1;
	}
	public void setPatientSsn1(String patientSsn1) {
		this.patientSsn1 = patientSsn1;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	

	
}
