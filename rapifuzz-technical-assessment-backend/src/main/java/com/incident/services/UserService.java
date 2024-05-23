package com.incident.services;

import com.incident.model.User;

public interface UserService {
    User createUser(User user);

    User updateUser(Long id, User user);

    boolean deleteUser(Long id);

    User getUserById(Long id);
}
