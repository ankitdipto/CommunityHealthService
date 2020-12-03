package com.ankitdipto.Community_Health_Management.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MEDICAL_HELP_RECORDS
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int MedicalId;
	
	@Column(length=20)
	private String Name;

	@Column(length=30)
	private String Profession;

	//@Column(length=30)
	//private String Address;

	private boolean AvailibilityStatus =true ;

	@OneToOne(mappedBy = "Healthworker",
			 cascade = CascadeType.ALL,
			 fetch = FetchType.LAZY,
			 orphanRemoval = true)
	private DOCTORS Doctor;
	
	@OneToOne(mappedBy = "Healthworker2",
			  cascade = CascadeType.ALL,
			  fetch = FetchType.LAZY,
			  orphanRemoval = true)
	private AMBULANCE_DETAILS Ambulance;

	public int getMedicalId() {
		return MedicalId;
	}

	public void setMedicalId(int medicalId) {
		MedicalId = medicalId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public boolean getAvailibilityStatus() {
		return AvailibilityStatus;
	}

	public void setAvailibilityStatus(boolean availibilityStatus) {
		AvailibilityStatus = availibilityStatus;
	}

	public DOCTORS getDoctor() {
		return Doctor;
	}

	public void setDoctor(DOCTORS doctor) {
		Doctor = doctor;
	}

	public AMBULANCE_DETAILS getAmbulance() {
		return Ambulance;
	}

	public void setAmbulance(AMBULANCE_DETAILS ambulance) {
		Ambulance = ambulance;
	}

	
}
