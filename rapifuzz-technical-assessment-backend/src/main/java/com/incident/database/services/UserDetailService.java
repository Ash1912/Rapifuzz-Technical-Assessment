package com.incident.database.services;

import com.incident.model.UserDetail;

public interface UserDetailService {
    void save(UserDetail userDetail); // Method to save UserDetail object
    
    boolean existsByEmail(String email);
    
	public UserDetail findByEmail(String email);

	public UserDetail findEmail(String email);
	
	public static void update(String password, String confirmPassword, String email) {
		// TODO Auto-generated method stub
		
	}
}
