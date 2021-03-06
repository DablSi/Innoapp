package com.example.innoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.innoapp.R;

// university map tab floor 3
public class FragmentTab3 extends Fragment {
    private static final int LAYOUT = R.layout.fragment_tab3;

    public static FragmentTab3 getInstance() {
        Bundle args = new Bundle();
        FragmentTab3 fragment3 = new FragmentTab3();
        fragment3.setArguments(args);
        return fragment3;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(LAYOUT, container, false);
    }


}