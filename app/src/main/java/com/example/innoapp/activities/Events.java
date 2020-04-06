package com.example.innoapp.activities;

import com.example.innoapp.fragments.Event;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.innoapp.R;
import com.example.innoapp.fragments.RVAdapter;
import com.google.android.material.snackbar.Snackbar;

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

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        Snackbar.make(recyclerView, "Данная секция все еще в разработке", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        // size of RV can't be changed
        recyclerView.setHasFixedSize(true);

        // linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //  set dataEvents
        int countCards=5;
        dataEvents = new Event[countCards];
        for(int i=0;i<countCards;i++)
        {
            // Название, дата, дата конца, группы, кастомное, место, описание, количество посетителей
            Date d = new Date(2020+i,12-i,1+2*i);
            Date d1 = new Date(2020+i,12-i,2+3*i);
            LinkedList<Group> ll= new LinkedList<Group>();
            dataEvents[i]= new Event("Событие "+Integer.toString(i),d,d1,ll,
                    false,"Место",
                    "Описание",0);
        }
        // an adapter
        mAdapter = new RVAdapter(dataEvents);
        recyclerView.setAdapter(mAdapter);
    }

}
