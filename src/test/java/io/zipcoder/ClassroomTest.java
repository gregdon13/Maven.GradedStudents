package io.zipcoder;

import apple.laf.JRSUIUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

public class ClassroomTest {

    @Test
    public void averageScoreTest() {
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        //When
        double actual = classroom.getAverageExamScore();
        double expected = 125.0;

        //Then
        Assert.assertEquals((long) actual, (long) expected);
    }

    @Test
    public void addStudentTestTwo() {
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom();
        Double[] examScoresLeon = { 80.0, 150.0, 250.0, 0.0 };
        Double[] examScoresCarl = { 75.0, 100.0, 250.0, 60.0 };
        Student leon = new Student("Leon", "Hunter", examScoresLeon);
        Student carl = new Student("Carl", "Weathers", examScoresCarl);

        //When
        classroom.addStudent(carl);
        classroom.addStudent(leon);
        Student[] postEnroll = classroom.getStudents();

        //Then
        System.out.print(Arrays.toString(postEnroll));
    }

    @Test
    public void addStudentTest() {
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 80.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        //When
        classroom.addStudent(student);

        Student[] postEnroll = classroom.getStudents();

        //Then
        System.out.print(Arrays.toString(postEnroll));
    }

    @Test
    public void removeStudentTest() {
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 80.0, 150.0, 250.0, 0.0 };
        Double[] examScoresTwo = { 90.0, 110.0, 150.0, 30.0 };
        Student leon = new Student("Leon", "Hunter", examScores);
        Student carl = new Student("Carl", "Weathers", examScoresTwo);

        //When
        classroom.addStudent(carl);
        Student[] expected = classroom.getStudents();
        classroom.addStudent(leon);
        classroom.removeStudent("Carl", "Weathers");
        Student[] actual = classroom.getStudents();

        //Then
        //Assert.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));

    }

    @Test
    public void reorderStuTest() {
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 50.0, 50.0};
        Double[] examScoresTwo = { 90.0, 100.0};
        Double[] examScoresThree = {100.0, 100.0};
        Double[] examScoresFour = {25.0, 35.0};
        Student leon = new Student("Leon", "Hunter", examScores);
        Student carl = new Student("Carl", "Weathers", examScoresTwo);
        Student benny = new Student("Benny", "Sharpe", examScoresThree);
        Student jimmy = new Student ("Jimmy", "Carter", examScoresFour);

        //When
        classroom.addStudent(carl);
        classroom.addStudent(benny);
        classroom.addStudent(jimmy);
        classroom.addStudent(leon);
        Student[] newArr = classroom.stuByScore();


        //Then
        System.out.println(Arrays.toString(newArr));
    }

    @Test
    public void gradeBookTest() {
        //Given
        int maxNumberOfStudents = 5;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 80.0};
        Double[] examScoresTwo = { 90.0};
        Double[] examScoresThree = {100.0};
        Double[] examScoresFour = {65.0};
        Double[] examScoresFive = {50.0};
        Student leon = new Student("Leon", "Hunter", examScores);
        Student carl = new Student("Carl", "Weathers", examScoresTwo);
        Student benny = new Student("Benny", "Sharpe", examScoresThree);
        Student katie = new Student("Katie", "Donnelly", examScoresFour);
        Student greg = new Student("Greg", "Pratt", examScoresFive);

        //When
        classroom.addStudent(carl);
        classroom.addStudent(benny);
        classroom.addStudent(leon);
        classroom.addStudent(katie);
        classroom.addStudent(greg);

        //Then
        System.out.println(classroom.getGradeBook());
    }
}
