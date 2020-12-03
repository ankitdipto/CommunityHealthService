package com.ankitdipto.Community_Health_Management.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class LOCATION 
{
    @Id
    @Column(name="AddressCode")
    private int AddressCode;
    
    @Column(name="pincode")
    private int Pincode;

    @Column(name="stree_name",length=30)
    private String StreetName;

    @Column(name="street_no")
    private int StreetNo;

    @Column(name="block_number")
    private int BlockNo;

    @OneToMany(mappedBy = "location1",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
    private Set<PUBLIC_RECORDS> persons = new LinkedHashSet<>();

    @OneToOne(mappedBy = "location2",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
    private HOSPITAL_INFORMATION hospital;

    @OneToOne(mappedBy = "location3",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
    private ISOLATION_CENTRE_DETAILS isocentre;

    @OneToOne(mappedBy = "location4",
			 cascade = CascadeType.ALL ,
			 fetch = FetchType.LAZY ,
			 orphanRemoval = true)
    private DOCTORS doctor;
    
    public int getAddressCode() {
        return AddressCode;
    }

    public void setAddressCode(int addressCode) {
        AddressCode = addressCode;
    }

    public int getPincode() {
        return Pincode;
    }

    public void setPincode(int pincode) {
        Pincode = pincode;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public int getStreetNo() {
        return StreetNo;
    }

    public void setStreetNo(int streetNo) {
        StreetNo = streetNo;
    }

    public int getBlockNo() {
        return BlockNo;
    }

    public void setBlockNo(int blockNo) {
        BlockNo = blockNo;
    }

    
}
