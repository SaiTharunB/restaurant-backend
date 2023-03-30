package com.restaurant.backend.models.client;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Getter
@Setter
public class LoginResponse {
    private String userId;
    private String email;
    private String fullName;

    private List<String> cart;

    private String token;

    public void setFullName(String fullName){
        if (StringUtils.isNotBlank(this.fullName)){
            System.out.println("***** if"+fullName+" "+this.fullName);
            this.fullName=this.getFullName()+" "+fullName;
        }
        else{
            this.fullName=fullName;
        }
        System.out.println("***** "+fullName+" "+this.fullName);
    }
}
