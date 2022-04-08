package com.example.detail_storage.service;

import com.example.detail_storage.model.User;
import com.example.detail_storage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    public Collection<User> getUsers() {

        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
