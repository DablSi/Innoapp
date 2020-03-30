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

    // Список карточек
    private List cards;
    // Ссылка на RecyclerView в activity_events.xml
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        // взятие ссылки на RecyclerView в activity_events.xml
        rv=(RecyclerView)findViewById(R.id.rv);

        // Установка в RecyclerViev LayoutManager (список)
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        // Загрузка 10 карточек
        initializeData();
        // Отображение крточек
        initializeAdapter();
    }

    private void initializeData(){
        cards = new ArrayList<>();
        //Название, дата, длительность, группы, кастомное, место, описание, количество посетителей
        Date d = new Date();
        cards.add(new Event("Card 1", "Content 1"));
        cards.add(new Event("Card 2", "Content 2"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cards);
        rv.setAdapter(adapter);
    }

}
