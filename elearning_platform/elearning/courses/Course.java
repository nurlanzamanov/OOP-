package elearning.courses;
import elearning.users.Student;
import elearning.users.Instructor;
import elearning.content.Assignment;
import elearning.exceptions.CourseFullException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private String courseId;
    private String title;
    private Instructor instructor;
    private int capacity;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<Assignment> assignments;
    private static int totalCourses = 0;

    //Constructor1
    public Course(String title, Instructor instructor) {
        this(title, instructor, 30);
    }

    //Constructor2
    public Course(String title, Instructor instructor, int capacity) {
        this.title = title;
        this.instructor = instructor;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.assignments = new ArrayList<>();
        totalCourses++;
        this.courseId = "CRS-" + totalCourses;
    }

    //Student elave etmek
    public void addStudent(Student student) throws CourseFullException {
        if (enrolledStudents.contains(student)) {
            System.out.println(student.getName() + " is already in course: " + title);
            return;
        }
        if (enrolledStudents.size() >= capacity) {
            throw new CourseFullException("Course \"" + title + "\" is full! Capacity: " + capacity);
        }
        enrolledStudents.add(student);
    }

    //Assignment elave etmek
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
        System.out.println("Assignment added to " + title + ": " + assignment.getTitle());
    }

    //displayInfo
    public void displayInfo() {
        System.out.println("--- Course Info ---");
        System.out.println("ID         : " + courseId);
        System.out.println("Title      : " + title);
        System.out.println("Instructor : " + instructor.getName());
        System.out.println("Students   : " + enrolledStudents.size() + "/" + capacity);
        System.out.println("Assignments: " + assignments.size());
    }

    //getters
    public static int getTotalCourses() { return totalCourses; }
    public static void decrementTotalCourses() { if (totalCourses > 0) totalCourses--; }
    public String getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public Instructor getInstructor() { return instructor; }
    public int getCapacity() { return capacity; }
    public List<Student> getEnrolledStudents() { return Collections.unmodifiableList(enrolledStudents); }
    public List<Assignment> getAssignments() { return Collections.unmodifiableList(assignments); }

    //setters
    public void setTitle(String title) { this.title = title; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
