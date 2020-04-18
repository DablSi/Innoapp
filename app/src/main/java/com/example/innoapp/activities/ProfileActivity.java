package com.example.innoapp.activities;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.innoapp.R;
import com.example.innoapp.utils.LocaleHelper;

public class ProfileActivity extends AppCompatActivity {
    Intent darkIntent = new Intent();
    private String eMail;
    private TextView txt_language;
    private String mLanguageCode = "en";
    public static boolean darkT = false;

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
        Switch switch1 = (Switch) findViewById(R.id.switch1);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SetDarkT(isChecked);
                darkT = isChecked;

            }
        });
        if (darkT) {
            switch1.setChecked(true);
        } else {
            switch1.setChecked(false);
        }
    }

    private void SetMail() {
        TextView mailTextView = findViewById(R.id.mailTextView);
        TextView avaTextView = findViewById(R.id.avaTextView);
        mailTextView.setText(eMail);
        avaTextView.setText(Character.toString(eMail.toCharArray()[0]));
    }

    private void SetDarkT(boolean darkT1) {
        ImageButton back = (ImageButton) findViewById(R.id.back);
        RelativeLayout languageLayout = (RelativeLayout) findViewById(R.id.languageLayout);
        RelativeLayout darkThemeLayout = (RelativeLayout) findViewById(R.id.darkThemeLayout);
        RelativeLayout notificationsLayout = (RelativeLayout) findViewById(R.id.notificationsLayout);
        RelativeLayout logOutLayout = (RelativeLayout) findViewById(R.id.logOutLayout);
        LinearLayout profileLinearLayout1 = (LinearLayout) findViewById(R.id.profileLinearLayout1);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textViewProfile1 = (TextView) findViewById(R.id.textViewProfile1);
        TextView textViewProfile2 = (TextView) findViewById(R.id.textViewProfile2);
        TextView textViewProfile3 = (TextView) findViewById(R.id.textViewProfile3);
        TextView textViewProfile4 = (TextView) findViewById(R.id.textViewProfile4);
        TextView txt_lang = (TextView) findViewById(R.id.txt_lang);
        TextView mailTextView = (TextView) findViewById(R.id.mailTextView);
        ImageView imageProfile = (ImageView) findViewById(R.id.imageProfile);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        ImageView languageImage = (ImageView) findViewById(R.id.languageImage);
        ImageView darkThemeImage = (ImageView) findViewById(R.id.darkThemeImage);
        ImageView notificationsImage = (ImageView) findViewById(R.id.notificationsImage);
        ImageView logOutImage = (ImageView) findViewById(R.id.logOutImage);
        ImageView faceBookImageView = (ImageView) findViewById(R.id.faceBookImageView);
        ImageView instaImageView = (ImageView) findViewById(R.id.instaImageView);
        ImageView VKImageView = (ImageView) findViewById(R.id.VKImageView);

        if (darkT1) {
            back.setImageResource(R.drawable.back2);
            profileLinearLayout1.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            darkThemeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            notificationsLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            logOutLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            textView.setTextColor(ContextCompat.getColor(this, R.color.white));
            mailTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
            textViewProfile1.setTextColor(ContextCompat.getColor(this, R.color.white));
            textViewProfile2.setTextColor(ContextCompat.getColor(this, R.color.white));
            textViewProfile3.setTextColor(ContextCompat.getColor(this, R.color.white));
            textViewProfile4.setTextColor(ContextCompat.getColor(this, R.color.white));
            txt_lang.setTextColor(ContextCompat.getColor(this, R.color.white));
            imageProfile.setImageResource(R.drawable.profile_image10);
            imageView6.setImageResource(R.drawable.lower_image_dark);
            languageImage.setImageResource(R.drawable.profile_image11);
            darkThemeImage.setImageResource(R.drawable.profile_image12);
            logOutImage.setImageResource(R.drawable.profile_image13);
            notificationsImage.setImageResource(R.drawable.profile_image14);
            //
            faceBookImageView.setImageResource(R.drawable.profile_image17);
            instaImageView.setImageResource(R.drawable.profile_image15);
            VKImageView.setImageResource(R.drawable.profile_image16);
            languageLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));

        } else {
            back.setImageResource(R.drawable.back);
            languageImage.setImageResource(R.drawable.profile_image6);
            darkThemeImage.setImageResource(R.drawable.profile_image7);
            notificationsImage.setImageResource(R.drawable.profile_image8);
            logOutImage.setImageResource(R.drawable.profile_image9);
            faceBookImageView.setImageResource(R.drawable.profile_image3);
            instaImageView.setImageResource(R.drawable.profile_image4);
            VKImageView.setImageResource(R.drawable.profile_image5);
            imageView6.setImageResource(R.drawable.lower_image);
            profileLinearLayout1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            textView.setTextColor(ContextCompat.getColor(this, R.color.black));
            textViewProfile1.setTextColor(ContextCompat.getColor(this, R.color.black));
            textViewProfile2.setTextColor(ContextCompat.getColor(this, R.color.black));
            textViewProfile3.setTextColor(ContextCompat.getColor(this, R.color.black));
            textViewProfile4.setTextColor(ContextCompat.getColor(this, R.color.black));
            txt_lang.setTextColor(ContextCompat.getColor(this, R.color.black));
            mailTextView.setTextColor(ContextCompat.getColor(this, R.color.black));
            imageProfile.setImageResource(R.drawable.profile_image2);
            languageLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_light_grey2));
            darkThemeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_light_grey2));
            notificationsLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_light_grey2));
            logOutLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_light_grey2));
        }
    }


}
