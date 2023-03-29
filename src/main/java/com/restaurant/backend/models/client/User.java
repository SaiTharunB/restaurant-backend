package com.restaurant.backend.models.client;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class User {
    @Id
    private String userId;

    @NotBlank(message = "First Name should not be blank")
    private String firstName;

    @NotBlank(message = "Last Name should not be blank")
    private String lastName;

    @Email(message = "Invalid email")
    private String email;

    @Size(min = 10,max = 10,message = "contact number should be of 10 digits")
    private String contactNo;

    private List<String> cart;

    private String token;
}
