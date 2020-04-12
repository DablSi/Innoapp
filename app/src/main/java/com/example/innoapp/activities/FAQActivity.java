package com.example.innoapp.activities;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import static com.example.innoapp.activities.ProfileActivity.darkT;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innoapp.R;
import com.example.innoapp.adapter.DataAdapter;

import static com.example.innoapp.activities.ProfileActivity.darkT;


public class FAQActivity extends AppCompatActivity {
    private RecyclerView questionsList;
    private DataAdapter adapter;
    private ImageButton back;
    String[] questions = {"Супер умный вопрос", "Ещё один супер умный вопрос", "Умные вопросы требуют умных ответов", "Очередной супер умный вопрос", "Я не знаю, что писать в этом вопросе"};
    String[] answers = {"Супер умный", "Ещё один супер умный ответ", "Умные ответы требуют умных вопросов", "Очередной супер умный ответ", "Я не знаю, что писать в этом ответе"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_activity);
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
        questionsList = findViewById(R.id.questionsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        questionsList.setLayoutManager(layoutManager);
        adapter = new DataAdapter(questions, answers, this);
        questionsList.setAdapter(adapter);
    }
    public void onResume()
    {
        super.onResume();
        SetDarkT();
    }

    private void SetDarkT() {
        ImageView faqImage = (ImageView) findViewById(R.id.faqImage);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        TextView fAQTextView = (TextView) findViewById(R.id.fAQTextView);
        ScrollView faqScrollView = (ScrollView) findViewById(R.id.faqScrollView);
        if (darkT) {
            faqImage.setImageResource(R.drawable.lower_image_dark);
            back.setImageResource(R.drawable.back2);
            faqScrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            fAQTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
        } else {
            faqImage.setImageResource(R.drawable.lower_image);
            back.setImageResource(R.drawable.back);
            faqScrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            fAQTextView.setTextColor(ContextCompat.getColor(this, R.color.black));

        }
    }


}