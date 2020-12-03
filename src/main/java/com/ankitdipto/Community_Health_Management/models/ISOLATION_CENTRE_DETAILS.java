package com.ankitdipto.Community_Health_Management.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class ISOLATION_CENTRE_DETAILS
{
	@Id
	private int CentreCode;

	//@Column(length=30)
	//private String Address;

	private double SizeOfRoom;
	
	private double TotalCostPerDay;
	
	private int AccommodationStrength;
	
	private int NoOfVacancies;
	
	/*@Column(length=20)
	private String Location;
	
	@Column(length=20)
	private String Street;
	
	private int Pincode;*/

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Locality",referencedColumnName = "WardNo")
	private ZONE zone;

	@OneToOne
	@JoinColumn(name="AddressCode",referencedColumnName = "AddressCode")
	private LOCATION location3;

	public int getCentreCode() {
		return CentreCode;
	}

	public void setCentreCode(int centreCode) {
		CentreCode = centreCode;
	}

	public double getSizeOfRoom() {
		return SizeOfRoom;
	}

	public void setSizeOfRoom(double sizeOfRoom) {
		SizeOfRoom = sizeOfRoom;
	}

	public double getTotalCostPerDay() {
		return TotalCostPerDay;
	}

	public void setTotalCostPerDay(double totalCostPerDay) {
		TotalCostPerDay = totalCostPerDay;
	}

	public int getAccommodationStrength() {
		return AccommodationStrength;
	}

	public void setAccommodationStrength(int accommodationStrength) {
		AccommodationStrength = accommodationStrength;
	}

	public int getNoOfVacancies() {
		return NoOfVacancies;
	}

	public void setNoOfVacancies(int noOfVacancies) {
		NoOfVacancies = noOfVacancies;
	}

	public ZONE getZone() {
		return zone;
	}

	public void setZone(ZONE zone) {
		this.zone = zone;
	}

	public LOCATION getLocation3() {
		return location3;
	}

	public void setLocation3(LOCATION location3) {
		this.location3 = location3;
	}


	

	
}
