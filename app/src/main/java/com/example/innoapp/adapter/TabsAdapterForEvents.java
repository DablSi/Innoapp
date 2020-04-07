package com.example.innoapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.innoapp.R;
import com.example.innoapp.activities.Events;
import com.example.innoapp.activities.Events.EventList1;
import com.example.innoapp.fragments.FragmentTab1;
import com.example.innoapp.fragments.FragmentTab2;
import com.example.innoapp.fragments.FragmentTab3;
import com.example.innoapp.fragments.FragmentTabEvents;
import com.google.android.material.tabs.TabItem;

import java.util.LinkedList;

public class TabsAdapterForEvents extends FragmentPagerAdapter {
    public String[] tabs;

    private static final int LAYOUT = R.layout.fragment_tab1;
    @SuppressWarnings("deprecation")
    public TabsAdapterForEvents(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @SuppressWarnings("ConstantConditions")
    @NonNull
    @Override
    public Fragment getItem(int position)
    {
                return FragmentTabEvents.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

}