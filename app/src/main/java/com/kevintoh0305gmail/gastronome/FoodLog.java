package com.kevintoh0305gmail.gastronome;

public class FoodLog
{
    String foodName;
    int foodCalories;

    public FoodLog()
    {

    }

    public FoodLog(String foodName, int foodCalories)
    {
        this.foodName = foodName;
        this.foodCalories = foodCalories;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(int foodCalories) {
        this.foodCalories = foodCalories;
    }
}
