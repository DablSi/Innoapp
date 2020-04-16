package com.example.innoapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.innoapp.activities.EventsActivity;
import com.example.innoapp.fragments.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import static com.example.innoapp.activities.EventsActivity.eList;
import static java.util.Collections.singleton;


public class FirebaseBackgroundService extends Service {

    private ValueEventListener handler;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Log.d("Service", "Service started");

        handler = new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("Service", "Data changed");
                for (DataSnapshot i : dataSnapshot.child("events").getChildren()) {
                    Date dateStart = null, dateEnd = null;
                    try {
                        dateStart = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(i.child("dateStart").getValue().toString());
                        dateEnd = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(i.child("dateEnd").getValue().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Event newEvent = new Event(i.child("name").getValue().toString(), dateStart, dateEnd,
                            new LinkedList(singleton(i.child("invitedgroups").getValue())),
                            (boolean) i.child("is_optional").getValue(), i.child("place").getValue().toString(),
                            i.child("description").getValue().toString(), Math.toIntExact((Long) i.child("visitors").getValue()), false);
                    boolean unique = true;
                    if (eList == null) {
                        eList = new LinkedList<EventsActivity.EventList1>();
                    }
                    for (EventsActivity.EventList1 j : eList) {
                        for (Event k : j.classEventsInList) {
                            if (k.compare(newEvent)) {
                                unique = false;
                                break;
                            }
                        }
                        if (!unique) {
                            break;
                        }
                    }
                    if (unique) {
                        eList.add(new EventsActivity.EventList1(new Event[]{newEvent}));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.addValueEventListener(handler);
    }

}