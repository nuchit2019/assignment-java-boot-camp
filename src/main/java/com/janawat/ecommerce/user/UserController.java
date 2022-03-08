package com.janawat.ecommerce.user;

import com.janawat.ecommerce.authen.LoginRequest;
import com.janawat.ecommerce.authen.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginResponse loginResponse;

    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public LoginResponse login(@RequestBody LoginRequest request) {
        String token = userService.login(request.getUsername(), request.getPassword());
        loginResponse.setMessage("Login Success...");
        loginResponse.setToken(token);
        return loginResponse;
    }

}
