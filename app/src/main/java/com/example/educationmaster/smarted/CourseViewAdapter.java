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

public class CourseViewAdapter extends ArrayAdapter<Course> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Course> mData;

    public CourseViewAdapter(Context context, ArrayList<Course> items) {
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
    public Course getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            View elementView = mInflater.inflate(R.layout.student_course_card_layout, parent, false);
            TextView courseName = (TextView) elementView.findViewById(R.id.course_name_textview);
            TextView courseId = (TextView) elementView.findViewById(R.id.course_id_textview);
            courseName.setText(mData.get(position).getCourseName());
            courseId.setText(mData.get(position).getCourseID());
            return elementView;
        }


        return view;
    }
}
