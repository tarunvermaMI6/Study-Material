package com.enginerringdigest.java8;

@FunctionalInterface // if we don't declare any abstract function here it will still a functional
						// interface cause it inheriting the method from parent
public interface ChildInterface extends MyInterface {
	// public void hello1(); // will throw compile time error

	public void hello(); // won't give error cause its a same method use in parent
}
