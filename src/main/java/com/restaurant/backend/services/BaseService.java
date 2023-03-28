package com.restaurant.backend.services;

import com.restaurant.backend.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ValidationService validationService;

}
