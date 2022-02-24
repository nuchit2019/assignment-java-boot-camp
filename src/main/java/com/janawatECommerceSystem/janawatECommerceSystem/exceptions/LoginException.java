package com.janawatECommerceSystem.janawatECommerceSystem.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginException extends RuntimeException {

    public LoginException(String username) {
        super(String.format("login failed for user: %s", username));
    }
}
