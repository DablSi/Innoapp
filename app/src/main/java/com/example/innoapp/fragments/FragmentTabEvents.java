package com.example.innoapp.fragments;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innoapp.R;
import com.example.innoapp.activities.Events;
import com.example.innoapp.adapter.DataAdapter;
import com.example.innoapp.adapter.DataAdapterEvents;

import java.util.LinkedList;

import static com.example.innoapp.activities.Events.datesInList1;
import static com.example.innoapp.activities.Events.eList;
import static com.example.innoapp.activities.Events.eventsInList1;

public class FragmentTabEvents extends Fragment {
    public static LinkedList<Events.EventList1> eList2;
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private static String[] datesList;
    private static String[] eventList;
    private static Event[] classEventList;
    private Context context = null;
    private DataAdapterEvents adapter;

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
            RecyclerView eventsList1 = (RecyclerView) view1;
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(context);
            eventsList1.setLayoutManager(layoutManager1);
            adapter = new DataAdapterEvents(datesInList1[mPage-1], eventsInList1[mPage-1], mPage, context);
            eventsList1.setAdapter(adapter);
            return view1;
    }
}