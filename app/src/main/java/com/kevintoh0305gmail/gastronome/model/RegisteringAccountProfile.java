package com.kevintoh0305gmail.gastronome.model;

public class RegisteringAccountProfile {
    private static String gender;
    private static int age;
    private static double height;
    private static double weight;
    private static String goal;

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        RegisteringAccountProfile.gender = gender;
    }

    public static void setAge(int age) {
        RegisteringAccountProfile.age = age;
    }

    public static int getAge() {
        return age;
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        RegisteringAccountProfile.height = height;
    }

    public static double getWeight() {
        return weight;
    }

    public static void setWeight(double weight) {
        RegisteringAccountProfile.weight = weight;
    }

    public static String getGoal() {
        return goal;
    }

    public static void setGoal(String goal) {
        RegisteringAccountProfile.goal = goal;
    }
}
