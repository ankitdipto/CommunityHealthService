package com.ankitdipto.Community_Health_Management.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class COVID19_ACTIVE
{
	/*@Id
	private int HealthCardNo;
	
	private String HealthProblems;
	private String Symptoms;*/
	@Id
	@Column(name="aadhar_id")
	private long AadharNo;

	@Column(name="respiratory_problem")
	private boolean BreathingTrouble;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="AadharNo",referencedColumnName = "AadharNo")
	private PUBLIC_RECORDS pubrec;

	@Column(name="Infection_Status",nullable=false,columnDefinition = "boolean default true")
	private boolean Status;

	@Column(name="age")
	private int Age;

	public boolean isBreathingTrouble() {
		return BreathingTrouble;
	}

	public void setBreathingTrouble(boolean breathingTrouble) {
		BreathingTrouble = breathingTrouble;
	}

	public PUBLIC_RECORDS getPubrec() {
		return pubrec;
	}

	public void setPubrec(PUBLIC_RECORDS pubrec) {
		this.pubrec = pubrec;
		this.AadharNo=pubrec.getAadharNo();
		this.Age=pubrec.getAge();
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public long getAadharNo() {
		return AadharNo;
	}

	public void setAadharNo(long aadharNo) {
		AadharNo = aadharNo;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

		
}
