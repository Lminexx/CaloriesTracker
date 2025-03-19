package org.example.testovoe.Mapper;

import org.example.testovoe.DTO.DailyReportDTO;
import org.example.testovoe.entity.User;
import org.example.testovoe.entity.FoodLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DailyReportMapper {

    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "date", source = "today")
    @Mapping(target = "targetCalories", source = "user.dailyCalorieNorm")
    DailyReportDTO toDailyReportDTO(User user, List<FoodLog> foodLogs, LocalDate today);
}