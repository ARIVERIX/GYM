package com.example.restapiservice.repository;

import com.example.restapiservice.entity.Support;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportRepository extends JpaRepository<Support, Long> {
    // Дополнительные методы или запросы, если требуется
}
