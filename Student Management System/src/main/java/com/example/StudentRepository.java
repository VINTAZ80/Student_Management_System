package com.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Repository class for managing student operations
class StudentRepository {

    // List to hold student objects
    private final ArrayList<Student> studentList;

    // Constructor to initialize the repository with the student list
    public StudentRepository(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    // Adds a new student to the repository
    void addNewStudent(Scanner inputScanner) {
        int studentId = 0;
        String studentName = "";
        int studentAge = 0;

        // Input Student ID
        while (true) {
            System.out.print("\nEnter Student ID: ");
            try {
                String input = inputScanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("\nStudent ID cannot be empty. Please try again.");
                    continue;
                }
                studentId = Integer.parseInt(input);
                if (studentId <= 0) {
                    System.out.println("\nStudent ID must be a positive number. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid numeric Student ID.");
            }
        }

        // Input Student Name
        while (true) {
            System.out.print("\nEnter Student Name: ");
            studentName = inputScanner.nextLine().trim();

            // Check if the name is empty
            if (studentName.isEmpty()) {
                System.out.println("\nName cannot be empty. Please try again.");
                continue;
            }

            // Check if the name contains only alphabetic characters and spaces
            if (!studentName.matches("[a-zA-Z ]+")) {
                System.out.println("\nName can only contain alphabetic characters and spaces. Please try again.");
                continue;
            }

            // If both conditions are met, break the loop
            break;
        }
        
        // Input Student Age
        while (true) {
            System.out.print("\nEnter Student Age: ");
            try {
                String input = inputScanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("\nStudent Age cannot be empty. Please try again.");
                    continue;
                }
                studentAge = Integer.parseInt(input);
                if (studentAge <= 0) {
                    System.out.println("\nStudent Age must be a positive number. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid numeric Student Age.");
            }
        }

        // Check if a student with the same ID already exists
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                System.out.println("\nError: A student with ID " + studentId + " already exists.");
                return;
            }
        }

        // Add the new student to the list
        studentList.add(new Student(studentId, studentName, studentAge));
        System.out.println("\nStudent added successfully!");
    }


    // Removes a student from the repository based on their ID
    void removeStudentById(Scanner inputScanner) {
        int studentId = 0;

        // Input Student ID
        while (true) {
            System.out.print("\nEnter Student ID to remove: ");
            try {
                studentId = inputScanner.nextInt();
                inputScanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid numeric Student ID.");
                inputScanner.nextLine(); // Clear invalid input
            }
        }

        // Search for the student in the list
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                studentList.remove(student); // Remove the student if found
                System.out.println("\nStudent with ID " + studentId + " removed successfully!");
                return;
            }
        }

        // If the student is not found, display an error message
        System.out.println("\nError: Student with ID " + studentId + " not found.");
    }

    // Displays all students in the repository
    void displayAllStudents() {
        if (studentList.isEmpty()) { // Check if the list is empty
            System.out.println("\nNo students found.");
            return;
        }

        // Print header with aligned columns
        System.out.println("\n--- List of Students ---");
        System.out.printf("%-10s %-20s %-5s%n", "ID", "Name", "Age");
        System.out.println("-----------------------------------------");

        // Print each student's details with aligned formatting
        for (Student student : studentList) {
            System.out.printf("%-10s %-20s %-5d%n",
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getStudentAge());
        }
    }

    // Searches for a student by their ID
    void searchStudentById(Scanner inputScanner) {
        int studentId = 0;

        // Input Student ID
        while (true) {
            System.out.print("\nPlease enter the Student ID you want to search for: ");
            try {
                studentId = inputScanner.nextInt();
                inputScanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid numeric Student ID.");
                inputScanner.nextLine(); // Clear invalid input
            }
        }

        // Search for the student in the list
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                // Print the student's details if found
                System.out.println("\n--- Student Found ---");
                System.out.printf("%-10s: %d%n", "ID", student.getStudentId());
                System.out.printf("%-10s: %s%n", "Name", student.getStudentName());
                System.out.printf("%-10s: %d%n", "Age", student.getStudentAge());
                return;
            }
        }

        // If the student is not found, display a message
        System.out.println("\nNo student found with the provided ID.");
    }
}
