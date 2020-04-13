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
public class FragmentTab4 extends Fragment {
    private static final int LAYOUT = R.layout.fragment_tab4;

    public static FragmentTab4 getInstance() {
        Bundle args = new Bundle();
        FragmentTab4 fragment4 = new FragmentTab4();
        fragment4.setArguments(args);
        return fragment4;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(LAYOUT, container, false);
    }


}