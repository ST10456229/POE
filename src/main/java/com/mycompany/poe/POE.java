/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import javax.swing.JOptionPane;
import java.util.regex.*;
/**
 *
 * @author RC_Student_lab
 */
public class POE {

    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter Username:");
        if (isValidUsername(username)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no longer than 5 characters in length.");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter Password:");
        if (checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }

        
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");

        
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
    }

    public static boolean isValidUsername(String username) {
        
        return username.matches("^\\w{1,5}_\\w*$");
    }

    public static boolean checkPasswordComplexity(String password) {
        
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
}
