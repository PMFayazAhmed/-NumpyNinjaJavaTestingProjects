package com.ninja.demo.entity;

public abstract class Pizza implements Meals {

    private AllergyNutrition meal;

    //Constructors, getters + setters

    public void ViewNutrition() {
        
        meal.Nutrition("Pizza");
    }

    public void ViewAllergy() {
        
        meal.Allergy("Pizza");
    }
}
