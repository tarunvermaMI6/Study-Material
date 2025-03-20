package com.kunal.kushwah.oops;

public class AbstractExampleChild extends AbstractClassParent{

	@Override
	public void greetings() {
		
		System.out.println("Hello ....");
		
	}
	
	@Override
	public void greetingsInHindi() {
		
		System.out.println("Hello ....child");
		
	}
	
	public static void main(String[] args) {
		AbstractExampleChild child = new AbstractExampleChild();
		child.greetings();
		child.greetingsInHindi();
		AbstractClassParent parent = new AbstractExampleChild();
		parent.greetingsInHindi();
		//AbstractClassParent parent = new AbstractClassParent(); abstract class object creation not allowed
	}

	
}
