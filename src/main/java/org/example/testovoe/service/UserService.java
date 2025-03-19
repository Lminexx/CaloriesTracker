package org.example.testovoe.service;
import org.example.testovoe.DTO.CaloriesStatusDTO;
import org.example.testovoe.DTO.DailyReportDTO;
import org.example.testovoe.DTO.FoodLogDTO;
import org.example.testovoe.DTO.UserDTO;
import org.example.testovoe.Mapper.DailyReportMapper;
import org.example.testovoe.Mapper.FoodLogMapper;
import org.example.testovoe.Mapper.StatusMapper;
import org.example.testovoe.Mapper.UserMapper;
import org.example.testovoe.entity.Dish;
import org.example.testovoe.entity.FoodLog;
import org.example.testovoe.entity.User;
import org.example.testovoe.repository.FoodLogRepository;
import org.example.testovoe.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final FoodLogRepository foodLogRepository;
    private final FoodLogMapper foodLogMapper;
    private final StatusMapper statusMapper;
    private final DailyReportMapper dailyReportMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, FoodLogRepository foodLogRepository, FoodLogMapper foodLogMapper, StatusMapper statusMapper, DailyReportMapper dailyReportMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.foodLogRepository = foodLogRepository;
        this.foodLogMapper = foodLogMapper;
        this.statusMapper = statusMapper;
        this.dailyReportMapper = dailyReportMapper;
    }

    public UserDTO save(User user){
        return userMapper.toUserDTO(userRepository.save(user));
    }

    public List<UserDTO> findAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .toList();
    }


    public double calculateCalorieNorm(User user) {
        double bmr = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge() + 5;
        return switch (user.getTarget()) {
            case WEIGHT_LOSS -> bmr * 1.2;
            case MAINTENANCE -> bmr * 1.55;
            case MASS_GAIN -> bmr * 1.8;
            default -> throw new IllegalStateException("Unknown target: " + user.getTarget());
        };
    }

    private double calculateTotalCalories(List<FoodLog> foodLogs) {
        double totalCalories = 0;
        for (FoodLog log : foodLogs) {
            for (Dish dish : log.getDishes()) {
                totalCalories += dish.getCalories();
            }
        }
        return totalCalories;
    }

    public DailyReportDTO getDailyReport(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate today = LocalDate.now();
        List<FoodLog> foodLogs = foodLogRepository.findByUserIdAndDate(userId, today);

        double totalCalories = calculateTotalCalories(foodLogs);

        DailyReportDTO report = dailyReportMapper.toDailyReportDTO(user, foodLogs, today);
        report.setTotalCalories(totalCalories);

        return report;
    }

    public CaloriesStatusDTO checkCaloriesStatus(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate today = LocalDate.now();
        List<FoodLog> foodLogs = foodLogRepository.findByUserIdAndDate(userId, today);

        double totalCalories = calculateTotalCalories(foodLogs);

        boolean isWithinLimit = totalCalories <= user.getDailyCalorieNorm();

        return statusMapper.toCaloriesStatusDTO(user, totalCalories, isWithinLimit);
    }


    public List<FoodLogDTO> getFoodHistory(Long userId) {
        List<FoodLog> foodLogs = foodLogRepository.findByUserId(userId);

        return foodLogMapper.foodLogsToFoodLogDTOs(foodLogs);
    }
}
