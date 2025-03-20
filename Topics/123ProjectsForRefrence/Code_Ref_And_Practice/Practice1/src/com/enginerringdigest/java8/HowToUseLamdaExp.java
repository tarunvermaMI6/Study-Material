package com.enginerringdigest.java8;

@FunctionalInterface
interface I {

	void helloWorld();
	default void helloDefaultWorld() {
		System.out.println("Yo Boi .....");
	}

}

class ChildTem1 implements I{

	@Override
	public void helloWorld() {
		
		System.out.println("Hello World ....");
	}
}

public class HowToUseLamdaExp{
	
	public static void main(String[] args) {
		
//		ChildTem1 ct = new ChildTem1();
	//	ct.helloWorld();
		
		// but with lamda expression we can skip making implementation class for functional interface and provide impl like -- 
		
		I i = ()->System.out.println("Hello through lamda ...."); // here we are providing impl to only abstract method of F.I
		i.helloWorld(); // we can say F.I is a data type of lamda exp
		i.helloDefaultWorld();
	}
}