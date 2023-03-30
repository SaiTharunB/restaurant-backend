package com.restaurant.backend.services;

import com.restaurant.backend.models.db.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RestaurantService {

    Page<Restaurant> getAllRestaurants(Pageable page);

    Page<Restaurant> getRestaurantByUserId(String userId, Pageable page);

}
