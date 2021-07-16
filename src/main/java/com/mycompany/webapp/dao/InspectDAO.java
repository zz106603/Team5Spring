package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.DiagnosisInspection;
import com.mycompany.webapp.dto.Patient;



public interface InspectDAO {
	public List<Patient> IpatientList();
	public List<DiagnosisInspection> InspectList(@Param("pno")String pno,@Param("did")String did);
	public void updateInspectStatus(@Param("iId")String i_id,@Param("bundleCode")String bundle_code,@Param("patientId")String patient_id,@Param("changeValue")String changeValue);
	public void updateInspectResult(@Param("iId")String i_id,@Param("bundleCode")String bundle_code,@Param("patientId")String patient_id,@Param("iResult")String iresult);
	public void updateInspectPstatus(@Param("dId")String d_id, @Param("totalIstatus")String total_i_status);
}
