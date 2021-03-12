package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        ArrayList<Student> stuList = new ArrayList<>(Arrays.asList(students));
        //List<Student> stuList = Arrays.asList(students);
        //Collections.addAll(stuList, students);
        stuList.add(student);
        Integer newLength = students.length + 1;
        students = stuList.toArray(stuList.toArray(new Student[newLength]));
    }

    public void removeStudent(String firstName, String lastName) {
        //int length = students.length;
        //ArrayList<Student> stuList = new ArrayList<>();
        //Student student = new Student(firstName, lastName);
        Student[] stuArrPH = getStudents();
        for (int i = 0; i < stuArrPH.length; i++) {
            if (stuArrPH[i].getFirstName().equals(firstName) && stuArrPH[i].getLastName().equals(lastName)) {
                stuArrPH[i] = null;
            }
        }
        for (int j= 0; j < stuArrPH.length - 1; j++) {
            if (stuArrPH[j] == null) {
                stuArrPH[j] = stuArrPH[j+1];
                stuArrPH[j+1] = null;
            }
        }
        students = stuArrPH;
    }

    public Student[] stuByScore() {
        //double counter = 0.0;
        Student[] stuArrPh = getStudents();
        //Student[] outArr = new Student[stuArrPh.length];

        for (int i = 0; i < stuArrPh.length - 1; i++) {
            for (int j = 0; j < stuArrPh.length -1; j++) {
                if (stuArrPh[i].getAverageExamScore() > stuArrPh[j + 1].getAverageExamScore()) {
                    Student tempStu = stuArrPh[j + 1];
                    stuArrPh[j + 1] = stuArrPh[i];
                    stuArrPh[i] = tempStu;
                }
            }
        }
        return stuArrPh;

    }
}
