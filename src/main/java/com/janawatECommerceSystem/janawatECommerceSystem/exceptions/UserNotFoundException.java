package com.janawatECommerceSystem.janawatECommerceSystem.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super(name);
    }
}
