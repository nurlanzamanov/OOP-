package elearning.users;
public abstract class User {
    private String name;
    private String email;
    private String password;
    private static int totalUsers = 0;

    //Constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        totalUsers++;
    }

    //displayInfo
    public abstract void displayInfo();

    //Check Password
    public boolean checkPassword(String input) {
        return this.password.equals(input);
    }

    //dec Total Users(user silinende)
    public static void decrementTotalUsers() {
        if (totalUsers > 0) totalUsers--;
    }

    //getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public static int getTotalUsers() { return totalUsers; }

    //setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
