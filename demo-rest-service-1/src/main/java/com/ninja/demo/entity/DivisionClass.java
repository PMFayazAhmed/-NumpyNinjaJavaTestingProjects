package com.ninja.demo.entity;

public class DivisionClass implements CalculatorOperation {
    private double left;
    private double right;
    private double result;

    // constructor, getters and setters
    @Override
    public void Perform() {
        if (right != 0) {
            result = left / right;
        }
    }
}