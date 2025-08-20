package com;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstSpringBootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootJpaApplication.class, args);
    }

    @Bean
    public OpenAPI customerApi() {
        return new OpenAPI();

    }
    //http://localhost:8080/swagger-ui/index.html
}
