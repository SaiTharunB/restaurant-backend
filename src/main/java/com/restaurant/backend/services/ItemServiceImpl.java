package com.restaurant.backend.services;

import com.restaurant.backend.models.db.Items;
import com.restaurant.backend.models.db.Restaurant;
import com.restaurant.backend.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public Page<Items> getAllitems(Pageable page) {

        Page<Items> items = itemsRepository.findAll(page);

        return items;
    }

    @Override
    public Page<Items> getItemsByRestaurantId(String restaurantId, Pageable page) {

        Page<Items> items = itemsRepository.findByRestaurantId(restaurantId, page);

        return items;
    }

    @Override
    public Page<Items> getItemsByItemCategory(String itemCategory, Pageable page){
        Page<Items> items = itemsRepository.findByItemCategory(itemCategory,page);
        return items;
    }
}
