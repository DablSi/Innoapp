package com.example.innoapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.innoapp.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class VotesActivity extends Activity {
    public static LinkedList<Vote> vоtes;
    private LinearLayout voteLinearLayout;
    private int countID = 0;
    private boolean b1 = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes);
        voteLinearLayout = findViewById(R.id.voteLinearLayout);
        vоtes = new LinkedList<Vote>();
        vоtes.add(new Vote("Favourite season?", new String[]{"Winter", "Spring", "Summer", "Autumn"}, false));
        CreateVotes(vоtes);
    }

    private void CreateVotes(LinkedList<Vote> list) {
        for (Vote i : list) {
            ArrayList<RadioButton> radioButtonsArrayList = new ArrayList<RadioButton>(); // array for RadioButtons
            int[] voted = new int[i.variants.length];

            RelativeLayout relativeLayout1 = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeLayout1Params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            relativeLayout1Params.setMargins(0, 50, 0, 0);
            relativeLayout1.setLayoutParams(relativeLayout1Params);
            relativeLayout1.setBackgroundColor(getResources().getColor(R.color.white));
            voteLinearLayout.addView(relativeLayout1);

            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeLayout2Params = new RelativeLayout.LayoutParams(840, LinearLayout.LayoutParams.WRAP_CONTENT);
            relativeLayout2Params.addRule(RelativeLayout.CENTER_IN_PARENT);
            relativeLayout2.setLayoutParams(relativeLayout2Params);
            relativeLayout2.setBackgroundColor(getResources().getColor(R.color.inno_green));
            relativeLayout2.setBackgroundResource(R.drawable.rectangle);
            relativeLayout2.setPadding(25, 10, 0, 0);
            relativeLayout1.addView(relativeLayout2);
            relativeLayout1.setId(RelativeLayout.generateViewId());

            TextView voteTextView = new TextView(this);
            voteTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            voteTextView.setText(i.name);
            voteTextView.setTextSize(22);
            relativeLayout2.addView(voteTextView);
            voteTextView.setTextColor(getResources().getColor(R.color.white));
            voteTextView.setId(TextView.generateViewId());

            if (!i.multiple) {
                RadioGroup voteRadioGroup = new RadioGroup(this);
                RelativeLayout.LayoutParams voteRadioGroupParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                voteRadioGroupParams.addRule(RelativeLayout.BELOW, voteTextView.getId());
                voteRadioGroup.setLayoutParams(voteRadioGroupParams);
                voteRadioGroup.setPadding(0, 10, 0, 25);
                relativeLayout2.addView(voteRadioGroup);
                final int[] lastP = {-1};

                for (int j = 0; j < i.variants.length; j++) {
                    RadioButton voteRadioButton = new RadioButton(this);
                    RelativeLayout.LayoutParams voteRadioButtonParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    voteRadioButton.setLayoutParams(voteRadioButtonParams);
                    voteRadioButton.setText(i.variants[j]);
                    voteRadioButton.setTextColor(getResources().getColor(R.color.white));
                    voteRadioButton.setTextSize(17);
                    voteRadioGroup.addView(voteRadioButton);
                    radioButtonsArrayList.add(voteRadioButton);
                    voteRadioButton.setId(countID);
                    countID++;
                    int finalI2 = list.indexOf(i);
                    int finalI = j;
                    voteRadioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (lastP[0] > -1) {
                                if (lastP[0] != finalI) {
                                    voted[lastP[0]] = voted[lastP[0]] - 1;
                                    voted[finalI] = voted[finalI] + 1;
                                }
                            } else {
                                voted[finalI] = voted[finalI] + 1;
                            }
                            lastP[0] = finalI;
                            for (int k = 0; k < list.get(finalI2).variants.length; k++) {
                                radioButtonsArrayList.get(k).setText(list.get(finalI2).variants[k] + "           " + voted[k]);
                            }
                        }
                    });
                }
            } else {
                // здесь ты делаешь CheckBox :^)
            }

        }

        ImageView imageView1 = new ImageView(this);
        RelativeLayout.LayoutParams imageView1Params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imageView1Params.setMargins(0, 50, 0, 0);
        imageView1.setLayoutParams(imageView1Params);
        imageView1.setImageResource(R.drawable.profile_image1);
        voteLinearLayout.addView(imageView1);
    }

    class Vote {
        String name;
        String[] variants;
        boolean multiple;

        public Vote(String name, String[] variants, boolean multiple) {
            this.name = name;
            this.variants = variants;
            this.multiple = multiple;
        }
    }
}