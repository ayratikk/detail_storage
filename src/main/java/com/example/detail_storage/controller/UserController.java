package com.example.detail_storage.controller;

import com.example.detail_storage.dto.UserDto;
import com.example.detail_storage.mapping.UserMapper;
import com.example.detail_storage.model.User;
import com.example.detail_storage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<UserDto> getAll() {
        return mapper.domainListToDtoList(userService.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser(@PathVariable Long id) {
        return mapper.domainToDto(userService.getUser(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto update(@RequestBody UserDto userDto) {
        return mapper.domainToDto(userService.saveUser(mapper.dtoToDomain(userDto)));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return HttpStatus.NO_CONTENT;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto create(@RequestBody UserDto userDto) {
        return mapper.domainToDto(userService.saveUser(mapper.dtoToDomain(userDto)));
    }

//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(User user) {
//        userService.saveUser(user);
//        return "success";
//    }
}