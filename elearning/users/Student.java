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


    public Student(String name, String email, String password) {
        this(name, email, password, "N/A");
    }

    public Student(String name, String email, String password, String studentId) {
        super(name, email, password);
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
        this.submissionHistory = new LinkedList<>();
    }

    @Override
    public void enroll(Course course) throws CourseFullException {
        enroll(course, "No reason specified");
    }

    public void enroll(Course course, String reason) throws CourseFullException {
        if (enrolledCourses.contains(course)) {
            System.out.println(getName() + " is already enrolled in " + course.getTitle());
            return;
        }
        course.addStudent(this);
        enrolledCourses.add(course);
        System.out.println(getName() + " enrolled in " + course.getTitle() + " | Reason: " + reason);
    }

    @Override
    public void submit(Assignment assignment, String answer) throws DeadlinePassedException {
        if (assignment.isOverdue()) {
            throw new DeadlinePassedException("Deadline has passed for: " + assignment.getTitle());
        }
        Submission submission = new Submission(this, assignment, answer);
        submissionHistory.add(submission);
        System.out.println(getName() + " submitted: " + assignment.getTitle());
    }

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


    public void addGrade(Assignment assignment, Grade grade) {
        grades.put(assignment, grade);
    }


    @Override
    public void displayInfo() {
        System.out.println("--- Student Info ---");
        System.out.println("Name     : " + getName());
        System.out.println("Email    : " + getEmail());
        System.out.println("ID       : " + studentId);
        System.out.println("Courses  : " + enrolledCourses.size());
        System.out.println("Submissions: " + submissionHistory.size());
    }


    public String getStudentId() { 
        return studentId; 
    }
    public ArrayList<Course> getEnrolledCourses() { 
        return enrolledCourses; 
    }
    public HashMap<Assignment, Grade> getGrades() { 
        return grades; 
    }
    public LinkedList<Submission> getSubmissionHistory() { 
        return submissionHistory; 
    }

    
    public void setStudentId(String studentId) { 
        this.studentId = studentId; 
    }
}