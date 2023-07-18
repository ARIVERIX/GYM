package com.example.restapiservice.repository;

import com.example.restapiservice.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    // Дополнительные методы или запросы, если требуется
}
