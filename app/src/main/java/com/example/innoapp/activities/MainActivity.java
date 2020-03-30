package com.example.innoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.adapter.TabsPagerFragmentAdapters;
import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder13;
import com.google.android.material.tabs.TabLayout;

import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    private TextView tvBarcode;
    private ViewPager mapsViewPager;
    private ImageView map1ImageView;
    private ImageView map2ImageView;
    private ImageView map3ImageView;

    public static String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sp.getString(LOGIN, "").equals(""))
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        tvBarcode = findViewById(R.id.tvBarcode);//штрих код
        initTabs();// инициализация табов
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/EanP72TtNormal.ttf");//шрифт штрих кода
        tvBarcode.setTypeface(font);//установка шрифта штрих кода
        EAN13CodeBuilder13 bb = new EAN13CodeBuilder13(code);//ввод значения штрих кода
        tvBarcode.setText(bb.getCode());
        map1ImageView = findViewById(R.id.map1ImageView);
        map2ImageView = findViewById(R.id.map2ImageView);
        map3ImageView = findViewById(R.id.map3ImageView);
        //настройки штрих кода
        RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(500, 350);
        layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParamsBarcode.addRule(RelativeLayout.CENTER_HORIZONTAL);
        tvBarcode.setLayoutParams(layoutParamsBarcode);
        tvBarcode.setPadding(0, 25, 0, 0);


    }

    private void initTabs() {
        TabLayout mapsTabLayout = findViewById(R.id.mapsTabLayout);
        mapsViewPager = findViewById(R.id.mapsViewPager);
        TabsPagerFragmentAdapters adapters = new TabsPagerFragmentAdapters(getSupportFragmentManager());
        mapsViewPager.setAdapter(adapters);
        mapsTabLayout.setupWithViewPager(mapsViewPager);
    }

    boolean barcodeScale = false;

    public void onButtonClickBarcode(View v) //зум штрих кода
    {
        float dp = getResources().getDisplayMetrics().density;
        if (barcodeScale) {
            tvBarcode.setTextSize(100);
            barcodeScale = false;

            RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(500, 350);
            layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParamsBarcode.addRule(RelativeLayout.CENTER_HORIZONTAL);
            tvBarcode.setLayoutParams(layoutParamsBarcode);
            tvBarcode.setPadding(0, 25, 0, 0);
        } else {
            tvBarcode.setTextSize(TypedValue.COMPLEX_UNIT_MM, 40);
            //tvBarcode.setTextSize(250);
            RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 725);
            layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParamsBarcode.addRule(RelativeLayout.CENTER_IN_PARENT);
            tvBarcode.setLayoutParams(layoutParamsBarcode);
            tvBarcode.setPadding(0, 50, 0, 0);
            barcodeScale = true;
        }

    }

    boolean mapBool1 = false;

    /*public void onButtonClickMap1(View v) {
        if (mapBool1) {
            RelativeLayout.LayoutParams layoutParamsMapUI = new RelativeLayout.LayoutParams(900, 700);
            map1ImageView.setLayoutParams(layoutParamsMapUI);

            mapBool1 = false;
        } else {

            RelativeLayout.LayoutParams layoutParamsMapUI = new RelativeLayout.LayoutParams(900, 700);
            map1ImageView.setLayoutParams(layoutParamsMapUI);
            mapBool1 = true;
        }
    }*/
}




