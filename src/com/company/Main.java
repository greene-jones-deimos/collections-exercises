package com.company;

public class Main {

    public static void main(String[] args) {
	    var student = new Student2("Amber");
	    student.addGrade(90);
	    student.addGrade(99);
	    student.addGrade(87);
        System.out.println("student.getGradeAverage() = " + student.getGradeAverage());
        student.recordAttendance("2019/12/10", "A");
        student.recordAttendance("2019/12/11", "A");
        student.recordAttendance("2019/12/12", "p");
        student.recordAttendance("2019/12/13", "A");
        student.recordAttendance("2019/12/14", "p");
        student.calculateAttendance();

    }
}
