package com.ankitdipto.Community_Health_Management.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class HOSPITAL_INFORMATION
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RegistrationNo;

	@Column(length=20,nullable = false)
	private String HospitalName;
	
	@Column(nullable = false)
	private int NoOfGeneralBeds;
	
	@Column(nullable = false)
	private int NoOfCovidBedsFree;
	
	private boolean RtpcrTestAvailibility;
	
	private int NoOfFullTimeDoctors;
	
	private int NoOfDengueBedsFree;
	
	/*@Column(length=30,nullable = false)
	private String Location;
	
	@Column(length=20,nullable = false)
	private String Street;
	
	private int Pincode;*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="AddressCode",referencedColumnName = "AddressCode")
	private LOCATION location2;

	@ManyToOne
	@JoinColumn(name="Locality",referencedColumnName = "WardNo")
	private ZONE zone3;

	public int getRegistrationNo() {
		return RegistrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		RegistrationNo = registrationNo;
	}

	public String getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}

	public int getNoOfGeneralBeds() {
		return NoOfGeneralBeds;
	}

	public void setNoOfGeneralBeds(int noOfGeneralBeds) {
		NoOfGeneralBeds = noOfGeneralBeds;
	}

	public int getNoOfCovidBedsFree() {
		return NoOfCovidBedsFree;
	}

	public void setNoOfCovidBedsFree(int noOfCovidBedsFree) {
		NoOfCovidBedsFree = noOfCovidBedsFree;
	}

	public boolean isRtpcrTestAvailibility() {
		return RtpcrTestAvailibility;
	}

	public void setRtpcrTestAvailibility(boolean rtpcrTestAvailibility) {
		RtpcrTestAvailibility = rtpcrTestAvailibility;
	}

	public int getNoOfFullTimeDoctors() {
		return NoOfFullTimeDoctors;
	}

	public void setNoOfFullTimeDoctors(int noOfFullTimeDoctors) {
		NoOfFullTimeDoctors = noOfFullTimeDoctors;
	}

	public int getNoOfDengueBedsFree() {
		return NoOfDengueBedsFree;
	}

	public void setNoOfDengueBedsFree(int noOfDengueBedsFree) {
		NoOfDengueBedsFree = noOfDengueBedsFree;
	}

	public ZONE getZone3() {
		return zone3;
	}

	public void setZone3(ZONE zone3) {
		this.zone3 = zone3;
	}

	public LOCATION getLocation2() {
		return location2;
	}

	public void setLocation2(LOCATION location2) {
		this.location2 = location2;
	}

    @Override
    public String toString() {
          return "HOSPITAL_INFORMATION [HospitalName=" + HospitalName + ", NoOfCovidBedsFree=" + NoOfCovidBedsFree
                      + ", NoOfDengueBedsFree=" + NoOfDengueBedsFree + ", NoOfFullTimeDoctors=" + NoOfFullTimeDoctors
                      + ", NoOfGeneralBeds=" + NoOfGeneralBeds + ", RegistrationNo=" + RegistrationNo+"]";
    }

		
}
