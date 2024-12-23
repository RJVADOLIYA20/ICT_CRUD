package com.ty.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
	   private String date;
	   private String gender;
	   private String address;
	   private String state;
	   private String district;
	   private String taluka;
	   private String pincode;
	   private String familyIncome;
	   private String interest;
	   private int j2ee;
	   private int hibernate;
	   private int spring;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTaluka() {
		return taluka;
	}
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getFamilyIncome() {
		return familyIncome;
	}
	public void setFamilyIncome(String familyIncome) {
		this.familyIncome = familyIncome;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public int getJ2ee() {
		return j2ee;
	}
	public void setJ2ee(int j2ee) {
		this.j2ee = j2ee;
	}
	public int getHibernate() {
		return hibernate;
	}
	
	public void setHibernate(int hibernate) {
		this.hibernate = hibernate;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "userEntity [id=" + id + ", fullName=" + fullName + ", date=" + date + ", gender=" + gender
				+ ", address=" + address + ", state=" + state + ", district=" + district + ", taluka=" + taluka
				+ ", pincode=" + pincode + ", familyIncome=" + familyIncome + ", interest=" + interest + ", j2ee="
				+ j2ee + ", hibernate=" + hibernate + ", spring=" + spring + "]";
	}
	
	
}
