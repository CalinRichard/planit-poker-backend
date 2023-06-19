package com.richardcalin.planitpoker.service;

import com.richardcalin.planitpoker.model.entity.User;
import com.richardcalin.planitpoker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String email) {
        User user = new User();
        user.setEmail(email);
        userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
