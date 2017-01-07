package com.example.educationmaster.smarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SignUpMainActivity extends AppCompatActivity {
    private static final String USER_TYPE_KEY = "userType";
    private static final int USER_STUDENT = 0;
    private static final int USER_PROFESSOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();

        int userType = (int) extras.get(USER_TYPE_KEY);
        if (userType == USER_STUDENT) {
            setContentView(R.layout.activity_sign_up_student);
            Toast.makeText(getBaseContext(), "PROF SIGNUP", Toast.LENGTH_SHORT).show();
        } else if (userType == USER_PROFESSOR) {
            setContentView(R.layout.activity_sign_up_admin);
            Toast.makeText(getBaseContext(), "STUDENT SIGNUP", Toast.LENGTH_SHORT).show();
        }


    }
}
