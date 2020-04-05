package com.example.innoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static com.example.innoapp.activities.LoginActivity.CODE;
import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    private TextView tvBarcode, txtDescriptionBarcode;
    public static String code = "124958761310";
    private boolean barcodeScale = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sp.getString(LOGIN, "").equals(""))
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        code = sp.getString(CODE, "124958761310");
        // barcode
        tvBarcode = findViewById(R.id.tvBarcode);
        txtDescriptionBarcode = findViewById(R.id.txt_description_barcode);
        FloatingActionButton fabSettings = findViewById(R.id.fab_setting);
        CardView btnMaps = findViewById(R.id.btn_maps);
        CardView btnFAQ = findViewById(R.id.btn_faq);
        CardView btnSchedule = findViewById(R.id.btn_schedule);
        CardView btnVoting = findViewById(R.id.btn_voting);
        // set barcode's font
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/EanP72TtNormal.ttf");
        tvBarcode.setTypeface(font);
        // sets barcode's value
        EAN13CodeBuilder bb = new EAN13CodeBuilder(code);
        tvBarcode.setText(bb.getCode());
        // barcode settings
        tvBarcode.setPadding(0, 20, 20, 20);
        fabSettings.setOnClickListener(view -> Snackbar.make(view, "This section is still in development", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        btnSchedule.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Events.class)));
        btnVoting.setOnClickListener(view -> Snackbar.make(view, "This section is still in development", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        btnFAQ.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FAQActivity.class)));
        btnMaps.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MapActivity.class)));

    }

    // zooms barcode
    public void onButtonClickBarcode(View v) {
        if (barcodeScale) {
            txtDescriptionBarcode.setTextSize(18);
            tvBarcode.setTextSize(120);
            barcodeScale = false;
            tvBarcode.setPadding(0, 20, 20, 20);
        } else {
            txtDescriptionBarcode.setTextSize(0);
            tvBarcode.setTextSize(200);
            tvBarcode.setPadding(0, 20, 20, 20);
            barcodeScale = true;
        }
    }
}

