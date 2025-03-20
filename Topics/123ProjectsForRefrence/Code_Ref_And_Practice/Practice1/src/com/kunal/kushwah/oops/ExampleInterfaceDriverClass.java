package com.kunal.kushwah.oops;

public class ExampleInterfaceDriverClass implements ExampleInterface,ExampleInterface1,ExampleInterface2{

	public static void main(String[] args) {
		
		ExampleInterface inter = new ExampleInterfaceDriverClass(); // ref type is interface
		System.out.println(inter.a);
	    inter.greetingsInHindi();
	    //inter.greetingsInHindi1(); can't access LHS defined the accessibility 
	}
	
	

	@Override
	public void greetingsInHindi2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void greetingsInHindi1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void greetings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void greetingsInHindi() {
		// TODO Auto-generated method stub
		
	}
}
