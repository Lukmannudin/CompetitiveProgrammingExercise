package leetcode;

import java.util.Scanner;

/*
 * Create the Student class.
 */

class Student {
    private String studentName;
    private Student student;
    private int count;

    Student() {

    }

    Student(String name) {
        Student student = getInstance();
        student.setStudentName(name);
        student.increment();
    }

    private void increment() {
        this.count++;
    }

    private void setStudentName(String name){
        this.studentName = name;
    }

    public Student getInstance() {
        if (this.student == null)
            student = new Student();

        return student;
    }

    @Override
    public String toString() {
        return "student " + count + " name = '" + this.studentName + "'";
    }
}

public class Exercise {


    private static final Scanner INPUT_READER = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfStudents = Integer.parseInt(INPUT_READER.nextLine());

        while (numberOfStudents-- > 0) {
            String studentName = INPUT_READER.nextLine();
            Student student = new Student(studentName);

            System.out.println(student);
        }
    }
}