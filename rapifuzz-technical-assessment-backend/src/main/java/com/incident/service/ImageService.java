package com.incident.service;

import java.time.Year;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.incident.database.services.IncidentServiceImpl;
import com.incident.database.services.UserDetailServiceImpl;
import com.incident.model.Incident;
import com.incident.model.UserDetail;
import com.incident.repository.IncidentRepository;
import com.incident.request.ForgotPasswordRequest;
import com.incident.request.IncidentRequest;
import com.incident.request.LoginRequest;
import com.incident.request.UserDetailsRequest;
import com.incident.request.updateIncidentRequest;
import com.incident.response.CommonResponse;
import com.incident.response.GetIncidentResponse;

@Service
public class ImageService {
 @Autowired
	private UserDetailServiceImpl userDetailService;

	@Autowired
	private GetIncidentResponse getIncidentResponse;
	
	@Autowired
	private IncidentServiceImpl incidentService;

	@Autowired
	private IncidentRepository incidentRepository;

	Gson gson = new Gson();
	Gson gsonObj = new GsonBuilder().setPrettyPrinting().create();

	/*
	 * public UserDetailResponse getDeatilService() { stub return null; }
	 */

	public CommonResponse addUser(UserDetailsRequest userDetailsRequest) {
		System.out.print("Inside Add user Controller");

		// Password and Confirm Password Validation
		String password = userDetailsRequest.getpassword();
		String confirmPassword = userDetailsRequest.getconfirmPassword();
		if (!password.equals(confirmPassword)) {
			CommonResponse commonResponse = new CommonResponse();
			commonResponse.setErrorCode(150);
			commonResponse.setStatus("Password and confirm password do not match");
			return commonResponse;
		}

		// Phone Number Validation
		String phoneNo = userDetailsRequest.getPhoneNo();
		if (phoneNo.length() != 10) {
			CommonResponse commonResponse = new CommonResponse();
			commonResponse.setErrorCode(151);
			commonResponse.setStatus("Phone number must be 10 digits long");
			return commonResponse;
		}

		// Email Validation
		String email = userDetailsRequest.getEmailId();
		if (!isValidEmail(email)) {
			CommonResponse commonResponse = new CommonResponse();
			commonResponse.setErrorCode(152);
			commonResponse.setStatus("Invalid email address");
			return commonResponse;
		}

		// Check if email is unique
		if (userDetailService.existsByEmail(email)) {
			CommonResponse commonResponse = new CommonResponse();
			commonResponse.setErrorCode(153);
			commonResponse.setStatus("Email address already exists");
			return commonResponse;
		}

		// Set user details if all validations pass
		UserDetail userDetail = new UserDetail();
		userDetail.setUserName(userDetailsRequest.getUserName());
		userDetail.setEmailId(email);
		userDetail.setAddress(userDetailsRequest.getAddress());
		userDetail.setPin(userDetailsRequest.getPinCode());
		userDetail.setCity(userDetailsRequest.getCity());
		userDetail.setCountry(userDetailsRequest.getCountry());
		userDetail.setPhoneNo(phoneNo);
		userDetail.setPassword(password);
		userDetail.setconfirmPassword(confirmPassword);

		userDetailService.save(userDetail);

		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setErrorCode(100);
		commonResponse.setStatus("Success");

		return commonResponse;
	}

//-------------------------------------------------------

	public CommonResponse loginUser(LoginRequest loginRequest) {
		UserDetail user = userDetailService.findByEmail(loginRequest.getEmail());
		// Check if user exists
		if (user == null) {
			// If user does not exist, return error response with code 155
			return new CommonResponse("Invalid email", 155);
		} else {
			// If user exists, check if password matches
			if (user.getpassword().equals(loginRequest.getPassword())) {
				// If password matches, return success response with code 100
				return new CommonResponse("Login successful", 100);
			} else {
				// If password is incorrect, return error response with code 156
				return new CommonResponse("Incorrect password", 156);
			}
		}
	}

//--------------------------------------------------
	public CommonResponse addIncident(IncidentRequest request) {

		UserDetail user = userDetailService.findByEmail(request.getEmail());
		String email = request.getEmail();
		String password = request.getPassword();

		if (user == null || !user.getpassword().equals(password)) {
			// If email or password is incorrect, return error response
			return new CommonResponse("Invalid credentials", 130);
		} else {

			Incident incident = new Incident();

			incident.setReporterName(request.getReporterName());
			incident.setIncidentDetail(request.getIncidentDetail());
			incident.setIncidentId(generateRandomIncidentId());

			if (request.getPriority().equalsIgnoreCase("high") || request.getPriority().equalsIgnoreCase("low")
					|| request.getPriority().equalsIgnoreCase("medium")) {
				incident.setPriority(request.getPriority());
			} else {
				incident.setPriority("low");
			}

			if (request.getIncidentStatus().equalsIgnoreCase("open") || request.getIncidentStatus().equalsIgnoreCase("closed")
					|| request.getIncidentStatus().equalsIgnoreCase("inprogress")) {
				incident.setIncidentStatus(request.getIncidentStatus());
			} else {
				incident.setIncidentStatus("Inprogress");

			}

			if (!"enterprise".equalsIgnoreCase(request.getIdentity()) && !"government".equalsIgnoreCase(request.getIdentity())) {
			    // If type is not Enterprise or Government, return error response
			    return new CommonResponse("Invalid identity", 131);
			}
			incident.setIdentity(request.getIdentity());
			System.out.print("incident" + incident + "\n");
			incidentService.save(incident);
		}

		return new CommonResponse("Login successful", 100);
	}

//-----------------------------------------------
	@Transactional
	public CommonResponse forgotPassword(ForgotPasswordRequest request) {
		try {
			// Find the user by email
			UserDetail user = userDetailService.findByEmail(request.getEmail());
			if (user == null) {
				return new CommonResponse("User with the provided email does not exist", 133);
			}

			// Check if new password and confirm password match
			if (!request.getNewPassword().equals(request.getConfirmPassword())) {
				return new CommonResponse("New password and confirm password do not match", 132);
			}

			// Update the password in the database
			user.setPassword(request.getNewPassword());
			user.setConfirmpassword(request.getConfirmPassword());
			userDetailService.save(user);

			return new CommonResponse("Password updated successfully", 100);
		} catch (Exception e) {
			// Handle any exceptions
			return new CommonResponse("Failed to update password. Please try again later.", 134);
		}
	}

//--------------------------------
	public GetIncidentResponse GetIncidentDetail(String incidentId) {
	    // Check if incident_id is null
	    if (incidentId == null) {
	        return getIncidentResponse.createErrorResponse("Invalid IncidentId", 120);
	    }

	    // Retrieve UserIncident object from service
	    Incident incident = incidentService.findByIncidentId(incidentId);

	    // Check if userIncident is null or incidentId is null
	    if (incident == null || incident.getIncidentId() == null ) {
	        return getIncidentResponse.createErrorResponse("Incident not found for given ID", 404);
	    }
	    
	    // Prepare response
	    GetIncidentResponse response = new GetIncidentResponse();
		response.setReporterName(incident.getReporterName());
	    response.setIncidentDetail(incident.getIncidentDetail());
	    response.setIncidentId(incidentId);
	    response.setIncidentStatus(incident.getIncidentStatus());
	    response.setPriority(incident.getPriority());
		response.setErrorMsg("Got IncidentResponse Successfully!");
	    response.setErrorCode(100);

	    return response;
	}


//-------------------------------
	public GetIncidentResponse updateIncidentDetail(updateIncidentRequest request) {

		Incident incident = new Incident();

		if (request.getIncidentId().isEmpty()|| request.getIncidentId() == null || request == null ) {
            return getIncidentResponse.createErrorResponse("Please enter Incident Id", 120);
        }
		
		incident = incidentService.findByIncidentId(request.getIncidentId());
		
		if (incident == null || incident.getIncidentId() == null ) {
            return getIncidentResponse.createErrorResponse("Invalid incident id or not found", 120);
        }
		
		incidentService.updateIncident(request.getPriority(), request.getIncidentDetail(), request.getIncidentId());

		GetIncidentResponse getIncidentResponse = new com.incident.response.GetIncidentResponse();

		getIncidentResponse.setIncidentDetail(request.getIncidentDetail());
		getIncidentResponse.setPriority(request.getPriority());
		getIncidentResponse.setReporterName(incident.getReporterName());
		getIncidentResponse.setIncidentId(incident.getIncidentId());

		if (incident.getIncidentStatus().equalsIgnoreCase("closed")) {
			getIncidentResponse.setIncidentStatus("closed");
			incidentService.updateStatus("closed", request.getIncidentId());
			getIncidentResponse.setIncidentStatus("closed");

            return getIncidentResponse.createErrorResponse("You can't edit incident status because its already closed", 120);
		}
		getIncidentResponse.setIncidentStatus(request.getIncidentStatus());
		getIncidentResponse.setErrorMsg("Updated IncidentResponse Successfully!");
        getIncidentResponse.setErrorCode(100);


		return getIncidentResponse;

	}



//-------------------------------------
	public boolean isValidEmail(String email) {
		// Check if email is not null or empty
		if (email == null || email.isEmpty()) {
			return false;
		}

		// Split email address into local part and domain part
		String[] parts = email.split("@");

		// Check if email has exactly one "@" symbol
		if (parts.length != 2) {
			return false;
		}

		// Check if local part is not empty
		String localPart = parts[0];
		if (localPart.isEmpty()) {
			return false;
		}

		// Check if domain part is not empty
		String domainPart = parts[1];
		if (domainPart.isEmpty()) {
			return false;
		}

		// Check if domain part contains at least one dot (.)
		if (!domainPart.contains(".")) {
			return false;
		}

		return true;
	}

//----------------------------------------------------------------
	public boolean existsByEmail(String email) {
		// Implement logic to check if a user with the given email exists in the
		// database
		// This is a simplified example assuming you're using Spring Data JPA

		// Assuming you have a UserRepository injected into your service
		return userDetailService.existsByEmail(email);
	}

//-----------------------------
	public static String generateRandomIncidentId() {
		// Generate a random 5-digit number
		Random random = new Random();
		int randomNumber = random.nextInt(90000) + 10000; // Random number between 10000 and 99999

		// Get the current year (assuming 2022)
		int currentYear = Year.now().getValue();

		// Construct and return the Incident ID in the specified format
		return "RMG" + randomNumber + currentYear;
	}

	public List<Incident> getAllIncidents() {
        return (List<Incident>) incidentRepository.findAll();
    }

}

