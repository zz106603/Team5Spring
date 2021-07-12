package com.mycompany.webapp.dto;

import java.util.Date;
import java.util.List;

public class Diagnosis {
	
	private String dDate;
	private Date addDdate;
	private String dStatus;
	private String iDate;
	private String totalIstatus;
	private String dId;
	
	private String comment;
	private String patientId;
	private List<Medicine> medicineList;
	private List<Inspection> inspectionList;
	
	private int receptionId;
	
	
	//과거기록 검사 목록
	private String bundleCode;
	private String iId;
	private String iName;
	private String inspector;
	private String iResult;
	
	
	

	public String getBundleCode() {
		return bundleCode;
	}

	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public Date getAddDdate() {
		return addDdate;
	}

	public void setAddDdate(Date addDdate) {
		this.addDdate = addDdate;
	}

	public String getiId() {
		return iId;
	}

	public void setiId(String iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public String getiResult() {
		return iResult;
	}

	public void setiResult(String iResult) {
		this.iResult = iResult;
	}

	public int getReceptionId() {
		return receptionId;
	}

	public void setReceptionId(int receptionId) {
		this.receptionId = receptionId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public List<Medicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
	}

	public List<Inspection> getInspectionList() {
		return inspectionList;
	}

	public void setInspectionList(List<Inspection> inspectionList) {
		this.inspectionList = inspectionList;
	}


	public String getdDate() {
		return dDate;
	}

	public void setdDate(String dDate) {
		this.dDate = dDate;
	}

	public String getdStatus() {
		return dStatus;
	}

	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
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

	
	
	

}
