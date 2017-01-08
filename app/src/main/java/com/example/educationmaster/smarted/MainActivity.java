package com.example.educationmaster.smarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String STUDENT_DETAILS = "student-details/";
    private static final String ADMIN_DETAILS = "admin-details/";
    private static final String USER_TYPE_KEY = "userType";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    private static final int USER_STUDENT = 0;
    private static final int USER_ADMIN = 1;
    private Button mSignUpBtn;
    private Button mLoginBtn;
    private int selectedId;
    private RadioGroup mRadioGroup;
    private EditText mUsernameEt;
    private EditText mPasswordEt;

    private static final FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    private static DatabaseReference dbRef = mDB.getReferenceFromUrl("https://smarteddb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignUpBtn = (Button) findViewById(R.id.btnSignUp);
        mLoginBtn = (Button) findViewById(R.id.btnLogin);

        mUsernameEt = (EditText) findViewById(R.id.username_edittext);
        mPasswordEt = (EditText) findViewById(R.id.password_edittext);

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


        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("log call  is :", String.valueOf(selectedId));
                if (selectedId == 0) {
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra(USER_TYPE_KEY, USER_STUDENT));
                } else if (selectedId == 1) {
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra(USER_TYPE_KEY, USER_ADMIN));
                }
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listOfParams = new ArrayList<String>();
                listOfParams.add(USERNAME_KEY);
                listOfParams.add(PASSWORD_KEY);
                if (selectedId == 0) {
                    String usernameString = mUsernameEt.getText().toString();
                    String passwordString = mPasswordEt.getText().toString();
                    String location = STUDENT_DETAILS+usernameString;
                    new NetTask(location, listOfParams, 1, new AsyncPostExecute() {
                        @Override
                        public void OnPostExecuteMethod(ArrayList<Object> values) {
                            String usernameString = mUsernameEt.getText().toString();
                            String passwordString = mPasswordEt.getText().toString();
                            Log.d("VINIT", (String) values.get(0));
                            Log.d("VINIT", (String) values.get(1));
                        }
                    }).execute();
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra(USER_TYPE_KEY, USER_STUDENT));
                } else if (selectedId == 1) {
                    startActivity(new Intent(MainActivity.this, SignUpMainActivity.class).putExtra(USER_TYPE_KEY, USER_ADMIN));
                }
                //new NetTask2(STUDENT_DETAILS+"america", USERNAME_KEY).executeRead();
            }


        });

    }

    private boolean isLoginSuccessful(String testUsername, String testPassword, String actualUsername, String actualPassword) {


        return false;
    }
}

