package com.example.innoapp.activities;

import com.example.innoapp.fragments.Event;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.innoapp.R;
import com.example.innoapp.fragments.RVAdapter;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.security.acl.Group;
import java.util.Date;
import java.util.LinkedList;

public class Events extends AppCompatActivity {

    // Экземпляр списка RecyclerView
    private RecyclerView recyclerView;
    // Обработчик списка
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    // List of events
    private Event[] dataEvents;
    // This var is need for closeDescription()
    private int heightOfDescription;

    // Open description of card
    public void OpenDescription() {
        TextView tv = (TextView) findViewById(R.id.cardDescription);
        CardView cv = (CardView) findViewById(R.id.cv);
        FrameLayout.LayoutParams TVParams;
        TVParams = (FrameLayout.LayoutParams) tv.getLayoutParams();
        int startHeightTV = TVParams.height;
        this.heightOfDescription = startHeightTV;
        TVParams.height = tv.getMaxHeight();
        int endHeightTV = TVParams.height;
        //RecyclerView.LayoutParams CVParams;
        //CVParams = (RecyclerView.LayoutParams) cv.getLayoutParams();
        //int startHeightCV = CVParams.height;
        //CVParams.height = startHeightCV + endHeightTV - startHeightTV;
    }

    // Close description of card
    public void CloseDescription(TextView tv, CardView.LayoutParams cv) {
        int startHeightTV = tv.getHeight();
        int startHeightCV = cv.height;
        tv.setHeight(this.heightOfDescription);
        int endHeightTV = tv.getHeight();
        cv.height = startHeightCV + endHeightTV -startHeightTV;
    }

    // Send request for participation in event to server
    public void RequestForParticipation(String UserId) {
        //
        // code there if you have access to server
        //
        // ask if user not taking part in event and have access to event
        //   True: countVisitors on server+=1; add UserId to list of participators on server
        //   False: nothing
    }

    // Send request for leave participation in event to server
    public void RequestForLeaveParticipation(String UserId) {
        //
        // code there if you have access to server
        //
        // ask if user taking part in event
        //   True: countVisitors on server-=1; remove UserId from list of participators
        //   False: nothing
    }

    // Start activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        // size of RV can't be changed
        recyclerView.setHasFixedSize(true);

        // linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //  set dataEvents
        int countCards=5;
        dataEvents = new Event[countCards];
        for(int i=0;i<countCards;i++)
        {
            // Название, дата, дата конца, группы, кастомное, место, описание, количество посетителей
            Date d = new Date(2020+i,12-i,1+2*i);
            Date d1 = new Date(2020+i,12-i,2+3*i);
            LinkedList<Group> ll= new LinkedList<Group>();
            dataEvents[i]= new Event("Событие "+Integer.toString(i),d,d1,ll,
                    false,"Актовый зал",
                    "012345678901234567890123456789012345678901234567890123456789012345012345678901234567890123456789012345678901234567890123456789012345",31);
        }
        // an adapter
        mAdapter = new RVAdapter(dataEvents);
        recyclerView.setAdapter(mAdapter);
    }

}
