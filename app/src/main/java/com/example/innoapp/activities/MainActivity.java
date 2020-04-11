package com.example.innoapp.activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.innoapp.activities.LoginActivity.CODE;
import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    int id = 1;

    private TextView tvBarcode, txtDescriptionBarcode, txtDate;
    public static String code = "124958761310", date = "04/05/2010";
    HashSet<String> groups;
    private boolean barcodeScale = false;
    DatabaseReference mDatabase;
    private NotificationManager mNotificationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sp.getString(LOGIN, "").equals(""))
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        code = sp.getString(CODE, "124958761310");
        groups = (HashSet<String>) sp.getStringSet("GROUPS", new HashSet<String>());
        // barcode
        tvBarcode = findViewById(R.id.tvBarcode);
        txtDate = findViewById(R.id.txt_date);
        txtDescriptionBarcode = findViewById(R.id.txt_description_barcode);
        FloatingActionButton fabSettings = findViewById(R.id.fab_setting);
        CardView btnMaps = findViewById(R.id.btn_maps);
        CardView btnFAQ = findViewById(R.id.btn_faq);
        CardView btnSchedule = findViewById(R.id.btn_schedule);
        CardView btnVoting = findViewById(R.id.btn_voting);
        // set barcode's font
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/EanP72TtNormal.ttf");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        tvBarcode.setTypeface(font);
        // sets barcode's value
        EAN13CodeBuilder bb = new EAN13CodeBuilder(code);
        tvBarcode.setText(bb.getCode());
        // barcode settings
        tvBarcode.setPadding(0, 20, 20, 20);
        fabSettings.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
        btnSchedule.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, EventsActivity.class)));
        btnVoting.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, VotesActivity.class)));
        btnFAQ.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FAQActivity.class)));
        btnMaps.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MapActivity.class)));
        planningPush();

        //get current date
        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");
        String newDateStr = postFormater.format(dateObj);
        //set date in the main screen
        txtDate.setText(newDateStr);
        txtDate.setAllCaps(true);
    }

    // zooms barcode
    public void onButtonClickBarcode(View v) {
        if (barcodeScale) {
            txtDescriptionBarcode.setTextSize(18);
            tvBarcode.setTextSize(120);
            barcodeScale = false;
            tvBarcode.setPadding(0, 20, 20, 20);
        } else {
            txtDescriptionBarcode.setTextSize(0);
            tvBarcode.setTextSize(200);
            tvBarcode.setPadding(0, 20, 20, 20);
            barcodeScale = true;
        }
    }

    long timeUp;

    String contentText;
    boolean dependence = false;

    private void planningPush() {
        Timer timer = new Timer();
        // задаю формат с помощью которого буду парсить потом значение из БД
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");


        DatabaseReference userRef = mDatabase.child("events");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    for (DataSnapshot j : i.child("invitedgroups").getChildren()) {
                        String invitedgroup = (String) j.getValue();
                        for (String s : groups) {
                            if (s.equals(invitedgroup)) {
                                dependence = true;
                                break;
                            }
                        }
                    }
                    try {
                        if (dependence) {

                            // забираю все данные из event из БД
                            id = (int) i.child("id").getValue();
                            String name = (String) i.child("name").getValue();
                            boolean is_optional = (boolean) i.child("is_optional").getValue();
                            String place = (String) i.child("place").getValue();
                            String startDate = (String) i.child("dateStart").getValue();

                            // высчитываю время
                            try {
                                timeUp = Objects.requireNonNull(format.parse(Objects.requireNonNull(startDate))).getTime();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            // нахожу разницу
                            long diff = timeUp - System.currentTimeMillis();

                            try {
                                if (is_optional) {
                                    contentText = "Просим по желанию пройти в " + place + " через 10 минут там начнется мероприятие " + name;
                                } else {
                                    contentText = "Просим пройти в " + place + " через 10 минут там начнется обязательное мероприятие " + name;

                                }
                                // создаю пуш
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                createPush("Опопвещение о мероприятии");


                                                Log.d("WTF", "I AM TIRED");
                                            }
                                        });
                                    }
                                }, diff - 600000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        userRef.addListenerForSingleValueEvent(valueEventListener);

    }


    private void createPush(String title) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(MainActivity.this.getApplicationContext(), "notify_001");
        Intent ii = new Intent(MainActivity.this.getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, ii, 0);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle(title);

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle(title);
        mBuilder.setContentText(contentText);
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);
        mBuilder.setAutoCancel(true);

        mNotificationManager =
                (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        mNotificationManager.notify(id, mBuilder.build());
    }
}
