package elearning.users;
import elearning.courses.Course;
import java.util.ArrayList;
public class Admin extends User {
    private ArrayList<Student> allStudents;
    private ArrayList<Instructor> allInstructors;
    private ArrayList<Course> allCourses;

    //Constructor
    public Admin(String name, String email, String password) {
        super(name, email, password);
        this.allStudents = new ArrayList<>();
        this.allInstructors = new ArrayList<>();
        this.allCourses = new ArrayList<>();
    }

    //Student elave etmek
    public void addStudent(Student student) {
        if (allStudents.contains(student)) {
            System.out.println("Student already registered: " + student.getName());
            return;
        }
        allStudents.add(student);
        System.out.println("Student added: " + student.getName());
    }

    //Student silmek
    public void removeStudent(Student student) {
        if (allStudents.remove(student)) {
            User.decrementTotalUsers();
            System.out.println("Student removed: " + student.getName());
        } else {
            System.out.println("Student not found: " + student.getName());
        }
    }

    //Instructor elave etmek
    public void addInstructor(Instructor instructor) {
        if (allInstructors.contains(instructor)) {
            System.out.println("Instructor already registered: " + instructor.getName());
            return;
        }
        allInstructors.add(instructor);
        System.out.println("Instructor added: " + instructor.getName());
    }

    //Instructor silmek
    public void removeInstructor(Instructor instructor) {
        if (allInstructors.remove(instructor)) {
            User.decrementTotalUsers();
            System.out.println("Instructor removed: " + instructor.getName());
        } else {
            System.out.println("Instructor not found: " + instructor.getName());
        }
    }

    //Course elave etmek
    public void addCourse(Course course) {
        if (allCourses.contains(course)) {
            System.out.println("Course already registered: " + course.getTitle());
            return;
        }
        allCourses.add(course);
        System.out.println("Course registered: " + course.getTitle());
    }

    //Course silmek
    public void removeCourse(Course course) {
        if (allCourses.remove(course)) {
            Course.decrementTotalCourses();
            System.out.println("Course removed: " + course.getTitle());
        } else {
            System.out.println("Course not found: " + course.getTitle());
        }
    }

    //Butun studentlari gostermek
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

    //Butun instructorlari gostermek
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

    //Butun courselari gostermek
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

    //Admin displayInfo
    @Override
    public void displayInfo() {
        System.out.println("--- Admin Info ---");
        System.out.println("Name        : " + getName());
        System.out.println("Email       : " + getEmail());
        System.out.println("Students    : " + allStudents.size());
        System.out.println("Instructors : " + allInstructors.size());
        System.out.println("Courses     : " + allCourses.size());
    }

    //getters
    public ArrayList<Student> getAllStudents() { return allStudents; }
    public ArrayList<Instructor> getAllInstructors() { return allInstructors; }
    public ArrayList<Course> getAllCourses() { return allCourses; }
}
