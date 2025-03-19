package org.example.testovoe.Mapper;
import org.example.testovoe.DTO.UserDTO;
import org.example.testovoe.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "age", source = "user.age")
    @Mapping(target = "weight", source = "user.weight")
    @Mapping(target = "height", source = "user.height")
    @Mapping(target = "target", source = "user.target")
    @Mapping(target = "dailyCalorieNorm", source = "user.dailyCalorieNorm")
    UserDTO toUserDTO(User user);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "age", source = "dto.age")
    @Mapping(target = "weight", source = "dto.weight")
    @Mapping(target = "height", source = "dto.height")
    @Mapping(target = "target", source = "dto.target")
    @Mapping(target = "dailyCalorieNorm", source = "dto.dailyCalorieNorm")
    User toUser(UserDTO dto);
}
