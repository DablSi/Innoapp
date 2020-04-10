package com.example.innoapp.activities;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innoapp.R;


public class ProfileActivity extends AppCompatActivity {
    private String eMail;
    //private TextView txt_language;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        eMail = sp.getString(LoginActivity.EMAIL, "Cene655@mail.ru");
        SetMail();
       // txt_language = findViewById(R.id.txt_lang);

    }

    private void SetMail() {
        TextView mailTextView = findViewById(R.id.mailTextView);
        TextView avaTextView = findViewById(R.id.avaTextView);
        mailTextView.setText(eMail);
        avaTextView.setText(Character.toString(eMail.toCharArray()[0]));
    }
}
