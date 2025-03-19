package org.example.testovoe.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    @Min(10) @Max(100)
    private Integer age;

    @Column(nullable = false)
    @Min(30) @Max(300)
    private Double weight;

    @Column(nullable = false)
    @Min(100) @Max(250)
    private Double height;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Target target;

    @Transient
    private Double dailyCalorieNorm;

    public enum Target{
        WEIGHT_LOSS,
        MAINTENANCE,
        MASS_GAIN
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Min(10) @Max(100) Integer getAge() {
        return age;
    }

    public void setAge(@Min(10) @Max(100) Integer age) {
        this.age = age;
    }

    public @Min(30) @Max(300) Double getWeight() {
        return weight;
    }

    public void setWeight(@Min(30) @Max(300) Double weight) {
        this.weight = weight;
    }

    public @Min(100) @Max(250) Double getHeight() {
        return height;
    }

    public void setHeight(@Min(100) @Max(250) Double height) {
        this.height = height;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Double getDailyCalorieNorm() {
        return dailyCalorieNorm;
    }

    public void setDailyCalorieNorm(Double dailyCalorieNorm) {
        this.dailyCalorieNorm = dailyCalorieNorm;
    }

}
