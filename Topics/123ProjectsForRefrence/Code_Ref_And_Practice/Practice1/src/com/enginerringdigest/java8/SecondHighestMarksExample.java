package com.enginerringdigest.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestMarksExample {
    public static void main(String[] args) {
        // Create a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student(85, "Alice"));
        students.add(new Student(92, "Bob"));
        students.add(new Student(78, "Charlie"));
        students.add(new Student(88, "Diana"));
        students.add(new Student(92, "Eve")); // Same marks as Bob for complexity

        // Find the second highest marks using Stream API
        Optional<Integer> secondHighestMarks = students.stream()
            .map(Student::getMarks) // Extract marks
            .distinct() // Remove duplicate marks
            .sorted(Comparator.reverseOrder()) // Sort in descending order
            .skip(1) // Skip the highest marks
            .findFirst(); // Get the second highest

        // Print the result
        if (secondHighestMarks.isPresent()) {
            System.out.println("Second highest marks: " + secondHighestMarks.get());
        } else {
            System.out.println("No second highest marks found.");
        }
    }
}

class Student {
    // Properties
    private int marks;
    private String name;

    // Constructor
    public Student(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    // Default Constructor
    public Student() {
        // Default values can be set here if needed
    }

    // Getter for marks
    public int getMarks() {
        return marks;
    }

    // Setter for marks
    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // toString method for displaying student details
    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}