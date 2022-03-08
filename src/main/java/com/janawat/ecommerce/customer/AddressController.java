package com.janawat.ecommerce.customer;

import com.janawat.ecommerce.authen.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private UserToken userToken;

    @Autowired
    private AddressService addressService;


    @GetMapping("/address")
    public ResponseEntity<AddressResponse> getAddressResponse(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {

        String username = userToken.decodeToken(token);

        return new ResponseEntity<>(AddressResponse.fromAddress(addressService.getDefaulAddress(username)), HttpStatus.OK);

    }
}
