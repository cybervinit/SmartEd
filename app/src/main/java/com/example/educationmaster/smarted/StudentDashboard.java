package com.example.educationmaster.smarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentDashboard extends AppCompatActivity {
    private static final String USERNAME_KEY = "username";
    private String student_username;

    private ListView mStudentCoursesListView;
    private ArrayList<String> courseIdList;
    private MarkViewAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        mStudentCoursesListView = (ListView) findViewById(R.id.student_dashboard_listview);
        courseIdList = new ArrayList<>();

        // <<<FIREBASE CALL>>> --> Get student object.

        // Replace all course IDs in the courseIdList with the actual!
        for (int i = 0; i < 20; i++) {
            courseIdList.add("Course "+i);
        }

        courseAdapter = new MarkViewAdapter(this, courseIdList);

        mStudentCoursesListView.setAdapter(courseAdapter);

        mStudentCoursesListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Start the course viewing activity where the user is allowed to see his
                // current course status and information.
                // You'll probably need to give the course id or something to id the course for
                // Firebase.
            }
        });

        courseIdList.add("ADDED ITEM");
        courseAdapter.notifyDataSetChanged();





    }
}
