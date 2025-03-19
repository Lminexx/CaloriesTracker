package org.example.testovoe.DTO;

import org.example.testovoe.entity.Dish;

import java.time.LocalDate;
import java.util.List;

public class FoodLogDTO {
    private LocalDate date;
    private List<Dish> dishes;


    public FoodLogDTO(LocalDate date, List<Dish> dishes) {
        this.date = date;
        this.dishes = dishes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}