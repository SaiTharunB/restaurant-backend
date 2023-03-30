package com.restaurant.backend.controller;

import com.restaurant.backend.models.db.Restaurant;
import com.restaurant.backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class restaurantController {

    @Autowired
    RestaurantService restaurantService;

//    @GetMapping(value = "/allRestaurants")
//    public ResponseEntity<List<Restaurant>> getAllRestaurants(Pageable page){
//
//        List<Restaurant> restaurants = restaurantService.getAllRestaurants(page).toList();
//
//        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/restaurants")
//    public ResponseEntity<List<Restaurant>> getRestaurants(Pageable page){
//
//        List<Restaurant> restaurants = restaurantService.getRestaurantByUserId(page).toList();
//
//    }


}
