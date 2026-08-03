package com.divyansha.irctc.exception;

public class TrainNotFoundException extends RuntimeException {
    public TrainNotFoundException(String message) {
        super(message);
    }
}
