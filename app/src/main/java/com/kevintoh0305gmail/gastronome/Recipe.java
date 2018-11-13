package com.kevintoh0305gmail.gastronome;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    String title;
    ArrayList<String> ingredients;
    int prepTime;
    int readyTime;
    ArrayList<String> instructions;
    Long servSize;
    int calories;
    String type;
    String shortDesc;
    String difficulty;
    String dietary;

    public Recipe() {}

    public Recipe(String title, ArrayList<String> ingredients, int prepTime, int readyTime, ArrayList<String> instructions, Long servSize, int calories, String type, String shortDesc, String difficulty, String dietary) {
        this.title = title;
        this.ingredients = ingredients;
        this.prepTime = prepTime;
        this.readyTime = readyTime;
        this.instructions = instructions;
        this.servSize = servSize;
        this.calories = calories;
        this.type = type;
        this.shortDesc = shortDesc;
        this.difficulty = difficulty;
        this.dietary = dietary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(int readyTime) {
        this.readyTime = readyTime;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    public Long getServSize() {
        return servSize;
    }

    public void setServSize(Long servSize) {
        this.servSize = servSize;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDietary() {
        return dietary;
    }

    public void setDietary(String dietary) {
        this.dietary = dietary;
    }
}

