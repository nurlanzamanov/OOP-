package elearning.users;

import elearning.courses.Course;
import elearning.content.Assignment;
import elearning.content.Submission;
import elearning.content.Grade;
import elearning.interfaces.Enrollable;
import elearning.interfaces.Submittable;
import elearning.exceptions.CourseFullException;
import elearning.exceptions.DeadlinePassedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Student extends User implements Enrollable, Submittable {

    private String studentId;
    private ArrayList<Course> enrolledCourses;
    private HashMap<Assignment, Grade> grades;
    private LinkedList<Submission> submissionHistory;

    // Constructor 1 - basic
    public Student(String name, String email, String password) {
        this(name, email, password, "N/A");
    }

    // Constructor 2 - with studentId (constructor 1 calls this one via this())
    public Student(String name, String email, String password, String studentId) {
        super(name, email, password);
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
        this.submissionHistory = new LinkedList<>();
    }

    // enroll - version 1 (no reason)
    @Override
    public void enroll(Course course) throws CourseFullException {
        enroll(course, "No reason specified");
    }

    // enroll - version 2 overloaded (with reason)
    public void enroll(Course course, String reason) throws CourseFullException {
        if (enrolledCourses.contains(course)) {
            System.out.println(getName() + " is already enrolled in " + course.getTitle());
            return;
        }
        course.addStudent(this); // this can throw CourseFullException
        enrolledCourses.add(course);
        System.out.println(getName() + " enrolled in " + course.getTitle() + " | Reason: " + reason);
    }

    // submit assignment
    @Override
    public void submit(Assignment assignment, String answer) throws DeadlinePassedException {
        if (assignment.isOverdue()) {
            throw new DeadlinePassedException("Deadline has passed for: " + assignment.getTitle());
        }
        Submission submission = new Submission(this, assignment, answer);
        submissionHistory.add(submission);
        System.out.println(getName() + " submitted: " + assignment.getTitle());
    }

    // calculate GPA from grades HashMap
    public double getGPA() {
        if (grades.isEmpty()) {
            System.out.println("No grades yet.");
            return 0.0;
        }
        double total = 0;
        for (Grade grade : grades.values()) {
            total += grade.getScore();
        }
        double gpa = total / grades.size();
        System.out.println(getName() + "'s GPA: " + gpa);
        return gpa;
    }

    // add a grade for an assignment
    public void addGrade(Assignment assignment, Grade grade) {
        grades.put(assignment, grade);
    }

    // override abstract method from User
    @Override
    public void displayInfo() {
        System.out.println("--- Student Info ---");
        System.out.println("Name     : " + getName());
        System.out.println("Email    : " + getEmail());
        System.out.println("ID       : " + studentId);
        System.out.println("Courses  : " + enrolledCourses.size());
        System.out.println("Submissions: " + submissionHistory.size());
    }

    // Getters
    public String getStudentId() { return studentId; }
    public ArrayList<Course> getEnrolledCourses() { return enrolledCourses; }
    public HashMap<Assignment, Grade> getGrades() { return grades; }
    public LinkedList<Submission> getSubmissionHistory() { return submissionHistory; }

    // Setters
    public void setStudentId(String studentId) { this.studentId = studentId; }
}