package com.incident.database.services;

import com.incident.model.UserDetail;
import com.incident.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository repository;

    @Override
    public void save(UserDetail detail) {
        repository.save(detail);
    }
    
    public boolean existsByEmail(String email) {
        return repository.existsByEmailId(email);
    }
    
    public UserDetail findByEmail(String email) {
		return repository.findByEmail(email);
	}

    public UserDetail findEmail(String email) {
		return repository.findEmail(email);
	}

	public void update(String password, String confirmPassword, String email) {
		repository.update(password, confirmPassword, email);

	}
}
