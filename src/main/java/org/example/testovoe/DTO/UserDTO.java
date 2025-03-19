package org.example.testovoe.DTO;

public class UserDTO {
    private String name;
    private String email;
    private Integer age;
    private Double weight;
    private Double height;
    private String target;
    private Double dailyCalorieNorm;


    public UserDTO() {
    }

    public UserDTO(String name, String email, Integer age, Double weight, Double height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getDailyCalorieNorm() {
        return dailyCalorieNorm;
    }

    public void setDailyCalorieNorm(Double dailyCalorieNorm) {
        this.dailyCalorieNorm = dailyCalorieNorm;
    }
}
