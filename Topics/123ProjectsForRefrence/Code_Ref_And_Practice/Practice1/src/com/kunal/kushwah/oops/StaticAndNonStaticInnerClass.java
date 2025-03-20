package com.kunal.kushwah.oops;

public class StaticAndNonStaticInnerClass {

	private static String name = "tarun";

	static class Test {

		public void display() {
			System.out.println(name);
		}
	}

	class Test1 {

		public void display() {

			System.out.println("yo boi ........");
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.display();

		StaticAndNonStaticInnerClass obj = new StaticAndNonStaticInnerClass();
		StaticAndNonStaticInnerClass.Test1 test1 = obj.new Test1();
		test1.display();

	}
}
