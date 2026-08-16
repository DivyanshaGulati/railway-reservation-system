package com.divyansha.irctc.service;

import com.divyansha.irctc.dto.RegisterUserRequest;
import com.divyansha.irctc.dto.UserResponse;
import com.divyansha.irctc.entity.User;
import com.divyansha.irctc.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    // Constructor Injection
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(RegisterUserRequest request) {
        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole("USER");

        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        User registeredUser = userRepository.save(user);
        return new UserResponse(registeredUser.getId(), registeredUser.getFullName(), registeredUser.getEmail(), registeredUser.getRole(), registeredUser.getCreatedAt(), registeredUser.getUpdatedAt());
    }
}
