package com.restaurant.backend.repository;

import com.restaurant.backend.models.db.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

    Page<Restaurant> findByUserId(String userId, Pageable page);
}
