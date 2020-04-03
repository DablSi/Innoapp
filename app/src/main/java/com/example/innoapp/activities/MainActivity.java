package com.example.innoapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.innoapp.adapter.TabsPagerFragmentAdapters;
import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder13;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.tabs.TabLayout;

import static com.example.innoapp.activities.LoginActivity.CODE;
import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    private TextView tvBarcode;
    public static String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        if (sp.getString(LOGIN, "").equals(""))
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        code = sp.getString(CODE, "");
//        // barcode
//        tvBarcode = findViewById(R.id.tvBarcode);
//        // barcode font
//        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/EanP72TtNormal.ttf");
//        // sets the barcode
//        tvBarcode.setTypeface(font);
//        // sets barcode's value
//        EAN13CodeBuilder13 bb = new EAN13CodeBuilder13(code);
//        tvBarcode.setText(bb.getCode());
//        // barcode settings
//        RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(500, 350);
//        layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        layoutParamsBarcode.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        tvBarcode.setLayoutParams(layoutParamsBarcode);
//        tvBarcode.setPadding(0, 25, 0, 0);
    }



//    boolean barcodeScale = false;
//
//    // zooms barcode
//    public void onButtonClickBarcode(View v) {
//        if (barcodeScale) {
//            tvBarcode.setTextSize(100);
//            barcodeScale = false;
//
//            RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(500, 350);
//            layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//            layoutParamsBarcode.addRule(RelativeLayout.CENTER_HORIZONTAL);
//            tvBarcode.setLayoutParams(layoutParamsBarcode);
//            tvBarcode.setPadding(0, 25, 0, 0);
//        } else {
//            tvBarcode.setTextSize(TypedValue.COMPLEX_UNIT_MM, 40);
//            RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 725);
//            layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//            layoutParamsBarcode.addRule(RelativeLayout.CENTER_IN_PARENT);
//            tvBarcode.setLayoutParams(layoutParamsBarcode);
//            tvBarcode.setPadding(0, 50, 0, 0);
//            barcodeScale = true;
//        }
//
//    }
}

