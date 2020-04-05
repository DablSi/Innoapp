package com.example.innoapp.activities;


import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.innoapp.R;


public class ProfileActivity extends AppCompatActivity
{
    private String eMail = "Cene655@mail.ru";
    private TextView mailTextView;
    private TextView avaTextView;
    private RelativeLayout languageLayout;
    private RelativeLayout darkThemeLayout;
    private RelativeLayout notificationsLayout;
    private RelativeLayout logOutLayout;
    private char[] chArray = eMail.toCharArray();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        SetMail();
    }
    private void SetMail( )
    {
        mailTextView = (TextView)findViewById(R.id.mailTextView);
        avaTextView = (TextView)findViewById(R.id.avaTextView);
        mailTextView.setText(eMail);
        avaTextView.setText(Character.toString(chArray[0]));
    }
    /*private void initLayout()
    {
        languageLayout = (RelativeLayout)findViewById(R.id.languageLayout);
        darkThemeLayout = (RelativeLayout)findViewById(R.id.darkThemeLayout);
        notificationsLayout = (RelativeLayout)findViewById(R.id.notificationsLayout);
        logOutLayout = (RelativeLayout)findViewById(R.id.logOutLayout);
    }*/
}
