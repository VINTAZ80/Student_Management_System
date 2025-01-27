package com.example;

import java.util.ArrayList;
import java.util.Scanner;

// Main class that drives the Student Management System
public class StudentManagementSystem {

    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner inputScanner = new Scanner(System.in);

        // Static list to store student information
        ArrayList<Student> studentList = new ArrayList<>();

        // Start the menu-driven application
        MenuHandler.start(studentList, inputScanner);
    }
}
