package com.ankitdipto.Community_Health_Management.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class DOCTORS
{
	@Id
	@Column(name="LicenceNo")
	private int MedicalId;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="LicenceNo", referencedColumnName = "MedicalId")
	private MEDICAL_HELP_RECORDS Healthworker;
	
	//@Column(length=30)
	//private String ChamberLocation;
	
	@Column(length=10)
	private String DutyHours;
	
	@Column(length=30)
	private String Degree;
	
	/*@Column(length=20)
	private String ChamberStree;
	private int ChamberPincode;*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="chamber_address_code",referencedColumnName = "AddressCode")
	private LOCATION location4;

	public int getMedicalId() {
		return MedicalId;
	}

	public void setMedicalId(int medicalId) {
		MedicalId = medicalId;
	}

	public MEDICAL_HELP_RECORDS getHealthworker() {
		return Healthworker;
	}

	public void setHealthworker(MEDICAL_HELP_RECORDS healthworker) {
		Healthworker = healthworker;
		this.MedicalId=healthworker.getMedicalId();
	}

	public String getDutyHours() {
		return DutyHours;
	}

	public void setDutyHours(String dutyHours) {
		DutyHours = dutyHours;
	}

	public String getDegree() {
		return Degree;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}

	public LOCATION getLocation4() {
		return location4;
	}

	public void setLocation4(LOCATION location4) {
		this.location4 = location4;
	}
}