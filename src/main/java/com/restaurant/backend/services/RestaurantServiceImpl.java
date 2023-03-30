package com.restaurant.backend.services;

import com.restaurant.backend.models.db.Restaurant;
import com.restaurant.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Page<Restaurant> getAllRestaurants(Pageable page) {

        Page<Restaurant> restaurants = restaurantRepository.findAll(page);

        return restaurants;
    }

    @Override
    public Page<Restaurant> getRestaurantByUserId(String userId, Pageable page) {

        Page<Restaurant> restaurants = restaurantRepository.findByUserId(userId,page);

        return restaurants;
    }
}
