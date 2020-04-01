package com.example.innoapp.fragments;

import com.example.innoapp.fragments.Event;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.innoapp.R;

import java.util.Date;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    private Event[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public MyViewHolder(CardView v) {
            super(v);
            cardView = v;
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

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        // setting card parameters:
        // name
        TextView cardName = (TextView) holder.cardView.findViewById(R.id.cardName);
        cardName.setText(mDataset[position].getName());

        // date
        Date date = mDataset[position].getDate();
        String textDate = Integer.toString(date.getDay())+" " + Integer.toString(date.getMonth())
                + " " + Integer.toString(date.getYear());
        TextView cardDate = (TextView) holder.cardView.findViewById(R.id.cardDate);
        cardDate.setText(textDate);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}