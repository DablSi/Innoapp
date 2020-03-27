package com.example.innoapp.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder;

public class CodeFragment extends Fragment {

    public static String code = "124958761310";

    public CodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_code, container, false);
        TextView barcode = rootView.findViewById(R.id.barcode);
        /// установить шрифт штрих-кода
        Typeface font = Typeface.createFromAsset(rootView.getContext().getResources().getAssets(), "EanP72TtNormal.ttf");
        barcode.setTypeface(font);

        EAN13CodeBuilder bb = new EAN13CodeBuilder(code);
        barcode.setText(bb.getCode());
        return inflater.inflate(R.layout.fragment_code, container, false);
    }
}
