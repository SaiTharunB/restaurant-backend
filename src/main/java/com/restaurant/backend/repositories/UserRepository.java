package com.restaurant.backend.repositories;

import com.restaurant.backend.models.db.DbUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<DbUser,String> {
    DbUser findByEmail(String email);
    DbUser findByEmailAndPassword(String email,String password);
}
