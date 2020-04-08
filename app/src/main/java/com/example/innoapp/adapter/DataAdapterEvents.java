package com.example.innoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.innoapp.R;
import com.example.innoapp.fragments.Event;
import com.example.innoapp.fragments.FragmentTabEvents;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;



public class DataAdapterEvents extends RecyclerView.Adapter<DataAdapterEvents.DataAdapterHolderEvents> {
    private int viewHolderCount = 0;
    private String[] datesList;
    private String[] eventsList;
    private int numTab;
    private Context parent;

        public DataAdapterEvents(String[]d , String[]e, int numTab, Context parent) {
        datesList = d;
        eventsList = e;
        this.numTab = numTab-1;
        this.parent = parent;
    }

    @NonNull
    @Override
    public DataAdapterEvents.DataAdapterHolderEvents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdQuestions = R.layout.list_iten_events;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdQuestions, parent, false);
        DataAdapterEvents.DataAdapterHolderEvents viewHolder = new DataAdapterEvents.DataAdapterHolderEvents(view);
        try {
            viewHolder.datesView.setText(datesList[viewHolderCount]);
            viewHolder.eventsView.setText(eventsList[viewHolderCount]);
            // set id for event on this tab (it need for opening card)
            viewHolder.eventId.setText(Integer.toString(viewHolderCount));
            viewHolder.eventTabId.setText(Integer.toString(numTab));
            viewHolderCount++;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterHolderEvents holder, int position) {

    }


    @Override
    public int getItemCount() {
        return datesList.length;
    }

    class DataAdapterHolderEvents extends RecyclerView.ViewHolder {

        TextView datesView;
        TextView eventsView;
        TextView eventId;
        TextView eventTabId;
        RelativeLayout relativeLayout;

        public DataAdapterHolderEvents(@NonNull View itemView) {
            super(itemView);
            datesView = itemView.findViewById(R.id.datesView);
            eventsView = itemView.findViewById(R.id.eventsView);
            eventId = itemView.findViewById(R.id.eventId);
            eventTabId = itemView.findViewById(R.id.eventTabId);
            relativeLayout = itemView.findViewById(R.id.rl);
            int position = getAdapterPosition();



        }

    }
}

