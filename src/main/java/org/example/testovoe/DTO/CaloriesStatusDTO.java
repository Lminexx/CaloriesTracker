package org.example.testovoe.DTO;

public class CaloriesStatusDTO {
    private String userName;
    private double totalCalories;
    private double targetCalories;
    private boolean isWithinLimit;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTargetCalories() {
        return targetCalories;
    }

    public void setTargetCalories(double targetCalories) {
        this.targetCalories = targetCalories;
    }

    public boolean isWithinLimit() {
        return isWithinLimit;
    }

    public void setWithinLimit(boolean withinLimit) {
        isWithinLimit = withinLimit;
    }
}