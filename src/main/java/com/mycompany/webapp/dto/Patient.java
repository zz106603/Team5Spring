package com.mycompany.webapp.dto;

public class Patient {

	private String patientId;
	private String patientName; 
	private int patientAge; 
	private String patientSex; 
	private String patientSsn1; 
	private String patientSsn2; 
	private String patientPhone; 
	private int patientZip; 
	private String address; 
	private String addressDetail;
	
	private int rId;
	
	public int getrId() {
		return rId;
	}
	
	public void setrId(int rId) {
		this.rId = rId;
	}
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
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public String getPatientSsn1() {
		return patientSsn1;
	}
	public void setPatientSsn1(String patientSsn1) {
		this.patientSsn1 = patientSsn1;
	}
	public String getPatientSsn2() {
		return patientSsn2;
	}
	public void setPatientSsn2(String patientSsn2) {
		this.patientSsn2 = patientSsn2;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public int getPatientZip() {
		return patientZip;
	}
	public void setPatientZip(int patientZip) {
		this.patientZip = patientZip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	
	
	
}
