package com.mycompany.webapp.dto;

public class DiagnosisInspection {
	private String iId;
	private String dId;
	private String iStatus;
	private String iResult;
	private	String patientId;
	private String bundleCode;
	private String iName;
	private String iUnit;
	private String lowerLimit;
	private String upperLimit;
	private	String inspector;
	public String getiId() {
		return iId;
	}
	public void setiId(String iId) {
		this.iId = iId;
	}
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public String getiStatus() {
		return iStatus;
	}
	public void setiStatus(String iStatus) {
		this.iStatus = iStatus;
	}
	public String getiResult() {
		return iResult;
	}
	public void setiResult(String iResult) {
		this.iResult = iResult;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getBundleCode() {
		return bundleCode;
	}
	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getiUnit() {
		return iUnit;
	}
	public void setiUnit(String iUnit) {
		this.iUnit = iUnit;
	}
	public String getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public String getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	
	
}
