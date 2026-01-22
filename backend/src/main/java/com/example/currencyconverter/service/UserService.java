package com.example.currencyconverter.service;

import com.example.currencyconverter.entity.User;
import com.example.currencyconverter.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(String username, String apiKey){
        User user = new User(username, apiKey);
        return userRepository.save(user);
    }

    public Optional<User> findByApiKey(String apiKey){
        return userRepository.findByApiKey(apiKey);
    }
}
