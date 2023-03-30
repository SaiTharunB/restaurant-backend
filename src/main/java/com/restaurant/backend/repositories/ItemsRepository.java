package com.restaurant.backend.repositories;

import com.restaurant.backend.models.db.Items;
import com.restaurant.backend.models.db.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends MongoRepository<Items,String> {

    Page<Items> findByRestaurantId(String restaurantId, Pageable page);

    Page<Items> findByItemCategory(String itemCategory, Pageable page);
}
