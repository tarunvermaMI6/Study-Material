package com.enginerringdigest.java8;

@FunctionalInterface // mandatory so that next developer can know that its a functional interface
// an interface having exactly one abstract method called as functional interface but it 
//can have multiple default and static method
public interface MyInterface {

	public void hello();
}
