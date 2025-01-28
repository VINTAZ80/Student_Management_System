/**
 * @file Student.java
 * @brief Represents a Student with ID, name, and age.
 * 
 * This class provides the structure for storing and managing student details 
 * including student ID, name, and age. It includes constructors, getters, 
 * and setters for its attributes.
 */

package com.example;

/**
 * @class Student
 * @brief Represents a student entity.
 * 
 * The Student class provides attributes to store the ID, name, and age of a student. 
 * It also provides methods to get and set these attributes.
 */
class Student {
    private int studentId;      /**< Unique ID of the student. */
    private String studentName; /**< Name of the student. */
    private int studentAge;     /**< Age of the student. */

    /**
     * @brief Constructor to initialize a student.
     * 
     * @param studentId The unique ID of the student.
     * @param studentName The name of the student.
     * @param studentAge The age of the student.
     */
    public Student(int studentId, String studentName, int studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    /**
     * @brief Getter for studentId.
     * 
     * @return The unique ID of the student.
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @brief Setter for studentId.
     * 
     * @param studentId The unique ID to set for the student.
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * @brief Getter for studentName.
     * 
     * @return The name of the student.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @brief Setter for studentName.
     * 
     * @param studentName The name to set for the student.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @brief Getter for studentAge.
     * 
     * @return The age of the student.
     */
    public int getStudentAge() {
        return studentAge;
    }

    /**
     * @brief Setter for studentAge.
     * 
     * @param studentAge The age to set for the student.
     */
    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}