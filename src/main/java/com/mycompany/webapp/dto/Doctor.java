package com.mycompany.webapp.dto;


public class Doctor {
	private String doctorId;
	private String doctorName;
	private String doctorPhone;
	private String doctorOffice;
	private String userId;
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorPhone() {
		return doctorPhone;
	}
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	public String getDoctorOffice() {
		return doctorOffice;
	}
	public void setDoctorOffice(String doctorOffice) {
		this.doctorOffice = doctorOffice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}