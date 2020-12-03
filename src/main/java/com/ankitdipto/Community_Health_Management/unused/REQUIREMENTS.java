package com.ankitdipto.Community_Health_Management.unused;

import com.ankitdipto.Community_Health_Management.models.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
public class REQUIREMENTS
{
	@Column(length=20)
	private String Name;

	@Column(length=30)
	private String FoodItemsNeeded;
	
	@Column(length=30)
	private String RationNeeded;
	
	@Column(length=10)
	private String IncomeGroup;

	@Id
	@Column(name="AadharNo")
	private long AadharNo;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="AADHAR_NO",referencedColumnName = "AadharNo")
	private PUBLIC_RECORDS pubrec2;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Locality",referencedColumnName = "WardNo")
	private ZONE zone2;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFoodItemsNeeded() {
		return FoodItemsNeeded;
	}

	public void setFoodItemsNeeded(String foodItemsNeeded) {
		FoodItemsNeeded = foodItemsNeeded;
	}

	public String getRationNeeded() {
		return RationNeeded;
	}

	public void setRationNeeded(String rationNeeded) {
		RationNeeded = rationNeeded;
	}

	public String getIncomeGroup() {
		return IncomeGroup;
	}

	public void setIncomeGroup(String incomeGroup) {
		IncomeGroup = incomeGroup;
	}

	public long getAadharNo() {
		return AadharNo;
	}

	public void setAadharNo(long aadharNo) {
		AadharNo = aadharNo;
	}

	public PUBLIC_RECORDS getPubrec2() {
		return pubrec2;
	}

	public void setPubrec2(PUBLIC_RECORDS pubrec2) {
		this.pubrec2 = pubrec2;
		this.AadharNo=pubrec2.getAadharNo();
	}

	public ZONE getZone2() {
		return zone2;
	}

	public void setZone2(ZONE zone2) {
		this.zone2 = zone2;
	}

	
}
