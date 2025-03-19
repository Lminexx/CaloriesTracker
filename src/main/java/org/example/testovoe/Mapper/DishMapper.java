package org.example.testovoe.Mapper;

import org.example.testovoe.DTO.DishDTO;
import org.example.testovoe.DTO.FoodLogDTO;
import org.example.testovoe.entity.Dish;
import org.example.testovoe.entity.FoodLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);
    DishDTO toDishDTO(Dish dish);
    Dish toDish(DishDTO dishDTO);
}
