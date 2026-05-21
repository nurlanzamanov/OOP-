package elearning.users;
import elearning.courses.Course;
import elearning.content.Submission;
import elearning.content.Grade;
import elearning.exceptions.InvalidGradeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instructor extends User {
    private String instructorId;
    private String department;
    private ArrayList<Course> teachingCourses;

    //Constructor1
    public Instructor(String name, String email, String password, String instructorId) {
        this(name, email, password, instructorId, "Not specified");
    }

    //Constructor2
    public Instructor(String name, String email, String password, String instructorId, String department) {
        super(name, email, password);
        this.instructorId = instructorId;
        this.department = department;
        this.teachingCourses = new ArrayList<>();
    }

    //Course yaratmaq 1
    public Course createCourse(String title) {
        Course course = new Course(title, this);
        teachingCourses.add(course);
        System.out.println("Course created: " + title + " by " + getName());
        return course;
    }

    //Course yaratmaq 2
    public Course createCourse(String title, int capacity) {
        Course course = new Course(title, this, capacity);
        teachingCourses.add(course);
        System.out.println("Course created: " + title + " (capacity: " + capacity + ") by " + getName());
        return course;
    }

    //Submission qiymetlendirmek
    public void gradeSubmission(Submission submission, double score) throws InvalidGradeException {
        double maxScore = submission.getAssignment().getMaxScore();
        if (score < 0 || score > maxScore) {
            throw new InvalidGradeException("Invalid score: " + score + ". Must be between 0 and " + maxScore);
        }
        if (submission.isGraded()) {
            System.out.println("Warning: " + submission.getStudent().getName()
                    + "'s submission is already graded. Overwriting previous grade.");
        }
        Grade grade = new Grade(score, maxScore);
        submission.getStudent().addGrade(submission.getAssignment(), grade);
        submission.setGraded(true);
        System.out.println(getName() + " graded " + submission.getStudent().getName()
                + "'s submission | Score: " + score + "/" + maxScore
                + " | Letter: " + grade.getLetterGrade());
    }

    //displayInfo
    @Override
    public void displayInfo() {
        System.out.println("--- Instructor Info ---");
        System.out.println("Name       : " + getName());
        System.out.println("Email      : " + getEmail());
        System.out.println("ID         : " + instructorId);
        System.out.println("Department : " + department);
        System.out.println("Courses    : " + teachingCourses.size());
    }

    //getters
    public String getInstructorId() { return instructorId; }
    public String getDepartment() { return department; }
    public List<Course> getTeachingCourses() { return Collections.unmodifiableList(teachingCourses); }
    
    //setters
    public void setInstructorId(String instructorId) { this.instructorId = instructorId; }
    public void setDepartment(String department) { this.department = department; }
}
