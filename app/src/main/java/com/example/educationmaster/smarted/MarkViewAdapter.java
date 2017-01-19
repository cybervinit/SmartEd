package com.example.educationmaster.smarted;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Vinit on 2017-01-07.
 */

public class MarkViewAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mData;

    public MarkViewAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.student_course_card_layout, items);
        mContext = context;
        mData = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View currentView = view;
        if (currentView == null) {
            currentView = mInflater.inflate(R.layout.student_course_card_layout, null);
        }
        TextView courseName = (TextView) currentView.findViewById(R.id.course_name_textview);
        TextView courseId = (TextView) currentView.findViewById(R.id.course_id_textview);
        courseId.setText(mData.get(position)+" --> index");

        // Make call to Firebase using courseID and username
        // <<<FIREBASE CALL>>>

        //courseName.setText(mData.get(position).getCourseName());
        //courseId.setText(mData.get(position).getCourseID());
        return currentView;
    }
}
