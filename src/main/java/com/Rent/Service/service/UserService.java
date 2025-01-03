package com.Rent.Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rent.Service.model.User;
import com.Rent.Service.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(String firstName, String lastName, String userEmail, Long userPhone) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserEmail(userEmail);
        user.setUserPhone(userPhone);

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
