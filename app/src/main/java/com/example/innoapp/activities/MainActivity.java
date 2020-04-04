package com.example.innoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder;

import static com.example.innoapp.activities.LoginActivity.CODE;
import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    private TextView tvBarcode, txtDescriptionBarcode;
    public  static String code = "124958761310";
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
        // set barcode's font
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/EanP72TtNormal.ttf");
        tvBarcode.setTypeface(font);
        // sets barcode's value
        EAN13CodeBuilder bb = new EAN13CodeBuilder(code);
        tvBarcode.setText(bb.getCode());
        // barcode settings
        tvBarcode.setPadding(0, 20, 20, 20);
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

