package com.kevintoh0305gmail.gastronome;

public class User {
    private String UserID;
    private String Name;
    private String Email;
    private String Gender;
    private String Goal;
    private int Age;
    private double Height;
    private double Weight;
    private double BMI;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public String getGoal() {
        return Goal;
    }

    public void setGoal(String goal) {
        Goal = goal;
    }

    public User()
    {

    }

    public User(String uid, String name, String email, String goal, String gender, int age, double height, double weight, double bmi) {
        UserID = uid;
        Name = name;
        Email = email;
        Gender = gender;
        Goal = goal;
        Age = age;
        Height = height;
        Weight = weight;
        BMI = bmi;
    }

}