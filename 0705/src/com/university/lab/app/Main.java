package com.university.lab.app;

import com.university.lab.model.Student;
import com.university.lab.print.PrintResult;

public class Main {
    public static void main(String[] args){
        Student student1 = new Student("Nurlan",87);
        Student student2 = new Student("Fuad",90);
        PrintResult print = new PrintResult();
        print.printResult(student1);
        print.printResult(student2);
        print.printBetter(student1,student2);
    }
}
