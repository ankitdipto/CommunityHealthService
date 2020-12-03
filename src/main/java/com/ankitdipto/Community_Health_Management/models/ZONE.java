package com.ankitdipto.Community_Health_Management.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ZONE
{
	@Id
	@Column(name="WardNo")
	private int WardNo;
	
	@Column(length=30)
	private String Mla;

	private int NoOfResidents;
	private int PopulationDensity;
	private java.util.Date SanitisationStatus;
	private int NoOfCovid19Cases;

	@OneToMany(mappedBy = "zone",
			  cascade = CascadeType.REMOVE,
			  fetch = FetchType.LAZY,
			  orphanRemoval = true)
	private Set<ISOLATION_CENTRE_DETAILS> Isoset=new LinkedHashSet<ISOLATION_CENTRE_DETAILS>();

	/*@OneToMany(mappedBy = "zone2",
			  cascade = CascadeType.REMOVE,
			  fetch = FetchType.LAZY,
			  orphanRemoval = true)
	private Set<REQUIREMENTS> Reqset=new LinkedHashSet<REQUIREMENTS>();*/

	@OneToMany(mappedBy = "zone3",
			  cascade = CascadeType.REMOVE,
			  fetch = FetchType.LAZY,
			  orphanRemoval = true)
	private Set<HOSPITAL_INFORMATION> Hospitals=new LinkedHashSet<HOSPITAL_INFORMATION>();

	public int getWardNo() {
		return WardNo;
	}

	public void setWardNo(int wardNo) {
		WardNo = wardNo;
	}

	public String getMla() {
		return Mla;
	}

	public void setMla(String mla) {
		Mla = mla;
	}

	public int getNoOfResidents() {
		return NoOfResidents;
	}

	public void setNoOfResidents(int noOfResidents) {
		NoOfResidents = noOfResidents;
	}

	public int getPopulationDensity() {
		return PopulationDensity;
	}

	public void setPopulationDensity(int populationDensity) {
		PopulationDensity = populationDensity;
	}

	public java.util.Date getSanitisationStatus() {
		return SanitisationStatus;
	}

	public void setSanitisationStatus(java.util.Date sanitisationStatus) {
		SanitisationStatus = sanitisationStatus;
	}

	public int getNoOfCovid19Cases() {
		return NoOfCovid19Cases;
	}

	public void setNoOfCovid19Cases(int noOfCovid19Cases) {
		NoOfCovid19Cases = noOfCovid19Cases;
	}

	public Set<ISOLATION_CENTRE_DETAILS> getIsoset() {
		return Isoset;
	}

	public void setIsoset(Set<ISOLATION_CENTRE_DETAILS> isoset) {
		Isoset = isoset;
	}

	/*public Set<REQUIREMENTS> getReqset() {
		return Reqset;
	}

	public void setReqset(Set<REQUIREMENTS> reqset) {
		Reqset = reqset;
	}*/

	public Set<HOSPITAL_INFORMATION> getHospitals() {
		return Hospitals;
	}

	public void setHospitals(Set<HOSPITAL_INFORMATION> hospitals) {
		Hospitals = hospitals;
	}

	
}
