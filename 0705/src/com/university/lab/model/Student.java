package com.university.lab.model;

public class Student {
        private String name;
        private double grade;

        public Student(String name,int grade){
            this.name=name;
            this.grade=grade;
        }

        public double getGrade(){
            return grade;
        }
        public void setGrade(double grade){
            this.grade=grade;
        }
        public String getName(){
            return name;
        }



}
