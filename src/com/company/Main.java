package com.company;

public class Main {

    public static void main(String[] args) {
	    var student = new Student2("Amber");
	    student.addGrade(90);
	    student.addGrade(99);
	    student.addGrade(87);
        System.out.println("student.getGradeAverage() = " + student.getGradeAverage());
    }
}
