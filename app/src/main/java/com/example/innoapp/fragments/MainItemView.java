package com.example.innoapp.fragments;
import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.innoapp.adapter.MainStepperAdapter;
import com.example.innoapp.R;

import static com.example.innoapp.activities.ProfileActivity.darkT;

public class MainItemView extends LinearLayout {
    String [] itemsList;
    String [] dateList;
    int itemPosition;
    int tabId;
    public MainItemView( Context context, String[] array1, String[] array2, int position, int newTabId) {
        super( context );
        itemsList = array2;
        dateList = array1;
        itemPosition = position;
        tabId = newTabId;
        initialize( context );
    }

    public MainItemView( Context context,  AttributeSet attrs ) {
        super( context, attrs );
        initialize( context );
    }

    public MainItemView(
            Context context,
            AttributeSet attrs,
            int defStyleAttr ) {
        super( context, attrs, defStyleAttr );
        initialize( context );
    }

    private void initialize( Context context ) {
        setClipChildren( true );
        setOrientation( VERTICAL );
        LayoutInflater.from( context ).inflate( R.layout.item, this, true );
        TextView itemDates = (TextView) findViewById(R.id.itemDates);
        itemDates.setText(dateList[itemPosition]);
        TextView itemEvents = (TextView) findViewById(R.id.itemEvents);
        itemEvents.setText(itemsList[itemPosition]);
        TextView itemId = (TextView) findViewById(R.id.eventId);
        itemId.setText(Integer.toString(itemPosition));
        TextView itemTabId = (TextView) findViewById(R.id.eventTabId);
        RelativeLayout itemRelativeLayout = (RelativeLayout) findViewById(R.id.itemRelativeLayout);
        itemTabId.setText(Integer.toString(tabId));
        if(darkT)
        {
            itemRelativeLayout.setBackgroundResource(R.drawable.scheldue2);;
            itemDates.setTextColor(Color.parseColor("#FFFFFF"));
            itemEvents.setTextColor(Color.parseColor("#FFFFFF"));
            itemId.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else {
            itemRelativeLayout.setBackgroundResource(R.drawable.schedule);;
            itemDates.setTextColor(Color.parseColor("#000000"));
            itemEvents.setTextColor(Color.parseColor("#000000"));
            itemId.setTextColor(Color.parseColor("#000000"));
        }


    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Log.wtf( "WTF", "Saving MainItemView state" );
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState( Parcelable state ) {
        Log.wtf( "WTF", "Restoring MainItemView state" );
        super.onRestoreInstanceState( state );
    }
}