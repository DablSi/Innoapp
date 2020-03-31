package com.example.innoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.adapter.TabsPagerFragmentAdapters;
import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder13;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.tabs.TabLayout;

import static com.example.innoapp.activities.LoginActivity.CODE;
import static com.example.innoapp.activities.LoginActivity.LOGIN;

public class MainActivity extends AppCompatActivity {

    private TextView tvBarcode;
    private ViewPager mapsViewPager;

    public static String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sp.getString(LOGIN, "").equals(""))
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        code = sp.getString(CODE, "");
        // barcode
        tvBarcode = findViewById(R.id.tvBarcode);
        // tabs initialisation
        initTabs();
        // barcode font
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/EanP72TtNormal.ttf");
        // sets the barcode
        tvBarcode.setTypeface(font);
        // sets barcode's value
        EAN13CodeBuilder13 bb = new EAN13CodeBuilder13(code);
        tvBarcode.setText(bb.getCode());
        // barcode settings
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

    // zooms barcode
    public void onButtonClickBarcode(View v) {
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
            RelativeLayout.LayoutParams layoutParamsBarcode = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 725);
            layoutParamsBarcode.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParamsBarcode.addRule(RelativeLayout.CENTER_IN_PARENT);
            tvBarcode.setLayoutParams(layoutParamsBarcode);
            tvBarcode.setPadding(0, 50, 0, 0);
            barcodeScale = true;
        }

    }

    public void zoomMap(View v) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
        PhotoView photoView = mView.findViewById(R.id.imageView);
        int id = v.getId();
        int res = R.drawable.firstf;
        if (id == R.id.map2ImageView) {
            res = R.drawable.secondf;
        } else if (id == R.id.map3ImageView) {
            res = R.drawable.thirdf;
        }
        photoView.setImageResource(res);
        mBuilder.setView(mView);
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}




