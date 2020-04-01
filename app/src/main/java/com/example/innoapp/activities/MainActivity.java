package com.example.innoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innoapp.R;

import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sp.getString(LOGIN, "").equals(""))
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

 */
    }
    // for debug, can be deleted
    public void StartEvents(View view) {
        Intent intent = new Intent(this, Events.class);
        startActivity(intent);
    }
}
