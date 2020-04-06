package com.example.innoapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.innoapp.R;
import com.example.innoapp.fragments.FragmentTab1;
import com.example.innoapp.fragments.FragmentTab2;
import com.example.innoapp.fragments.FragmentTab3;
import com.example.innoapp.fragments.FragmentTabEvents;
import com.google.android.material.tabs.TabItem;

public class TabsAdapterForEvents extends FragmentPagerAdapter {
    public String[] tabs;
    private static final int LAYOUT = R.layout.fragment_tab1;
    private String[] pagerD;
    private String[] pagerE;
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
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                String[] d1 = {"0", "sa24fa", "ew12gwgw"};
                String[] e1 = {"sdgf1213", "sa12421fa", "ewg124214wgw"};
                return FragmentTabEvents.newInstance(position, d1, e1);
            case 1:
                String[] d2 = {"1", "sa24fa", "ew12gwgw"};
                String[] e2 = {"111111sdgf1213", "sa12421fa", "ewg124214wgw"};
                return FragmentTabEvents.newInstance(position, d2, e2);
            case 2:
                String[] d3 = {"2", "sa24fa", "ew12gwgw"};
                String[] e3 = {"111111sdgf1213", "sa12421fa", "ewg124214wgw"};
                return FragmentTabEvents.newInstance(position, d3, e3);
            case 3:
                String[] d4 = {"3", "sa24fa", "ew12gwgw"};
                String[] e4 = {"111111sdgf1213", "sa12421fa", "ewg124214wgw"};
                return FragmentTabEvents.newInstance(position, d4, e4);
            case 4:
                String[] d5 = {"4", "sa24fa", "ew12gwgw"};
                String[] e5 = {"111111sdgf1213", "sa12421fa", "ewg124214wgw"};
                return FragmentTabEvents.newInstance(position, d5, e5);
            case 5:
                String[] d6 = {"6", "sa24fa", "ew12gwgw"};
                String[] e6 = {"111111sdgf1213", "sa12421fa", "ewg124214wgw"};
                return FragmentTabEvents.newInstance(position, d6, e6);
            default:
                String[] d7 = {"3", "sa24fa", "ew12gwgw11"};
                String[] e7 = {"111111sdgf1213", "sa12421fa", "ewg124214wg1111w"};
                return FragmentTabEvents.newInstance(position, d7, e7);
    }

    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}