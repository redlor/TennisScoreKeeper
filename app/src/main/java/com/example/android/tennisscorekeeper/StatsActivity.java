package com.example.android.tennisscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
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
        int set1Pl1 = extras.getInt("scorePlayer1Set1");
        int set2Pl1 = extras.getInt("scorePlayer1Set2");
        int set3Pl1 = extras.getInt("scorePlayer1Set3");
        int set4Pl1 = extras.getInt("scorePlayer1Set4");
        int set5Pl1 = extras.getInt("scorePlayer1Set5");
        int set1Pl2 = extras.getInt("scorePlayer2Set1");
        int set2Pl2 = extras.getInt("scorePlayer2Set2");
        int set3Pl2 = extras.getInt("scorePlayer2Set3");
        int set4Pl2 = extras.getInt("scorePlayer2Set4");
        int set5Pl2 = extras.getInt("scorePlayer2Set5");
        int tieSet1Pl1 = extras.getInt("player1TieSet1");
        int tieSet2Pl1 = extras.getInt("player1TieSet2");
        int tieSet3Pl1 = extras.getInt("player1TieSet3");
        int tieSet4Pl1 = extras.getInt("player1TieSet4");
        int tieSet5Pl1 = extras.getInt("player1TieSet5");
        int tieSet1Pl2 = extras.getInt("player2TieSet1");
        int tieSet2Pl2 = extras.getInt("player2TieSet2");
        int tieSet3Pl2 = extras.getInt("player2TieSet3");
        int tieSet4Pl2 = extras.getInt("player2TieSet4");
        int tieSet5Pl2 = extras.getInt("player2TieSet5");
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
        Boolean threeSets = extras.getBoolean("threeSets");

        TextView txtPlayer1 = (TextView) findViewById(R.id.player1_stats);
        txtPlayer1.setText(pl1);
        TextView txtPlayer2 = (TextView) findViewById(R.id.player2_stats);
        txtPlayer2.setText(pl2);
        TextView txtPlayer1Card = (TextView) findViewById(R.id.player_top_1);
        txtPlayer1Card.setText(pl1);
        TextView txtPlayer2Card = (TextView) findViewById(R.id.player_top_2);
        txtPlayer2Card.setText(pl2);

        TextView txtSet1Player1 = (TextView) findViewById(R.id.set_1_score_player1);
        txtSet1Player1.setText((String.valueOf(set1Pl1)));
        TextView txtSet2Player1 = (TextView) findViewById(R.id.set_2_score_player1);
        txtSet2Player1.setText((String.valueOf(set2Pl1)));
        TextView txtSet3Player1 = (TextView) findViewById(R.id.set_3_score_player1);
        txtSet3Player1.setText((String.valueOf(set3Pl1)));
        TextView txtSet4Player1 = (TextView) findViewById(R.id.set_4_score_player1);
        txtSet4Player1.setText((String.valueOf(set4Pl1)));
        TextView txtSet5Player1 = (TextView) findViewById(R.id.set_5_score_player1);
        txtSet5Player1.setText((String.valueOf(set5Pl1)));
        TextView txtSet1Player2 = (TextView) findViewById(R.id.set_1_score_player2);
        txtSet1Player2.setText((String.valueOf(set1Pl2)));
        TextView txtSet2Player2 = (TextView) findViewById(R.id.set_2_score_player2);
        txtSet2Player2.setText((String.valueOf(set2Pl2)));
        TextView txtSet3Player2 = (TextView) findViewById(R.id.set_3_score_player2);
        txtSet3Player2.setText((String.valueOf(set3Pl2)));
        TextView txtSet4Player2 = (TextView) findViewById(R.id.set_4_score_player2);
        txtSet4Player2.setText((String.valueOf(set4Pl2)));
        TextView txtSet5Player2 = (TextView) findViewById(R.id.set_5_score_player2);
        txtSet5Player2.setText((String.valueOf(set5Pl2)));
        TextView txtTieSet1Player1 = (TextView) findViewById(R.id.set_1_tie_player1);
        txtTieSet1Player1.setText((String.valueOf(tieSet1Pl1)));
        TextView txtTieSet2Player1 = (TextView) findViewById(R.id.set_2_tie_player1);
        txtTieSet2Player1.setText((String.valueOf(tieSet2Pl1)));
        TextView txtTieSet3Player1 = (TextView) findViewById(R.id.set_3_tie_player1);
        txtTieSet3Player1.setText((String.valueOf(tieSet3Pl1)));
        TextView txtTieSet4Player1 = (TextView) findViewById(R.id.set_4_tie_player1);
        txtTieSet4Player1.setText((String.valueOf(tieSet4Pl1)));
        TextView txtTieSet5Player1 = (TextView) findViewById(R.id.set_5_tie_player1);
        txtTieSet5Player1.setText((String.valueOf(tieSet5Pl1)));
        TextView txtTieSet1Player2 = (TextView) findViewById(R.id.set_1_tie_player2);
        txtTieSet1Player2.setText((String.valueOf(tieSet1Pl2)));
        TextView txtTieSet2Player2 = (TextView) findViewById(R.id.set_2_tie_player2);
        txtTieSet2Player2.setText((String.valueOf(tieSet2Pl2)));
        TextView txtTieSet3Player2 = (TextView) findViewById(R.id.set_3_tie_player2);
        txtTieSet3Player2.setText((String.valueOf(tieSet3Pl2)));
        TextView txtTieSet4Player2 = (TextView) findViewById(R.id.set_4_tie_player2);
        txtTieSet4Player2.setText((String.valueOf(tieSet4Pl2)));
        TextView txtTieSet5Player2 = (TextView) findViewById(R.id.set_5_tie_player2);
        txtTieSet5Player2.setText((String.valueOf(tieSet5Pl2)));
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
        CardView cardSet4player1 = (CardView) findViewById(R.id.card_4_set_player1);
        CardView cardSet5player1 = (CardView) findViewById(R.id.card_5_set_player1);
        CardView cardSet4player2 = (CardView) findViewById(R.id.card_4_set_player2);
        CardView cardSet5player2 = (CardView) findViewById(R.id.card_5_set_player2);

        txtTieSet1Player1.setVisibility(View.INVISIBLE);
        txtTieSet2Player1.setVisibility(View.INVISIBLE);
        txtTieSet3Player1.setVisibility(View.INVISIBLE);
        txtTieSet4Player1.setVisibility(View.INVISIBLE);
        txtTieSet5Player1.setVisibility(View.INVISIBLE);
        txtTieSet1Player2.setVisibility(View.INVISIBLE);
        txtTieSet2Player2.setVisibility(View.INVISIBLE);
        txtTieSet3Player2.setVisibility(View.INVISIBLE);
        txtTieSet4Player2.setVisibility(View.INVISIBLE);
        txtTieSet5Player2.setVisibility(View.INVISIBLE);


        if (threeSets){
            cardSet4player1.setVisibility(View.INVISIBLE);
            cardSet5player1.setVisibility(View.INVISIBLE);
            cardSet4player2.setVisibility(View.INVISIBLE);
            cardSet5player2.setVisibility(View.INVISIBLE);
        }
        if (tieSet1Pl1 != 0 | tieSet1Pl2 != 0){
            txtTieSet1Player1.setVisibility(View.VISIBLE);
            txtTieSet1Player2.setVisibility(View.VISIBLE);
        }
        if (tieSet2Pl1 != 0 | tieSet2Pl2 != 0){
            txtTieSet2Player1.setVisibility(View.VISIBLE);
            txtTieSet2Player2.setVisibility(View.VISIBLE);
        }
        if (tieSet3Pl1 != 0 | tieSet3Pl2 != 0){
            txtTieSet3Player1.setVisibility(View.VISIBLE);
            txtTieSet3Player2.setVisibility(View.VISIBLE);
        }
        if (tieSet4Pl1 != 0 | tieSet4Pl2 != 0){
            txtTieSet4Player1.setVisibility(View.VISIBLE);
            txtTieSet4Player2.setVisibility(View.VISIBLE);
        }
        if (tieSet5Pl1 != 0 | tieSet5Pl2 != 0){
            txtTieSet5Player1.setVisibility(View.VISIBLE);
            txtTieSet5Player2.setVisibility(View.VISIBLE);
        }
        Button goToMainMenu = (Button) findViewById(R.id.btn_go_to_main_menu);
        goToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainMenu = new Intent(StatsActivity.this, MenuActivity.class);
                startActivity(backToMainMenu);
            }
        });
    }


}
