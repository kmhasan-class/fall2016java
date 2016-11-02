/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.example;

/**
 *
 * @author kmhasan
 */
public class Student implements Comparable {
    private String studentId;
    private String studentName;
    private double cgpa;

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
    
    public void print() {
        System.out.println(studentId + " " + studentName + " " + cgpa);
    }

    @Override
    public int compareTo(Object o) {
        Student a = this;
        Student b = (Student) o;
        // -ve if a < b
        // +ve if a > b
        // ==0 if a == b
        
        if (a.cgpa < b.cgpa)
            return +1;
        else if (a.cgpa > b.cgpa)
            return -1;
        else return 0;
    }
}
