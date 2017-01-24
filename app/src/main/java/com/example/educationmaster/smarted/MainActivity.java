package com.example.educationmaster.smarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {
    private static final String STUDENT_DETAILS = "student-details/";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    private Button mSignUpBtn;
    private Button mLoginBtn;
    private EditText mUsernameEt;
    private EditText mPasswordEt;
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://smarteddb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private Api api = retrofit.create(Api.class);




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



        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MainActivity.this, SignUpMainActivity.class));
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Login Authentication HERE <><><><><>
                //startActivity(new Intent(MainActivity.this, StudentDashboard.class));

            }


        });

    }

}

