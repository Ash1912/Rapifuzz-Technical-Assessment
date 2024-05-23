package com.incident.services;

import com.incident.entity.UserEntity;
import com.incident.model.User;
import com.incident.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity = userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            BeanUtils.copyProperties(user, existingUser.get(), "id", "password");
            userRepository.save(existingUser.get());
            BeanUtils.copyProperties(existingUser.get(), user);
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            User user = new User();
            BeanUtils.copyProperties(userEntity.get(), user);
            return user;
        }
        return null;
    }
}
