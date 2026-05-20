package elearning.users;

import elearning.courses.Course;
import java.util.ArrayList;

public class Admin extends User {

    private ArrayList<Student> allStudents;
    private ArrayList<Instructor> allInstructors;
    private ArrayList<Course> allCourses;

    // Constructor
    public Admin(String name, String email, String password) {
        super(name, email, password);
        this.allStudents = new ArrayList<>();
        this.allInstructors = new ArrayList<>();
        this.allCourses = new ArrayList<>();
    }

    // Student management
    public void addStudent(Student student) {
        allStudents.add(student);
        System.out.println("Student added: " + student.getName());
    }

    public void removeStudent(Student student) {
        if (allStudents.remove(student)) {
            System.out.println("Student removed: " + student.getName());
        } else {
            System.out.println("Student not found: " + student.getName());
        }
    }

    // Instructor management
    public void addInstructor(Instructor instructor) {
        allInstructors.add(instructor);
        System.out.println("Instructor added: " + instructor.getName());
    }

    public void removeInstructor(Instructor instructor) {
        if (allInstructors.remove(instructor)) {
            System.out.println("Instructor removed: " + instructor.getName());
        } else {
            System.out.println("Instructor not found: " + instructor.getName());
        }
    }

    // Course management
    public void addCourse(Course course) {
        allCourses.add(course);
        System.out.println("Course registered: " + course.getTitle());
    }

    public void removeCourse(Course course) {
        if (allCourses.remove(course)) {
            System.out.println("Course removed: " + course.getTitle());
        } else {
            System.out.println("Course not found: " + course.getTitle());
        }
    }

    // Display all students
    public void displayAllStudents() {
        System.out.println("\n=== All Students (" + allStudents.size() + ") ===");
        if (allStudents.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : allStudents) {
            s.displayInfo();
        }
    }

    // Display all instructors
    public void displayAllInstructors() {
        System.out.println("\n=== All Instructors (" + allInstructors.size() + ") ===");
        if (allInstructors.isEmpty()) {
            System.out.println("No instructors registered.");
            return;
        }
        for (Instructor i : allInstructors) {
            i.displayInfo();
        }
    }

    // Display all courses
    public void displayAllCourses() {
        System.out.println("\n=== All Courses (" + allCourses.size() + ") ===");
        if (allCourses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }
        for (Course c : allCourses) {
            c.displayInfo();
        }
    }

    // Override abstract method from User
    @Override
    public void displayInfo() {
        System.out.println("--- Admin Info ---");
        System.out.println("Name        : " + getName());
        System.out.println("Email       : " + getEmail());
        System.out.println("Students    : " + allStudents.size());
        System.out.println("Instructors : " + allInstructors.size());
        System.out.println("Courses     : " + allCourses.size());
    }

    // Getters
    public ArrayList<Student> getAllStudents() { return allStudents; }
    public ArrayList<Instructor> getAllInstructors() { return allInstructors; }
    public ArrayList<Course> getAllCourses() { return allCourses; }
}