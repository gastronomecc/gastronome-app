package com.kevintoh0305gmail.gastronome;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    String title;
    String imageURL;
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
    String fats;
    String carbs;
    String protein;
    String salt;
    String sugar;

    public Recipe() {}

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public Recipe(String title, String imageURL, ArrayList<String> ingredients, int prepTime, int readyTime, ArrayList<String> instructions, Long servSize, int calories, String type, String shortDesc, String difficulty, String dietary, String fats, String carbs, String protein, String salt, String sugar) {

        this.title = title;
        this.imageURL = imageURL;
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
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
        this.salt = salt;
        this.sugar = sugar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

