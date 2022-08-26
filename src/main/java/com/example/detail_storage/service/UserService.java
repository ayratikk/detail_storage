package com.example.detail_storage.service;

import com.example.detail_storage.common.exception.ExceptionHandler;
import com.example.detail_storage.model.Role;
import com.example.detail_storage.model.User;
import com.example.detail_storage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    ExceptionHandler ex;

    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }
}
