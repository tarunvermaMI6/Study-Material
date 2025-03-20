package com.java.pattern;

public class FactoryPattern {

	public static void main(String[] args) {

		FPattern fp = new FPattern();
		Shape s = fp.getSape("circle");
		s.draw();
	}
}

class FPattern {

	public Shape getSape(String name) {

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
