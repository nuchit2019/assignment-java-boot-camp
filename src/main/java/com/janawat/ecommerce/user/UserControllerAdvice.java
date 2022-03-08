package com.janawat.ecommerce.user;

import com.janawat.ecommerce.authen.LoginResponse;
import com.janawat.ecommerce.authen.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @Autowired
    private LoginResponse loginResponse;

    @ExceptionHandler(LoginException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public LoginResponse loginFail(LoginException e) {
        loginResponse.setMessage("Login Fail..." + e.getMessage());
        loginResponse.setToken("");
        return loginResponse;
    }
}

