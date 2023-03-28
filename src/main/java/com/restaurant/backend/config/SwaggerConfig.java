package com.restaurant.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket RestaurantApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder()
                .title("Restaurant APIs")
                .version("0.1").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.restaurant.backend"))
                .build()
                .useDefaultResponseMessages(false)
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                        .name("Accept")
                                        .defaultValue("application/json")
                                        .parameterType("header")
                                        .required(false)
                                        .build()));
    }
}
