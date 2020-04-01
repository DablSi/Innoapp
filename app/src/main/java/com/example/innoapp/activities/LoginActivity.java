package com.example.innoapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.innoapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private DatabaseReference mDatabase;

    public static final String LOGIN = "login";
    public static final String CODE = "code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.loginButton);
        email = findViewById(R.id.input_email);
        btn.setOnClickListener(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        String emailString = email.getText().toString();
        // I leave only numbers and latin letters, for example: goshan164@gmail.com = goshan164gmailcom
        emailString = emailString.replaceAll("[^A-Za-z0-9]", "");
        Log.d("TEST", emailString);
        DatabaseReference userRef = mDatabase.child("users").child(emailString);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // if there is a user with such email, then log him in
                if (dataSnapshot.exists()) {
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(LOGIN, email.getText().toString());
                    for (DataSnapshot i : dataSnapshot.child("groups").getChildren()) {
                        String topic = (String) i.getValue();
                        // add users to their groups
                        FirebaseMessaging.getInstance().subscribeToTopic(Objects.requireNonNull(topic))
                                .addOnCompleteListener(task -> {
                                    String msg = "SUCCESS";
                                    if (!task.isSuccessful()) {
                                        msg = "FAILED";
                                    }
                                    Log.d("SUBCRIBE TO TOPIC:", msg);
                                    Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                });

                    }

                    MainActivity.code = (String) dataSnapshot.child("code").getValue();
                    editor.putString(CODE, MainActivity.code);
                    editor.apply();
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle(R.string.notification)
                            .setMessage(R.string.email_wrong)
                            .setCancelable(false)
                            .setNegativeButton("ОК",
                                    (dialog, id) -> dialog.dismiss());
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        userRef.addListenerForSingleValueEvent(valueEventListener);


    }


    // not to let user return to the main activity using the back button
    @Override
    public void onBackPressed() {
    }
}