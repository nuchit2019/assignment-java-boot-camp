package com.janawatECommerceSystem.janawatECommerceSystem.controllers;

import com.janawatECommerceSystem.janawatECommerceSystem.exceptions.LoginException;
import com.janawatECommerceSystem.janawatECommerceSystem.models.User;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.UserRepository;
import com.janawatECommerceSystem.janawatECommerceSystem.request.LoginRequest;
import com.janawatECommerceSystem.janawatECommerceSystem.response.LoginResponse;
import com.janawatECommerceSystem.janawatECommerceSystem.services.UserService;
import com.janawatECommerceSystem.janawatECommerceSystem.services.UserToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserToken userToken;



    @Test
    @DisplayName("Login User testing, Password=1234 จะต้องได้ token=sample_token testing")
    public void LoginSuccess() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/login/";
        URI uri = new URI(baseUrl);

        User user = new User();
        user.setUsername("testing");
        user.setPassword("1234");


        userService.setUserRepository(userRepository);
        userService.setUserToken(userToken);

        when(userRepository.findByUsername("testing")).thenReturn(Optional.of(user));
        when(userToken.createTokenByUserName("testing")).thenReturn("sample_token " + user.getUsername());


        LoginRequest loginRequest = new LoginRequest("testing", "1234");
        LoginResponse response = testRestTemplate.postForEntity(uri, loginRequest, LoginResponse.class).getBody();

        assert response != null;
        assertEquals("sample_token " + user.getUsername(), response.getToken());

    }

    @Test
    @DisplayName("Login User  testing, Password=1234XX จะต้อง Throws LoginException")
    public void LoginFailed() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/login/";
        URI uri = new URI(baseUrl);

        User user = new User();
        user.setUsername("testing");
        user.setPassword("1234");


        userService.setUserRepository(userRepository);
        userService.setUserToken(userToken);

        when(userRepository.findByUsername("testing"))
                .thenReturn(Optional.of(user));

        assertThrows(LoginException.class, () -> {
            userService.login("testing", "1234XX");
        });

    }


}