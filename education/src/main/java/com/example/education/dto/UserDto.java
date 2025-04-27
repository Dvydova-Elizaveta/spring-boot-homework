package com.example.education.dto;

import com.example.education.validation.StartsWithCapitalLetter;
import com.example.education.validation.ValidUserName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    @StartsWithCapitalLetter
    @ValidUserName
    private String name;

    @Email(message = "Email должен быть валидным")
    @NotNull(message = "Email не может быть пустым")
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
