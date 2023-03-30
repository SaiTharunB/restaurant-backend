package com.restaurant.backend.services;

import com.restaurant.backend.exceptions.ValidationException;
import com.restaurant.backend.models.db.DbUser;
import com.restaurant.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidationService {

    @Autowired
    UserRepository userRepository;
     public void checkEmailIsUnique(String email){
         DbUser user=userRepository.findByEmail(email);
         if(user!=null){
             throw new ValidationException(user.getEmail()+" already exists in our system");
         }
     }
}
