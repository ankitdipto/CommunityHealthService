package com.ankitdipto.Community_Health_Management.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class COVID19_RECOVERED
{
	@Column(name="name",length=20,nullable = false)
	private String Name;
	
	//private int Age;
	
	@Column(name="curr_health_status")
	private boolean CurrentHealthStatus;
	
	@Column(length=5, nullable = false)
	private String BloodGroup;
	
	@Id
	@Column(name="aadhar_id")
	private long AadharNo;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="aadhar_id",referencedColumnName = "AadharNo")
	private PUBLIC_RECORDS pubrec4;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBloodGroup() {
		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	public long getAadharNo() {
		return AadharNo;
	}

	public void setAadharNo(long aadharNo) {
		AadharNo = aadharNo;
	}

	public PUBLIC_RECORDS getPubrec4() {
		return pubrec4;
	}

	public void setPubrec4(PUBLIC_RECORDS pubrec4) {
		this.pubrec4 = pubrec4;
		this.AadharNo=pubrec4.getAadharNo();
	}

	public void setCurrentHealthStatus(boolean currentHealthStatus) {
		CurrentHealthStatus = currentHealthStatus;
	}

	public boolean isCurrentHealthStatus() {
		return CurrentHealthStatus;
	}

	
}
