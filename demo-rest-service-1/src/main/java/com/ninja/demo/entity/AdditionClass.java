package com.ninja.demo.entity;

public class AdditionClass implements CalculatorOperation {
	private double left;
    private double right;
    private double result = 0.0;

    public AdditionClass(double left, double right) {
        this.left = left;
        this.right = right;
    }

	public double getLeft() {
		return left;
	}

	public void setLeft(double left) {
		this.left = left;
	}

	public double getRight() {
		return right;
	}

	public void setRight(double right) {
		this.right = right;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public void Perform()
	{
		result = left+right;
	}

}
