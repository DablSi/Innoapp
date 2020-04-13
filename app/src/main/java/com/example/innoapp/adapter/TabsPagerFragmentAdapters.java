package com.example.innoapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.innoapp.fragments.FragmentTab1;
import com.example.innoapp.fragments.FragmentTab2;
import com.example.innoapp.fragments.FragmentTab3;
import com.example.innoapp.fragments.FragmentTab4;
import com.example.innoapp.fragments.FragmentTab5;
import com.example.innoapp.fragments.FragmentTab6;

import static com.example.innoapp.activities.ProfileActivity.darkT;

public class TabsPagerFragmentAdapters extends FragmentPagerAdapter {
    private String[] tabs;

    @SuppressWarnings("deprecation")
    public TabsPagerFragmentAdapters(@NonNull FragmentManager fm) {
        super(fm);
        tabs = new String[]{
                "Первый этаж",
                "Второй этаж",
                "Третий этаж"
        };
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
        if(darkT) {
            switch (position) {
                case 0:
                    return FragmentTab4.getInstance();
                case 1:
                    return FragmentTab5.getInstance();
                case 2:
                    return FragmentTab6.getInstance();
            }
        }
        else {
            switch (position) {
                case 0:
                    return FragmentTab1.getInstance();
                case 1:
                    return FragmentTab2.getInstance();
                case 2:
                    return FragmentTab3.getInstance();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
