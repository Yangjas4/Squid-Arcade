package com.example.squidarcade;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

import android.content.Intent;

public class HomeActivity extends AppCompatActivity {

    private Button rlglButtonJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        rlglButtonJ = (Button) findViewById(R.id.rlglButton);
        rlglButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRlgl();
            }
        });

    }
    public void openRlgl(){
        Intent intent = new Intent(this, redLightGreenLight.class);
        startActivity(intent);
    }
}