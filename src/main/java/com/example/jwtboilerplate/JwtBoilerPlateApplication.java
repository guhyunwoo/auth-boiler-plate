package com.example.jwtboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class JwtBoilerPlateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtBoilerPlateApplication.class, args);
    }

}
