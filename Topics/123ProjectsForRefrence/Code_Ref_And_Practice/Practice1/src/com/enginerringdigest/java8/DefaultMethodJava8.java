package com.enginerringdigest.java8;

interface Parent {

	default void sayHello() {
		System.out.println("fck You baby!");
	}
}

class Child implements Parent {

	// 2 or i can also provide my impl here
//	@Override
//	public void sayHello() {
//		// Parent.super.sayHello();
//		System.out.println("fck you too baby!");
//	}
}

public class DefaultMethodJava8 {

	// I can access method in Parent interface directly so no need to make a child
	// class
	// implement parent

	public static void main(String[] args) {

		// 1
		Child ch = new Child();
		ch.sayHello();

		// 3
//      Parent p = new Child(); // parent holding child ref
//		p.sayHello(); // child func get called

		Parent p = new Parent() { // anonymous func use to give impl
			@Override
			public void sayHello() {
				// Parent.super.sayHello();
				System.out.println("using anonym .....");
			}
		};
		// p.sayHello();

	}

}
