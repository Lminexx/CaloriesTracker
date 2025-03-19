package org.example.testovoe;
import org.example.testovoe.DTO.DailyReportDTO;
import org.example.testovoe.DTO.FoodLogDTO;
import org.example.testovoe.DTO.UserDTO;
import org.example.testovoe.Mapper.DailyReportMapper;
import org.example.testovoe.Mapper.FoodLogMapper;
import org.example.testovoe.Mapper.UserMapper;
import org.example.testovoe.entity.Dish;
import org.example.testovoe.entity.FoodLog;
import org.example.testovoe.entity.User;
import org.example.testovoe.repository.FoodLogRepository;
import org.example.testovoe.repository.UserRepository;
import org.example.testovoe.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private FoodLogRepository foodLogRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private FoodLogMapper foodLogMapper;

    @Mock
    private DailyReportMapper dailyReportMapper;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testUser = new User();
        testUser.setId(1L);
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");
        testUser.setAge(25);
        testUser.setWeight(70.0);
        testUser.setHeight(175.0);
        testUser.setTarget(User.Target.MAINTENANCE);
    }

    @Test
    void saveUser_ShouldReturnUserDTO() {
        UserDTO expectedUserDTO = new UserDTO();
        expectedUserDTO.setName("Test User");
        expectedUserDTO.setEmail("test@example.com");

        when(userRepository.save(any(User.class))).thenReturn(testUser);
        when(userMapper.toUserDTO(testUser)).thenReturn(expectedUserDTO);

        UserDTO actualUserDTO = userService.save(testUser);

        assertEquals("Test User", actualUserDTO.getName());
        assertEquals("test@example.com", actualUserDTO.getEmail());
        verify(userRepository, times(1)).save(testUser);
    }

    @Test
    void findAllUsers_ShouldReturnListOfUserDTO() {
        List<User> users = List.of(testUser);
        List<UserDTO> expectedDTOs = List.of(new UserDTO("Test User", "test@example.com", 25, 70.0, 175.0));

        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.toUserDTO(any(User.class))).thenReturn(expectedDTOs.get(0));

        List<UserDTO> actualUsers = userService.findAll();

        assertEquals(1, actualUsers.size());
        assertEquals("Test User", actualUsers.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void calculateCalorieNorm_ShouldReturnCorrectValue() {
        double expectedCalories = (10 * 70 + 6.25 * 175 - 5 * 25 + 5) * 1.55;
        double actualCalories = userService.calculateCalorieNorm(testUser);

        assertEquals(expectedCalories, actualCalories, 0.01);
    }

    @Test
    void getDailyReport_ShouldReturnReportDTO() {
        List<FoodLog> foodLogs = List.of(
                new FoodLog(1L, testUser, List.of(new Dish(1L, "Dish1", 200, 10.0, 5.0, 20.0)), LocalDate.now())
        );
        double totalCalories = 200;

        DailyReportDTO expectedReport = new DailyReportDTO();
        expectedReport.setUserName("Test User");
        expectedReport.setDate(LocalDate.now());
        expectedReport.setTotalCalories(totalCalories);
        expectedReport.setTargetCalories(2500.0);

        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(foodLogRepository.findByUserIdAndDate(1L, LocalDate.now())).thenReturn(foodLogs);
        when(dailyReportMapper.toDailyReportDTO(any(), any(), any())).thenReturn(expectedReport);

        DailyReportDTO actualReport = userService.getDailyReport(1L);

        assertEquals(expectedReport.getUserName(), actualReport.getUserName());
        assertEquals(expectedReport.getDate(), actualReport.getDate());
        assertEquals(expectedReport.getTotalCalories(), actualReport.getTotalCalories());
    }


    @Test
    void getFoodHistory_ShouldReturnListOfFoodLogDTO() {
        List<FoodLog> foodLogs = List.of(
                new FoodLog(1L, testUser, List.of(new Dish(1L, "Dish1", 500, 10.0, 5.0, 20.0)), LocalDate.now())
        );

        List<FoodLogDTO> expectedFoodLogDTOs = List.of(new FoodLogDTO(LocalDate.now()));

        when(foodLogRepository.findByUserId(1L)).thenReturn(foodLogs);
        when(foodLogMapper.foodLogsToFoodLogDTOs(foodLogs)).thenReturn(expectedFoodLogDTOs);

        List<FoodLogDTO> actualFoodLogs = userService.getFoodHistory(1L);

        assertEquals(1, actualFoodLogs.size());
        assertEquals(LocalDate.now(), actualFoodLogs.get(0).getDate());
    }
}