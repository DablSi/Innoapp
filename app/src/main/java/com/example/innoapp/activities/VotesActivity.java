package com.example.innoapp.activities;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.innoapp.R;
import com.example.innoapp.fragments.VoteFragment;

import java.util.ArrayList;

public class VotesActivity extends Activity
{
    private String[][] vоtes = {{"Голосование 1231","23","26"}, {"Голосование 12321","23a","26","любая длинаааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааап"},{"Голосова21212ние 12321","23a","26","любая длинаааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааап"}};
    private LinearLayout voteLinearLayout;
    private int countID = 0;
    private boolean b1 = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes);
        voteLinearLayout = (LinearLayout) findViewById(R.id.voteLinearLayout);;
        CreateVotes(vоtes);

    }
    private void CreateVotes(String [] [] array){
        for (int i1 = 0; i1 < array.length; i1++) {
            //
            //
            int[] myArray = new int[array[i1].length - 1]; // array for Checked Changed
            //
            //
            ArrayList<RadioButton> radioButtonsArrayList = new ArrayList<RadioButton>(); // array for RadioButtons
            //
            RelativeLayout relativeLayout1 = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeLayout1Params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            relativeLayout1Params.setMargins(0,50,0,0);
            relativeLayout1.setLayoutParams(relativeLayout1Params);
            relativeLayout1.setBackgroundColor(getResources().getColor(R.color.white));
            voteLinearLayout.addView(relativeLayout1);
            //
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeLayout2Params = new RelativeLayout.LayoutParams(840, LinearLayout.LayoutParams.WRAP_CONTENT);
            relativeLayout2Params.addRule(RelativeLayout.CENTER_IN_PARENT);
            relativeLayout2.setLayoutParams(relativeLayout2Params);
            relativeLayout2.setBackgroundColor(getResources().getColor(R.color.inno_green));
            relativeLayout1.addView(relativeLayout2);
            relativeLayout1.setId(RelativeLayout.generateViewId());
            //
            TextView voteTextView = new TextView(this);
            voteTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            voteTextView.setText(array[i1][0]);
            voteTextView.setTextSize(22);
            relativeLayout2.addView(voteTextView);
            voteTextView.setTextColor(getResources().getColor(R.color.white));
            voteTextView.setId(TextView.generateViewId());
            //
            RadioGroup voteRadioGroup = new RadioGroup(this);
            RelativeLayout.LayoutParams voteRadioGroupParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            voteRadioGroupParams.addRule(RelativeLayout.BELOW, voteTextView.getId());
            voteRadioGroup.setLayoutParams(voteRadioGroupParams);
            relativeLayout2.addView(voteRadioGroup);
            final boolean[] b = {false};
            //
            for (int i2 = 1; i2 < array[i1].length; i2++) {
                RadioButton voteRadioButton = new RadioButton(this);
                RelativeLayout.LayoutParams voteRadioButtonParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                voteRadioButton.setLayoutParams(voteRadioButtonParams);
                voteRadioButton.setText(array[i1][i2]);
                voteRadioButton.setTextColor(getResources().getColor(R.color.white));
                voteRadioButton.setTextSize(17);
                voteRadioGroup.addView(voteRadioButton);
                radioButtonsArrayList.add(voteRadioButton);
                voteRadioButton.setId(countID);
                countID++;
                int finalI2 = i1;
                int finalI = i2;
                voteRadioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(b[0] == false)
                        {
                        myArray[finalI - 1] = myArray[finalI - 1] + 1;
                        b[0] = true;
                        }
                        for (int i3 = 1; i3 <  array[finalI2].length; i3++)
                        {
                            radioButtonsArrayList.get(i3 - 1).setText(array[finalI2][i3] + "           " + Integer.toString(myArray[i3 - 1]));
                        }
                    }
                });//
            }

        }


    }
}
