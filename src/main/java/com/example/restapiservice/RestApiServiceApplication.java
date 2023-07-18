package com.example.restapiservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.restapiservice.repository")
@EnableTransactionManagement
public class RestApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // Здесь можно добавить другие бины и настройки, если необходимо

}
