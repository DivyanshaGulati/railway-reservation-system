package com.divyansha.irctc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
