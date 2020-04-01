package com.example.innoapp.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innoapp.R;
import com.example.innoapp.adapter.DataAdapter;


public class FAQActivity extends AppCompatActivity {
    private RecyclerView questionsList;
    private DataAdapter adapter;
    String questions[] = {"Супер умный вопрос", "Ещё один супер умный вопрос", "Умные вопросы требуют умных ответов", "Очередной супер умный вопрос", "Я не знаю, что писать в этом вопросе"};
    String answers[] = {"Супер умный", "Ещё один супер умный ответ", "Умные ответы требуют умных вопросов", "Очередной супер умный ответ", "Я не знаю, что писать в этом ответе"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_activity);
        questionsList = findViewById(R.id.questionsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        questionsList.setLayoutManager(layoutManager);
        adapter = new DataAdapter(questions, answers, this);
        questionsList.setAdapter(adapter);
    }


}