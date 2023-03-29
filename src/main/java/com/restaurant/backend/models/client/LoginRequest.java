package com.restaurant.backend.models.client;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {
    @Email(message = "Invalid email")
    private String email;

    @Size(min = 5,message = "password should be minimum 5 characters")
    private String password;
}
