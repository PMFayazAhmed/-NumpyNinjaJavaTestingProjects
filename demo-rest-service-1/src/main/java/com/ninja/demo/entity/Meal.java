package com.ninja.demo.entity;

import java.math.BigDecimal;

public class Meal {
	private String text;
	private String description;
	private BigDecimal price;
	
	//Constructors, getters and setters
	
	// methods that directly relate to the meal properties
    public String replaceWordInMeal(String word,String replacementWord){
    	if (text.contains(word)) {
            text = text.replace(word, replacementWord);
        }
        return text;
    }

    public boolean isWordInMeal(String word){
        return text.contains(word);
    }
    
    void PrintNameToConsole()
    {
    	//our code for formatting and printing the text
    }

}
