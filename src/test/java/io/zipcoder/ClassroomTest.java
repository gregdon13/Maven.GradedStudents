package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
    public void addStudentTest() {
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 80.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        //When
        Student[] preEnroll = classroom.getStudents();
        System.out.print(Arrays.toString(preEnroll) + "\n");
        classroom.addStudent(student);

        Student[] postEnroll = classroom.getStudents();

        //Then
        System.out.print(Arrays.toString(postEnroll));
    }

}
