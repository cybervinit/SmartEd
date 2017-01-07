package com.example.educationmaster.smarted;

import java.util.ArrayList;

/**
 * Created by Vinit on 2017-01-07.
 */

public class Student {
    private String name;
    private ArrayList<Course> courseList;
    private int studentID;
    private String password;
    private String username;

    public Student (String name, int studentID, String password, String username) {
        this.name = name;
        this.studentID = studentID;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public int getStudentID() {
        return studentID;
    }
}
