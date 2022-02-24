package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.exceptions.LoginException;
import com.janawatECommerceSystem.janawatECommerceSystem.response.LoginResponse;
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
    public LoginResponse loginFail(LoginException e){
        loginResponse.setMessage("Login Fail..."+e.getMessage());
        loginResponse.setToken("");
        return  loginResponse ;
    }
}

