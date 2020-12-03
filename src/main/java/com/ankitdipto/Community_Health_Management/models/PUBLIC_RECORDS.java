package com.ankitdipto.Community_Health_Management.models;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class PUBLIC_RECORDS
{
	@Id
	private long AadharNo;
	
	@Column(length=20)
	private String Name;
	
	private int Age;
	
	@Column(length=5)
	private String BloodGroup;
	
	@Column(name="profession",length=20)
	private String WorkInformation;
	
	private int ContactNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="AddressCode",referencedColumnName = "AddressCode")
	private LOCATION location1;
	
	/*@Column(length=20)
	private String CurrentHealthStatus;
	
	private int NoOfFamilyMembers;*/

	@OneToOne(mappedBy = "pubrec",
			 cascade = CascadeType.ALL,
			 fetch = FetchType.LAZY,
			 orphanRemoval = true)
	private COVID19_ACTIVE CovidInfected;

	/*@OneToOne(mappedBy = "pubrec2",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
	private REQUIREMENTS Reqitems;*/
	
	/*@OneToOne(mappedBy = "pubrec3",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
	private DENGUE_ACTIVE Dengvictim;*/
	
	@OneToOne(mappedBy = "pubrec4",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
	private COVID19_RECOVERED Noncov;

	@OneToOne(mappedBy = "pubrec5",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
	private CLUB_MEMBER_RECORDS ClubMember;

	public long getAadharNo() {
		return AadharNo;
	}

	public void setAadharNo(long aadharNo) {
		AadharNo = aadharNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getBloodGroup() {
		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	public String getWorkInformation() {
		return WorkInformation;
	}

	public void setWorkInformation(String workInformation) {
		WorkInformation = workInformation;
	}

	public int getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(int contactNumber) {
		ContactNumber = contactNumber;
	}

	public COVID19_ACTIVE getCovidInfected() {
		return CovidInfected;
	}

	public void setCovidInfected(COVID19_ACTIVE covidInfected) {
		CovidInfected = covidInfected;
	}

	/*public REQUIREMENTS getReqitems() {
		return Reqitems;
	}

	public void setReqitems(REQUIREMENTS reqitems) {
		Reqitems = reqitems;
	}*/

	public COVID19_RECOVERED getNoncov() {
		return Noncov;
	}

	public void setNoncov(COVID19_RECOVERED noncov) {
		Noncov = noncov;
	}

	public CLUB_MEMBER_RECORDS getClubMember() {
		return ClubMember;
	}

	public void setClubMember(CLUB_MEMBER_RECORDS clubMember) {
		ClubMember = clubMember;
	}

	@Override
	public String toString() {
		return "PUBLIC_RECORDS [AadharNo=" + AadharNo + ", Age=" + Age + ", BloodGroup=" + BloodGroup + ", ClubMember="
				+ ClubMember + ", ContactNumber=" + ContactNumber + ", CovidInfected=" + CovidInfected + ", Name="
				+ Name + ", Noncov=" + Noncov + ", WorkInformation=" + WorkInformation + ", location1=" + location1
				+ "]";
	}

	public LOCATION getLocation1() {
		return location1;
	}

	public void setLocation1(LOCATION location1) {
		this.location1 = location1;
	}
	
	
}	