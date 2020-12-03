package com.ankitdipto.Community_Health_Management.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AMBULANCE_DETAILS
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String RegistrationNo;
	
	@Column(length=20,nullable = false)
	private String OwnerName;

	/*@Column(length=40,nullable = false)
	private String EquipmentsAvailable;
	
	@Column(length=30)
	private String ParkingLocation;*/
	@Column(name="availability")
	private boolean AvailabilityStatus =true;
	
	@OneToOne
	@JoinColumn(name="medical_staff_id", referencedColumnName = "MedicalId")
	private MEDICAL_HELP_RECORDS Healthworker2;

	public String getRegistrationNo() {
		return RegistrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		RegistrationNo = registrationNo;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}

	public MEDICAL_HELP_RECORDS getHealthworker2() {
		return Healthworker2;
	}

	public void setHealthworker2(MEDICAL_HELP_RECORDS healthworker2) {
		Healthworker2 = healthworker2;
		
	}

	public boolean isAvailabilityStatus() {
		return AvailabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) {
		AvailabilityStatus = availabilityStatus;
	}

			
}
