package com.janawat.ecommerce.user;

import com.janawat.ecommerce.authen.UserToken;
import com.janawat.ecommerce.authen.LoginException;
import com.janawat.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private   UserRepository userRepository;//
//    public UserService(){}
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//
//    }


    @Autowired
    private UserToken userToken;


    public User create(String email, String password, String userName) {
        //validate
        if(Objects.isNull(email)) {
            //throw email null
        }


        //verify


        //save
        User user = new User();


        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);

        return userRepository.save(user);

    }

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

//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }
}

