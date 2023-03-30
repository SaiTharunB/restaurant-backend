package com.restaurant.backend.models.db;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Document(collection = "users")
public class DbUser {
    @Id
    private String id;

    @NotBlank(message = "First Name should not be blank")
    private String firstName;

    @NotBlank(message = "Last Name should not be blank")
    private String lastName;

    @Email(message = "Invalid email")
    private String email;

    @Size(min = 10,max = 10,message = "contact number should be of 10 digits")
    private String contactNo;

    private List<String> cart;

    @Size(min = 5,message = "password should be minimum 5 characters")
    private String password;

    private String token;

}
