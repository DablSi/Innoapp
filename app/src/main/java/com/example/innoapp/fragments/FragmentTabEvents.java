package com.example.innoapp.fragments;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innoapp.R;
import com.example.innoapp.activities.Events;
import com.example.innoapp.adapter.DataAdapter;
import com.example.innoapp.adapter.DataAdapterEvents;
import com.example.innoapp.adapter.MainStepperAdapter;
import com.liefery.android.vertical_stepper_view.VerticalStepperView;

import java.util.LinkedList;
import static com.example.innoapp.activities.Events.datesInList1;
import static com.example.innoapp.activities.Events.eList;
import static com.example.innoapp.activities.Events.eventsInList1;

public class FragmentTabEvents extends Fragment {
    public static LinkedList<Events.EventList1> eList2;
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private static String[] datesList;
    private static String[] eventList;
    private Context context = null;
    private DataAdapterEvents adapter;

    public static FragmentTabEvents newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentTabEvents fragment = new FragmentTabEvents();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        switch (mPage) {
            case 1:
            View view1 = inflater.inflate(R.layout.fragment_tab_events, container, false);
            VerticalStepperView eventsList1 = (VerticalStepperView) view1;
            eventsList1.setStepperAdapter( new MainStepperAdapter( context, datesInList1[0], eventsInList1[0]));
            return view1;
            case 2:
                View view2 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList2 = (VerticalStepperView) view2;
                eventsList2.setStepperAdapter( new MainStepperAdapter( context, datesInList1[1], eventsInList1[1]));
                return view2;
            case 3:
                View view3 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList3 = (VerticalStepperView) view3;
                eventsList3.setStepperAdapter( new MainStepperAdapter( context, datesInList1[2], eventsInList1[2]));
                return view3;
            case 4:
                View view4 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList4 = (VerticalStepperView) view4;
                eventsList4.setStepperAdapter( new MainStepperAdapter( context, datesInList1[3], eventsInList1[3]));
                return view4;
            case 5:
                View view5 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList5 = (VerticalStepperView) view5;
                eventsList5.setStepperAdapter( new MainStepperAdapter( context, datesInList1[4], eventsInList1[4]));
                return view5;
            case 6:
                View view6 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList6 = (VerticalStepperView) view6;
                eventsList6.setStepperAdapter( new MainStepperAdapter( context, datesInList1[5], eventsInList1[5]));
                return view6;
            case 7:
                View view7 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList7 = (VerticalStepperView) view7;
                eventsList7.setStepperAdapter( new MainStepperAdapter( context, datesInList1[6], eventsInList1[6]));
                return view7;
            case 8:
                View view8 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList8 = (VerticalStepperView) view8;
                eventsList8.setStepperAdapter( new MainStepperAdapter( context, datesInList1[7], eventsInList1[7]));
                return view8;
            case 9:
                View view9 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList9 = (VerticalStepperView) view9;
                eventsList9.setStepperAdapter( new MainStepperAdapter( context, datesInList1[8], eventsInList1[8]));
                return view9;
            case 10:
                View view10 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList10 = (VerticalStepperView) view10;
                eventsList10.setStepperAdapter( new MainStepperAdapter( context, datesInList1[9], eventsInList1[9]));
                return view10;
            case 11:
                View view11 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList11 = (VerticalStepperView) view11;
                eventsList11.setStepperAdapter( new MainStepperAdapter( context, datesInList1[10], eventsInList1[10]));
                return view11;
            case 12:
                View view12 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList12 = (VerticalStepperView) view12;
                eventsList12.setStepperAdapter( new MainStepperAdapter( context, datesInList1[11], eventsInList1[11]));
                return view12;
            case 13:
                View view13 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList13 = (VerticalStepperView) view13;
                eventsList13.setStepperAdapter( new MainStepperAdapter( context, datesInList1[12], eventsInList1[12]));
                return view13;
            case 14:
                View view14 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList14 = (VerticalStepperView) view14;
                eventsList14.setStepperAdapter( new MainStepperAdapter( context, datesInList1[13], eventsInList1[13]));
                return view14;
            case 15:
                View view15 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList15 = (VerticalStepperView) view15;
                eventsList15.setStepperAdapter( new MainStepperAdapter( context, datesInList1[14], eventsInList1[14]));
                return view15;
            case 16:
                View view16 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList16 = (VerticalStepperView) view16;
                eventsList16.setStepperAdapter( new MainStepperAdapter( context, datesInList1[15], eventsInList1[15]));
                return view16;
            case 17:
                View view17 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList17 = (VerticalStepperView) view17;
                eventsList17.setStepperAdapter( new MainStepperAdapter( context, datesInList1[16], eventsInList1[16]));
                return view17;
            case 18:
                View view18 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList18 = (VerticalStepperView) view18;
                eventsList18.setStepperAdapter( new MainStepperAdapter( context, datesInList1[17], eventsInList1[17]));
                return view18;
            case 19:
                View view19 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList19 = (VerticalStepperView) view19;
                eventsList19.setStepperAdapter( new MainStepperAdapter( context, datesInList1[18], eventsInList1[18]));
                return view19;
            case 20:
                View view20 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList20 = (VerticalStepperView) view20;
                eventsList20.setStepperAdapter( new MainStepperAdapter( context, datesInList1[19], eventsInList1[19]));
                return view20;
            case 21:
                View view21 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList21 = (VerticalStepperView) view21;
                eventsList21.setStepperAdapter( new MainStepperAdapter( context, datesInList1[20], eventsInList1[20]));
                return view21;
            case 22:
                View view22 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList22 = (VerticalStepperView) view22;
                eventsList22.setStepperAdapter( new MainStepperAdapter( context, datesInList1[21], eventsInList1[21]));
                return view22;
            case 23:
                View view23 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList23 = (VerticalStepperView) view23;
                eventsList23.setStepperAdapter( new MainStepperAdapter( context, datesInList1[22], eventsInList1[2]));
                return view23;
            case 24:
                View view24 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList24 = (VerticalStepperView) view24;
                eventsList24.setStepperAdapter( new MainStepperAdapter( context, datesInList1[23], eventsInList1[23]));
                return view24;
            case 25:
                View view25 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList25 = (VerticalStepperView) view25;
                eventsList25.setStepperAdapter( new MainStepperAdapter( context, datesInList1[24], eventsInList1[24]));
                return view25;
            case 26:
                View view26 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList26 = (VerticalStepperView) view26;
                eventsList26.setStepperAdapter( new MainStepperAdapter( context, datesInList1[25], eventsInList1[25]));
                return view26;
            case 27:
                View view27 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList27 = (VerticalStepperView) view27;
                eventsList27.setStepperAdapter( new MainStepperAdapter( context, datesInList1[26], eventsInList1[26]));
                return view27;
            case 28:
                View view28 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList28 = (VerticalStepperView) view28;
                eventsList28.setStepperAdapter( new MainStepperAdapter( context, datesInList1[27], eventsInList1[27]));
                return view28;
            case 29:
                View view29 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList29 = (VerticalStepperView) view29;
                eventsList29.setStepperAdapter( new MainStepperAdapter( context, datesInList1[28], eventsInList1[28]));
                return view29;
            case 30:
                View view30 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList30 = (VerticalStepperView) view30;
                eventsList30.setStepperAdapter( new MainStepperAdapter( context, datesInList1[29], eventsInList1[29]));
                return view30;
            case 31:
                View view31 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList31 = (VerticalStepperView) view31;
                eventsList31.setStepperAdapter( new MainStepperAdapter( context, datesInList1[30], eventsInList1[30]));
                return view31;
            default:
                View view32 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                VerticalStepperView eventsList32 = (VerticalStepperView) view32;
                eventsList32.setStepperAdapter( new MainStepperAdapter( context, datesInList1[30], eventsInList1[30]));
                return view32;

        }

    }


}