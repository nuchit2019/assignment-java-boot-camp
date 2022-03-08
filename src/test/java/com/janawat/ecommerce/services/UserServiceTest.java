package com.janawat.ecommerce.services;

import com.janawat.ecommerce.user.UserService;
import com.janawat.ecommerce.authen.UserToken;
import com.janawat.ecommerce.authen.LoginException;
import com.janawat.ecommerce.model.User;
import com.janawat.ecommerce.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserToken userToken;


    @Test
    @DisplayName("ส่ง username = testing และ password = 1234 จะต้องได้ token = testing")
    public void login() {

        UserService userService = new UserService();
        User user = new User();
        user.setUsername("testing");
        user.setPassword("1234");

        //userService.setUserRepository(userRepository);
        userService.setUserToken(userToken);

        when(userRepository.findByUsername("testing")).thenReturn(Optional.of(user));
        when(userToken.createTokenByUserName("testing")).thenReturn("testing");

        String result = userService.login("testing", "1234");

        assertEquals("testing", result);
    }

    @Test
    @DisplayName("ส่ง username = testing และ password = 1234xx จะต้อง Throws LoginException")
    public void loginFail() {

        User user = new User();
        user.setUsername("testing");
        user.setPassword("1234");

        UserService userService = new UserService();
        //userService.setUserRepository(userRepository);
        userService.setUserToken(userToken);

        when(userRepository.findByUsername("testing"))
                .thenReturn(Optional.of(user));

        assertThrows(LoginException.class, () -> { userService.login("testing", "1234XX");
        });

    }
}