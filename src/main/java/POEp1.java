
import java.util.HashMap;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class POEp1 {
private static HashMap<String, String> registeredUsers = new HashMap<>();

    public static void main(String[] args) {
        // Registering some users (for demonstration purposes)
        registerUser("user1", "Password123!", "John", "Doe");
        registerUser("user2", "StrongP@ssw0rd", "Jane", "Smith");
        registerUser("user3", "My$3cr3tP@ss", "Alice", "Johnson");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter Password: ");
        String enteredPassword = scanner.nextLine();

        if (authenticateUser(enteredUsername, enteredPassword)) {
            System.out.println("Welcome " + getUserFirstName(enteredUsername) + ", " + getUserLastName(enteredUsername) + " it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
        scanner.close();
    }

    public static void registerUser(String username, String password, String firstName, String lastName) {
        registeredUsers.put(username, password + "," + firstName + "," + lastName);
    }

    public static boolean authenticateUser(String enteredUsername, String enteredPassword) {
        if (registeredUsers.containsKey(enteredUsername)) {
            String storedPassword = registeredUsers.get(enteredUsername).split(",")[0];
            return storedPassword.equals(enteredPassword);
        }
        return false;
    }

    public static String getUserFirstName(String username) {
        if (registeredUsers.containsKey(username)) {
            return registeredUsers.get(username).split(",")[1];
        }
        return "";
    }

    public static String getUserLastName(String username) {
        if (registeredUsers.containsKey(username)) {
            return registeredUsers.get(username).split(",")[2];
        }
        return "";
    }    
}
