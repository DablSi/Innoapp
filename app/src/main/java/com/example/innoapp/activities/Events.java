package com.example.innoapp.activities;

import com.example.innoapp.fragments.Event;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.innoapp.R;
import com.example.innoapp.fragments.RVAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Events extends AppCompatActivity {

    private List cards;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        rv = (RecyclerView)findViewById(R.id.rv);

        // set LayoutManager in RecycleView (list)
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        // load 10 cards
        initializeData();
        // show cards
        initializeAdapter();
    }

    private void initializeData(){
        cards = new ArrayList<>();
        // Name, date, duration, groups, optionality, place, description, number of visitors
        Date d = new Date();
        cards.add(new Event("Card 1", "Content 1"));
        cards.add(new Event("Card 2", "Content 2"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cards);
        rv.setAdapter(adapter);
    }

}
