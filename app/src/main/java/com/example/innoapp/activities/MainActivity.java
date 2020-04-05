package com.example.innoapp.activities;

import android.annotation.SuppressLint;
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
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.innoapp.R;
import com.example.innoapp.adapter.TabsPagerFragmentAdapters;
import com.example.innoapp.utils.EAN13CodeBuilder13;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


import static com.example.innoapp.activities.LoginActivity.CODE;
import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    private TextView tvBarcode;
    DatabaseReference mDatabase;
    private NotificationManager mNotificationManager;

    public static String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sp.getString(LOGIN, "").equals(""))
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        code = sp.getString(CODE, "");
        // barcode
        tvBarcode = findViewById(R.id.tvBarcode);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // tabs initialisation
        initTabs();
        // barcode font
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/EanP72TtNormal.ttf");
        // sets the barcode
        tvBarcode.setTypeface(font);
        // sets barcode's value
        EAN13CodeBuilder13 bb = new EAN13CodeBuilder13(code);
        tvBarcode.setText(bb.getCode());
        // barcode settings
        RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(500, 350);
        layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParamsBarcode.addRule(RelativeLayout.CENTER_HORIZONTAL);
        tvBarcode.setLayoutParams(layoutParamsBarcode);
        tvBarcode.setPadding(0, 25, 0, 0);
        planningPush();
    }

    private void initTabs() {
        TabLayout mapsTabLayout = findViewById(R.id.mapsTabLayout);
        ViewPager mapsViewPager = findViewById(R.id.mapsViewPager);
        TabsPagerFragmentAdapters adapters = new TabsPagerFragmentAdapters(getSupportFragmentManager());
        mapsViewPager.setAdapter(adapters);
        mapsTabLayout.setupWithViewPager(mapsViewPager);
    }

    boolean barcodeScale = false;

    // zooms barcode
    public void onButtonClickBarcode(View v) {
        if (barcodeScale) {
            tvBarcode.setTextSize(100);
            barcodeScale = false;

            RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(500, 350);
            layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParamsBarcode.addRule(RelativeLayout.CENTER_HORIZONTAL);
            tvBarcode.setLayoutParams(layoutParamsBarcode);
            tvBarcode.setPadding(0, 25, 0, 0);
        } else {
            tvBarcode.setTextSize(TypedValue.COMPLEX_UNIT_MM, 40);
            RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 725);
            layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParamsBarcode.addRule(RelativeLayout.CENTER_IN_PARENT);
            tvBarcode.setLayoutParams(layoutParamsBarcode);
            tvBarcode.setPadding(0, 50, 0, 0);
            barcodeScale = true;
        }

    }

    @SuppressLint("InflateParams")
    public void zoomMap(View v) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
        PhotoView photoView = mView.findViewById(R.id.imageView);
        int id = v.getId();
        int res = R.drawable.firstf;
        if (id == R.id.map2ImageView) {
            res = R.drawable.secondf;
        } else if (id == R.id.map3ImageView) {
            res = R.drawable.thirdf;
        }
        photoView.setImageResource(res);
        mBuilder.setView(mView);
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    long timeUp;
    int cnt = 1;
    String contentText;

    private void planningPush() {
        Timer timer = new Timer();
        // задаю формат с помощью которого буду парсить потом значение из БД
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");


        DatabaseReference userRef = mDatabase.child("events");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot i : dataSnapshot.getChildren()) {

                    // забираю все данные из event из БД

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

                                        cnt += 1;
                                        Log.d("WTF", "I AM TIRED");
                                    }
                                });
                            }
                        }, diff - 600000);
                    } catch (Exception e) {
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

        mNotificationManager.notify(cnt, mBuilder.build());
    }
}


