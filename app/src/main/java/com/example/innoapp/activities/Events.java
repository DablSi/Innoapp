package com.example.innoapp.activities;

import com.example.innoapp.fragments.Event;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.innoapp.R;
import com.example.innoapp.fragments.RVAdapter;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Events extends AppCompatActivity {

    // карточка
    private Event event;
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

        // Загрузка карточки
        initializeData();
        // Отображение карточки
        initializeAdapter();
        
    }

    private void initializeData(){

        //Название, дата, длительность, группы, кастомное, место, описание, количество посетителей
        Date d = new Date();
        LinkedList<Group> ll = new LinkedList<Group>();
        event = new Event("Завтрак ", d, "30 минут", ll, false, "Столовая", "Подаётся гречка с сосисками, манная каша, булочки с джемом, чай и морс.", 31);
       /*
        Date d1 = new Date();
        LinkedList<Group> ll1 = new LinkedList<Group>();
        cards.add(new Event("Лекция: проблемы разрабатывающего карточки", d1, "1 час", ll1, true, "Актовый зал", "Узнай самые актуальные проблемы Android-разработчика и решения, которые принял ведущий разработки карточек Иннополиса.", 14));
       */
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(event);
        rv.setAdapter(adapter);
    }

}
