package com.example.innoapp.activities;

import com.example.innoapp.fragments.Event;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.innoapp.R;
import com.example.innoapp.fragments.RVAdapter;

import java.security.acl.Group;
import java.util.Date;
import java.util.LinkedList;

public class Events extends AppCompatActivity {

    // Экземпляр списка RecyclerView
    private RecyclerView recyclerView;
    // Обработчик списка
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Event[] dataEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

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
                    false,"Актовый зал",
                    "012345678901234567890123456789012345678901234567890123456789012345",31);
        }
        // an adapter
        mAdapter = new RVAdapter(dataEvents);
        recyclerView.setAdapter(mAdapter);
    }

}
