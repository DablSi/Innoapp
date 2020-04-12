package com.example.innoapp.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.content.ContextCompat;

import com.example.innoapp.R;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.innoapp.activities.ProfileActivity.darkT;

public class VotesActivity extends Activity {
    public static LinkedList<Vote> vоtes;
    private LinearLayout voteLinearLayout;
    private int countID = 0;
    private boolean b1 = false;
    String[] groupsS = {"Group 1", "Group 2", "Group 3", "Group 4", "Group 5", "Group 6"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes);
        ImageView back = findViewById(R.id.back);
        TextView title = findViewById(R.id.text1);
        title.setTypeface(Typeface.createFromAsset(this.getAssets(), "fonts/elektra_text_pro.otf"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        voteLinearLayout = (LinearLayout) findViewById(R.id.voteLinearLayout);
        vоtes = new LinkedList<Vote>();
        CreateSpinner(groupsS);
    }
    public void onResume()
    {
        super.onResume();
        SetDarkT();
    }

    private void SetDarkT() {
        TextView text1 = (TextView) findViewById(R.id.text1);
        RelativeLayout relativeLayoutVotes = (RelativeLayout) findViewById(R.id.relativeLayoutVotes);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        ScrollView scrollView1 = (ScrollView) findViewById(R.id.scrollView1);
        Spinner groups = (Spinner) findViewById(R.id.groups);
        ImageButton back = (ImageButton) findViewById(R.id.back);

        if(darkT)
        {
            text1.setTextColor(ContextCompat.getColor(this, R.color.white));
            relativeLayoutVotes.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            linearLayout1.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            scrollView1.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            groups.setBackgroundResource(R.drawable.spinner2);
            back.setImageResource(R.drawable.back2);
        }
        else{
            back.setImageResource(R.drawable.back);
            text1.setTextColor(ContextCompat.getColor(this, R.color.black));
            relativeLayoutVotes.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            linearLayout1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            scrollView1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            groups.setBackgroundResource(R.drawable.spinner);
        }
    }

    private void CreateSpinner(String[] sGroups) {
        Spinner groups = (Spinner) findViewById(R.id.groups);
        ArrayAdapter<String> adapter;
        if (darkT){
            adapter = new ArrayAdapter<String>(this, R.layout.spinner_text2, groupsS);
        }
        else{
             adapter = new ArrayAdapter<String>(this, R.layout.spinner_text, groupsS);
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groups.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                voteLinearLayout.removeAllViews();
                // Получаем выбранный объект
                vоtes.removeAll(vоtes);
                String item = (String) parent.getItemAtPosition(position);
                switch (item) {
                    case ("Group 1"):
                        vоtes.add(new Vote("Favourite season?", new String[]{"Winter", "Spring", "Summer", "Autumn"}, false));
                        vоtes.add(new Vote("Favourite season?", new String[]{"Winter", "Spring", "Summer", "Autumn"}, true));
                        vоtes.add(new Vote("Favourite season?", new String[]{"Winter", "Spring", "Summer", "Autumn"}, true));
                        CreateVotes(vоtes);
                        break;
                    case ("Group 2"):
                        vоtes.add(new Vote("Favourite season124?", new String[]{"Win314ter", "Spr134ing", "Sum4mer", "Autumn"}, false));
                        vоtes.add(new Vote("Favourite season1241?", new String[]{"Win134ter", "Spri134ng", "Sum134mer", "Aut4umn"}, true));
                        CreateVotes(vоtes);
                        break;
                    case ("Group 3"):
                        vоtes.add(new Vote("favourite season?125125126236", new String[]{"Winter", "Spring", "Summer", "Autumn"}, false));
                        vоtes.add(new Vote("Favourite season?", new String[]{"Winter", "Spring", "Summer", "Autumn"}, true));
                        CreateVotes(vоtes);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        groups.setOnItemSelectedListener(itemSelectedListener);
    }

    @SuppressLint("RestrictedApi")
    private void CreateVotes(LinkedList<Vote> list) {
        Typeface elektra = Typeface.createFromAsset(this.getAssets(), "fonts/elektra_text_pro.otf");
        for (Vote i : list) {
            ArrayList<RadioButton> radioButtonsArrayList = new ArrayList<RadioButton>(); // array for RadioButtons
            ArrayList<CheckBox> checkBoxArrayList = new ArrayList<CheckBox>();
            int[] voted = new int[i.variants.length];
            RelativeLayout relativeLayout1 = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeLayout1Params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            relativeLayout1Params.setMargins(0, 50, 0, 0);
            relativeLayout1.setLayoutParams(relativeLayout1Params);
            if(darkT) {
                relativeLayout1.setBackgroundColor(getResources().getColor(R.color.inno_dark_blue));
            }
            else {
                relativeLayout1.setBackgroundColor(getResources().getColor(R.color.white));
            }

            voteLinearLayout.addView(relativeLayout1);

            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeLayout2Params = new RelativeLayout.LayoutParams(920, LinearLayout.LayoutParams.WRAP_CONTENT);
            relativeLayout2Params.addRule(RelativeLayout.CENTER_IN_PARENT);
            relativeLayout2.setLayoutParams(relativeLayout2Params);

            if(darkT) {
                relativeLayout2.setBackgroundResource(R.drawable.rectangle3);
            }
            else {
                relativeLayout2.setBackgroundResource(R.drawable.rectangle);
            }
            relativeLayout2.setPadding(25, 10, 0, 25);
            relativeLayout1.addView(relativeLayout2);
            relativeLayout1.setId(RelativeLayout.generateViewId());

            TextView voteTextView = new TextView(this);
            voteTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            voteTextView.setText(i.name);
            voteTextView.setTextSize(22);
            voteTextView.setPadding(0, 0, 0, 10);
            voteTextView.setTypeface(elektra);
            relativeLayout2.addView(voteTextView);
            voteTextView.setTextColor(getResources().getColor(R.color.white));
            voteTextView.setId(TextView.generateViewId());
            final int[] lastP = {-1};
            if (!i.multiple) {
                RadioGroup voteRadioGroup = new RadioGroup(this);
                RelativeLayout.LayoutParams voteRadioGroupParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                voteRadioGroupParams.addRule(RelativeLayout.BELOW, voteTextView.getId());
                voteRadioGroup.setLayoutParams(voteRadioGroupParams);
                relativeLayout2.addView(voteRadioGroup);


                for (int j = 0; j < i.variants.length; j++) {
                    AppCompatRadioButton voteRadioButton = new AppCompatRadioButton(this);
                    RelativeLayout.LayoutParams voteRadioButtonParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    voteRadioButton.setLayoutParams(voteRadioButtonParams);
                    voteRadioButton.setText(i.variants[j]);
                    voteRadioButton.setTextColor(getResources().getColor(R.color.white));
                    voteRadioButton.setTextSize(17);
                    ColorStateList colorStateList = new ColorStateList(
                            new int[][]{
                                    new int[]{android.R.attr.state_enabled} //enabled
                            },
                            new int[] {getResources().getColor(R.color.white) }
                    );
                    voteRadioButton.setSupportButtonTintList(colorStateList);
                    voteRadioGroup.addView(voteRadioButton);
                    radioButtonsArrayList.add(voteRadioButton);
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
                for (int j = 0; j < i.variants.length; j++) {
                    AppCompatCheckBox voteCheckBox = new AppCompatCheckBox(this);
                    RelativeLayout.LayoutParams voteCheckBoxParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    if (j > 0) {
                        voteCheckBoxParams.addRule(RelativeLayout.BELOW, checkBoxArrayList.get(j - 1).getId());
                    } else {
                        voteCheckBoxParams.addRule(RelativeLayout.BELOW, voteTextView.getId());
                    }
                    voteCheckBox.setLayoutParams(voteCheckBoxParams);
                    voteCheckBox.setText(i.variants[j]);
                    voteCheckBox.setTextColor(getResources().getColor(R.color.white));
                    voteCheckBox.setTextSize(17);
                    ColorStateList colorStateList = new ColorStateList(
                            new int[][]{
                                    new int[]{android.R.attr.state_enabled} //enabled
                            },
                            new int[] {getResources().getColor(R.color.white) }
                    );
                    voteCheckBox.setSupportButtonTintList(colorStateList);
                    voteCheckBox.setTypeface(elektra);
                    relativeLayout2.addView(voteCheckBox);
                    voteCheckBox.setId(CheckBox.generateViewId());
                    checkBoxArrayList.add(voteCheckBox);
                    int finalI2 = list.indexOf(i);
                    int finalI = j;
                    final boolean[] ch = {false};
                    voteCheckBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (ch[0]) {
                                voted[finalI] = voted[finalI] - 1;
                                ch[0] = false;
                            } else {
                                voted[finalI] = voted[finalI] + 1;
                                ch[0] = true;
                            }
                            lastP[0] = finalI;
                            for (int k = 0; k < list.get(finalI2).variants.length; k++) {
                                checkBoxArrayList.get(k).setText(list.get(finalI2).variants[k] + "           " + voted[k]);
                            }
                        }
                    });
                }

            }
        }
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