package com.example.innoapp.activities;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innoapp.R;
import com.google.android.material.snackbar.Snackbar;


public class ProfileActivity extends AppCompatActivity {
    private String eMail;
    private TextView mailTextView;
    private TextView avaTextView;
    private RelativeLayout languageLayout;
    private RelativeLayout darkThemeLayout;
    private RelativeLayout notificationsLayout;
    private RelativeLayout logOutLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        eMail = sp.getString(LoginActivity.EMAIL, "Cene655@mail.ru");
        SetMail();
    }

    private void SetMail() {
        mailTextView = (TextView) findViewById(R.id.mailTextView);
        avaTextView = (TextView) findViewById(R.id.avaTextView);
        mailTextView.setText(eMail);
        avaTextView.setText(Character.toString(eMail.toCharArray()[0]));
    }
}
