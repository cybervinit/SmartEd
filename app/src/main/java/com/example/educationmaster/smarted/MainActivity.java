package com.example.educationmaster.smarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private static final String USER_TYPE_KEY = "userType";
    private static final String USERNAME_KEY = "username";
    private static final int USER_STUDENT = 0;
    private static final int USER_ADMIN = 1;

    private Button mSignUpBtn;
    private Button mLoginBtn;
    private int selectedId;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignUpBtn = (Button) findViewById(R.id.btnSignUp);
        mLoginBtn = (Button) findViewById(R.id.btnLogin);

        mRadioGroup = (RadioGroup) findViewById(R.id.rgMain);
        RadioButton rbAdmin = (RadioButton) findViewById(R.id.rbAdmin);
        rbAdmin.setId(R.id.rbAdmin);
        RadioButton rbStudent = (RadioButton) findViewById(R.id.rbStudent);
        rbStudent.setId(R.id.rbStudent);


        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rbAdmin) {
                    selectedId = 1;
                } else if (checkedId == R.id.rbStudent) {
                    selectedId = 0;
                }
            }
        });


        /*


        mUserToggleBtn.setTextOff("Student");
        mUserToggleBtn.setTextOn("Admin");

        mUserToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    userType = 1;
                } else {
                    userType = 0;
                }
            }
        });*/

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("log call  is :", String.valueOf(selectedId));
                if (selectedId == 0) {
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra(USER_TYPE_KEY, USER_STUDENT));
                }
                else if (selectedId == 1){
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra(USER_TYPE_KEY, USER_ADMIN));
                }
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START THE LOGIN  PROCESS
                startActivity(new Intent(MainActivity.this, StudentDashboard.class).putExtra(USERNAME_KEY, "dham"));
            }
        });


    }


}
