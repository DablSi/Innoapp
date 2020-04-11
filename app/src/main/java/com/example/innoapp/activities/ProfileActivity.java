package com.example.innoapp.activities;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innoapp.R;
import com.example.innoapp.utils.LocaleHelper;

public class ProfileActivity extends AppCompatActivity {
    private String eMail;
    private TextView txt_language;
    private String mLanguageCode = "en";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        eMail = sp.getString(LoginActivity.EMAIL, "Cene655@mail.ru");
        // TODO: ADD CHECKING VALID EMAIL (IF THERE IS NO EMAIL)
        SetMail();
        txt_language = findViewById(R.id.txt_lang);
        //Change Russian to English via button
        txt_language.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                //Change Application level locale
                LocaleHelper.setLocale(ProfileActivity.this, mLanguageCode);
                txt_language.setText("RUS");
                //It is required to recreate the activity to reflect the change in UI.
                recreate();
            }
        });

    }

    private void SetMail() {
        TextView mailTextView = findViewById(R.id.mailTextView);
        TextView avaTextView = findViewById(R.id.avaTextView);
        mailTextView.setText(eMail);
        avaTextView.setText(Character.toString(eMail.toCharArray()[0]));
    }
}
