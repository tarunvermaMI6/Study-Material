package com.javadesign.pattern;

public class SingletonDesignPattern {

	public static void main(String[] args) {

		SInglePattern object = SInglePattern.getObject();

		if (object.hashCode() == object.hashCode()) {
			System.out.println("true");
		}
	}
}

//ek baar he banao and use karo
//jese ki agar jdbc me db connection banana hai to ek baar he banega na and wo he object har jagah use hoga
class SInglePattern {

	// private isliye taki bahar se koi bc na kar sake

	// lazy way of doing this because, object will not get created until we call the
	// function
//	private static SInglePattern object = null;

	// eager way of doing this coz when the class load static will get called (not a
	// good way)
	private static SInglePattern object = new SInglePattern();

	// bahar se koi iis class ko implement karke object na bana sake islye
	// constructor private kar do
	// ab bahar se koi ise SingletonDesignPattern obj = new
	// SingletonDesignPattern(); nahi kar sakta

	private SInglePattern() {

	}

	// ab jab bahar se koi object nai bana sakta or jo andar object banega wo access
	// ho sakta hai class se bas so make static

	public static SInglePattern getObject() {

		if (object == null) {

			synchronized (SInglePattern.class) { // thread safety

				if (object == null) {
					return new SInglePattern();
				}
			}
		}

		return object;
	}

}