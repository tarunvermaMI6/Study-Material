package com.interviews;

public interface MyInterface {

	void helloWorld();
}

class AB {

	public void fuunc1() {

		MyInterface intf = () -> {
			System.out.println("123");
		};
		intf.helloWorld();
	}

}
