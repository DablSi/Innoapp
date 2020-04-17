package com.example.innoapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.innoapp.fragments.Vote;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.innoapp.activities.VotesActivity.votes;
import static java.util.Collections.singletonList;

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
                for (DataSnapshot i : dataSnapshot.child("votes").getChildren()) {
                    ArrayList variantsArray = new ArrayList();
                    variantsArray.addAll((List) singletonList(i.child("variants").getValue()).get(0));
                    Vote newVote = new Vote(i.getKey(), i.child("voteName").getValue().toString(), (String[]) variantsArray.toArray(new String[]{}),
                            (boolean) i.child("multiple").getValue(), i.child("groupName").getValue().toString());
                    boolean unique = true;
                    if (votes == null) {
                        votes = new LinkedList<Vote>();
                    }
                    for (int j = 0; j < votes.size(); j++) {
                        if (votes.get(j).id.equals(newVote.id)) {
                            votes.set(j, newVote);
                            unique = false;
                        }
                    }
                    if (unique) {
                        votes.add(newVote);
                    }
                }

//                for (DataSnapshot i : dataSnapshot.child("events").getChildren()) {
//                    Date dateStart = null, dateEnd = null;
//                    try {
//                        dateStart = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(i.child("dateStart").getValue().toString());
//                        dateEnd = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(i.child("dateEnd").getValue().toString());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    LinkedList<String> linkedList = new LinkedList<String>();
//                    for (Object j : (List) singletonList(i.child("invitedgroups").getValue()).get(0)) {
//                        linkedList.add(j.toString());
//                    }
//                    Event newEvent = new Event(i.getKey(), i.child("name").getValue().toString(), dateStart, dateEnd,
//                            linkedList, (boolean) i.child("is_optional").getValue(),
//                            i.child("place").getValue().toString(), i.child("description").getValue().toString(),
//                            Math.toIntExact((Long) i.child("visitors").getValue()), false);
//                    boolean unique = true;
//                    if (eList == null) {
//                        eList = new LinkedList<EventsActivity.EventList1>();
//                    }
//                    for (EventsActivity.EventList1 j : eList) {
//                        for (Event k : j.classEventsInList) {
//                            if (k.id.equals(newEvent.id)) {
//                                unique = false;
//                                j.classEventsInList.set(j.classEventsInList.indexOf(k), newEvent);
//                                break;
//                            }
//                        }
//                        if (!unique) {
//                            break;
//                        }
//                    }
//                    if (unique) {
//                        LinkedList<Event> addList = new LinkedList<Event>();
//                        addList.add(newEvent);
//                        eList.add(new EventsActivity.EventList1(addList));
//                    }
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.addValueEventListener(handler);
    }

}