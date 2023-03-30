package com.restaurant.backend.models.db;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Document(collection  = "restaurant")
public class Restaurant {

    @Id
    private String restaurantId;

    @NotBlank(message = "Restaurant Name should not be blank")
    @Size(min = 3, message = "Restaurant Name should be at least 3 characters")
    private String restaurantName;

    @NotBlank(message = "Restaurant address should not be blank")
    @Size(min = 3, max=500, message = "Restaurant Address should be at least 3 characters")
    private String address;

    @NotBlank(message = "Restaurant Phone Number should not be blank")
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message="Enter valid phone number")
    private String restaurantPhNumber;

    @Email(message = "Enter valid Restaurant Email")
    private String restaurantEmail;

    @NotEmpty(message = "There are no menu items. Please add at least one menu item")
    private List<Items> menuItems;

    private String restaurantRating;


    private String userId;

    @ReadOnlyProperty
    @CreatedDate
    private Timestamp createdAt;

    @LastModifiedDate
    private Timestamp updatedAt;


}
