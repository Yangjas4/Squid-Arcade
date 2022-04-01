package com.example.squidarcade.Marbles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.squidarcade.Marbles.Singleplayer.game;
import com.example.squidarcade.R;

public class MarblesMain extends AppCompatActivity {
    private Button singleplayerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marbles_main);

        singleplayerButton = (Button) findViewById(R.id.singleplayer);
        singleplayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView playerMarbles = findViewById(R.id.marblesRemaining);

                setContentView(R.layout.activity_marbles_singleplayer_evenOdd);
                game game = new game();
                while (game.getWinner()==null){
                    playerMarbles.setText(game.getHuman().getMarbles());
                }
            }
        });
    }
}