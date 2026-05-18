package elearning.users;

import elearning.courses.Course;
import java.util.ArrayList;

public abstract class User {

    private String name;
    private String email;
    private String password;
    private static int totalUsers = 0;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        totalUsers++;
    }

    // Abstract method - every subclass MUST override this
    public abstract void displayInfo();

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public static int getTotalUsers() { return totalUsers; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}