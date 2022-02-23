package com.janawatECommerceSystem.janawatECommerceSystem.exceptions;

public class LoginException extends RuntimeException {
    public LoginException(String username) {
        super(String.format("login failed for user: %s", username));
    }
}
