package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity implements
        FirstFragment.OnFragmentInteractionListener,
        MyFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new FirstFragment())
                    .commit();
        }
    }

    @Override
    public void onOpenSecondFragment() {
        openSecondFragment();
    }

    @Override
    public void onOpenAnotherActivity() {
        Intent intent = new Intent(this, AnotherActivity.class);
        startActivity(intent);
    }

    private void openSecondFragment() {
        SecondFragment secondFragment = SecondFragment.newInstance("Привет из MainActivity!", "");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, secondFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFirstButtonClicked() {
        Toast.makeText(this, "Кнопка 1 нажата во фрагменте", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSecondButtonClicked() {
        Intent intent = new Intent(this, AnotherActivity.class);
        startActivity(intent);
    }
}



