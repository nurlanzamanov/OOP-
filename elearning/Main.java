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

        // -------------------------------------------------------
        // 1. CREATE ADMIN
        // -------------------------------------------------------
        Admin admin = new Admin("Admin Ali", "ali@elearn.com", "admin123");
        System.out.println("✔ Admin created.\n");

        // -------------------------------------------------------
        // 2. CREATE INSTRUCTORS
        // -------------------------------------------------------
        Instructor instructor1 = new Instructor("Dr. Sara", "sara@elearn.com", "pass123", "INS-001", "Computer Science");
        Instructor instructor2 = new Instructor("Prof. John", "john@elearn.com", "pass456", "INS-002");
        System.out.println("✔ Instructors created.\n");

        // -------------------------------------------------------
        // 3. CREATE STUDENTS
        // -------------------------------------------------------
        Student student1 = new Student("Kamran", "kamran@elearn.com", "stu123", "STU-001");
        Student student2 = new Student("Leyla", "leyla@elearn.com", "stu456", "STU-002");
        Student student3 = new Student("Tural", "tural@elearn.com", "stu789");  // no ID - uses constructor 1
        System.out.println("✔ Students created.\n");

        // -------------------------------------------------------
        // 4. SHOW STATIC - total users created
        // -------------------------------------------------------
        System.out.println(">>> Total users created: " + elearning.users.User.getTotalUsers());
        System.out.println();

        // -------------------------------------------------------
        // 5. REGISTER EVERYONE WITH ADMIN
        // -------------------------------------------------------
        admin.addStudent(student1);
        admin.addStudent(student2);
        admin.addStudent(student3);
        admin.addInstructor(instructor1);
        admin.addInstructor(instructor2);
        System.out.println();

        // -------------------------------------------------------
        // 6. INSTRUCTORS CREATE COURSES (overloaded constructors)
        // -------------------------------------------------------
        Course course1 = instructor1.createCourse("Java OOP");           // default capacity 30
        Course course2 = instructor1.createCourse("Data Structures", 2); // capacity 2 (to test CourseFullException)
        Course course3 = instructor2.createCourse("Web Development");
        System.out.println();

        // -------------------------------------------------------
        // 7. SHOW STATIC - total courses created
        // -------------------------------------------------------
        System.out.println(">>> Total courses created: " + Course.getTotalCourses());
        System.out.println();

        // -------------------------------------------------------
        // 8. REGISTER COURSES WITH ADMIN
        // -------------------------------------------------------
        admin.addCourse(course1);
        admin.addCourse(course2);
        admin.addCourse(course3);
        System.out.println();

        // -------------------------------------------------------
        // 9. STUDENTS ENROLL (overloaded enroll)
        // -------------------------------------------------------
        try {
            student1.enroll(course1);                                      // enroll version 1 - no reason
            student1.enroll(course2, "I love data structures!");           // enroll version 2 - with reason
            student2.enroll(course1);
            student2.enroll(course2, "Required for my major");
            student3.enroll(course1);
        } catch (CourseFullException e) {
            System.out.println("❌ Enrollment failed: " + e.getMessage());
        }
        System.out.println();

        // -------------------------------------------------------
        // 10. TEST CourseFullException - course2 capacity is 2
        // -------------------------------------------------------
        System.out.println(">>> Testing CourseFullException:");
        try {
            student3.enroll(course2, "Trying to join full course");
        } catch (CourseFullException e) {
            System.out.println("❌ CourseFullException caught: " + e.getMessage());
        }
        System.out.println();

        // -------------------------------------------------------
        // 11. CREATE ASSIGNMENTS
        // -------------------------------------------------------
        Assignment assignment1 = new Assignment("OOP Basics Quiz", 100);                              // constructor 1
        Assignment assignment2 = new Assignment("Linked List Task", 50, "Implement a linked list");   // constructor 2
        Assignment assignment3 = new Assignment("Overdue Task", 80, "This is overdue", true);         // constructor 3 - overdue!

        course1.addAssignment(assignment1);
        course1.addAssignment(assignment2);
        course1.addAssignment(assignment3);
        System.out.println();

        // -------------------------------------------------------
        // 12. STUDENTS SUBMIT ASSIGNMENTS
        // -------------------------------------------------------
        System.out.println(">>> Testing submissions:");
        try {
            student1.submit(assignment1, "My answer to OOP Basics");
            student2.submit(assignment2, "Here is my linked list implementation");
        } catch (DeadlinePassedException e) {
            System.out.println("❌ DeadlinePassedException caught: " + e.getMessage());
        }
        System.out.println();

        // -------------------------------------------------------
        // 13. TEST DeadlinePassedException
        // -------------------------------------------------------
        System.out.println(">>> Testing DeadlinePassedException:");
        try {
            student1.submit(assignment3, "Trying to submit overdue task");
        } catch (DeadlinePassedException e) {
            System.out.println("❌ DeadlinePassedException caught: " + e.getMessage());
        }
        System.out.println();

        // -------------------------------------------------------
        // 14. INSTRUCTOR GRADES SUBMISSIONS
        // -------------------------------------------------------
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

        // -------------------------------------------------------
        // 15. TEST InvalidGradeException
        // -------------------------------------------------------
        System.out.println(">>> Testing InvalidGradeException:");
        try {
            instructor1.gradeSubmission(sub1, 150); // 150 is above maxScore of 100
        } catch (InvalidGradeException e) {
            System.out.println("❌ InvalidGradeException caught: " + e.getMessage());
        }
        System.out.println();

        // -------------------------------------------------------
        // 16. CALCULATE GPA
        // -------------------------------------------------------
        System.out.println(">>> GPA Calculation:");
        student1.getGPA();
        student2.getGPA();
        student3.getGPA(); // no grades yet
        System.out.println();

        // -------------------------------------------------------
        // 17. POLYMORPHISM - displayInfo() on each user type
        // -------------------------------------------------------
        System.out.println(">>> Polymorphism - displayInfo():");
        admin.displayInfo();
        System.out.println();
        instructor1.displayInfo();
        System.out.println();
        student1.displayInfo();
        System.out.println();

        // -------------------------------------------------------
        // 18. ADMIN DISPLAYS EVERYTHING
        // -------------------------------------------------------
        admin.displayAllStudents();
        admin.displayAllInstructors();
        admin.displayAllCourses();

        System.out.println("\n========================================");
        System.out.println("         PLATFORM DEMO COMPLETE!        ");
        System.out.println("========================================");
    }
}