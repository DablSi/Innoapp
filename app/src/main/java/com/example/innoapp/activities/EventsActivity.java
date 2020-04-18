package com.example.innoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.innoapp.R;
import com.example.innoapp.adapter.TabsAdapterForEvents;
import com.example.innoapp.fragments.Event;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import static com.example.innoapp.activities.ProfileActivity.darkT;

public class EventsActivity extends AppCompatActivity {
    public static LinkedList<Event> eList;
    public static LinkedList<Date> tabDates;

    // Open card
    public void onMyButtonClick(@NonNull View view) {
        Intent intent = new Intent(this, EventCardActivity.class);
        TextView tVEventId = (TextView) view.findViewById(R.id.eventId);
        int eventId = Integer.parseInt(tVEventId.getText().toString());
        Event event = eList.get(eventId);
        intent.putExtra("event", (Serializable) event);
        intent.putExtra("eventId", eventId);
        startActivity(intent);
    }

    // Start activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabDates = new LinkedList<Date>();
        for (int i = 0; i < eList.size(); i++) {
            tabDates.add(eList.get(i).getDate());
        }
        for (int i = 0; i < tabDates.size() - 1; i++) {
            if (tabDates.get(i).equals(tabDates.get(i + 1))) {
                tabDates.remove(i);
                i--;
            }
            ;
        }
        Collections.sort(tabDates);
        initTabs();
    }

    // Load tabs
    private void initTabs() {
        TabLayout eventsTabLayout = findViewById(R.id.eventsTabLayout);
        ViewPager eventsViewPager = findViewById(R.id.eventsViewPager);
        TabsAdapterForEvents adapters = new TabsAdapterForEvents(getSupportFragmentManager());
        LinkedList<String> tabs2 = new LinkedList<String>();
        for (int i = 0; i < tabDates.size(); i++) {
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM.dd");
            tabs2.add(formatForDateNow.format(tabDates.get(i)));
        }
        adapters.tabs = tabs2;
        eventsViewPager.setAdapter(adapters);
        eventsTabLayout.setupWithViewPager(eventsViewPager);
    }

    public void onResume() {
        super.onResume();
        SetDarkT();
    }

    private void SetDarkT() {

        RelativeLayout eventsRelativeLayout = (RelativeLayout) findViewById(R.id.eventsRelativeLayout);
        TextView textViewSchedule = (TextView) findViewById(R.id.textViewSchedule);
        HorizontalScrollView eventsHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.eventsHorizontalScrollView);
        TabLayout eventsTabLayout = (TabLayout) findViewById(R.id.eventsTabLayout);
        ViewPager eventsViewPager = (ViewPager) findViewById(R.id.eventsViewPager);
        if (darkT) {
            eventsRelativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            eventsHorizontalScrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            eventsTabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            eventsViewPager.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            textViewSchedule.setTextColor(ContextCompat.getColor(this, R.color.white));
            eventsTabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.white), ContextCompat.getColor(this, R.color.white));
            eventsTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.inno_blue));
        } else {
            textViewSchedule.setTextColor(ContextCompat.getColor(this, R.color.black));
            eventsTabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.black));
            eventsRelativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            eventsViewPager.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            eventsHorizontalScrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            eventsTabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            eventsTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }

}