package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

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
            for (int j = i+1; j < stuArrPh.length; j++) {
                if (stuArrPh[i].getAverageExamScore() > stuArrPh[j].getAverageExamScore()) {
                    Student tempStu = stuArrPh[j];
                    stuArrPh[j] = stuArrPh[i];
                    stuArrPh[i] = tempStu;
                }
            }
        }
        return stuArrPh;
    }

    public HashMap<Student, Character> getGradeBook() {
        Student[] lowToHigh = stuByScore();
        //System.out.println(Arrays.toString(lowToHigh));
        HashMap<Student, Character> gradeBook = new HashMap<Student, Character>();
        for (int i = 0; i < lowToHigh.length; i++) {
            double percentile = ((i+1) * 100.0) / lowToHigh.length;
            System.out.println(percentile);
            System.out.println(lowToHigh[i]);
            if (percentile > 89.0) {
                gradeBook.put(lowToHigh[i], 'A');
            } else if (percentile > 51.0 && percentile <= 89.0) {
                gradeBook.put(lowToHigh[i], 'B');
            } else if (percentile > 30.0 && percentile <= 51.0) {
                gradeBook.put(lowToHigh[i], 'C');
            } else if (percentile > 11.0 && percentile <= 30.0) {
                gradeBook.put(lowToHigh[i], 'D');
            } else if (percentile <= 11) {
                gradeBook.put(lowToHigh[i], 'F');
            }
        }
        return gradeBook;
    }
}
