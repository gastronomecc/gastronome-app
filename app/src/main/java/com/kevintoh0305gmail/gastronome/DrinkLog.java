package com.kevintoh0305gmail.gastronome;

public class DrinkLog {
    String drinkName;
    int drinkCalories;

    public DrinkLog()
    {

    }

    public DrinkLog(String foodName, int foodCalories)
    {
        this.drinkName = foodName;
        this.drinkCalories = foodCalories;
    }

    public String getFoodName() {
        return drinkName;
    }

    public void setFoodName(String foodName) {
        this.drinkName = foodName;
    }

    public int getFoodCalories() {
        return drinkCalories;
    }

    public void setFoodCalories(int foodCalories) {
        this.drinkCalories = foodCalories;
    }
}
