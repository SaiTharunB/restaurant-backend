package com.restaurant.backend.controller;

import com.restaurant.backend.models.db.Items;
import com.restaurant.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Items>> getAllitems(Pageable page) {
        List<Items> items = itemService.getAllitems(page).toList();

        return new ResponseEntity<List<Items>>(items, HttpStatus.OK);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<List<Items>> getItemsbyRestaurantId(@PathVariable("id") String id, Pageable page){
        List<Items> items = itemService.getItemsByRestaurantId(id,page).toList();
        return new ResponseEntity<List<Items>>(items,HttpStatus.OK);
    }

    @GetMapping("/items/{category}")
    public ResponseEntity<List<Items>> getItemsbyCatrgory(@PathVariable("category") String category, Pageable page){
        List<Items> items=itemService.getItemsByItemCategory(category,page).toList();
        return new ResponseEntity<List<Items>>(items,HttpStatus.OK);
    }

}
