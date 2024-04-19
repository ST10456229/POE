
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class POEp2 {
private String username;
    private String password;
 public POEp2(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkUserName() {
        return username.contains("_");
    }

    public boolean checkPasswordComplexity() {
        if (password.length() < 8) {
            return false;
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }

        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }

        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            return false;
        }

        return true;
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is incorrectly formatted.";
        }

        if (!checkPasswordComplexity()) {
            return "Password does not meet the complexity requirements.";
        }

        return "User registered successfully.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        // Check if the entered username and password are non-empty
        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            return false;
        }
        
        // Check if the entered username and password match the stored ones
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Login successful.";
        } else {
            return "Login failed.";
        }
    }

    // Getters and setters for username and password (if needed)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter username
        System.out.print("Enter Username: ");
        String enteredUsername = scanner.nextLine();

        // Prompt the user to enter password
        System.out.print("Enter Password: ");
        String enteredPassword = scanner.nextLine();

        POEp2 login = new POEp2("user_name", "Password123!");
        String registrationStatus = login.registerUser();
        System.out.println(registrationStatus);

        boolean loginSuccess = login.loginUser(enteredUsername, enteredPassword);
        String loginStatus = login.returnLoginStatus(loginSuccess);
        System.out.println(loginStatus);

        scanner.close();
    }
}    

