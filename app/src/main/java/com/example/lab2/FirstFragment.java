package com.example.lab2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends BaseFragment {

    private OnFragmentInteractionListener callback;

    public interface OnFragmentInteractionListener {
        void onOpenSecondFragment();
        void onOpenAnotherActivity();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            callback = (OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException(context + " must implement OnFragmentInteractionListener");
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

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btnToSecond = view.findViewById(R.id.btnToSecond);
        Button btnToActivity = view.findViewById(R.id.btnToActivity);

        btnToSecond.setOnClickListener(v -> {
            if (callback != null) {
                callback.onOpenSecondFragment();
            }
        });

        btnToActivity.setOnClickListener(v -> {
            if (callback != null) {
                callback.onOpenAnotherActivity();
            }
        });

        return view;
    }
}


