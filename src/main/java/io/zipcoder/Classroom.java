package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Classroom {
    Student[] students = new Student[0];
    Student ph = new Student();

    public Classroom (int maxNumberOfStudents) {

    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom () {
        Student[] students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }


    public double getAverageExamScore() {
        double sumTotal = 0;
        Student[] allTheChildren = getStudents();
        for (int i = 0; i < allTheChildren.length; i++) {
            sumTotal += allTheChildren[i].getAverageExamScore();
        }
        return sumTotal / allTheChildren.length;
    }

    public void addStudent (Student student) {
        int length = students.length + 1;
        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(student);
        students = stuList.toArray(new Student[length]);
    }
}
