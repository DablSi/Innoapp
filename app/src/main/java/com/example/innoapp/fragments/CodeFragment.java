package com.example.innoapp.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.innoapp.R;
import com.example.innoapp.utils.EAN13CodeBuilder;


/**
 * Фрагмент для отображения штрих-кода
 */
public class CodeFragment extends Fragment {

    // код для штрих-кода
    public static String code = "124958761310";
    // размер шрифта штрих-кода в мм
    // 35 - размер штрих-кода для прочтения машиной. Для миниатюры размер изменить
    public static float size = 35;

    public CodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_code, container, false);
        TextView barcode = rootView.findViewById(R.id.barcode);
        /// установить шрифт штрих-кода
        Typeface font = Typeface.createFromAsset(rootView.getContext().getResources().getAssets(), "fonts/EanP72TtNormal.ttf");
        barcode.setTypeface(font);

        EAN13CodeBuilder bb = new EAN13CodeBuilder(code);
        // "рисует" штрих-код
        barcode.setText(bb.getCode());
        // устанавливает размер штрих-кода
        barcode.setTextSize(TypedValue.COMPLEX_UNIT_MM, size);
        return rootView;
    }
}
