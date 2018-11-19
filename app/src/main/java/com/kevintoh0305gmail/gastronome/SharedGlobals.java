package com.kevintoh0305gmail.gastronome;

import com.kevintoh0305gmail.gastronome.model.User;

public class SharedGlobals {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        SharedGlobals.currentUser = currentUser;
    }
}
