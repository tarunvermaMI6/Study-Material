package com.kunal.kushwah.oops;

public class ObjectCloning {

	public static void main(String[] args) throws CloneNotSupportedException {

		Name name = new Name();
		Name name1 = new Name(name); // just copying on object to another, it takes sometimes
		
		// better approach
		
		Name name2 = (Name) name.clone();
		
		
	}
}

class Name implements Cloneable{

	String firstName;
	String lastName;

	public Name() {

	}

	public Name(Name name) {
		this.firstName = name.firstName;
		this.lastName = name.lastName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		return super.clone();
	}
}
