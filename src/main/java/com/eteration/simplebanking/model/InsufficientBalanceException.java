package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation
public class InsufficientBalanceException extends Exception {
    private String message;

    public InsufficientBalanceException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
