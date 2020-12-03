package com.ankitdipto.Community_Health_Management.unused;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ankitdipto.Community_Health_Management.models.PUBLIC_RECORDS;



//@Entity
public class LIVES_IN 
{

	private String STREET;
	private int PINCODE;

	/*@Id
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="UID",referencedColumnName = "AADHAR_NO" )*/
	
	private PUBLIC_RECORDS pubrec;

	/*@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="area",referencedColumnName = "WARD_NO")
	private ZONE zone;*/

	public String getStreet(){
		return STREET;
	}

	public void setStreet(String STREET){
		this.STREET=STREET;
	}

	public int getPincode(){
		return PINCODE;
	}

	public void setPincode(int PINCODE){
		this.PINCODE=PINCODE;
	}
}