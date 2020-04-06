package com.example.innoapp.activities;

import com.example.innoapp.adapter.TabsAdapterForEvents;
import com.example.innoapp.adapter.TabsPagerFragmentAdapters;
import com.example.innoapp.fragments.Event;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.innoapp.R;
import com.example.innoapp.fragments.RVAdapter;
import com.google.android.material.tabs.TabLayout;

import java.security.acl.Group;
import java.util.Date;
import java.util.LinkedList;

public class Events extends AppCompatActivity {

    // Экземпляр списка RecyclerView
    private RecyclerView recyclerView;
    // Обработчик списка
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    // List of events
    private Event[] dataEvents;
    private String[] dates = {"01.01","01.02","01.03","01.04","01.05","01.06","01.07","01.08","01.09","01.01","01.10","01.11","01.12","01.13","01.14","01.15","01.16","01.17","01.18","01.19","01.20","01.21","01.22","01.23","01.24","01.25","01.26","01.27","01.28","01.29","01.30","01.31"};

    // Send request for participation in event to server
    public void RequestForParticipation(String UserId) {
        //
        // code there if you have access to server
        //
        // ask if user not taking part in event and have access to event
        //   True: countVisitors on server+=1; add UserId to list of participators on server
        //   False: nothing
    }

    // Send request for leave participation in event to server
    public void RequestForLeaveParticipation(String UserId) {
        //
        // code there if you have access to server
        //
        // ask if user taking part in event
        //   True: countVisitors on server-=1; remove UserId from list of participators
        //   False: nothing
    }

    // Start activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        initTabs();

    }
    private void initTabs() {
        TabLayout eventsTabLayout = findViewById(R.id.eventsTabLayout);
        ViewPager eventsViewPager = findViewById(R.id.eventsViewPager);
        TabsAdapterForEvents adapters = new TabsAdapterForEvents(getSupportFragmentManager());
        adapters.tabs = dates;

        eventsViewPager.setAdapter(adapters);
        eventsTabLayout.setupWithViewPager(eventsViewPager);
    }


}
