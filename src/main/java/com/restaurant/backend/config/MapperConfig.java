package com.restaurant.backend.config;

import com.restaurant.backend.models.client.LoginResponse;
import com.restaurant.backend.models.client.User;
import com.restaurant.backend.models.db.DbUser;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    public ModelMapper modelMapper=new ModelMapper();
    @Bean
    public ModelMapper modelMapper(){
        mapUsers();
        mapUserToLoginResponse();
        return modelMapper;
    }
    private void mapUsers(){
        modelMapper.typeMap(DbUser.class, User.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getId(), User::setUserId);
                });
    }

    private void mapUserToLoginResponse(){
        modelMapper.typeMap(DbUser.class, LoginResponse.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getId(), LoginResponse::setUserId);
                });
    }

}
