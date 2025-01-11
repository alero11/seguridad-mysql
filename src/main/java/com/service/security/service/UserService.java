package com.service.security.service;

import com.service.security.model.User;
import com.service.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private UserRepository repository;


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}
