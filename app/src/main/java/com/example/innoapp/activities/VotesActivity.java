package com.example.innoapp.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.innoapp.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class VotesActivity extends Activity {
    public static LinkedList<Vote> vоtes;
    private LinearLayout voteLinearLayout;
    private int countID = 0;
    private boolean b1 = false;
    String[] groupsS = {"NTI", "Школа по информатике"};
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

    private void CreateSpinner(String[] sGroups) {
        Spinner groups = (Spinner) findViewById(R.id.groups);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_text, groupsS);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        groups.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                voteLinearLayout.removeAllViews();
                // Получаем выбранный объект
                vоtes.removeAll(vоtes);
                String item = (String) parent.getItemAtPosition(position);
                switch (item) {
                    case ("NTI"):
                        vоtes.add(new Vote("Любимое время года?", new String[]{"Зима", "Весна", "Лето", "Осень"}, false));
                        vоtes.add(new Vote("Любимое время года?", new String[]{"Зима", "Весна", "Лето", "Осень"}, true));
                        vоtes.add(new Vote("Любимое время года?", new String[]{"Зима", "Весна", "Лето", "Осень"}, true));
                        CreateVotes(vоtes);
                        break;
                    case ("Школа по информатике"):
                        vоtes.add(new Vote("Любимый палец?", new String[]{"Мизинец", "Безымянный", "Средний", "Указательный", "Большой"}, false));
                        vоtes.add(new Vote("Любимый палец?", new String[]{"Мизинец", "Безымянный", "Средний", "Указательный", "Большой"}, true));
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
            relativeLayout1.setBackgroundColor(getResources().getColor(R.color.white));
            voteLinearLayout.addView(relativeLayout1);

            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeLayout2Params = new RelativeLayout.LayoutParams(920, LinearLayout.LayoutParams.WRAP_CONTENT);
            relativeLayout2Params.addRule(RelativeLayout.CENTER_IN_PARENT);
            relativeLayout2.setLayoutParams(relativeLayout2Params);
            relativeLayout2.setBackgroundColor(getResources().getColor(R.color.inno_green));
            relativeLayout2.setBackgroundResource(R.drawable.rectangle);
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
                    RadioButton voteRadioButton = new RadioButton(this);
                    RelativeLayout.LayoutParams voteRadioButtonParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    voteRadioButton.setLayoutParams(voteRadioButtonParams);
                    voteRadioButton.setText(i.variants[j]);
                    voteRadioButton.setTextColor(getResources().getColor(R.color.white));
                    voteRadioButton.setTextSize(17);
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
                    CheckBox voteCheckBox = new CheckBox(this);
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