package com.janawat.ecommerce.authen;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserToken {

    public String createTokenByUserName(String username) {
        return String.format("sample_token %s", username);
    }

    public String decodeToken(String token) {

        Scanner sc = new Scanner(token);
        String user = "";
        while (sc.hasNext()) {
            user = sc.next();
        }

        return user;

    }
}
