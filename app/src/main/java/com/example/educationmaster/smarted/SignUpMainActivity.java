package com.example.educationmaster.smarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpMainActivity extends AppCompatActivity {
    private static final String USER_TYPE_KEY = "userType";

    private Button mSubmitStudentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up_student);
        Toast.makeText(getBaseContext(), "STUDENT SIGNUP", Toast.LENGTH_SHORT).show();
        mSubmitStudentBtn = (Button) findViewById(R.id.btnSubmitStudent);
        mSubmitStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpStudent();
            }
        });
    }



    private void signUpStudent() {
        Student newStudent = new Student(((EditText) findViewById(R.id.etNameStudent)).getText().toString(),
                ((EditText) findViewById(R.id.etStudentNoStudent)).getText().toString(),
                ((EditText) findViewById(R.id.etPasswordStudent)).getText().toString(),
                ((EditText) findViewById(R.id.etUsernameStudent)).getText().toString());

        //new NetTask(newStudent).executeAddNewStudent();

    }
}
