package com.coderhack.coderhack.exception;

@SuppressWarnings("serial")
public class InvalidScoreException extends RuntimeException {
    public InvalidScoreException(String message) {
        super(message);
    }
}