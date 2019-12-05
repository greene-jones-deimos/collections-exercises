package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Student2 {
    private String name;
    private ArrayList<Integer> grades = new ArrayList<>();
    private HashMap<String, String> githubNames = new HashMap<>();
    private HashMap<String, String> attendance = new HashMap<>();
    private Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public Student2(String name) {
        this.name = name;
    }

    public void addGrade(int grade){
        grades.add(grade);
        System.out.println("Grade added");
    }

    public Double getGradeAverage(){
      Integer total =  grades.stream().reduce(0,(a,b) -> a + b);
      return (double)(total / grades.size());
    }

    public void showGrades(){
        grades.forEach(grade -> System.out.print("| " + grade +" |"));
    }
    public int getGradeTotal(){
        return grades.stream().reduce(0,(a,b)-> a +b);
    }
    public void recordAttendance(String date, String attendanceCode){
        boolean validateDate =
                date.matches("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
        boolean validateAttendance =
                attendanceCode.matches("(?i)(a|p)");
        if(validateAttendance && validateDate){
            attendance.put(date, attendanceCode);
            System.out.println("Attendance recorded: " +  attendanceCode.toUpperCase());
        }
        else {
            System.out.println("Invalid attendanceCode");
            System.out.print("Date in format YYYY/MM/DD: ");
            System.out.println();
            date = scan.nextLine();
            System.out.print("Attendance in format (A|P): ");
            attendanceCode = scan.nextLine();
            recordAttendance(date, attendanceCode);

        }

    }

    public void
    calculateAttendance(){
        int totalDays = attendance.size();
        int absenseAmount = (int) attendance.values().stream().filter(a -> a.equalsIgnoreCase("p")).count();
        int percentage = (absenseAmount * 100) / totalDays;
        System.out.println("Attendance present percentage: " + percentage+"%");
    }

    public String getName() {
        return name;
    }
}