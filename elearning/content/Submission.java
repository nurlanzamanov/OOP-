package elearning.content;

import elearning.users.Student;

public class Submission {

    private Student student;
    private Assignment assignment;
    private String answer;
    private boolean isGraded;

    // Constructor
    public Submission(Student student, Assignment assignment, String answer) {
        this.student = student;
        this.assignment = assignment;
        this.answer = answer;
        this.isGraded = false; // always starts as not graded
    }

    // Display submission info
    public void displayInfo() {
        System.out.println("--- Submission Info ---");
        System.out.println("Student    : " + student.getName());
        System.out.println("Assignment : " + assignment.getTitle());
        System.out.println("Answer     : " + answer);
        System.out.println("Graded     : " + (isGraded ? "Yes" : "No"));
    }

    // Getters
    public Student getStudent() { return student; }
    public Assignment getAssignment() { return assignment; }
    public String getAnswer() { return answer; }
    public boolean isGraded() { return isGraded; }

    // Setters
    public void setAnswer(String answer) { this.answer = answer; }
    public void setGraded(boolean graded) { this.isGraded = graded; }
}