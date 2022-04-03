package com.example.squidarcade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivitySingleplayer extends AppCompatActivity {
    private Button singleplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_rlgl_player);
        singleplayer = (Button) findViewById(R.id.button);
        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSingleplayer();
            }
        });
    }
    public void openSingleplayer(){
        Intent intent = new Intent(MainActivitySingleplayer.this, Singleplayer.class);
        startActivity(intent);
    }
}