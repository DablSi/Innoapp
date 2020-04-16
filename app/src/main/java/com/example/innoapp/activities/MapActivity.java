package com.example.innoapp.activities;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import static com.example.innoapp.activities.ProfileActivity.darkT;
import com.example.innoapp.R;
import com.example.innoapp.adapter.TabsPagerFragmentAdapters;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.tabs.TabLayout;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MapActivity extends AppCompatActivity {

    private final String MAPKIT_API_KEY = "f3853322-454d-46ca-bc44-7e018de1e1f2";
    private final Point TARGET_LOCATION = new Point(55.752080, 48.744609);

    private MapView mapView;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);
        setContentView(R.layout.map_activity);
        super.onCreate(savedInstanceState);
        TextView title = findViewById(R.id.mapTextView);
        title.setTypeface(Typeface.createFromAsset(this.getAssets(), "fonts/elektra_text_pro.otf"));
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
        initTabs();
    }


    @Override
    protected void onStop() {
        // stop all of the instances
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // start all of the instances
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }

    private void initTabs() {
        TabLayout mapsTabLayout = findViewById(R.id.mapsTabLayout);
        ViewPager mapsViewPager = findViewById(R.id.mapsViewPager);
        TabsPagerFragmentAdapters adapters = new TabsPagerFragmentAdapters(getSupportFragmentManager());
        mapsViewPager.setAdapter(adapters);
        mapsTabLayout.setupWithViewPager(mapsViewPager);
    }

    @SuppressLint("InflateParams")
    public void zoomMap(View v) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MapActivity.this);
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
    @Override
    public void onResume()
    {
        super.onResume();
        SetDarkT();
    }

    private void SetDarkT() {
        TabLayout mapsTabLayout = (TabLayout) findViewById(R.id.mapsTabLayout);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        TextView mapTextView = (TextView) findViewById(R.id.mapTextView);

        if(darkT)
        {
            mapsTabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.white), ContextCompat.getColor(this, R.color.white));
            mapsTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.inno_blue));
            mapsTabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            relativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.inno_dark_blue));
            back.setImageResource(R.drawable.back2);
            mapTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
        }
        else {
            relativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            mapsTabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            mapsTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorPrimary));
            mapsTabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.black));
            back.setImageResource(R.drawable.back);
            mapTextView.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
        ///
    }
}




