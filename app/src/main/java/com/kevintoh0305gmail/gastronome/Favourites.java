package com.kevintoh0305gmail.gastronome;

public class Favourites {
    String email;
    Recipe recipe;

    public Favourites() {}

    public Favourites(String email, Recipe recipe) {
        this.email = email;
        this.recipe = recipe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
