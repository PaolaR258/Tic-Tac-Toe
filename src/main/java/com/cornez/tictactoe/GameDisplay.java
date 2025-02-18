package com.cornez.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private Board Board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.button3);
        Button homeBTN = findViewById(R.id.button4);
        TextView playerTurn = findViewById(R.id.textView5);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String [] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        Board = findViewById(R.id.board);

        Board.setUpGame(playAgainBTN, homeBTN, playerTurn, playerNames);

        if (playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }
    }

    public void playAgainButtonClick(View view){
        Board.resetGame();
        Board.invalidate();

    }

    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}