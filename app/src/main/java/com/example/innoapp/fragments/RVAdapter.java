package com.example.innoapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.innoapp.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {
    // Список карточек
    List cards;

    // Взятие экземпляра карточки
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CardViewHolder(CardView cv) {
            super(cv);
            cardView = cv;
        }
    }

    // Передача списка карточек
    RVAdapter(List cards){
        this.cards = cards;
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
        cardName.setText(cards.get(position).getName());
        TextView content = (TextView)cardView.findViewById(R.id.content);
        content.setText(cards.get(position).content);

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}