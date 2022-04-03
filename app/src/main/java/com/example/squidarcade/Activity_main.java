package com.example.squidarcade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class Activity_main extends AppCompatActivity {

    private marblesViewModel marbleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marbleViewModel = new ViewModelProvider(this).get(marblesViewModel.class);
        marbleViewModel.getGame().observe(this, item -> {


        });







    }
}