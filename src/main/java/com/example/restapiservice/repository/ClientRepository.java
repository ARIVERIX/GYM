package com.example.restapiservice.repository;

import com.example.restapiservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Дополнительные методы или запросы, если требуется
}
