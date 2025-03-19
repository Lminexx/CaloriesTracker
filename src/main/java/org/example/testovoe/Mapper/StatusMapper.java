package org.example.testovoe.Mapper;

import org.example.testovoe.DTO.CaloriesStatusDTO;
import org.example.testovoe.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "user.dailyCalorieNorm", target = "targetCalories")
    CaloriesStatusDTO toCaloriesStatusDTO(User user, double totalCalories, boolean isWithinLimit);
}
