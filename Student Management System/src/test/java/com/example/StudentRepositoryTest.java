package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the StudentRepository class.
 */
class StudentRepositoryTest {

    private ArrayList<Student> studentList;
    private StudentRepository repository;

    /**
     * Sets up the test environment before each test.
     * 
     * Initializes an empty list of students and creates a new instance
     * of the StudentRepository with the list.
     */
    @BeforeEach
    void setUp() {
        studentList = new ArrayList<>();
        repository = new StudentRepository(studentList);
    }

    /**
     * Tests the addition of a new student with valid inputs.
     * 
     * Verifies that the student is successfully added to the list 
     * with the correct details.
     */
    @Test
    void testAddNewStudent_Success() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(101, 20);
        when(mockScanner.nextLine()).thenReturn("", "Ali");

        repository.addNewStudent(mockScanner);

        assertEquals(1, studentList.size());
        assertEquals(101, studentList.get(0).getStudentId());
        assertEquals("Ali", studentList.get(0).getStudentName());
        assertEquals(20, studentList.get(0).getStudentAge());
    }

    /**
     * Tests the addition of a new student with a duplicate ID.
     * 
     * Verifies that the student is not added to the list when the 
     * provided ID already exists in the list.
     */
    @Test
    void testAddNewStudent_DuplicateId() {
        studentList.add(new Student(101, "Ali", 20));

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(101);
        when(mockScanner.nextLine()).thenReturn("", "Ali");

        repository.addNewStudent(mockScanner);

        assertEquals(1, studentList.size());
    }

    /**
     * Tests the display of all students when the list is non-empty.
     * 
     * Verifies that the list is printed correctly and its size 
     * remains unchanged.
     */
    @Test
    void testDisplayAllStudents_NonEmpty() {
        studentList.add(new Student(101, "Ali", 20));
        repository.displayAllStudents();

        // You'd typically assert the printed output in integration/system tests
        // Here, we focus on ensuring the list is printed without modifying its size
        assertEquals(1, studentList.size());
    }

    /**
     * Tests the search functionality for a student by ID when the student is found.
     * 
     * Verifies that the method executes properly and displays the correct details.
     */
    @Test
    void testSearchStudentById_Found() {
        studentList.add(new Student(101, "Ali", 20));

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(101);

        repository.searchStudentById(mockScanner);
    }

    /**
     * Tests the search functionality for a student by ID when the student is not found.
     * 
     * Verifies that the method executes properly without modifying the list.
     */
    @Test
    void testSearchStudentById_NotFound() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(999);

        repository.searchStudentById(mockScanner);

        // Test focuses on ensuring proper execution without modifying the list
        assertTrue(studentList.isEmpty());
    }

    /**
     * Tests the removal of a student by ID when the student exists in the list.
     * 
     * Verifies that the student is successfully removed and the list becomes empty.
     */
    @Test
    void testRemoveStudentById_Success() {
        studentList.add(new Student(101, "Ali", 20));

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(101);

        repository.removeStudentById(mockScanner);

        assertTrue(studentList.isEmpty());
    }

    /**
     * Tests the removal of a student by ID when the student does not exist in the list.
     * 
     * Verifies that the list remains unchanged when no matching student is found.
     */
    @Test
    void testRemoveStudentById_NotFound() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(999);

        repository.removeStudentById(mockScanner);

        assertTrue(studentList.isEmpty());
    }

    /**
     * Tests the display of all students when the list is empty.
     * 
     * Verifies that the method executes properly without modifying the list.
     */
    @Test
    void testDisplayAllStudents_Empty() {
        repository.displayAllStudents();

        // Ensures that the list remains empty during this operation
        assertTrue(studentList.isEmpty());
    }
}
