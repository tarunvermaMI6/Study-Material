package com.enginerringdigest.java8.revision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStudentS {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student("Adesh", 30), new Student("Abtarun", 90), new Student("Subh", 80));
		list = list.stream().sorted(Comparator.comparing(Student::getAge)).toList();

		/*
		CustomComp comp = new CustomComp();
		Collections.sort(list, comp);
		
		list.stream().sorted((st1,st2)->{
	
			return st1.getUsername().compareTo(st2.getUsername());
		}).toList();  */
		
		list.forEach(x->System.out.println(x.getUsername()));	}
}

class CustomComp implements Comparator<Student> {

	/*
	 * private Student st;
	 * 
	 * public CustomComp(Student st) { this.st = st; }
	 */

	@Override
	public int compare(Student st1, Student st2) {

		return st1.getUsername().compareTo(st2.getUsername());

	}

}

class Student {

	private String username;
	private int age;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {

		this.username = name;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
