package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.exceptions.LoginException;
import com.janawatECommerceSystem.janawatECommerceSystem.models.User;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToken userToken;

    public String login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return userToken.createTokenByUserName(username);
            }
        }

        throw new LoginException(username);
    }

    public String getUserByToken(String token) {
        return userToken.decodeToken(token);
    }

    public void register(User newUser) {
        userRepository.save(newUser);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }
}

