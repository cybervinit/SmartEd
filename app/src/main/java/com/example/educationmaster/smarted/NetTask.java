package com.example.educationmaster.smarted;



import android.os.AsyncTask;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Vinit on 2017-01-07.
 */

public class NetTask extends AsyncTask<ArrayList<Object>, ArrayList<Object>, ArrayList<Object>>{

    Student mStudent;
    Admin mAdmin;
    private static final FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    private static DatabaseReference dbRef = mDB.getReferenceFromUrl("https://smarteddb.firebaseio.com/");
    private ArrayList<Object> values;
    private ArrayList<String> listOfEndpaths;
    private String location;
    private AsyncPostExecute postNetTask;
    private int taskType;




    public NetTask (String location, ArrayList<String> listOfEndpaths, int taskType, AsyncPostExecute postNetTask) {
        this.postNetTask = postNetTask;
        this.taskType = taskType;
        this.listOfEndpaths = listOfEndpaths;
        this.location = location;
        values = new ArrayList<>();
    }

    @Override
    protected ArrayList<Object> doInBackground(ArrayList<Object>[] objects) {

        if (taskType == 0) { // write

        } else if (taskType == 1) { // read
            for (int i = 0; i < listOfEndpaths.size(); i++) {
                //Log.d("VINIT", "BEFORE READ");
                //read(location, listOfEndpaths.get(i));
                //Log.d("VINIT", "AFTER READ");
                values.add(new NetTask2(location, listOfEndpaths.get(i)).executeRead());
            }
        }

        return values;
    }

    public void executeAddNewStudent() {
        dbRef.child("student-details").child(mStudent.getUsername()).setValue(mStudent);

    }



    public void read(String location, final String endPath) {
        Query myStudent = dbRef.child(location).child(endPath);
        Log.d("VINIT", "FCT CALLED");
        myStudent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    Log.d("VINIT", "DURING DATA CHANGE READ");
                    values.add((String) dataSnapshot.child(endPath).getValue());
                    Log.d("VINITVINITVINIT", endPath);
                } catch (Exception e) {
                    Log.d("VINIT EXCEPTION", e.getMessage());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onPostExecute(ArrayList<Object> values) {
        super.onPostExecute(values);
        postNetTask.OnPostExecuteMethod(values);
    }








    /*public NetTask (Student student, int taskType, AsyncPostExecute postNetTask) {
        this.mStudent = student;
        this.postNetTask = postNetTask;
        this.taskType = taskType;

    }

    public NetTask (Admin admin, int taskType, AsyncPostExecute postNetTask) {
        this.mAdmin = admin;
        this.postNetTask = postNetTask;
        this.taskType = taskType;
    }*/
    /*public void executeAdmin() {
        dbRef.child("admin-details").push().setValue(mAdmin);
    }*/
}
