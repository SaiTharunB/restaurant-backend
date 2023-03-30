package com.restaurant.backend.services;

import com.restaurant.backend.models.db.Items;
import com.restaurant.backend.models.db.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {

    Page<Items> getAllitems(Pageable page);

    Page<Items> getItemsByRestaurantId(String restaurantId, Pageable page);

    Page<Items> getItemsByItemCategory(String itemCategory, Pageable page);
}
