package com.richardcalin.planitpoker.service;

import com.richardcalin.planitpoker.model.entity.User;
import com.richardcalin.planitpoker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
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
