package com.example.educationmaster.smarted;

/**
 * Created by Vinit on 2017-01-07.
 */
public class Course {
    private String courseID;
    private String courseName;
    private int numberOfStudents;

    public Course (String courseID, String courseName){
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}
