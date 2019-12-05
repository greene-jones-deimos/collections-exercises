package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GradesApplication2 {
    private static
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
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

        startApplication(students);



    }

    public static void
    startApplication(HashMap<String,Student2> hash){
        System.out.println("" +
                "Please choose from the menu items: \n" +
                "1: View one student's grades \n" +
                "2: View all grades \n" +
                "3: Veiw the class average \n" +
                "4: Veiw full report for all students ");

        switch (scan.nextLine()){
            case "1": seeMoreStudentInfo(hash);
            break;
            case "2": viewAllGrades(hash);
            break;
            case "3": viewClassAverage(hash);
            break;
            default: viewFullReport(hash);
            break;
        }
        askToContinue(hash);
    }
    public static void
    seeMoreStudentInfo(HashMap<String, Student2>  hash){
        System.out.println("+++ USERS ++");
        hash.forEach((key, value)-> System.out.print("|" + key + "|"));
        System.out.println("");
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
        System.out.print("| Name: "+ student.getName());
        System.out.print("| Average = " + student.getGradeAverage());
        System.out.println("");
        System.out.print("GRADES:");
        student.showGrades();
    }



    public static void
    viewAllGrades(HashMap<String, Student2> hash){
        hash.forEach((key,value)-> {
            System.out.print("| Name: " + value.getName());
            System.out.print("| Average: " + value.getGradeAverage());
            System.out.println("__Grades__");
            value.showGrades();
            System.out.println("----------------");

        });
    }

    public static void
    viewClassAverage(HashMap<String, Student2> hash) {
        int total = hash.values().stream().mapToInt(Student2::getGradeTotal).sum();
        int average = total / hash.size();
        System.out.println("Class average: " + average);
    }

    public static void
    viewFullReport(HashMap<String, Student2> hash){
        viewClassAverage(hash);
        viewAllGrades(hash);
    }

    public static void
    askToContinue(HashMap<String, Student2> hash){
        System.out.print("Would you like to conitune?(y/n) ");
        String answer = scan.nextLine();
        if(answer.equalsIgnoreCase("n")) System.out.println("Goodbye");
        else startApplication(hash);

    }


}
