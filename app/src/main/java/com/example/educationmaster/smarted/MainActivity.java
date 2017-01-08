package com.example.educationmaster.smarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgMain);
        RadioButton rbAdmin = (RadioButton) findViewById(R.id.rbAdmin);
        RadioButton rbStudent = (RadioButton) findViewById(R.id.rbStudent);

        final int selectedId = radioGroup.getCheckedRadioButtonId();


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
                if (selectedId == 0) {
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra("userType", selectedId));
                }
                else {
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra("userType", 1));
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
