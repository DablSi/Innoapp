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

import java.util.LinkedList;
import static com.example.innoapp.activities.EventsActivity.datesInList1;
import static com.example.innoapp.activities.EventsActivity.eventsInList1;

public class FragmentTabEvents extends Fragment {
    public static LinkedList<EventsActivity.EventList1> eList2;
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private Context context = null;


    public static FragmentTabEvents newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentTabEvents fragment = new FragmentTabEvents();
        fragment.setArguments(args);
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
            View view1 = inflater.inflate(R.layout.fragment_tab_events, container, false);
            VerticalStepperView eventsList1 = (VerticalStepperView) view1;
            eventsList1.setStepperAdapter( new MainStepperAdapter( context, datesInList1[mPage - 1],
                    eventsInList1[mPage - 1], mPage-1));
            return view1;
    }


}