package com.janawatECommerceSystem.janawatECommerceSystem.services;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserToken {
    public String createTokenByUserName(String username)
    {
        return String.format("Bearer %s", username);
    }

    public String decodeToken (String token){
        Scanner scanner = new Scanner(token);
        scanner.next();
        return scanner.next();
    }
}
