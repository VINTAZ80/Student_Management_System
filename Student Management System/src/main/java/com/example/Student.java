package com.example;

class Student {
    private int studentId;
    private String studentName;
    private int studentAge;

    // Constructor to initialize a student
    public Student(int studentId, String studentName, int studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    // Getter for studentId
    public int getStudentId() {
        return studentId;
    }

    // Setter for studentId
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter for studentName
    public String getStudentName() {
        return studentName;
    }

    // Setter for studentName
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Getter for studentAge
    public int getStudentAge() {
        return studentAge;
    }

    // Setter for studentAge
    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}
