package elearning;
import elearning.users.Admin;
import elearning.users.Instructor;
import elearning.users.Student;
import elearning.courses.Course;
import elearning.content.Assignment;
import elearning.content.Submission;
import elearning.content.Grade;
import elearning.exceptions.CourseFullException;
import elearning.exceptions.DeadlinePassedException;
import elearning.exceptions.InvalidGradeException;


public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("      E-LEARNING PLATFORM STARTING     ");
        System.out.println("========================================\n");

        //Admin yaradilir
        Admin admin = new Admin("Admin Ali", "ali@elearn.com", "admin123");
        System.out.println("✔ Admin created.\n");

        //Instructorlar yaradilir
        Instructor instructor1 = new Instructor("Dr. Sara", "sara@elearn.com", "pass123", "INS-001", "Computer Science");
        Instructor instructor2 = new Instructor("Prof. John", "john@elearn.com", "pass456", "INS-002");
        System.out.println("✔ Instructors created.\n");

        //Studentlar yaradilir
        Student student1 = new Student("Kamran", "kamran@elearn.com", "stu123", "STU-001");
        Student student2 = new Student("Leyla", "leyla@elearn.com", "stu456", "STU-002");
        Student student3 = new Student("Tural", "tural@elearn.com", "stu789");  
        System.out.println("✔ Students created.\n");
        System.out.println(">>> Total users created: " + elearning.users.User.getTotalUsers());
        System.out.println();


        //Studentlar elave edilir
        admin.addStudent(student1);
        admin.addStudent(student2);
        admin.addStudent(student3);
        admin.addInstructor(instructor1);
        admin.addInstructor(instructor2);
        System.out.println();

        //Courselar yaradilir
        Course course1 = instructor1.createCourse("Java OOP");           
        Course course2 = instructor1.createCourse("Data Structures", 2); 
        Course course3 = instructor2.createCourse("Web Development");
        System.out.println();
        System.out.println(">>> Total courses created: " + Course.getTotalCourses());
        System.out.println();

        //Courselar elave edilir
        admin.addCourse(course1);
        admin.addCourse(course2);
        admin.addCourse(course3);
        System.out.println();

        //Studentlar enroll edir
        try {
            student1.enroll(course1);                                      
            student1.enroll(course2, "I love data structures!");           
            student2.enroll(course1);
            student2.enroll(course2, "Required for my major");
            student3.enroll(course1);
        } catch (CourseFullException e) {
            System.out.println("❌ Enrollment failed: " + e.getMessage());
        }
        System.out.println();

        //Erroru yoxlamaq
        System.out.println(">>> Testing CourseFullException:");
        try {
            student3.enroll(course2, "Trying to join full course");
        } catch (CourseFullException e) {
            System.out.println("❌ CourseFullException caught: " + e.getMessage());
        }
        System.out.println();

        //Assignment yaratmaq
        Assignment assignment1 = new Assignment("OOP Basics Quiz", 100);                              
        Assignment assignment2 = new Assignment("Linked List Task", 50, "Implement a linked list");   
        Assignment assignment3 = new Assignment("Overdue Task", 80, "This is overdue", true);         
        course1.addAssignment(assignment1);
        course1.addAssignment(assignment2);
        course1.addAssignment(assignment3);
        System.out.println();

        //Submission etmek
        System.out.println(">>> Testing submissions:");
        try {
            student1.submit(assignment1, "My answer to OOP Basics");
            student2.submit(assignment2, "Here is my linked list implementation");
        } catch (DeadlinePassedException e) {
            System.out.println("❌ DeadlinePassedException caught: " + e.getMessage());
        }
        System.out.println();

        //Deadline erroru
        System.out.println(">>> Testing DeadlinePassedException:");
        try {
            student1.submit(assignment3, "Trying to submit overdue task");
        } catch (DeadlinePassedException e) {
            System.out.println("❌ DeadlinePassedException caught: " + e.getMessage());
        }
        System.out.println();

        //Submissiona grade vermek
        System.out.println(">>> Grading submissions:");
        Submission sub1 = student1.getSubmissionHistory().get(0);
        Submission sub2 = student2.getSubmissionHistory().get(0);
        try {
            instructor1.gradeSubmission(sub1, 95);
            instructor1.gradeSubmission(sub2, 40);
        } catch (InvalidGradeException e) {
            System.out.println("❌ InvalidGradeException caught: " + e.getMessage());
        }
        System.out.println();

        //Invalid Grade Error
        System.out.println(">>> Testing InvalidGradeException:");
        try {
            instructor1.gradeSubmission(sub1, 150); 
        } catch (InvalidGradeException e) {
            System.out.println("❌ InvalidGradeException caught: " + e.getMessage());
        }
        System.out.println();

        //GPA-i hesablamaq
        System.out.println(">>> GPA Calculation:");
        student1.getGPA();
        student2.getGPA();
        student3.getGPA(); 
        System.out.println();

        //displayInfo
        System.out.println(">>> Polymorphism - displayInfo():");
        admin.displayInfo();
        System.out.println();
        instructor1.displayInfo();
        System.out.println();
        student1.displayInfo();
        System.out.println();
        admin.displayAllStudents();
        admin.displayAllInstructors();
        admin.displayAllCourses();

        //End
        System.out.println("\n========================================");
        System.out.println("         PLATFORM DEMO COMPLETE!        ");
        System.out.println("========================================");
    }
}