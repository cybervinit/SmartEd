package com.example.educationmaster.smarted;



import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
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
        dbRef.child("student-details").push().setValue(mStudent);

    }

    public void executeAdmin() {
        dbRef.child("admin-details").push().setValue(mAdmin);
    }

    public void readStudent() {
        dbRef.child("student-details").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*GenericTypeIndicator<List<Object>> t = new GenericTypeIndicator<List<Object>>(){};
                List<Object> studentListRetrieved = dataSnapshot.getValue(t);*/
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.d("TEST", child.getValue().toString());
                    child.getValue();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //Query myStudent = dbRef.child("student-details").child()
    }
}
