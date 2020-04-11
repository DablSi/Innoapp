package com.example.innoapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.innoapp.R;
import com.example.innoapp.fragments.Event;

import java.util.concurrent.TimeUnit;

public class EventCardActivity extends AppCompatActivity {

    public int eventId;
    public int tabId;
    public int countVisitors;

    public void onMyButtonClick(@NonNull View view) {
        ToggleButton TBParticipation = (ToggleButton) findViewById(R.id.cardParticipation);
        boolean participation = TBParticipation.isChecked();
        int intParticipation;
        if (participation == true)
            intParticipation = 1;
        else
            intParticipation = 0;
        EventsActivity.classEventsInList1[tabId][eventId].setParticipation(participation);
        TextView TVCountVisitors = (TextView) findViewById(R.id.cardCountVisitors);
        countVisitors = countVisitors - 1 + 2 * intParticipation;
        EventsActivity.classEventsInList1[tabId][eventId].setCountVisitors(countVisitors);
        TVCountVisitors.setText(Integer.toString(countVisitors));
        // Here should be code that send information to server about join or leave event
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_card);
        Intent intent = getIntent();
        int eventId = (int) intent.getIntExtra("eventId", 0);
        int tabId = (int) intent.getIntExtra("tabId", 0);
        this.eventId = eventId;
        this.tabId = tabId;
        Event event = (Event) intent.getSerializableExtra("event");
        TextView TVDuration = (TextView) findViewById(R.id.cardDuration);
        TextView TVDate = (TextView) findViewById(R.id.cardDate);
        TextView TVCountVisitors = (TextView) findViewById(R.id.cardCountVisitors);
        TextView TVName = (TextView) findViewById(R.id.cardName);
        TextView TVDescription = (TextView) findViewById(R.id.cardDescription);
        TextView TVPlace = (TextView) findViewById(R.id.cardPlace);
        ToggleButton TBParticipation = (ToggleButton) findViewById(R.id.cardParticipation);

        // duration
        long diffInMillies = Math.abs(event.getDateEnd().getTime() - event.getDate().getTime());
        long diffDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        long diffHours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        long diffMinutes = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS) % 60;
        // if diff between start and end more than 24 hours, set days
        if (diffDays != 0) {
            String textDiffDays = Long.toString(diffDays);
            if (diffDays >= 10 && diffDays <= 20) {
                textDiffDays += " дней";
            } else if (diffDays % 10 == 1) {
                textDiffDays += " день";
            } else if (diffDays % 10 <= 4 && diffDays % 10 >= 2) {
                textDiffDays += " дня";
            } else {
                textDiffDays += " дней";
            }
            TVDuration.setText(textDiffDays);
        }
        // else if diff between start and end more than 60 minutes, set hours
        else if (diffHours != 0) {
            String textDiffHours = Long.toString(diffHours);
            if (diffHours >= 10 && diffHours <= 20) {
                textDiffHours += " часов";
            } else if (diffHours % 10 == 1) {
                textDiffHours += " час";
            } else if (diffHours % 10 <= 4 && diffHours % 10 >= 2) {
                textDiffHours += " часа";
            } else {
                textDiffHours += " часов";
            }
            if (diffMinutes != 0) {
                textDiffHours += " " + Long.toString(diffMinutes);
                if (diffMinutes >= 10 && diffMinutes <= 20) {
                    textDiffHours += " минут";
                } else if (diffMinutes % 10 == 1) {
                    textDiffHours += " минута";
                } else if (diffMinutes % 10 <= 4 && diffMinutes % 10 >= 2) {
                    textDiffHours += " минуты";
                } else {
                    textDiffHours += " минут";
                }
            }
            TVDuration.setText(textDiffHours);
        }
        // else set minutes
        else {
            String textDiffMinutes = Long.toString(diffMinutes);
            if (diffMinutes >= 10 && diffMinutes <= 20) {
                textDiffMinutes += " минут";
            } else if (diffMinutes % 10 == 1) {
                textDiffMinutes += " минута";
            } else if (diffMinutes % 10 <= 4 && diffMinutes % 10 >= 2) {
                textDiffMinutes += " минуты";
            } else {
                textDiffMinutes += " минут";
            }
            TVDuration.setText(textDiffMinutes);
        }

        // date  %tB %tY
        TVDate.setText(String.format("%td ", event.getDate()) +
                String.format("%tB ", event.getDate()) + Integer.toString(event.getDate().getYear()) +
                String.format(" %tR", event.getDate()));

        // countVisitors
        TVCountVisitors.setText(Integer.toString(event.getCountVisitors()));
        this.countVisitors = event.getCountVisitors();

        // name
        TVName.setText(event.getName());

        // description
        TVDescription.setText(event.getDescription());

        // place
        TVPlace.setText(event.getPlace());

        // participation
        TBParticipation.setChecked(event.getParticipation());
    }
}
