package com.restaurant.backend.models.db;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Document(collection  = "items")
public class Items {

    @Id
    private String itemId;

    @NotBlank(message = "Item Name should not be blank")
    private String itemName;

    @NotBlank(message = "Item category should not be blank")
    private String itemCategory;

    @DecimalMin(value = "0.01", message = "Item price should not be 0")
    private BigDecimal itemPrice;

}
