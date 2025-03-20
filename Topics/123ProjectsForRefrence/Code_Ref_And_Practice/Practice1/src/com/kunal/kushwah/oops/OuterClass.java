package com.kunal.kushwah.oops;

// an example of static class
public class OuterClass {

	
	static private class InnerClass{
	
		public static void main(String[] args) {
			System.out.println("In inner class main method ....");
		}
	}
	
	public static void main(String[] args) {
		//InnerClass ic = new InnerClass();// error, coz that inner class(without static) belongs to OuterClass we can't make object of that
	
		OuterClass oc = new OuterClass();
		InnerClass ic = new InnerClass();
		OuterClass.InnerClass.main(args);
	
	}
}
