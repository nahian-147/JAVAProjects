package com.nahian.continum;

public class Square extends Shapes{
	private double side = 0.0;
	Square(double side){
		this.side = side;
		System.out.println("A square of side length "+side+" has been created.");
	}
	double getArea(){
		return this.side * this.side;
	}
}