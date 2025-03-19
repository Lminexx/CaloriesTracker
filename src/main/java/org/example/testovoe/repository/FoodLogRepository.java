package org.example.testovoe.repository;

import org.example.testovoe.entity.FoodLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FoodLogRepository extends JpaRepository<FoodLog, Long> {
    List<FoodLog> findByUserIdAndDate(Long userId, LocalDate date);
    List<FoodLog> findByUserId(Long userId);

}
