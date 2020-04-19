package com.example.innoapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.innoapp.R;
import com.example.innoapp.activities.EventsActivity;
import com.example.innoapp.adapter.MainStepperAdapter;
import com.liefery.android.vertical_stepper_view.VerticalStepperView;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import static com.example.innoapp.activities.EventsActivity.eList;
import static com.example.innoapp.activities.EventsActivity.tabDates;

public class FragmentTabEvents extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private Context context = null;
    public static LinkedList<String> tabs;

    public static FragmentTabEvents newInstance(int page, LinkedList<String> tabs2) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentTabEvents fragment = new FragmentTabEvents();
        fragment.setArguments(args);
        tabs = tabs2;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinkedList<String> eventsInList1 = new LinkedList<String>();
        LinkedList<String> datesInList1 = new LinkedList<String>();
        LinkedList<Long> times = new LinkedList<Long>();
        String d1;
        String d2;
        String t1;
        String t2;
        SimpleDateFormat formatForDateNow1 = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat formatForDateNow2 = new SimpleDateFormat("mm");
        Collections.sort(eList);
        for (int i = 0; i < eList.size(); i++) {
            d1 = formatForDateNow1.format(tabDates.get(mPage - 1));
            d2 = formatForDateNow1.format(eList.get(i).date);
            t1 = formatForDateNow2.format(eList.get(i).date);
            t2 = formatForDateNow2.format(eList.get(i).dateEnd);
            if (d1.equals(d2)) {
                eventsInList1.add(eList.get(i).name);
                datesInList1.add(Integer.toString(eList.get(i).date.getHours()) + ":" + t1 + " - " + Integer.toString(eList.get(i).dateEnd.getHours()) + ":" + t2);
                times.add(eList.get(i).dateEnd.getTime());
            }
        }
        View view1 = inflater.inflate(R.layout.fragment_tab_events, container, false);
        VerticalStepperView eventsList1 = (VerticalStepperView) view1;
        Date nowTime = new Date(2020, 1, 12, 15, 40);
        eventsList1.setStepperAdapter(new MainStepperAdapter(context, datesInList1, eventsInList1, mPage - 1, times, nowTime));
        return view1;
    }

}