package com.enginerringdigest.java8;

interface Parent1 {

	static void sayHello() {
		System.out.println("Hey hello in Parent .......");
	}
}

class Childtemp implements Parent1 {

	// 1. static method defined in Parent class will not visible to child class coz it belongs to interface only
	
	static void sayHello() { // this is not an inheritance this method belongs to child class
		System.out.println("Hey hello in child ......");
	}
}

class MainClass {
	
	public static void main(String[] args){
		
		Childtemp c = new Childtemp();
	//	c.sayHello();  can not access parent static method through child
		Parent1.sayHello(); // accessing through interface
	}
}