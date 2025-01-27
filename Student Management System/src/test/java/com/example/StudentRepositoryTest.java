package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class StudentRepositoryTest {

    private ArrayList<Student> studentList;
    private StudentRepository repository;

    @BeforeEach
    void setUp() {
        studentList = new ArrayList<>();
        repository = new StudentRepository(studentList);
    }

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

    @Test
    void testAddNewStudent_DuplicateId() {
        studentList.add(new Student(101, "Ali", 20));

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(101);
        when(mockScanner.nextLine()).thenReturn("", "Ali");

        repository.addNewStudent(mockScanner);

        assertEquals(1, studentList.size());
    }

    @Test
    void testDisplayAllStudents_NonEmpty() {
        studentList.add(new Student(101, "Ali", 20));
        repository.displayAllStudents();

        // You'd typically assert the printed output in integration/system tests
        // Here, we focus on ensuring the list is printed without modifying its size
        assertEquals(1, studentList.size());
    }

    @Test
    void testSearchStudentById_Found() {
        studentList.add(new Student(101, "Ali", 20));

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(101);

        repository.searchStudentById(mockScanner);
    }

    @Test
    void testSearchStudentById_NotFound() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(999);

        repository.searchStudentById(mockScanner);

        // Test focuses on ensuring proper execution without modifying the list
        assertTrue(studentList.isEmpty());
    }

    @Test
    void testRemoveStudentById_Success() {
        studentList.add(new Student(101, "Ali", 20));

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(101);

        repository.removeStudentById(mockScanner);

        assertTrue(studentList.isEmpty());
    }

    @Test
    void testRemoveStudentById_NotFound() {
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextInt()).thenReturn(999);

        repository.removeStudentById(mockScanner);

        assertTrue(studentList.isEmpty());
    }

    @Test
    void testDisplayAllStudents_Empty() {
        repository.displayAllStudents();

        // Ensures that the list remains empty during this operation
        assertTrue(studentList.isEmpty());
    }
}
