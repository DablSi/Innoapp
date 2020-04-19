package com.example.innoapp.adapter;

import android.content.Context;
import android.icu.util.LocaleData;
import android.view.View;

import com.example.innoapp.fragments.Event;
import com.example.innoapp.fragments.MainItemView;
import com.liefery.android.vertical_stepper_view.VerticalStepperAdapter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
public class MainStepperAdapter extends VerticalStepperAdapter {
    LinkedList<String> dataArray;
    LinkedList<String> eventsArray;
    LinkedList<Long> times;
    Long nowTime;
    int count;
    int tabId;
    //Long q = Long.valueOf(78444444);
    public MainStepperAdapter(Context context, LinkedList<String> array1, LinkedList<String> array2, int newTabId,LinkedList<Long> times2, Date nowTime2 ) {
        super( context );
        dataArray = array1;
        count = array1.size();
        eventsArray = array2;
        tabId = newTabId;
        times = times2;
        nowTime =  System.currentTimeMillis();

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

        for(int i = 0; i < times.size(); i++)
        {

            if (nowTime >= times.get(i))
            {
                jumpTo(i + 1);
            }
        }

        return content;
    }
}