package com.example.innoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.innoapp.R;
import com.example.innoapp.fragments.CodeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // тестовый вызов фрагмента штрих-кода
        getSupportFragmentManager().beginTransaction()
                .add(R.id.relativeLayout, new CodeFragment()).commit();
    }
}
