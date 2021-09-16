package com.ninja.demo.entity;

public abstract class OnlineOrder implements Meals {

    public void ViewAllergy() {
        throw new AssertionError("Allergy Information not available for the meal");
    }

    public void ViewNutrition() {
        //Code to view nutrition content of the meal
    }
}
