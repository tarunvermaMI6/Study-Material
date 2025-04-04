package com.javadesign.pattern;

public class FactoryPattern {

	Integer
	public static void main(String[] args) {

		Shape s = FPattern.getSape("circle");
		s.draw();
	}
}

class FPattern {

	public static Shape getSape(String name) {

		if (name == null) {
			return null;
		}

		if (name == "circle") {
			return new Circle();
		}

		if (name == "rectangle") {
			return new Rcatngle();
		}

		if (name == "square") {
			return new Square();
		}

		return null;
	}
}

interface Shape {

	void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle");

	}

}

class Square implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Square");
	}

}

class Rcatngle implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Rcatngle");
	}

}
