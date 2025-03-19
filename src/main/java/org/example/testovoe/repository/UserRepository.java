package org.example.testovoe.repository;

import org.example.testovoe.entity.FoodLog;
import org.example.testovoe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
