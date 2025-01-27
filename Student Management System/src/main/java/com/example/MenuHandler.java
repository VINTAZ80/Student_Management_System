package com.example;

import java.util.ArrayList;
import java.util.Scanner;

// Handles the menu and user interactions
class MenuHandler {

    // Starts the menu-driven application (Static Method)
    public static void start(ArrayList<Student> studentList, Scanner inputScanner) {
        // Create a repository to manage students
        StudentRepository repository = new StudentRepository(studentList);

        while (true) {
            // Display the menu options
            System.out.println("\n--- Student Management Application ---");
            System.out.println("1. Add New Student");
            System.out.println("2. Remove Student By ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                // Read the user's choice
                int userChoice = inputScanner.nextInt();
                inputScanner.nextLine(); // Consume the leftover newline character

                // Handle the user's choice
                switch (userChoice) {
                    case 1 -> repository.addNewStudent(inputScanner); // Add a new student
                    case 2 -> repository.removeStudentById(inputScanner); // Remove a student
                    case 3 -> repository.displayAllStudents(); // Display all students
                    case 4 -> repository.searchStudentById(inputScanner); // Search for a student
                    case 5 -> {
                        System.out.println("Exiting the application. Goodbye!");
                        return; // Exit the application
                    }
                    default -> System.out.println("Invalid choice. Please try again."); // Handle invalid input
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                inputScanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
