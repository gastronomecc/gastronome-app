package com.kevintoh0305gmail.gastronome;


public class Logs {

    String day;
    String title;
    String email;
    int calories;

    public Logs() {
    }

    public Logs(String day, String title, String email, int calories) {
        this.day = day;
        this.title = title;
        this.email = email;
        this.calories = calories;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String uid) {
        this.email = email;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}