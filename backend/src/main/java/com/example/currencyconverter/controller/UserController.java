package com.example.currencyconverter.controller;

import com.example.currencyconverter.dto.CreateUserRequest;
import com.example.currencyconverter.entity.User;
import com.example.currencyconverter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // GET user by API key
    @GetMapping("/{apiKey}")
    public ResponseEntity<User> getUserByApiKey(@PathVariable("apiKey") String apiKey){
        Optional<User> user = userService.findByApiKey(apiKey);

        return user
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREATE new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request){
        User createdUser =
                userService.createUser(request.username(), request.apiKey());
        return ResponseEntity.ok(createdUser);
    }

}
