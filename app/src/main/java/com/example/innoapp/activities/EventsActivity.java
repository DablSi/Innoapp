package com.example.innoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.innoapp.R;
import com.example.innoapp.adapter.TabsAdapterForEvents;
import com.example.innoapp.fragments.Event;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.security.acl.Group;
import java.util.Date;
import java.util.LinkedList;

public class EventsActivity extends AppCompatActivity {
    public static String[][] datesInList1;
    public static String[][] eventsInList1;
    public static Event[][] classEventsInList1;
    private String[] dates;
    public static LinkedList<EventsActivity.EventList1> eList;

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
        // Array below should be taken from server
        eList = new LinkedList<EventList1>();


        eList.add(new EventList1(
                new Event[]{new Event("Презентация приложения", new Date(2020, 3, 12, 12, 00),
                        new Date(2020, 3, 12, 13, 0),
                        new LinkedList<Group>(), false, "Просторы интернета", "Показ приложения, сделанного школьниками за 2 недели, которое будет использоваться университетом Иннополиса.", 0, false)}));//1
        eList.add(new EventList1(new Event[]{new Event("Breakfast", new Date(2020, 3, 13, 8, 30),
                new Date(2020, 3, 13, 13, 0),
                new LinkedList<Group>(), false, "Столовая", "Вкусный завтрак", 0, false),
                new Event("Lunch", new Date(2020, 3, 13, 14, 0),
                        new Date(2020, 3, 13, 15, 0),
                        new LinkedList<Group>(), false, "Столовая", "Сытный обед", 0, false),
                new Event("Snack", new Date(2020, 3, 13, 15, 30),
                        new Date(2020, 3, 13, 16, 0),
                        new LinkedList<Group>(), false, "Кофейня", "Лёгкий перекус. Выпейте чашечку чая", 0, false),
                new Event("Dinner", new Date(2020, 3, 13, 18, 0),
                        new Date(2020, 3, 13, 20, 00),
                        new LinkedList<Group>(), false, "Столовая", "Ароматный ужин", 0, false),
                new Event("Lunch", new Date(2020, 3, 13, 14, 0),
                        new Date(2020, 3, 13, 15, 0),
                        new LinkedList<Group>(), false, "Столовая", "Сытный обед", 0, false)}));//2
        eList.add(new EventList1(
                new Event[]{new Event("Событие", new Date(2020, 5, 1, 10, 0),
                        new Date(2020, 5, 1, 11, 0),
                        new LinkedList<Group>(), false, "Место", "Описание", 0, false),}));//1
        // get information about events from eList
        String[][] datesInList = new String[eList.size()][];
        String[][] eventsInList = new String[eList.size()][];
        Event[][] classEventsInList = new Event[eList.size()][];
        String[] newDates = new String[eList.size()];
        for (int i = 0; i < eList.size(); i++) {
            datesInList[i] = eList.get(i).datesInList;
            eventsInList[i] = eList.get(i).eventsInList;
            classEventsInList[i] = eList.get(i).classEventsInList;
            newDates[i] = String.format("%td", eList.get(i).classEventsInList[0].getDate()) + "." +
                    String.format("%tm", eList.get(i).classEventsInList[0].getDate());
        }
        datesInList1 = datesInList;
        eventsInList1 = eventsInList;
        classEventsInList1 = classEventsInList;
        dates = newDates;

        // Load tabs
        initTabs();
    }

    // Load tabs
    private void initTabs() {
        TabLayout eventsTabLayout = findViewById(R.id.eventsTabLayout);
        ViewPager eventsViewPager = findViewById(R.id.eventsViewPager);
        TabsAdapterForEvents adapters = new TabsAdapterForEvents(getSupportFragmentManager());
        adapters.tabs = dates;

        eventsViewPager.setAdapter(adapters);
        eventsTabLayout.setupWithViewPager(eventsViewPager);
    }

    public class EventList1 {
        String[] datesInList;
        String[] eventsInList;
        Event[] classEventsInList;

        public EventList1(Event[] classEventsInList) {
            // Set string time and names from array of events
            String[] newDatesInList = new String[classEventsInList.length];
            String[] newEventsInList = new String[classEventsInList.length];
            for (int i = 0; i < classEventsInList.length; i++) {
                String stringDate;
                stringDate = String.format("%tR", classEventsInList[i].getDate()) + " - " +
                        String.format("%tR", classEventsInList[i].getDateEnd());
                String stringName = classEventsInList[i].getName();
                newDatesInList[i] = stringDate;
                newEventsInList[i] = stringName;
            }
            this.datesInList = newDatesInList;
            this.eventsInList = newEventsInList;
            this.classEventsInList = classEventsInList;
        }
    }
}
