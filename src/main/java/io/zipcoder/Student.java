package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
    String firstName = "";
    String lastName = "";
    ArrayList<Double> examScores;

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
        System.out.println(output);
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
