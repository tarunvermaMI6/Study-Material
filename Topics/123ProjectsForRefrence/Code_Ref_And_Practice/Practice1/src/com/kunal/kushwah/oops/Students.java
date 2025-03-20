package com.kunal.kushwah.oops;

public class Students {

	private int marks;
	private String name;

	public Students() {

	}

	public Students(int marks, String name) {
		super();
		this.marks = marks;
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Students [marks=" + marks + ", name=" + name + "]";
	}

}
