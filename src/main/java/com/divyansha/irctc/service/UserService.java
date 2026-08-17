package com.divyansha.irctc.service;

import com.divyansha.irctc.dto.LoginRequest;
import com.divyansha.irctc.dto.LoginResponse;
import com.divyansha.irctc.dto.RegisterUserRequest;
import com.divyansha.irctc.dto.UserResponse;
import com.divyansha.irctc.entity.User;
import com.divyansha.irctc.exception.EmailAlreadyRegisteredException;
import com.divyansha.irctc.exception.InvalidCredentialsException;
import com.divyansha.irctc.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    // Constructor Injection
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UserResponse registerUser(RegisterUserRequest request) {
        Optional<User> existingUser =
                userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new EmailAlreadyRegisteredException("Email already registered");
        }
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

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
        String token = jwtService.generateToken(user.getId(), user.getRole());
        return new LoginResponse(token);
    }
}
