package elearning.content;

import elearning.interfaces.Gradable;

public class Assignment implements Gradable {

    private String title;
    private String description;
    private double maxScore;
    private boolean overdue;

    // Constructor 1 - without overdue (defaults to false)
    public Assignment(String title, double maxScore) {
        this(title, maxScore, "No description", false);
    }

    // Constructor 2 - with description, no overdue
    public Assignment(String title, double maxScore, String description) {
        this(title, maxScore, description, false);
    }

    // Constructor 3 - everything
    public Assignment(String title, double maxScore, String description, boolean overdue) {
        this.title = title;
        this.maxScore = maxScore;
        this.description = description;
        this.overdue = overdue;
    }

    // Implements Gradable interface
    @Override
    public double calculateGrade() {
        return maxScore;
    }

    // Display assignment info
    public void displayInfo() {
        System.out.println("--- Assignment Info ---");
        System.out.println("Title      : " + title);
        System.out.println("Description: " + description);
        System.out.println("Max Score  : " + maxScore);
        System.out.println("Overdue    : " + (overdue ? "Yes" : "No"));
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getMaxScore() { return maxScore; }
    public boolean isOverdue() { return overdue; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setMaxScore(double maxScore) { this.maxScore = maxScore; }
    public void setOverdue(boolean overdue) { this.overdue = overdue; }
}