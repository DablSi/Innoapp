package com.example.innoapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.innoapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private EditText email;
    private DatabaseReference mDatabase;

    public static final String LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.loginButton);
        email = findViewById(R.id.input_email);
        btn.setOnClickListener(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        String emailString = email.getText().toString();
        // оставляю только цифры и латинские буквы, например: goshan164@gmail.com = goshan164gmailcom
        emailString = emailString.replaceAll("[^A-Za-z0-9]", "");
        Log.d("TEST", emailString);
        DatabaseReference userRef = mDatabase.child("users").child(emailString);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // если существует пользователь с такой почтой пустить его в приложение
                if (dataSnapshot.exists()) {
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(LOGIN, email.getText().toString());
                    editor.commit();
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle(R.string.notification)
                            .setMessage(R.string.email_wrong)
                            .setCancelable(false)
                            .setNegativeButton("ОК",
                                    (dialog, id) -> {
                                        dialog.dismiss();

                                    });
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


    // чтобы человек не мог вернуться в главную активность кнопкой назад
    @Override
    public void onBackPressed() {
    }
}
