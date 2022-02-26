package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.RestConsumer;
import com.janawatECommerceSystem.janawatECommerceSystem.models.Address;
import com.janawatECommerceSystem.janawatECommerceSystem.response.AddressResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.AddressService;
import com.janawatECommerceSystem.janawatECommerceSystem.services.UserToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @LocalServerPort
    int randomServerPort;
    @MockBean
    private UserToken userToken;
    @MockBean
    private AddressService addressService;
    @Autowired
    private RestConsumer testTemp;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("GetAddress โดยส่ง User=user1 และ token=sampleToken ต้องได้  Address ของ user1")
    void getAddressResponse() {

        String TOKEN = "sampleToken";
        String USER = "user1";
        String URL = "http://localhost:" + randomServerPort + "/GetAddress";


        Address address = new Address(
                "Nuchit",
                "Sample Address",
                "123456789",
                "Bangkapi",
                "Bangkok",
                "10310");

        when(userToken.decodeToken(TOKEN)).thenReturn(USER);
        when(addressService.getDefaulAddress(USER)).thenReturn(address);

        AddressResponse response = testTemp.getWithToken(URL, TOKEN, AddressResponse.class).getBody();


        assertNotNull(response);
        assertEquals(address.getAddress(), response.toAddress().getAddress());

    }


}