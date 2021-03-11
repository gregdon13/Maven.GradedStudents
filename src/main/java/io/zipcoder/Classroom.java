package io.zipcoder;

import java.lang.reflect.Array;

public class Classroom {
    Student[] students;

    public Classroom (int maxNumberOfStudents) {

    }

    public Classroom(Student[] students) {

    }

    public Classroom () {
        Student[] students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    //PH return
    public double getAverageExamScore() {
        //Student studentPH = new Student();
        double sumOfAverages = 0.0;
        for (int i = 0; i < students.length; i++) {

        }
        return 5.0;
    }
}
