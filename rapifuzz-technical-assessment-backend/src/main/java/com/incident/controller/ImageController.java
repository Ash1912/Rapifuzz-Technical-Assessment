package com.incident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.incident.request.ForgotPasswordRequest;
import com.incident.request.IncidentRequest;
import com.incident.request.LoginRequest;
import com.incident.request.UserDetailsRequest;
import com.incident.request.updateIncidentRequest;
import com.incident.response.CommonResponse;
import com.incident.response.GetIncidentResponse;
import com.incident.service.ImageService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class ImageController {
    @Autowired
	private ImageService imageService;
	

	
	@PostMapping("user/registration")
	public CommonResponse addUser(@RequestBody UserDetailsRequest userDetailsRequest) {
	log.info("Registering user: {}", userDetailsRequest.getUserName());
    return imageService.addUser(userDetailsRequest);
	}
	
	@GetMapping("user/login")
	public CommonResponse loginUser(@RequestBody LoginRequest loginRequest) {
       return imageService.loginUser(loginRequest);
	}
	
	@PostMapping("add/incident")
	public CommonResponse addIncident(@RequestBody IncidentRequest request) {
		return imageService.addIncident(request);
	}
	
	@PostMapping("forgot/password")
	public CommonResponse forgotPassword(@RequestBody ForgotPasswordRequest request) {
		return imageService.forgotPassword(request);
	}
	
	@GetMapping("/get/incident/{incidentId}")
	public GetIncidentResponse getIncidentDetail(@PathVariable("incidentId") String incident_id) {
	    return imageService.GetIncidentDetail(incident_id);
	}
	
	@PostMapping("update/incident")
	public GetIncidentResponse updateIncidentDetail(@RequestBody updateIncidentRequest request ) {
		return imageService.updateIncidentDetail(request);
	}
	
    
}
