package com.example.educationmaster.smarted;

import java.util.ArrayList;

/**
 * Created by Vinit on 2017-01-07.
 */

public class Admin {
    private String name;

    private ArrayList<Course> courseList;

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }
}
