package com.kevintoh0305gmail.gastronome;


public class Logs {

    String day;
    String title;
    String email;

    public Logs() {
    }

    public Logs(String day, String title, String email) {
        this.day = day;
        this.title = title;
        this.email = email;
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
}