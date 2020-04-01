package com.example.innoapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.innoapp.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataAdapterHolder> {
    private static int viewHolderCount = 0;
    private String[] Questions;
    private String[] Answers;
    private Context parent;
    public DataAdapter(String[] q, String[] a, Context parent)
    {
        Questions = q;
        Answers = a;
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
        viewHolder.questionView.setText(Questions[viewHolderCount]);
        viewHolderCount++;

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Questions.length;
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


            itemView.setOnClickListener(new View.OnClickListener()
            {
                boolean answerI = false;
                int lastPosition;
                @Override
                public void onClick(View v) {
                   int positionIndex = getAdapterPosition();
                    if(answerI)
                    {
                        answerView.setText("");
                        imageCheck.setImageResource(R.drawable.check_mark1);
                        answerI = false;

                    }
                    else
                    {
                        answerView.setText(Answers[positionIndex]);
                        lastPosition = positionIndex;
                        imageCheck.setImageResource(R.drawable.check_mark2);
                        answerI = true;
                    }

                    //answerView.setText(Answers[positionIndex]);
                }
            });
        }
        void bind(String textQuestion)
        {
            questionView.setText(textQuestion);
        }
    }
}