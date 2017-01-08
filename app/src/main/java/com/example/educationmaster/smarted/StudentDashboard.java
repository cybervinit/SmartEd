package com.example.educationmaster.smarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentDashboard extends AppCompatActivity {
    private static final String USERNAME_KEY = "username";
    private String student_username;

    private ListView mStudentCoursesListView;
    private ArrayList<String> courseIdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        student_username = (String) getIntent().getExtras().get(USERNAME_KEY);
        mStudentCoursesListView = (ListView) findViewById(R.id.student_dashboard_listview);
        courseIdList = new ArrayList<>();

        // <<<FIREBASE CALL>>> --> Get student object.

        // Replace all course IDs in the courseIdList with the actual!
        for (int i = 0; i < 20; i++) {
            courseIdList.add("Course"+i);
        }

        CourseViewAdapter courseAdapter = new CourseViewAdapter(this, courseIdList);

        mStudentCoursesListView.setAdapter(courseAdapter);





    }
}
