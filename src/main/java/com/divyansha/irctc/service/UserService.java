package com.divyansha.irctc.service;

import com.divyansha.irctc.dto.RegisterUserRequest;
import com.divyansha.irctc.entity.User;
import com.divyansha.irctc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;

    // Constructor Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(RegisterUserRequest request) {
        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user.setRole("USER");

        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        return userRepository.save(user);
    }
}
