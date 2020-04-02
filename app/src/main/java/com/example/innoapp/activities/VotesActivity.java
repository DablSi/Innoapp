package com.example.innoapp.activities;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.innoapp.R;
import com.example.innoapp.fragments.VoteFragment;

public class VotesActivity extends Activity
{
    private LinearLayout voteLinearLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes);
        voteLinearLayout = (LinearLayout) findViewById(R.id.voteLinearLayout);

        //
        RelativeLayout relativeLayout1 = new RelativeLayout(this);
        relativeLayout1.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 500
        ));
        relativeLayout1.setBackgroundColor(getResources().getColor(R.color.inno_dark_green));
        voteLinearLayout.addView(relativeLayout1);

    }
}
