package com.example.android.tennisscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hp on 08/03/2017.
 */

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Bundle extras = getIntent().getExtras();
        int pointsPL1 = extras.getInt("points_won_player1");
        int pointsPL2 = extras.getInt("points_won_player2");
        int acePL1 = extras.getInt("ace_player1");
        int acePL2 = extras.getInt("ace_player2");
        int winPL1 = extras.getInt("win_player1");
        int winPL2 = extras.getInt("win_player2");
        int errPL1 = extras.getInt("err_player1");
        int errPL2 = extras.getInt("err_player2");
        String pl1 = getIntent().getExtras().getString("name_player1");
        String pl2 = getIntent().getExtras().getString("name_player2");

        TextView txtPlayer1 = (TextView) findViewById(R.id.player1_stats);
        txtPlayer1.setText(pl1);
        TextView txtPlayer2 = (TextView) findViewById(R.id.player2_stats);
        txtPlayer2.setText(pl2);

        TextView txtPointsPlayer1 = (TextView) findViewById(R.id.txt_points_player1);
        txtPointsPlayer1.setText(String.valueOf(pointsPL1));
        TextView txtPointsPlayer2 = (TextView) findViewById(R.id.txt_points_player2);
        txtPointsPlayer2.setText(String.valueOf(pointsPL2));
        TextView txtAcesPlayer1 = (TextView) findViewById(R.id.txt_aces_player1);
        txtAcesPlayer1.setText(String.valueOf(acePL1));
        TextView txtAcesPlayer2 = (TextView) findViewById(R.id.txt_aces_player2);
        txtAcesPlayer2.setText(String.valueOf(acePL2));
        TextView txtWinnersPlayer1 = (TextView) findViewById(R.id.txt_winners_player1);
        txtWinnersPlayer1.setText(String.valueOf(winPL1));
        TextView txtWinnersPlayer2 = (TextView) findViewById(R.id.txt_winners_player2);
        txtWinnersPlayer2.setText(String.valueOf(winPL2));
        TextView txtErrorsPlayer1 = (TextView) findViewById(R.id.txt_errors_player1);
        txtErrorsPlayer1.setText(String.valueOf(errPL1));
        TextView txtErrorsPlayer2 = (TextView) findViewById(R.id.txt_errors_player2);
        txtErrorsPlayer2.setText(String.valueOf(errPL2));

        Button goToMainMenu = (Button)findViewById(R.id.btn_go_to_main_menu);
        goToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainMenu = new Intent(StatsActivity.this, MenuActivity.class);
                startActivity(backToMainMenu);
            }
        });
    }


}
