package org.example.testovoe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @Column(nullable = false)
    @Min(1)
    private Integer calories;

    @Column(nullable = false)
    @Min(0)
    private Double proteins;

    @Column(nullable = false)
    @Min(0)
    private Double fats;

    @Column(nullable = false)
    @Min(0)
    private Double carbs;


    public Dish(Long id, String name, Integer calories, Double proteins, Double fats, Double carbs) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Min(1) Integer getCalories() {
        return calories;
    }

    public void setCalories(@Min(1) Integer calories) {
        this.calories = calories;
    }

    public @Min(0) Double getProteins() {
        return proteins;
    }

    public void setProteins(@Min(0) Double proteins) {
        this.proteins = proteins;
    }

    public @Min(0) Double getFats() {
        return fats;
    }

    public void setFats(@Min(0) Double fats) {
        this.fats = fats;
    }

    public @Min(0) Double getCarbs() {
        return carbs;
    }

    public void setCarbs(@Min(0) Double carbs) {
        this.carbs = carbs;
    }
}
