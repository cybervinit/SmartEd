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
    private static final int USER_STUDENT = 0;
    private static final int USER_ADMIN = 1;

    private Button mSubmitStudentBtn;
    private Button mSubmitAdminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();

        int userType = (int) extras.get(USER_TYPE_KEY);
        if (userType == USER_STUDENT) {
            setContentView(R.layout.activity_sign_up_student);
            Toast.makeText(getBaseContext(), "STUDENT SIGNUP", Toast.LENGTH_SHORT).show();
            mSubmitStudentBtn = (Button) findViewById(R.id.btnSubmitStudent);
            mSubmitStudentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signUpStudent();
                }
            });

        } else if (userType == USER_ADMIN) {
            setContentView(R.layout.activity_sign_up_admin);
            Toast.makeText(getBaseContext(), "ADMIN SIGNUP", Toast.LENGTH_SHORT).show();
            mSubmitAdminBtn = (Button) findViewById(R.id.btnSubmitAdmin);
            mSubmitAdminBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signUpAdmin();
                }
            });
        }
    }



    private void signUpStudent() {
        Student newStudent = new Student(((EditText) findViewById(R.id.etNameStudent)).getText().toString(),
                ((EditText) findViewById(R.id.etStudentNoStudent)).getText().toString(),
                ((EditText) findViewById(R.id.etPasswordStudent)).getText().toString(),
                ((EditText) findViewById(R.id.etUsernameStudent)).getText().toString());

        //new NetTask(newStudent).executeAddNewStudent();

    }

    private void signUpAdmin() {
        Admin newAdmin = new Admin(((EditText) findViewById(R.id.etNameAdmin)).getText().toString(),
                ((EditText) findViewById(R.id.etPasswordAdmin)).getText().toString(),
                ((EditText) findViewById(R.id.etUsernameAdmin)).getText().toString());
        //Log.d("STUDENT INFO:", newStudent.getName());
        //new NetTask(newAdmin).executeAdmin();
    }
}
