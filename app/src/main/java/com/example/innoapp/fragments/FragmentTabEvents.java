package com.example.innoapp.fragments;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private static Event[] classEventList;
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
            RecyclerView eventsList1 = (RecyclerView) view1;
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(context);
            eventsList1.setLayoutManager(layoutManager1);
            adapter = new DataAdapterEvents(datesInList1[0], eventsInList1[0], mPage, context);
            eventsList1.setAdapter(adapter);
            return view1;
            case 2:
                View view2 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList2 = (RecyclerView) view2;
                LinearLayoutManager layoutManager2 = new LinearLayoutManager(context);
                eventsList2.setLayoutManager(layoutManager2);
                adapter = new DataAdapterEvents(datesInList1[1], eventsInList1[1], mPage, context);
                eventsList2.setAdapter(adapter);
                return view2;
            case 3:
                View view3 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList3 = (RecyclerView) view3;
                LinearLayoutManager layoutManager3 = new LinearLayoutManager(context);
                eventsList3.setLayoutManager(layoutManager3);
                adapter = new DataAdapterEvents(datesInList1[2], eventsInList1[2], mPage, context);
                eventsList3.setAdapter(adapter);
                return view3;
            case 4:
                View view4 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList4 = (RecyclerView) view4;
                LinearLayoutManager layoutManager4 = new LinearLayoutManager(context);
                eventsList4.setLayoutManager(layoutManager4);
                adapter = new DataAdapterEvents(datesInList1[3], eventsInList1[3], mPage, context);
                eventsList4.setAdapter(adapter);
                return view4;
            case 5:
                View view5 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList5 = (RecyclerView) view5;
                LinearLayoutManager layoutManager5 = new LinearLayoutManager(context);
                eventsList5.setLayoutManager(layoutManager5);
                adapter = new DataAdapterEvents(datesInList1[4], eventsInList1[4], mPage, context);
                eventsList5.setAdapter(adapter);
                return view5;
            case 6:
                View view6 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList6 = (RecyclerView) view6;
                LinearLayoutManager layoutManager6 = new LinearLayoutManager(context);
                eventsList6.setLayoutManager(layoutManager6);
                adapter = new DataAdapterEvents(datesInList1[5], eventsInList1[5], mPage, context);
                eventsList6.setAdapter(adapter);
                return view6;
            case 7:
                View view7 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList7 = (RecyclerView) view7;
                LinearLayoutManager layoutManager7 = new LinearLayoutManager(context);
                eventsList7.setLayoutManager(layoutManager7);
                adapter = new DataAdapterEvents(datesInList1[6], eventsInList1[6], mPage, context);
                eventsList7.setAdapter(adapter);
                return view7;
            case 8:
                View view8 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList8 = (RecyclerView) view8;
                LinearLayoutManager layoutManager8 = new LinearLayoutManager(context);
                eventsList8.setLayoutManager(layoutManager8);
                adapter = new DataAdapterEvents(datesInList1[7], eventsInList1[7], mPage, context);
                eventsList8.setAdapter(adapter);
                return view8;
            case 9:
                View view9 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList9 = (RecyclerView) view9;
                LinearLayoutManager layoutManager9 = new LinearLayoutManager(context);
                eventsList9.setLayoutManager(layoutManager9);
                adapter = new DataAdapterEvents(datesInList1[8], eventsInList1[8], mPage, context);
                eventsList9.setAdapter(adapter);
                return view9;
            case 10:
                View view10 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList10 = (RecyclerView) view10;
                LinearLayoutManager layoutManager10 = new LinearLayoutManager(context);
                eventsList10.setLayoutManager(layoutManager10);
                adapter = new DataAdapterEvents(datesInList1[9], eventsInList1[9], mPage, context);
                eventsList10.setAdapter(adapter);
                return view10;
            case 11:
                View view11 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList11 = (RecyclerView) view11;
                LinearLayoutManager layoutManager11 = new LinearLayoutManager(context);
                eventsList11.setLayoutManager(layoutManager11);
                adapter = new DataAdapterEvents(datesInList1[10], eventsInList1[10], mPage, context);
                eventsList11.setAdapter(adapter);
                return view11;
            case 12:
                View view12 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList12 = (RecyclerView) view12;
                LinearLayoutManager layoutManager12 = new LinearLayoutManager(context);
                eventsList12.setLayoutManager(layoutManager12);
                adapter = new DataAdapterEvents(datesInList1[11], eventsInList1[11], mPage, context);
                eventsList12.setAdapter(adapter);
                return view12;
            case 13:
                View view13 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList13 = (RecyclerView) view13;
                LinearLayoutManager layoutManager13 = new LinearLayoutManager(context);
                eventsList13.setLayoutManager(layoutManager13);
                adapter = new DataAdapterEvents(datesInList1[12], eventsInList1[12], mPage, context);
                eventsList13.setAdapter(adapter);
                return view13;
            case 14:
                View view14 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList14 = (RecyclerView) view14;
                LinearLayoutManager layoutManager14 = new LinearLayoutManager(context);
                eventsList14.setLayoutManager(layoutManager14);
                adapter = new DataAdapterEvents(datesInList1[13], eventsInList1[13], mPage, context);
                eventsList14.setAdapter(adapter);
                return view14;
            case 15:
                View view15 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList15 = (RecyclerView) view15;
                LinearLayoutManager layoutManager15 = new LinearLayoutManager(context);
                eventsList15.setLayoutManager(layoutManager15);
                adapter = new DataAdapterEvents(datesInList1[14], eventsInList1[14], mPage, context);
                eventsList15.setAdapter(adapter);
                return view15;
            case 16:
                View view16 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList16 = (RecyclerView) view16;
                LinearLayoutManager layoutManager16 = new LinearLayoutManager(context);
                eventsList16.setLayoutManager(layoutManager16);
                adapter = new DataAdapterEvents(datesInList1[15], eventsInList1[15], mPage, context);
                eventsList16.setAdapter(adapter);
                return view16;
            case 17:
                View view17 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList17 = (RecyclerView) view17;
                LinearLayoutManager layoutManager17 = new LinearLayoutManager(context);
                eventsList17.setLayoutManager(layoutManager17);
                adapter = new DataAdapterEvents(datesInList1[16], eventsInList1[16], mPage, context);
                eventsList17.setAdapter(adapter);
                return view17;
            case 18:
                View view18 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList18 = (RecyclerView) view18;
                LinearLayoutManager layoutManager18 = new LinearLayoutManager(context);
                eventsList18.setLayoutManager(layoutManager18);
                adapter = new DataAdapterEvents(datesInList1[17], eventsInList1[17], mPage, context);
                eventsList18.setAdapter(adapter);
                return view18;
            case 19:
                View view19 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList19 = (RecyclerView) view19;
                LinearLayoutManager layoutManager19 = new LinearLayoutManager(context);
                eventsList19.setLayoutManager(layoutManager19);
                adapter = new DataAdapterEvents(datesInList1[18], eventsInList1[18], mPage, context);
                eventsList19.setAdapter(adapter);
                return view19;
            case 20:
                View view20 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList20 = (RecyclerView) view20;
                LinearLayoutManager layoutManager20 = new LinearLayoutManager(context);
                eventsList20.setLayoutManager(layoutManager20);
                adapter = new DataAdapterEvents(datesInList1[19], eventsInList1[19], mPage, context);
                eventsList20.setAdapter(adapter);
                return view20;
            case 21:
                View view21 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList21 = (RecyclerView) view21;
                LinearLayoutManager layoutManager21 = new LinearLayoutManager(context);
                eventsList21.setLayoutManager(layoutManager21);
                adapter = new DataAdapterEvents(datesInList1[20], eventsInList1[20], mPage, context);
                eventsList21.setAdapter(adapter);
                return view21;
            case 22:
                View view22 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList22 = (RecyclerView) view22;
                LinearLayoutManager layoutManager22 = new LinearLayoutManager(context);
                eventsList22.setLayoutManager(layoutManager22);
                adapter = new DataAdapterEvents(datesInList1[21], eventsInList1[21], mPage, context);
                eventsList22.setAdapter(adapter);
                return view22;
            case 23:
                View view23 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList23 = (RecyclerView) view23;
                LinearLayoutManager layoutManager23 = new LinearLayoutManager(context);
                eventsList23.setLayoutManager(layoutManager23);
                adapter = new DataAdapterEvents(datesInList1[22], eventsInList1[22], mPage, context);
                eventsList23.setAdapter(adapter);
                return view23;
            case 24:
                View view24 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList24 = (RecyclerView) view24;
                LinearLayoutManager layoutManager24 = new LinearLayoutManager(context);
                eventsList24.setLayoutManager(layoutManager24);
                adapter = new DataAdapterEvents(datesInList1[23], eventsInList1[23], mPage, context);
                eventsList24.setAdapter(adapter);
                return view24;
            case 25:
                View view25 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList25 = (RecyclerView) view25;
                LinearLayoutManager layoutManager25 = new LinearLayoutManager(context);
                eventsList25.setLayoutManager(layoutManager25);
                adapter = new DataAdapterEvents(datesInList1[24], eventsInList1[24], mPage, context);
                eventsList25.setAdapter(adapter);
                return view25;
            case 26:
                View view26 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList26 = (RecyclerView) view26;
                LinearLayoutManager layoutManager26 = new LinearLayoutManager(context);
                eventsList26.setLayoutManager(layoutManager26);
                adapter = new DataAdapterEvents(datesInList1[25], eventsInList1[25], mPage, context);
                eventsList26.setAdapter(adapter);
                return view26;
            case 27:
                View view27 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList27 = (RecyclerView) view27;
                LinearLayoutManager layoutManager27 = new LinearLayoutManager(context);
                eventsList27.setLayoutManager(layoutManager27);
                adapter = new DataAdapterEvents(datesInList1[26], eventsInList1[26], mPage, context);
                eventsList27.setAdapter(adapter);
                return view27;
            case 28:
                View view28 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList28 = (RecyclerView) view28;
                LinearLayoutManager layoutManager28 = new LinearLayoutManager(context);
                eventsList28.setLayoutManager(layoutManager28);
                adapter = new DataAdapterEvents(datesInList1[27], eventsInList1[27], mPage, context);
                eventsList28.setAdapter(adapter);
                return view28;
            case 29:
                View view29 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList29 = (RecyclerView) view29;
                LinearLayoutManager layoutManager29 = new LinearLayoutManager(context);
                eventsList29.setLayoutManager(layoutManager29);
                adapter = new DataAdapterEvents(datesInList1[28], eventsInList1[28], mPage, context);
                eventsList29.setAdapter(adapter);
                return view29;
            case 30:
                View view30 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList30 = (RecyclerView) view30;
                LinearLayoutManager layoutManager30 = new LinearLayoutManager(context);
                eventsList30.setLayoutManager(layoutManager30);
                adapter = new DataAdapterEvents(datesInList1[29], eventsInList1[29], mPage, context);
                eventsList30.setAdapter(adapter);
                return view30;
            case 31:
                View view31 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList31 = (RecyclerView) view31;
                LinearLayoutManager layoutManager31 = new LinearLayoutManager(context);
                eventsList31.setLayoutManager(layoutManager31);
                adapter = new DataAdapterEvents(datesInList1[30], eventsInList1[30], mPage, context);
                eventsList31.setAdapter(adapter);
                return view31;
            default:
                View view32 = inflater.inflate(R.layout.fragment_tab_events, container, false);
                RecyclerView eventsList32 = (RecyclerView) view32;
                LinearLayoutManager layoutManager32 = new LinearLayoutManager(context);
                eventsList32.setLayoutManager(layoutManager32);
                adapter = new DataAdapterEvents(datesInList1[30], eventsInList1[30], mPage, context);
                eventsList32.setAdapter(adapter);
                return view32;

        }

    }
}