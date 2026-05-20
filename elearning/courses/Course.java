package elearning.courses;

import elearning.users.Student;
import elearning.users.Instructor;
import elearning.content.Assignment;
import elearning.exceptions.CourseFullException;

import java.util.ArrayList;

public class Course {

    private String courseId;
    private String title;
    private Instructor instructor;
    private int capacity;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Assignment> assignments;
    private static int totalCourses = 0;

    // Constructor 1 - default capacity 30
    public Course(String title, Instructor instructor) {
        this(title, instructor, 30);
    }

    // Constructor 2 - custom capacity
    public Course(String title, Instructor instructor, int capacity) {
        this.title = title;
        this.instructor = instructor;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.assignments = new ArrayList<>();
        totalCourses++;
        this.courseId = "CRS-" + totalCourses;
    }

    // Add student - throws CourseFullException if full
    public void addStudent(Student student) throws CourseFullException {
        if (enrolledStudents.size() >= capacity) {
            throw new CourseFullException("Course \"" + title + "\" is full! Capacity: " + capacity);
        }
        enrolledStudents.add(student);
    }

    // Add assignment to course
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
        System.out.println("Assignment added to " + title + ": " + assignment.getTitle());
    }

    // Display course info
    public void displayInfo() {
        System.out.println("--- Course Info ---");
        System.out.println("ID         : " + courseId);
        System.out.println("Title      : " + title);
        System.out.println("Instructor : " + instructor.getName());
        System.out.println("Students   : " + enrolledStudents.size() + "/" + capacity);
        System.out.println("Assignments: " + assignments.size());
    }

    // Static method
    public static int getTotalCourses() { return totalCourses; }

    // Getters
    public String getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public Instructor getInstructor() { return instructor; }
    public int getCapacity() { return capacity; }
    public ArrayList<Student> getEnrolledStudents() { return enrolledStudents; }
    public ArrayList<Assignment> getAssignments() { return assignments; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}