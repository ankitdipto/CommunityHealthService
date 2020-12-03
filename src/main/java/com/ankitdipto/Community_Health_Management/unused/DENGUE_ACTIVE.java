package com.ankitdipto.Community_Health_Management.unused;

import com.ankitdipto.Community_Health_Management.models.PUBLIC_RECORDS;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class DENGUE_ACTIVE
{

	private double MaxBodyTemperature;
	
	private double BloodPressureLevel;
	
	private int BloodPlateletCount;
	
	private boolean UrgentRequirementOfBlood;
	
	@Column(length=30)
	private String OtherHealthProblems;
	
	@Column(length=30)
	private String OtherSymptoms;
	
	@Id
	@Column(name="AadharNo")
	private long AadharNo;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "AadharNo", referencedColumnName = "AadharNo")
	private PUBLIC_RECORDS pubrec3;

	public double getMaxBodyTemperature() {
		return MaxBodyTemperature;
	}

	public void setMaxBodyTemperature(double maxBodyTemperature) {
		MaxBodyTemperature = maxBodyTemperature;
	}

	public double getBloodPressureLevel() {
		return BloodPressureLevel;
	}

	public void setBloodPressureLevel(double bloodPressureLevel) {
		BloodPressureLevel = bloodPressureLevel;
	}

	public int getBloodPlateletCount() {
		return BloodPlateletCount;
	}

	public void setBloodPlateletCount(int bloodPlateletCount) {
		BloodPlateletCount = bloodPlateletCount;
	}

	public boolean isUrgentRequirementOfBlood() {
		return UrgentRequirementOfBlood;
	}

	public void setUrgentRequirementOfBlood(boolean urgentRequirementOfBlood) {
		UrgentRequirementOfBlood = urgentRequirementOfBlood;
	}

	public String getOtherHealthProblems() {
		return OtherHealthProblems;
	}

	public void setOtherHealthProblems(String otherHealthProblems) {
		OtherHealthProblems = otherHealthProblems;
	}

	public String getOtherSymptoms() {
		return OtherSymptoms;
	}

	public void setOtherSymptoms(String otherSymptoms) {
		OtherSymptoms = otherSymptoms;
	}

	public long getAadharNo() {
		return AadharNo;
	}

	public void setAadharNo(long aadharNo) {
		AadharNo = aadharNo;
	}

	public PUBLIC_RECORDS getPubrec3() {
		return pubrec3;
	}

	public void setPubrec3(PUBLIC_RECORDS pubrec3) {
		this.pubrec3 = pubrec3;
		this.AadharNo=pubrec3.getAadharNo();
	}

	

}