package com.example.education.controller;

import com.example.education.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @PostMapping
    public String createUser(@RequestBody @Valid UserDto userDto) {
        return "Пользователь успешно создан";
    }
}
