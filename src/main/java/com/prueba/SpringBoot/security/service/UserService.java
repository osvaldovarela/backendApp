package com.prueba.SpringBoot.security.service;


import com.prueba.SpringBoot.security.entity.User;
import com.prueba.SpringBoot.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public void save(User user){
        userRepository.save(user);
    }
}