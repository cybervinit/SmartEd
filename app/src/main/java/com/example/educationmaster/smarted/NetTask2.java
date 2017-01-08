package com.example.educationmaster.smarted;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Vinit on 2017-01-08.
 */

public class NetTask2{

    private static final FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    private static DatabaseReference dbRef = mDB.getReferenceFromUrl("https://smarteddb.firebaseio.com/");
    private String location;
    private String endpath;
    private String value;


    public NetTask2 (String location, String endpath) {
        this.location = location;
        this.endpath = endpath;
        value = "";
    }

    public String executeRead () {
        Query myQ = dbRef.child(location);

        myQ.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("VINIT", (String) dataSnapshot.child(endpath).getValue());
                value = (String) dataSnapshot.child(endpath).getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return value;
    }
}
