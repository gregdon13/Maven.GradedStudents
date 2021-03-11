package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
    String firstName = "";
    String lastName = "";
    ArrayList<Double> examScores;

    public Student() {

    }

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        List<Double> examList = new ArrayList<>();
        Collections.addAll(examList, testScores);
        this.examScores = (ArrayList<Double>) examList;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String  getLastName() {
        return this.lastName;
    }

    public String getExamScores() {
        String output = "Exam Scores:\n";
        Double[] examArrDbl = examScores.toArray(new Double[examScores.size()]);
        String[] examStrArr = new String[examArrDbl.length];
        for (int i = 0; i <= examStrArr.length - 1; i++) {
            examStrArr[i] = examArrDbl[i].toString();
            if (i == examArrDbl.length - 1) {
                output += ("Exam " + (i+1) + ": " + examStrArr[i]);
            } else {
                output += ("Exam " + (i + 1) + ": " + examStrArr[i] + "\n");
            }
        }
        //output += ("Exam " + (examStrArr.length) + ": " + examStrArr[examStrArr.length-1]);
//        System.out.println(output);
        return output;
    }

    public void addExamScore (double examScore) {
        examScores.add(examScore);
    }

    public void changeExamScore(int examNumber, double newScore) {
        examScores.set(examNumber -1, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        int arrSize = examScores.size();
        Double[] examArrDbl = examScores.toArray(new Double[arrSize]);
        for (double d : examArrDbl) {
            sum += d;
        }
        double average = sum / examArrDbl.length;
        return average;
    }

    public String toString() {
        String output = "Student Name: " + firstName + " " + lastName + "\n"
                + "> Average Score: " + getAverageExamScore() + "\n"
                + "> " + getExamScores();
        return output;
    }

    public void setExamScores(Double[] examScores) {
        this.examScores = (ArrayList<Double>) Arrays.asList(examScores);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }
}
