package elearning.content;

public class Grade {

    private double score;
    private double maxScore;
    private String letterGrade;

    // Constructor
    public Grade(double score, double maxScore) {
        this.score = score;
        this.maxScore = maxScore;
        this.letterGrade = calculateLetterGrade();
    }

    // Calculate letter grade based on percentage
    private String calculateLetterGrade() {
        double percentage = (score / maxScore) * 100;

        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }

    // Display grade info
    public void displayInfo() {
        System.out.println("--- Grade Info ---");
        System.out.println("Score       : " + score + "/" + maxScore);
        System.out.println("Percentage  : " + String.format("%.1f", (score / maxScore) * 100) + "%");
        System.out.println("Letter Grade: " + letterGrade);
    }

    // Getters
    public double getScore() { return score; }
    public double getMaxScore() { return maxScore; }
    public String getLetterGrade() { return letterGrade; }

    // Setters
    public void setScore(double score) {
        this.score = score;
        this.letterGrade = calculateLetterGrade(); // recalculate when score changes
    }
}