package com.example.restapiservice.repository;

import com.example.restapiservice.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    // Можно добавить дополнительные методы запросов, если необходимо
}
