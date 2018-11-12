package com.kevintoh0305gmail.gastronome;

public class SharedGlobals {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        SharedGlobals.currentUser = currentUser;
    }
}
