package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Student2 {
    private String name;
    private ArrayList<Integer> grades = new ArrayList<>();
    private HashMap<String, String> githubNames = new HashMap<>();

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
        grades.forEach(grade -> System.out.println(grade));
    }
//    public Double getGradeAverage(int index){
//        if(grades.size() == index) return (double)(grades.get(index) / grades.size());
//        return (double) grades.get(index) + (index);
//    }
//    public Double getGradeAverage(){
//        return getGradeAverage(0);
//    }
    public String getName() {
        return name;
    }
}