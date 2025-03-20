package com.demo;

public class SingletomDemo {

	private SingletomDemo singletomDemo = null;

	private SingletomDemo() {

	}

	public SingletomDemo getInstance() {

		if (singletomDemo != null) {
			singletomDemo = new SingletomDemo();
		}

		return singletomDemo;
	}

}
