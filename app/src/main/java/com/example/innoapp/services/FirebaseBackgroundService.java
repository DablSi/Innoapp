package com.example.innoapp.services;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.innoapp.fragments.Event;
import com.example.innoapp.utils.Vote;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.example.innoapp.activities.EventsActivity.eList;
import static com.example.innoapp.activities.LoginActivity.LOGIN;
import static com.example.innoapp.activities.VotesActivity.groups;
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
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("Service", "Data changed");
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String login = sp.getString(LOGIN, "").replaceAll("[^A-Za-z0-9]", "");
                LinkedList<String> userGroups = new LinkedList<>();
                for (DataSnapshot j : dataSnapshot.child("users").child(login).child("groups").getChildren()) {
                    userGroups.add(j.getValue().toString());
                }
                for (String i : userGroups) {
                    if (groups == null)
                        groups = new LinkedList<String>();
                    if (Collections.binarySearch(groups, i) < 0)
                        groups.add(i);
                }
                for (DataSnapshot i : dataSnapshot.child("votes").getChildren()) {
                    LinkedList<String> variantsArray = new LinkedList<>();
                    LinkedList<Integer> votedArray = new LinkedList<>();
                    for (DataSnapshot j : i.child("variants").getChildren()) {
                        variantsArray.add(((List) (singletonList(j.getValue())).get(0)).get(0).toString());
                        votedArray.add(((Long) ((List) (singletonList(j.getValue())).get(0)).get(1)).intValue());
                    }
                    if (Collections.binarySearch(userGroups, i.child("groupName").getValue().toString()) < 0) {
                        continue;
                    }
                    Vote newVote = new Vote(i.getKey(), i.child("voteName").getValue().toString(), (String[]) variantsArray.toArray(new String[]{}),
                            votedArray.toArray(new Integer[]{}), (boolean) i.child("multiple").getValue(), i.child("groupName").getValue().toString());
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

                for (DataSnapshot i : dataSnapshot.child("events").getChildren()) {
                    Date dateStart = null, dateEnd = null;
                    try {
                        dateStart = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(i.child("dateStart").getValue().toString());
                        dateEnd = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(i.child("dateEnd").getValue().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LinkedList<String> eventGroups = new LinkedList<String>();
                    for (Object j : (List) singletonList(i.child("invitedgroups").getValue()).get(0)) {
                        eventGroups.add(j.toString());
                    }
                    eventGroups.retainAll(userGroups);
                    if (eventGroups.size() == 0) {
                        continue;
                    }
                    String id = i.getKey();
                    Event newEvent = new Event(i.getKey(), i.child("name").getValue().toString(), dateStart, dateEnd,
                            eventGroups, (boolean) i.child("is_optional").getValue(),
                            i.child("place").getValue().toString(), i.child("description").getValue().toString(),
                            Math.toIntExact((Long) i.child("visitors").getValue()), false);
                    boolean unique = true;
                    if (eList == null) {
                        eList = new LinkedList<Event>();
                    }
                    for (Event j : eList) {
                        if (j.id.equals(newEvent.id)) {
                            unique = false;
                            eList.set(eList.indexOf(j), newEvent);
                            break;
                        }
                    }
                    if (unique) {
                        eList.add(newEvent);
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