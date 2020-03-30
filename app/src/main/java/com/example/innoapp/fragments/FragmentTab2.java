package com.example.innoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.innoapp.R;

public class FragmentTab2 extends Fragment {
    private static final int LAYOUT = R.layout.fragment_tab2;
    private View view;
    public static FragmentTab2 getInstance()
    {
        Bundle args = new Bundle();
        FragmentTab2 fragment2 = new FragmentTab2();
        fragment2.setArguments(args);
        return fragment2;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }


}