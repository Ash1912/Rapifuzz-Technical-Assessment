package com.incident.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") // Update column name to "user_id"
	private Integer id;

	@Column(name = "User_Name")
	private String userName;

	@Column(name = "User_email")
	private String emailId;

	@Column(name = "User_address")
	private String address;

	@Column(name = "pin_code")
	private String pinCode;

	@Column(name = "city_name")
	private String city;

	@Column(name = "country_name")
	private String country;

	@Column(name = "User_phoneNo")
	private String phoneNo;

	@Column(name = "password")
	private String password;

	@Column(name = "confirm_Password")
	private String confirmPassword;


	// Getter methods
	public Integer getId() {
		return id;
	}

	public String getpassword() {
		return password;
	}

	public String getconfirmPassword() {
		return confirmPassword;
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
		return pinCode;
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

	// Setter methods
	public void setId(Integer id) {
		this.id = id;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public void setconfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
		this.pinCode = pin;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmpassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String toCustomString() {
        return "UserDetail{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

}
