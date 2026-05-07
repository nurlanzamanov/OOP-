package com.university.lab.print;
import com.university.lab.model.Student;

public class PrintResult {
    public void printResult(Student student){
        if (student.getGrade()>=60){
            System.out.println(String.format("%s has passed",student.getName()));
        }
        else{
            System.out.println(String.format("%s has failed",student.getName()));
        }
    }
    public void printBetter(Student student1,Student student2){
        if (student1.getGrade()>student2.getGrade()){
            System.out.println(String.format("%s has higher grade",student1.getName()));
        }
        else if (student1.getGrade()<student2.getGrade()){
            System.out.println(String.format("%s has higher grade",student2.getName()));
        }
        else {
            System.out.println(String.format("Both %s and %s the exact same grade",student1.getName(),student2.getName()));
        }
    }
}
