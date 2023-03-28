package com.restaurant.backend.services;

import com.restaurant.backend.exceptions.ValidationException;
import com.restaurant.backend.models.client.LoginRequest;
import com.restaurant.backend.models.client.LoginResponse;
import com.restaurant.backend.models.db.DbUser;
import com.restaurant.backend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;


@Service
public class UserService extends BaseService{

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;
    public LoginResponse createUser(DbUser user){
        logger.info("in create user :: {}",user);
        validationService.checkEmailIsUnique(user.getEmail());
        user.setToken(getHash(user.getEmail()+user.getPassword()));
        user.setPassword(getHash(user.getPassword()));
        user.setCart(new ArrayList<String>());
        DbUser dbUser = userRepository.save(user);
        if(dbUser==null){
            throw new ValidationException("Failed to create user");
        }
        return modelMapper.map(dbUser, LoginResponse.class);
    }

    private String getHash(String param){
        return DigestUtils.md5DigestAsHex(param.getBytes());
    }

    public LoginResponse loginUser(LoginRequest loginRequest) {
        DbUser resp=userRepository.findByEmailAndPassword(loginRequest.getEmail(),getHash(loginRequest.getPassword()));
        if(resp!=null){
            return mapLoginResponse(resp,modelMapper.map(resp,LoginResponse.class));
        }
        throw new ValidationException("User with given credentials doesn't exist");
    }

    private LoginResponse mapLoginResponse(DbUser user,LoginResponse response){
        response.setFullName(user.getFirstName()+" "+user.getLastName());
        return response;
    }
}
