package com.example.innoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.innoapp.R;
import com.example.innoapp.fragments.FragmentTabEvents;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapterEvents extends RecyclerView.Adapter<DataAdapterEvents.DataAdapterHolderEvents> {
    private int viewHolderCount = 0;
    private String[] datesList;
    private String[] eventsList;
   // private String[] answers;
    private Context parent;

        public DataAdapterEvents(String[]d , String[]e, Context parent) {
        datesList = d;
            eventsList = e;
       // answers = a;
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

        public DataAdapterHolderEvents(@NonNull View itemView) {
            super(itemView);
            datesView = itemView.findViewById(R.id.datesView);
            eventsView = itemView.findViewById(R.id.eventsView);
            int position = getAdapterPosition();



        }

    }
}
