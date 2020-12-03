package com.ankitdipto.Community_Health_Management.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CLUB_MEMBER_RECORDS
{
	@Column(length=20,nullable = false)
	private String Name;

	@Id
	private int MembershipId;
	
	private Date JoinDate;
	
	@Column(length=10)
	private String Position;
	
	private int Age;
	
	private boolean AvailabilityStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "AadharNo",referencedColumnName = "AadharNo")
	private PUBLIC_RECORDS pubrec5;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getMembershipId() {
		return MembershipId;
	}

	public void setMembershipId(int membershipId) {
		MembershipId = membershipId;
	}

	public Date getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public boolean isAvailabilityStatus() {
		return AvailabilityStatus;
	}

	public void setAvailabilityStatus(boolean availabilityStatus) {
		AvailabilityStatus = availabilityStatus;
	}

	public PUBLIC_RECORDS getPubrec5() {
		return pubrec5;
	}

	public void setPubrec5(PUBLIC_RECORDS pubrec5) {
		this.pubrec5 = pubrec5;
	}

		
}
