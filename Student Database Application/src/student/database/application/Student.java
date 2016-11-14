/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.database.application;

/**
 *
 * @author kmhasan
 */
public class Student {
    private String studentId;
    private String studentName;
    private double cgpa;

    public Student() {
    }

    public Student(String studentId, String studentName, double cgpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.cgpa = cgpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getCgpa() {
        return cgpa;
    }
    
    @Override
    public String toString() {
        return studentId + " - " + studentName;
    }
}
