package com.example.innoapp.activities;

import com.example.innoapp.adapter.TabsAdapterForEvents;
import com.example.innoapp.fragments.Event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
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

    // Экземпляр списка RecyclerView
    private RecyclerView recyclerView;
    // Обработчик списка
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    // List of events
    public static String[][] datesInList1;
    public static String[][] eventsInList1;
    public static Event[][] classEventsInList1;
    private String[] dates = {"01.01","01.02","01.03","01.04","01.05","01.06",
            "01.07","01.08","01.09","01.01","01.10","01.11","01.12","01.13",
            "01.14","01.15","01.16","01.17","01.18","01.19","01.20","01.21",
            "01.22","01.23","01.24","01.25","01.26","01.27","01.28","01.29",
            "01.30","01.31"};
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

        initTabs();
        eList = new LinkedList<EventList1>();
        eList.add(new EventList1(new String[]{"10:00-11:00"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//1
        eList.add(new EventList1(new String[]{"10:00-11:00","14:00-15:00","10:00-11:00","14:00-15:00"},
                new String[]{"Breakfast","Lunch", "Breakfast","Lunch"},
                new Event[]{new Event("Breakfast",new Date(2020,2,1,10,0),
                            new Date(2020,1,2,11,0),
                            new LinkedList<Group>(),false,"Место","Описание", 0),
                            new Event("Lunch",new Date(2020,1,2,14,0),
                            new Date(2020,1,2,15,0),
                            new LinkedList<Group>(),false,"Место","Описание", 0),
                            new Event("Breakfast",new Date(2020,1,2,10,0),
                            new Date(2020,1,2,11,0),
                            new LinkedList<Group>(),false,"Место","Описание", 0),
                            new Event("Lunch",new Date(2020,1,2,14,0),
                            new Date(2020,1,2,15,0),
                            new LinkedList<Group>(),false,"Место","Описание", 0),}));//2
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//3
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//4
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//5
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//6
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие1111"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//7
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//8
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//9
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//10
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//11
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие22222"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//12
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//13
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//14
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//15
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//16
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//17
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//18
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//19
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//20
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//21
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//22
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//23
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//24
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//25
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//26
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//27
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//28
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//29
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//30
        eList.add(new EventList1(new String[]{"10-11"}, new String[]{"Какое то событие"},
                new Event[]{new Event("Какое то событие",new Date(2020,1,1,10,0),
                        new Date(2020,1,1,11,0),
                        new LinkedList<Group>(),false,"Место","Описание", 0)}));//31
        String[][] datesInList = {eList.get(0).datesInList, eList.get(1).datesInList,
                eList.get(2).datesInList, eList.get(3).datesInList, eList.get(4).datesInList,
                eList.get(5).datesInList, eList.get(6).datesInList, eList.get(7).datesInList,
                eList.get(8).datesInList, eList.get(9).datesInList, eList.get(10).datesInList,
                eList.get(11).datesInList, eList.get(12).datesInList, eList.get(13).datesInList,
                eList.get(14).datesInList, eList.get(15).datesInList, eList.get(16).datesInList,
                eList.get(17).datesInList, eList.get(18).datesInList, eList.get(19).datesInList,
                eList.get(20).datesInList, eList.get(21).datesInList, eList.get(22).datesInList,
                eList.get(23).datesInList, eList.get(24).datesInList, eList.get(25).datesInList,
                eList.get(26).datesInList, eList.get(27).datesInList, eList.get(28).datesInList,
                eList.get(29).datesInList, eList.get(30).datesInList};
        String[][] eventsInList = {eList.get(0).eventsInList, eList.get(1).eventsInList,
                eList.get(2).eventsInList, eList.get(3).eventsInList, eList.get(4).eventsInList,
                eList.get(5).eventsInList, eList.get(6).eventsInList, eList.get(7).eventsInList,
                eList.get(8).eventsInList, eList.get(9).eventsInList, eList.get(10).eventsInList,
                eList.get(11).eventsInList, eList.get(12).eventsInList, eList.get(13).eventsInList,
                eList.get(14).eventsInList, eList.get(15).eventsInList, eList.get(16).eventsInList,
                eList.get(17).eventsInList, eList.get(18).eventsInList, eList.get(19).eventsInList,
                eList.get(20).eventsInList, eList.get(21).eventsInList, eList.get(22).eventsInList,
                eList.get(23).eventsInList, eList.get(24).eventsInList, eList.get(25).eventsInList,
                eList.get(26).eventsInList, eList.get(27).eventsInList, eList.get(28).eventsInList,
                eList.get(29).eventsInList, eList.get(30).eventsInList};
        Event[][] classEventsInList = {eList.get(0).classEventsInList, eList.get(1).classEventsInList,
                eList.get(2).classEventsInList, eList.get(3).classEventsInList, eList.get(4).classEventsInList,
                eList.get(5).classEventsInList, eList.get(6).classEventsInList, eList.get(7).classEventsInList,
                eList.get(8).classEventsInList, eList.get(9).classEventsInList, eList.get(10).classEventsInList,
                eList.get(11).classEventsInList, eList.get(12).classEventsInList, eList.get(13).classEventsInList,
                eList.get(14).classEventsInList, eList.get(15).classEventsInList, eList.get(16).classEventsInList,
                eList.get(17).classEventsInList, eList.get(18).classEventsInList, eList.get(19).classEventsInList,
                eList.get(20).classEventsInList, eList.get(21).classEventsInList, eList.get(22).classEventsInList,
                eList.get(23).classEventsInList, eList.get(24).classEventsInList, eList.get(25).classEventsInList,
                eList.get(26).classEventsInList, eList.get(27).classEventsInList, eList.get(28).classEventsInList,
                eList.get(29).classEventsInList, eList.get(30).classEventsInList};
        datesInList1 = datesInList;
        eventsInList1 = eventsInList;
        classEventsInList1 = classEventsInList;
    }


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
        public EventList1(String[] datesInList, String[] eventsInList,Event[] classEventsInList) {
            this.datesInList = datesInList;
            this.eventsInList = eventsInList;
            this.classEventsInList = classEventsInList;
        }
    }

}
