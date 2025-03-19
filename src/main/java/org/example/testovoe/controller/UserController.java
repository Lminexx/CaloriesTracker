package org.example.testovoe.controller;
import jakarta.validation.Valid;
import org.example.testovoe.DTO.*;
import org.example.testovoe.entity.Dish;
import org.example.testovoe.entity.FoodLog;
import org.example.testovoe.entity.User;
import org.example.testovoe.service.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody User user) {
        user.setDailyCalorieNorm(userService.calculateCalorieNorm(user));
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/report/daily/{userId}")
    public ResponseEntity<DailyReportDTO> getDailyReport(@PathVariable Long userId) {
        DailyReportDTO dailyReport = userService.getDailyReport(userId);
        return ResponseEntity.ok(dailyReport);
    }

    @GetMapping("/check/calories/{userId}")
    public ResponseEntity<CaloriesStatusDTO> checkCalories(@PathVariable Long userId) {
        CaloriesStatusDTO status = userService.checkCaloriesStatus(userId);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<FoodLogDTO>> getFoodHistory(@PathVariable Long userId) {
        List<FoodLogDTO> foodHistory = userService.getFoodHistory(userId);
        return ResponseEntity.ok(foodHistory);
    }

    @PostMapping("/dish")
    public ResponseEntity<DishDTO> addDish(@Valid @RequestBody Dish dish){
        return ResponseEntity.ok(userService.saveDish(dish));
    }

    @PostMapping("/food")
    public ResponseEntity<FoodLogDTO> addFoodLog(@Valid @RequestBody FoodLog foodLog) {
        return ResponseEntity.ok(userService.saveFoodLog(foodLog));
    }

}
