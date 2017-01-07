package com.example.educationmaster.smarted;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Vinit on 2017-01-07.
 */

public class CourseViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Course> mData;

    public CourseViewAdapter(Context context, ArrayList<Course> items) {
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View elementView = mInflater.inflate(R.layout.student_course_card_layout, viewGroup, false);
            return elementView;
        }


        return view;
    }
}
