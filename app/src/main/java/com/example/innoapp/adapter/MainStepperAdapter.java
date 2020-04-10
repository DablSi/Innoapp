package com.example.innoapp.adapter;

import android.content.Context;
import android.view.View;

import com.example.innoapp.fragments.MainItemView;
import com.liefery.android.vertical_stepper_view.VerticalStepperAdapter;

public class MainStepperAdapter extends VerticalStepperAdapter {
    String [] dataArray;
    public String [] eventsArray;
    int count;
    int tabId;
    public MainStepperAdapter( Context context, String [] array1, String [] array2, int newTabId ) {
        super( context );
        dataArray = array1;
        count = array1.length;
        eventsArray = array2;
        tabId = newTabId;
    }

    @Override
    public CharSequence getTitle( int position ) {
        return "";
    }

    @Override
    public CharSequence getSummary( int position ) {

        return "";
    }

    @Override
    public boolean isEditable( int position ) {
        return position == 1;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Void getItem( int position ) {
        return null;
    }
    @Override
    public View onCreateContentView( Context context, int position ) {
        View content = new MainItemView(context, dataArray, eventsArray, position, tabId);
        return content;
    }
}