package com.example.innoapp.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.innoapp.R;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.innoapp.activities.ProfileActivity.darkT;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataAdapterHolder> {
    private int viewHolderCount = 0;
    private String[] questions;
    private String[] answers;
    private Context parent;

    public DataAdapter(String[] q, String[] a, Context parent) {
        questions = q;
        answers = a;
        this.parent = parent;
    }

    @NonNull
    @Override
    public DataAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdQuestions = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdQuestions, parent, false);
        DataAdapterHolder viewHolder = new DataAdapterHolder(view);
        try {
            viewHolder.questionView.setText(questions[viewHolderCount]);
            viewHolderCount++;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return questions.length;
    }

    class DataAdapterHolder extends RecyclerView.ViewHolder {

        TextView questionView;
        TextView answerView;
        ImageView imageCheck;

        public DataAdapterHolder(@NonNull View itemView) {
            super(itemView);
            questionView = itemView.findViewById(R.id.questionView);
            answerView = itemView.findViewById(R.id.answerView);
            imageCheck = itemView.findViewById(R.id.imageCheck);
            int position = getAdapterPosition();
            if(darkT)
            {
                questionView.setTextColor(Color.parseColor("#FFFFFF"));
                imageCheck.setImageResource(R.drawable.check_mark3);
            }
            else
            {
                questionView.setTextColor(Color.parseColor("#000000"));
                imageCheck.setImageResource(R.drawable.check_mark1);
            }


            itemView.setOnClickListener(new View.OnClickListener() {
                boolean answerI = false;
                int lastPosition;

                @Override
                public void onClick(View v) {
                    int positionIndex = getAdapterPosition();
                    if (answerI) {
                        answerView.setText("");
                        if(darkT) {
                            imageCheck.setImageResource(R.drawable.check_mark3);
                        }
                        else {
                            imageCheck.setImageResource(R.drawable.check_mark1);
                        }
                        answerI = false;

                    } else {
                        answerView.setText(answers[positionIndex]);
                        lastPosition = positionIndex;
                        if(darkT) {
                            imageCheck.setImageResource(R.drawable.check_mark4);
                        }
                        else {
                            imageCheck.setImageResource(R.drawable.check_mark2);
                        }
                        answerI = true;
                    }

                }
            });
        }

    }
}