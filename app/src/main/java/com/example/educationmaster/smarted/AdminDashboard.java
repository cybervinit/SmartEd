package com.example.educationmaster.smarted;

/**
 * Created by Vishwa on 1/8/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AdminDashboard extends AppCompatActivity {
    private static final String USERNAME_KEY = "username";
    private String prof_username;
    private ListView mProfCourseslist;
    private ArrayList<String> courseIdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        prof_username = (String) getIntent().getExtras().get(USERNAME_KEY);
        mProfCourseslist = (ListView) findViewById(R.id.prof_dashboard_listview);
        courseIdList = new ArrayList<>();

        // <<<FIREBASE CALL>>> --> Get student object.

        // Replace all course IDs in the courseIdList with the actual!
        for (int i = 0; i < 20; i++) {
            courseIdList.add("Course" + i);
        }

        CourseViewAdapter courseAdapter = new CourseViewAdapter(this, courseIdList);

        mProfCourseslist.setAdapter(courseAdapter);


    }
}


