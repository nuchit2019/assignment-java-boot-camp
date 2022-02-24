package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.response.AddressResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.AddressService;
import com.janawatECommerceSystem.janawatECommerceSystem.services.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private UserToken userToken;

    @Autowired
    private AddressService addressService;


    @GetMapping("/GetAddress")
    public AddressResponse getAddressResponse(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {

        String username = userToken.decodeToken(token);

        return AddressResponse.fromAddress(addressService.getDefaulAddress(username));

    }
}
