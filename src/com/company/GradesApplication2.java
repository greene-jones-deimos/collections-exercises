package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GradesApplication2 {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        //! create HashMap
        HashMap<String, Student2> students = new HashMap<>()
        {{
            put("amberlovescats14", new Student2("Amber"));
            put("melidagreen10", new Student2("Melinda"));
            put("thomaslovescats8", new Student2("Thomas"));
            put("camilovescats", new Student2("Cami"));
        }};

        //! add random grades
        for(Student2 student : students.values()){
            Random rando = new Random();
            int firstGrade = rando.nextInt(100)+1;
            int secondGrade = rando.nextInt(100)+1;
            int thirdGrade = rando.nextInt(100) +1;
            student.addGrade(firstGrade);
            student.addGrade(secondGrade);
            student.addGrade(thirdGrade);
        }

        seeMoreStudentInfo(students);



    }
    public static void
    seeMoreStudentInfo(HashMap<String, Student2>  hash){
        System.out.println("+++ USERS ++");
        hash.forEach((key, value)-> System.out.println(key));
        System.out.print("Which user would you like to see more info on: ");
        String answer;
        while(true){
        answer = scan.nextLine();
        boolean validate = hash.containsKey(answer);
        if(validate) break;
            System.out.print("No users with that username were found, please try again: ");
        }
        chooseStudent(answer, hash);
    }

    public static void
    chooseStudent(String username, HashMap<String, Student2> map){
        boolean validate = map.containsKey(username);
        if(validate) {
            Student2 student = map.get(username);
            showInfo(student, map);
        }
        else System.out.println("Student Not Found");

    }

    public static void
    showInfo(Student2 student, HashMap<String, Student2> hash){
        System.out.println("Name: "+ student.getName());
        System.out.println("Average = " + student.getGradeAverage());
        System.out.println(":: GRADES ::");
        student.showGrades();
        while (true){
            System.out.print("Would you like to conitune?(y/n) ");
            String answer = scan.nextLine();
            System.out.println(answer);
            if(answer.equalsIgnoreCase("n"))break;
            seeMoreStudentInfo(hash);
        }
        System.out.println("Goodbye.");

    }



}
