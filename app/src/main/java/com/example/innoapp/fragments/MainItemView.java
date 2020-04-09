package com.example.innoapp.fragments;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.innoapp.adapter.MainStepperAdapter;
import com.example.innoapp.R;
public class MainItemView extends LinearLayout {
    String [] itemsList;
    String [] dateList;
    int itemPosition;
    public MainItemView( Context context, String[] array1, String[] array2, int position) {
        super( context );
        itemsList = array2;
        dateList = array1;
        itemPosition = position;
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