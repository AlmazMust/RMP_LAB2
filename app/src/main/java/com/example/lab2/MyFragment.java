package com.example.lab2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment extends BaseFragment {

    private OnFragmentInteractionListener callback;

    public interface OnFragmentInteractionListener {
        void onFirstButtonClicked();
        void onSecondButtonClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            callback = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my, container, false);

        Button btnFirst = view.findViewById(R.id.btn1);
        Button btnSecond = view.findViewById(R.id.btn2);

        btnFirst.setOnClickListener(v -> {
            if (callback != null) callback.onFirstButtonClicked();
        });

        btnSecond.setOnClickListener(v -> {
            if (callback != null) callback.onSecondButtonClicked();
        });

        return view;
    }
}

