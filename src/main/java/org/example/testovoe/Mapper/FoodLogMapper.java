package org.example.testovoe.Mapper;

import org.example.testovoe.DTO.FoodLogDTO;
import org.example.testovoe.entity.FoodLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodLogMapper {

    @Mapping(source = "date", target = "date")
    @Mapping(source = "dishes", target = "dishes")
    FoodLogDTO foodLogToFoodLogDTO(FoodLog foodLog);

    List<FoodLogDTO> foodLogsToFoodLogDTOs(List<FoodLog> foodLogs);
}
