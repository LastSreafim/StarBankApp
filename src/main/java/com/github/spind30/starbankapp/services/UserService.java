package com.github.spind30.starbankapp.services;

import com.github.spind30.starbankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UUID getUserIdByUsername(String username) {
        return userRepository.getUserIdByUsername(username);
    }

    public String getFullNameByUsername(String username) {
        return userRepository.getFullNameByUsername(username);
    }
}

