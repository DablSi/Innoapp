package com.example.innoapp.activities;

import com.example.innoapp.adapter.TabsAdapterForEvents;
import com.example.innoapp.fragments.Event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.example.innoapp.R;
import com.example.innoapp.fragments.FragmentTabEvents;
import com.google.android.material.tabs.TabLayout;

import java.security.acl.Group;
import java.util.Date;
import java.util.LinkedList;

public class Events extends AppCompatActivity {

    public static String[][] datesInList1;
    public static String[][] eventsInList1;
    public static Event[][] classEventsInList1;
    private String[] dates;
    public static LinkedList<Events.EventList1> eList;
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
    // Open card
     /* public void onMyButtonClick(@NonNull View view)
    {
       TextView tVEventId = (TextView)view.findViewById(R.id.eventId);
        int eventId = Integer.parseInt(tVEventId.getText().toString());
        TextView tVNumTab =(TextView) view.findViewById(R.id.eventTabId);
        int numTab = Integer.parseInt(tVNumTab.getText().toString());
        Event event = classEventsInList1[numTab][eventId];
        startActivity(intent);
    }*/

    // Open card
    public void onMyButtonClick(@NonNull  View view)
    {
        Intent intent = new Intent(this, event_card.class);
        TextView tVEventId = (TextView)view.findViewById(R.id.eventId);
        int eventId = Integer.parseInt(tVEventId.getText().toString());
        TextView tVNumTab =(TextView) view.findViewById(R.id.eventTabId);
        int numTab = Integer.parseInt(tVNumTab.getText().toString());
        Event event = classEventsInList1[numTab][eventId];
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
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//1
        eList.add(new EventList1(new Event[]{new Event("Breakfast",new Date(2020,1,2,10,0),
                            new Date(2020,1,2,11,0),
                            new LinkedList<Group>(),false,"Место","Описание", 0),
                            new Event("Lunch",new Date(2020,1,2,14,0),
                            new Date(2020,1,2,15,0),
                            new LinkedList<Group>(),false,"Место","Описание", 0)}));//2

        // get information about events from eList
        String[][] datesInList = new String[eList.size()][];
        String[][] eventsInList = new String[eList.size()][];
        Event[][] classEventsInList = new Event[eList.size()][];
        String[] newDates = new String[eList.size()];
        for(int i=0;i<eList.size();i++)
        {
            datesInList[i] = eList.get(i).datesInList;
            eventsInList[i] = eList.get(i).eventsInList;
            classEventsInList[i] = eList.get(i).classEventsInList;
            newDates[i] = String.format("%td",eList.get(i).classEventsInList[0].getDate())+"."+
                    String.format("%tm",eList.get(i).classEventsInList[0].getDate());
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
            for(int i=0;i<classEventsInList.length;i++)
            {
                String stringDate;
                stringDate = String.format("%tR",classEventsInList[i].getDate())+" - "+
                        String.format("%tR",classEventsInList[i].getDateEnd());
                String stringName = classEventsInList[i].getName();
                newDatesInList[i]=stringDate;
                newEventsInList[i]=stringName;
            }
            this.datesInList = newDatesInList;
            this.eventsInList = newEventsInList;
            this.classEventsInList = classEventsInList;
        }
    }

}
