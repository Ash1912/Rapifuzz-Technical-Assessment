package com.incident.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetailsRequest {

    public String userName;
	public String emailId;
	public String address;
	public String pinCode;
	public String city;
	public String country;
	public String phoneNo;
    private String password;
   
   private String confirmPassword;

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

    public String getPinCode() {
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



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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
    
    
    public void setpassword(String password) {
        this.password = password;
    }
    
    public void setconfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
}
