package com.example.innoapp.fragments;

import com.example.innoapp.fragments.Event;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.innoapp.R;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {
    // Список карточек
    Event event;

    // Взятие экземпляра карточки
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CardViewHolder(CardView cv) {
            super(cv);
            cardView = cv;
        }
    }

    // Передача списка карточек
    public RVAdapter(Event event){
        this.event = event;
    }

    // Создание новой карточки по каркасу в cardview.xml
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new CardViewHolder(cv);
    }

    // Задание соответствующих атрибутов для конкретной карточки
    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int position) {
        // Взятие экземпляра карточки
        CardView cardView = cardViewHolder.cardView;
        // Взятие экземпляра названия события
        TextView cardName = (TextView)cardView.findViewById(R.id.cardName);
        // Установка загруженного названия для события
        cardName.setText(event.getName());
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}