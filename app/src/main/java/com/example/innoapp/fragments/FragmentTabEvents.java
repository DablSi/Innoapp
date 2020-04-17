package com.example.innoapp.fragments;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class FragmentTabEvents extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private Context context = null;


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

    /*@Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view1 = inflater.inflate(R.layout.fragment_tab_events, container, false);
            VerticalStepperView eventsList1 = (VerticalStepperView) view1;
            eventsList1.setStepperAdapter( new MainStepperAdapter( context, datesInList1[mPage - 1],
                    eventsInList1[mPage - 1], mPage-1));
            return view1;
            return null;
    }*/


}