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
import com.example.innoapp.adapter.DataAdapter;
import com.example.innoapp.adapter.DataAdapterEvents;

public class FragmentTabEvents extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private static String[] datesList;
    private static String[] eventList;
    private Context context = null;
    private DataAdapterEvents adapter;
    public static FragmentTabEvents newInstance(int page, String[] d, String[] e) {
        datesList = d;
        eventList = e;
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentTabEvents fragment = new FragmentTabEvents();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_events, container, false);
        RecyclerView eventsList = (RecyclerView) view;
        eventsList.removeAllViews();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        eventsList.setLayoutManager(layoutManager);
        adapter = new DataAdapterEvents(datesList, eventList, context);
        eventsList.setAdapter(adapter);
        return view;
    }
}
