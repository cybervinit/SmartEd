package com.example.educationmaster.smarted;



import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinit on 2017-01-07.
 */

public class NetTask {

    Student mStudent;
    Admin mAdmin;
    private static final FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    private static DatabaseReference dbRef = mDB.getReferenceFromUrl("https://smarteddb.firebaseio.com/");


    public NetTask (Student student) {
        this.mStudent = student;

    }

    public NetTask (Admin admin) {
        this.mAdmin = admin;
    }

    public NetTask () {

    }

    public void executeAddNewStudent() {
        dbRef.child("student-details").child(mStudent.getUsername()).setValue(mStudent);

    }

    public void executeAdmin() {
        dbRef.child("admin-details").push().setValue(mAdmin);
    }

    public void readStudent(String username1) {
        Query myStudent = dbRef.equalTo("student-details/"+username1);
        //myStudent.getRef().eq

        myStudent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Student s = dataSnapshot.getValue(Student.class);
                Log.d("VINIT", s.getPassword());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
