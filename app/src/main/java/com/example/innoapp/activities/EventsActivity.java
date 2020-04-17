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
import java.util.Date;
import java.util.LinkedList;

import static com.example.innoapp.activities.ProfileActivity.darkT;

public class EventsActivity extends AppCompatActivity {
    public static Event[][] classEventsInList1;
    public static LinkedList<Event> eList;
    public LinkedList<String> tabs;

    // Open card
    public void onMyButtonClick(@NonNull View view) {
        Intent intent = new Intent(this, EventCardActivity.class);
        TextView tVEventId = (TextView) view.findViewById(R.id.eventId);
        int eventId = Integer.parseInt(tVEventId.getText().toString());
        TextView tVNumTab = (TextView) view.findViewById(R.id.eventTabId);
        int numTab = Integer.parseInt(tVNumTab.getText().toString());
        Event event = classEventsInList1[numTab][eventId];
        intent.putExtra("event", (Serializable) event);
        intent.putExtra("eventId", eventId);
        intent.putExtra("tabId", numTab);
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
        // Array below should be taken from server
        eList = new LinkedList<Event>();
        tabs = new LinkedList<String>();
        tabs.add("1");
        tabs.add("2");
        tabs.add("3");
        eList.add(new Event("test", "Презентация приложения", new Date(2020, 3, 12, 14, 40),
                new Date(2020, 3, 12, 14, 50),
                new LinkedList<String>(), false, "Просторы интернета",
                "Показ приложения, сделанного школьниками за 2 недели, которое будет использоваться университетом Иннополиса.", 0, false, "01.01"));//1

        initTabs();
    }

    // Load tabs
    private void initTabs() {
        TabLayout eventsTabLayout = findViewById(R.id.eventsTabLayout);
        ViewPager eventsViewPager = findViewById(R.id.eventsViewPager);
        TabsAdapterForEvents adapters = new TabsAdapterForEvents(getSupportFragmentManager());
        adapters.tabs = tabs;
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