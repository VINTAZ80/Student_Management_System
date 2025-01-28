/**
 * @file StudentManagementSystem.java
 * @brief Main class to drive the Student Management System.
 * 
 * This class initializes the application, sets up required resources, and starts 
 * the menu-driven system to manage students.
 */

package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @class StudentManagementSystem
 * @brief Entry point for the Student Management System application.
 * 
 * This class contains the main method to initialize the application, create a list 
 * to store student data, and start the menu-driven system using the MenuHandler class.
 */
public class StudentManagementSystem {

    /**
     * @brief Main method to start the application.
     * 
     * The main method sets up the Scanner for user input and initializes 
     * an ArrayList to store student information. It then calls the MenuHandler 
     * class to start the menu-driven system.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner inputScanner = new Scanner(System.in);

        // Static list to store student information
        ArrayList<Student> studentList = new ArrayList<>();

        // Start the menu-driven application
        MenuHandler.start(studentList, inputScanner);
    }
}
