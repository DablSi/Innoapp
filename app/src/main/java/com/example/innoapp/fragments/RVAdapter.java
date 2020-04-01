package com.example.innoapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.innoapp.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {
    // List of cards
    List cards;

    // Take a card object
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CardViewHolder(CardView cv) {
            super(cv);
            cardView = cv;
        }
    }

    // Card List Transfer
    RVAdapter(List cards){
        this.cards = cards;
    }

    // Create new card by cardview.xml
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new CardViewHolder(cv);
    }

    // Setting attributes for a card
    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int position) {
        // get card
        CardView cardView = cardViewHolder.cardView;
        // get event name
        TextView cardName = (TextView)cardView.findViewById(R.id.cardName);
        // set event name
        cardName.setText(cards.get(position).getName());
        TextView content = (TextView)cardView.findViewById(R.id.content);
        content.setText(cards.get(position).content);

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
