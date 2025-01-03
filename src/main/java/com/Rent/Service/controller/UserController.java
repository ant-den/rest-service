package com.Rent.Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Rent.Service.model.User;
import com.Rent.Service.repository.UserRepository;
import com.Rent.Service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    /**
     * Get all users.
     * 
     * @return List of all users.
     */
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Create a new user.
     * 
     * @param firstName User's first name.
     * @param lastName  User's last name.
     * @param userEmail User's email.
     * @param userPhone User's phone number.
     * @return The created User object.
     */
    @PostMapping("/new user")
    public User createUser(@RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String userEmail,
            @RequestParam Long userPhone) {
        return userService.createUser(firstName, lastName, userEmail, userPhone);
    }
}