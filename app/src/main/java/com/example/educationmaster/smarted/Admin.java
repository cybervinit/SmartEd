package com.example.educationmaster.smarted;

import java.util.ArrayList;

/**
 * Created by Vinit on 2017-01-07.
 */

public class Admin {


    private String name;
    private String password;
    private String username;

    private ArrayList<Course> courseList;

    public Admin(String name, String password, String username) {
        this.name = name;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }
}
