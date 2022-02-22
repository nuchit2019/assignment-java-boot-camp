package com.janawatECommerceSystem.janawatECommerceSystem.services;

import com.janawatECommerceSystem.janawatECommerceSystem.exceptions.UserNotFoundException;
import com.janawatECommerceSystem.janawatECommerceSystem.models.User;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String ConcatDat(String name){
        Optional<User> result = userRepository.findByName(name);

        if(result.isPresent()){
            return "Hello "+result.get().getName();
        }

        throw new UserNotFoundException(name);
    }
}
