package elearning.content;
public class Assignment {
    private String title;
    private String description;
    private double maxScore;
    private boolean overdue;

    //Constructor 1
    public Assignment(String title, double maxScore) {
        this(title, maxScore, "No description", false);
    }

    //Consrtuctor2
    public Assignment(String title, double maxScore, String description) {
        this(title, maxScore, description, false);
    }

    //Constructor3
    public Assignment(String title, double maxScore, String description, boolean overdue) {
        this.title = title;
        this.maxScore = maxScore;
        this.description = description;
        this.overdue = overdue;
    }

    //Display funksiyasi
    public void displayInfo() {
        System.out.println("--- Assignment Info ---");
        System.out.println("Title      : " + title);
        System.out.println("Description: " + description);
        System.out.println("Max Score  : " + maxScore);
        System.out.println("Overdue    : " + (overdue ? "Yes" : "No"));
    }

    //getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getMaxScore() { return maxScore; }
    public boolean isOverdue() { return overdue; }

    //setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setMaxScore(double maxScore) { this.maxScore = maxScore; }
    public void setOverdue(boolean overdue) { this.overdue = overdue; }
}
