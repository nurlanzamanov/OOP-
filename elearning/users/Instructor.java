package elearning.users;

import elearning.courses.Course;
import elearning.content.Submission;
import elearning.content.Grade;
import elearning.exceptions.InvalidGradeException;

import java.util.ArrayList;

public class Instructor extends User {

    private String instructorId;
    private String department;
    private ArrayList<Course> teachingCourses;

    public Instructor(String name, String email, String password, String instructorId) {
        this(name, email, password, instructorId, "Not specified");
    }

    public Instructor(String name, String email, String password, String instructorId, String department) {
        super(name, email, password);
        this.instructorId = instructorId;
        this.department = department;
        this.teachingCourses = new ArrayList<>();
    }

    public Course createCourse(String title) {
        Course course = new Course(title, this);
        teachingCourses.add(course);
        System.out.println("Course created: " + title + " by " + getName());
        return course;
    }

    public Course createCourse(String title, int capacity) {
        Course course = new Course(title, this, capacity);
        teachingCourses.add(course);
        System.out.println("Course created: " + title + " (capacity: " + capacity + ") by " + getName());
        return course;
    }

    public void gradeSubmission(Submission submission, double score) throws InvalidGradeException {
        double maxScore = submission.getAssignment().getMaxScore();

        if (score < 0 || score > maxScore) {
            throw new InvalidGradeException("Invalid score: " + score + ". Must be between 0 and " + maxScore);
        }

        Grade grade = new Grade(score, maxScore);
        submission.getStudent().addGrade(submission.getAssignment(), grade);
        submission.setGraded(true);

        System.out.println(getName() + " graded " + submission.getStudent().getName()
                + "'s submission | Score: " + score + "/" + maxScore
                + " | Letter: " + grade.getLetterGrade());
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Instructor Info ---");
        System.out.println("Name       : " + getName());
        System.out.println("Email      : " + getEmail());
        System.out.println("ID         : " + instructorId);
        System.out.println("Department : " + department);
        System.out.println("Courses    : " + teachingCourses.size());
    }


    public String getInstructorId() { 
        return instructorId; 
    }
    public String getDepartment() { 
        return department; 
    }
    public ArrayList<Course> getTeachingCourses() { 
        return teachingCourses; 
    }

    public void setInstructorId(String instructorId) { 
        this.instructorId = instructorId; 
    }
    public void setDepartment(String department) { 
        this.department = department; 
    }
}