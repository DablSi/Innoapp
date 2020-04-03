package com.example.innoapp.fragments;

import com.example.innoapp.activities.Events;
import com.example.innoapp.fragments.Event;

import android.content.Context;
import android.system.Int64Ref;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.innoapp.R;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    private Event[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        // This vars is need to work with concrete card
        int currentCardPosition;
        Context mContext;

        public MyViewHolder(CardView v, Context context) {
            super(v);
            cardView = v;

            // Listener of buttons
            mContext=context;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if(mContext instanceof Events){
                        ((Events)mContext).OpenDescription();
                    }
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RVAdapter(Event[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        MyViewHolder vh = new MyViewHolder(v,v.getContext());
        return new MyViewHolder(v, v.getContext());
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.currentCardPosition = position;
        if(position<getItemCount()) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            // setting card parameters:
            // name
            TextView cardName = (TextView) holder.cardView.findViewById(R.id.cardName);
            cardName.setText(mDataset[position].getName());

            // description
            // NEXUS 5X 33 liters - 1 string
            // NEXUS 5X 16.5dp - 1 string
            TextView cardDescription = (TextView) holder.cardView.findViewById(R.id.cardDescription);
            String description = mDataset[position].getDescription();
            cardDescription.setText(description);

            // date
            Date date = mDataset[position].getDate();
            String textDate = Integer.toString(date.getDay()) + " " + Integer.toString(date.getMonth())
                    + " " + Integer.toString(date.getYear());
            TextView cardDate = (TextView) holder.cardView.findViewById(R.id.cardDate);
            cardDate.setText(textDate);

            // time
            Date Time = mDataset[position].getDate();
            String textTime = Integer.toString(date.getHours()) + ":" + Integer.toString(date.getMinutes());
            TextView cardTime = (TextView) holder.cardView.findViewById(R.id.cardTime);
            cardTime.setText(textTime);

            // duration
            Date dateEnd = mDataset[position].getDateEnd();
            Date dateStart = mDataset[position].getDate();
            // time-difference
            long diffInMillies = Math.abs(dateEnd.getTime() - dateStart.getTime());
            long diffDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            long diffHours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            long diffMinutes = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
            TextView cardDuration = (TextView) holder.cardView.findViewById(R.id.cardDuration);
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
                cardDuration.setText(textDiffDays);
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
                cardDuration.setText(textDiffHours);
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
                cardDuration.setText(textDiffMinutes);
            }

            // place
            TextView cardPlace = (TextView) holder.cardView.findViewById(R.id.cardPlace);
            cardPlace.setText(mDataset[position].getPlace());

            // countVisitors
            TextView cardCountVisitors = (TextView) holder.cardView.findViewById(R.id.cardCountVisitors);
            int countVisitors = mDataset[position].getCountVisitors();
            String textCountVisitors = Long.toString(countVisitors);
            if (countVisitors >= 10 && countVisitors <= 20) {
                textCountVisitors += " человек";
            } else if (countVisitors % 10 <= 4 && countVisitors % 10 >= 2) {
                textCountVisitors += " человека";
            } else {
                textCountVisitors += " человек";
            }
            cardCountVisitors.setText(textCountVisitors);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}