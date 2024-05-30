package com.incident.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailResponse {

	public int id;
	public String userName;
	public String emailId;
	public String address;
	public String pin;
	public String city;
	public String country;
	public String phoneNo;
	
	   public int getId() {
	        return id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public String getEmailId() {
	        return emailId;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getPin() {
	        return pin;
	    }

	    public String getCity() {
	        return city;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public String getPhoneNo() {
	        return phoneNo;
	    }

	    // Setters
	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public void setPin(String pin) {
	        this.pin = pin;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

	    public void setPhoneNo(String phoneNo) {
	        this.phoneNo = phoneNo;
	    }
}

