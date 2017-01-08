package com.example.educationmaster.smarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private static final String USER_TYPE_KEY = "userType";
    private static final String USERNAME_KEY = "username";
    private int userType;

    private Button mSignUpBtn;
    private Button mLoginBtn;
    private ToggleButton mUserToggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignUpBtn = (Button) findViewById(R.id.btnSignUp);
        mLoginBtn = (Button) findViewById(R.id.btnLogin);
        mUserToggleBtn = (ToggleButton) findViewById(R.id.toggleUserType);
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
        });

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra("userType", userType));
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
