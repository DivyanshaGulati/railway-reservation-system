package com.divyansha.irctc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorResponse {
    private int status;
    private Map<String, String> errors;
}
