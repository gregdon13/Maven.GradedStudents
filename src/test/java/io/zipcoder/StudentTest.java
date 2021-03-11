package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void constructorTest() {

    }

    @Test
    public void getExamScoresTest() {
        //Given
        String firstName = "Darrow";
        String lastName = "Andromedus";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);

        //When
        String output = student.getExamScores();
        String expected = "Exam Scores:\n" + "Exam 1: 100.0\n" + "Exam 2: 95.0\n" + "Exam 3: 123.0\n" + "Exam 4: 96.0";

        //Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void addExamScoreTest() {
        //Given
        String firstName = "Darrow";
        String lastName = "Andromedus";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);

        //When
        String expected = "Exam Scores:\n" + "Exam 1: 100.0\n" + "Exam 2: 95.0";
        student.addExamScore(95.0);
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeExamScoreTest() {
        //Given
        String firstName = "Darrow";
        String lastName = "Andromedus";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);

        //When
        student.changeExamScore(1, 95.0);
        String expected = "Exam Scores:\n" + "Exam 1: 95.0";
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);
    }
}