package com.kunal.kushwah.oops;

public class Child extends Parent {

	public Child() {
        super();  
		this.abc = ""; // i can access parent instance variable from child class
	}
	
	public Child(Child child) {
        super(child); // calling parent const which takes parent obj can also take child obj  
		this.abc = ""; // i can access parent instance variable from child class
	}

	@Override
	public void call() {
		System.out.println("child func ...");
		System.out.println(this.getClass());
	}
	
	public void displayChild() {
	 System.out.println("call displayChild ");
	}

	public static void main(String[] args) {

		Child c = new Child(); // here when child const call it automatically calls parent const to initialize
								// value of parent class
		c.call(); // calling child func
		c.displayChild();
		Parent p = new Parent();
		p.call(); // call parent func

		Parent pc = new Child(); // overriding (decide on runtime) parent holding child ref ,
		// lhs (ref type) define the accesbility(parent only) and rhs (object type) decide which
		// function to call if its overridden
		pc.call(); // this is method overriding i.e presents in parent and child both but when
					// we call this method using parent ref holding child type object it will call
					// child method
		pc.parentMethod(); // can access parent and child properties
		pc.abc = "";
	//	pc.displayChild(); // cant call coz it can only access parent properties

		// Child cp = new Parent(); // child can not hold parent ref coz parent const
		// will call and the parent does'nt have any idea about child class and child
		// class const does'nt get call so object wont create
		int i = 1;
		
		Child c2 = (Child) pc; // now it becomes child
		c2.displayChild();
		c2.parentMethod();
		
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i);
	}
}
