package com.example.android.tennisscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.tennisscorekeeper.R.id.player_1_score;
import static com.example.android.tennisscorekeeper.R.id.player_1_score_tie;
import static com.example.android.tennisscorekeeper.R.id.player_2_score_tie;

/**
 * Created by Hp on 28/02/2017.
 */

public class ThreeSetsActivity extends AppCompatActivity {

    String pl1, pl2;

    int scorePlayer1Set1 = 0;
    int scorePlayer1Set2 = 0;
    int scorePlayer1Set3 = 0;
    int scorePlayer2Set1 = 0;
    int scorePlayer2Set2 = 0;
    int scorePlayer2Set3 = 0;

    int scorePlayer1 = 0;
    String Advantage1 = "";

    int scorePlayer2 = 0;
    String Advantage2 = "";

    int tie1 = 0;
    int tie2 = 0;

    int player1TieSet1, player1TieSet2, player1TieSet3, player2TieSet1, player2TieSet2, player2TieSet3;

    int setsWonPlayer1 = 0;
    int setsWonPlayer2 = 0;

    int pointsWonPlayer1 = 0;
    int pointsWonPlayer2 = 0;
    int winPlayer1 = 0;
    int winPlayer2 = 0;
    int errPlayer1 = 0;
    int errPlayer2 = 0;
    int acePlayer1 = 0;
    int acePlayer2 = 0;

    private TextView invPlayer1, invPlayer2, invADvPlayer1, invAdvPlayer2;
    private TextView invTiePlayer1, invTiePlayer2;
    private TextView tieSet1Player1, tieSet2Player1, tieSet3Player1, tieSet1Player2, tieSet2Player2, tieSet3Player2;
    private TextView txtSet1Pl1, txtSet2Pl1, txtSet3Pl1, txtSet4Pl1, txtSet5Pl1, txtSet1Pl2, txtSet2Pl2, txtSet3Pl2, txtSet4Pl2, txtSet5Pl2;
    private ImageView ballPlayer1, ballPlayer2;
    private boolean ball1, ball2;
    private CardView cardSet3Pl1, cardSet3Pl2, cardPointsPl1, cardPointsPl2;

    @Override
    protected void onSaveInstanceState(Bundle outState) {               // save variable to temporary variable
        super.onSaveInstanceState(outState);
        outState.putInt("scorePlayer1Set1", scorePlayer1Set1);
        outState.putInt("scorePlayer1Set2", scorePlayer1Set2);
        outState.putInt("scorePlayer1Set3", scorePlayer1Set3);
        outState.putInt("scorePlayer2Set1", scorePlayer2Set1);
        outState.putInt("scorePlayer2Set2", scorePlayer2Set2);
        outState.putInt("scorePlayer2Set3", scorePlayer2Set3);
        outState.putInt("scorePlayer1", scorePlayer1);
        outState.putInt("scorePlayer2", scorePlayer2);
        outState.putInt("tie1", tie1);
        outState.putInt("tie2", tie2);
        outState.putInt("player1TieSet1", player1TieSet1);
        outState.putInt("player2TieSet1", player2TieSet1);
        outState.putInt("player1TieSet2", player1TieSet2);
        outState.putInt("player2TieSet2", player2TieSet2);
        outState.putInt("player1TieSet3", player1TieSet3);
        outState.putInt("player2TieSet3", player2TieSet3);
        outState.putString("Advantage1", Advantage1);
        outState.putString("Advantage2", Advantage2);
        outState.putInt("pointsWonPlayer1", pointsWonPlayer1);
        outState.putInt("pointsWonPlayer2", pointsWonPlayer2);
        outState.putInt("acePlayer1", acePlayer1);
        outState.putInt("acePlayer2", acePlayer2);
        outState.putInt("winPlayer1", winPlayer1);
        outState.putInt("winPlayer2", winPlayer2);
        outState.putInt("errPlayer1", errPlayer1);
        outState.putInt("errPlayer2", errPlayer2);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {       //restore value
        scorePlayer1Set1 = savedInstanceState.getInt("scorePlayer1Set1");
        scorePlayer1Set2 = savedInstanceState.getInt("scorePlayer1Set2");
        scorePlayer1Set3 = savedInstanceState.getInt("scorePlayer1Set3");
        scorePlayer2Set1 = savedInstanceState.getInt("scorePlayer2Set1");
        scorePlayer2Set2 = savedInstanceState.getInt("scorePlayer2Set2");
        scorePlayer2Set3 = savedInstanceState.getInt("scorePlayer2Set3");
        scorePlayer1 = savedInstanceState.getInt("scorePlayer1");
        scorePlayer2 = savedInstanceState.getInt("scorePlayer2");
        Advantage1 = savedInstanceState.getString("Advantage1");
        Advantage2 = savedInstanceState.getString("Advantage2");
        tie1 = savedInstanceState.getInt("tie1");
        tie2 = savedInstanceState.getInt("tie2");
        player1TieSet1 = savedInstanceState.getInt("player1TieSet1");
        player2TieSet1 = savedInstanceState.getInt("player2TieSet1");
        player1TieSet2 = savedInstanceState.getInt("player1TieSet2");
        player2TieSet2 = savedInstanceState.getInt("player2TieSet2");
        player1TieSet3 = savedInstanceState.getInt("player1TieSet3");
        player2TieSet3 = savedInstanceState.getInt("player2TieSet3");
        pointsWonPlayer1 = savedInstanceState.getInt("pointsWonPlayer1");
        pointsWonPlayer2 = savedInstanceState.getInt("pointsWonPlayer2");
        acePlayer1 = savedInstanceState.getInt("acePlayer1");
        acePlayer2 = savedInstanceState.getInt("acePlayer2");
        winPlayer1 = savedInstanceState.getInt("winPlayer1");
        winPlayer2 = savedInstanceState.getInt("winPlayer1");
        errPlayer1 = savedInstanceState.getInt("errPlayer1");
        errPlayer2 = savedInstanceState.getInt("errPlayer1");


        if (Advantage1.equals("AD") | Advantage2.equals("AD")) {
            advantageVisible();
            displayAdvantage1(Advantage1);
            displayAdvantage2(Advantage2);
        } else if (tie1 > 0 | tie2 > 0) {
            tieBreakVisible();
            displayTiePlayer1(tie1);
            displayTiePlayer2(tie2);

        } else {
            gamePointsVisible();
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
        if (player1TieSet1 > 0 | player2TieSet1 > 0) {
            tieSet1Player1.setVisibility(View.VISIBLE);
            tieSet1Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set1(player1TieSet1);
            displayTiePlayer2Set1(player2TieSet1);
        }
        if (player1TieSet2 > 0 | player2TieSet2 > 0) {
            tieSet2Player1.setVisibility(View.VISIBLE);
            tieSet2Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set2(player1TieSet2);
            displayTiePlayer2Set2(player2TieSet2);
        }
        if (player1TieSet3 > 0 | player2TieSet3 > 0) {
            tieSet3Player1.setVisibility(View.VISIBLE);
            tieSet3Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set3(player1TieSet3);
            displayTiePlayer2Set3(player2TieSet3);
        }
        displayGamesPlayer1Set1(scorePlayer1Set1);
        displayGamesPlayer1Set2(scorePlayer1Set2);
        displayGamesPlayer1Set3(scorePlayer1Set3);
        displayGamesPlayer2Set1(scorePlayer2Set1);
        displayGamesPlayer2Set2(scorePlayer2Set2);
        displayGamesPlayer2Set3(scorePlayer2Set3);
        displayPointsPlayer1(pointsWonPlayer1);
        displayPointsPlayer2(pointsWonPlayer2);
        displayAcesPlayer1(acePlayer1);
        displayAcesPlayer2(acePlayer2);
        displayWinnersPlayer1(winPlayer1);
        displayWinnersPlayer2(winPlayer2);
        displayErrorsPlayer1(errPlayer1);
        displayErrorsPlayer2(errPlayer2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            scorePlayer1Set1 = savedInstanceState.getInt("scorePlayer1Set1");
            scorePlayer1Set2 = savedInstanceState.getInt("scorePlayer1Set2");
            scorePlayer1Set3 = savedInstanceState.getInt("scorePlayer1Set3");
            scorePlayer2Set1 = savedInstanceState.getInt("scorePlayer2Set1");
            scorePlayer2Set2 = savedInstanceState.getInt("scorePlayer2Set2");
            scorePlayer2Set3 = savedInstanceState.getInt("scorePlayer2Set3");
            scorePlayer1 = savedInstanceState.getInt("scorePlayer1");
            scorePlayer2 = savedInstanceState.getInt("scorePlayer2");
            Advantage1 = savedInstanceState.getString("Advantage1");
            Advantage2 = savedInstanceState.getString("Advantage2");
            tie1 = savedInstanceState.getInt("tie1");
            tie2 = savedInstanceState.getInt("tie2");
            player1TieSet1 = savedInstanceState.getInt("player1TieSet1");
            player2TieSet1 = savedInstanceState.getInt("player2TieSet1");
            player1TieSet2 = savedInstanceState.getInt("player1TieSet2");
            player2TieSet2 = savedInstanceState.getInt("player2TieSet2");
            player1TieSet3 = savedInstanceState.getInt("player1TieSet3");
            player2TieSet3 = savedInstanceState.getInt("player2TieSet3");
            pointsWonPlayer1 = savedInstanceState.getInt("pointsWonPlayer1");
            pointsWonPlayer2 = savedInstanceState.getInt("pointsWonPlayer2");
            acePlayer1 = savedInstanceState.getInt("acePlayer1");
            acePlayer2 = savedInstanceState.getInt("acePlayer2");
            winPlayer1 = savedInstanceState.getInt("winPlayer1");
            winPlayer2 = savedInstanceState.getInt("winPlayer1");
            errPlayer1 = savedInstanceState.getInt("errPlayer1");
            errPlayer2 = savedInstanceState.getInt("errPlayer1");
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_three_sets);


    /*    txtPl1 = (TextView) findViewById(R.id.player_bottom_1);
        txtPl2 = (TextView) findViewById(R.id.player_bottom_2);
        editPl1 = (EditText) findViewById(R.id.text_player_1);
        editPl1.addTextChangedListener(this);
        editPl2 = (EditText) findViewById(R.id.text_player_2);
        editPl2.addTextChangedListener(this);*/

        invPlayer1 = (TextView) findViewById(R.id.player_1_score);
        invPlayer2 = (TextView) findViewById(R.id.player_2_score);
        invTiePlayer1 = (TextView) findViewById(R.id.player_1_score_tie);
        invTiePlayer2 = (TextView) findViewById(R.id.player_2_score_tie);
        invADvPlayer1 = (TextView) findViewById(R.id.advantage1);
        invAdvPlayer2 = (TextView) findViewById(R.id.advantage2);

        TextView txtPlayer1_bottom = (TextView) findViewById(R.id.player_bottom_1);
        TextView txtPlayer1_top = (TextView) findViewById(R.id.player_top_1);
        pl1 = getIntent().getExtras().getString("name_player1");
        txtPlayer1_top.setText(pl1);
        txtPlayer1_bottom.setText(pl1);
        TextView txtPlayer2_bottom = (TextView) findViewById(R.id.player_bottom_2);
        TextView txtPlayer2_top = (TextView) findViewById(R.id.player_top_2);
        pl2 = getIntent().getExtras().getString("name_player2");
        txtPlayer2_top.setText(pl2);
        txtPlayer2_bottom.setText(pl2);

        ballPlayer1 = (ImageView) findViewById(R.id.ball_player1);
        ballPlayer2 = (ImageView) findViewById(R.id.ball_player2);
        ball1 = getIntent().getExtras().getBoolean("serve_player_1");
        ball2 = getIntent().getExtras().getBoolean("serve_player_2");

        if (ball1) {
            ballPlayer1.setVisibility(View.VISIBLE);
            ballPlayer2.setVisibility(View.INVISIBLE);
        } else {
            ballPlayer1.setVisibility(View.INVISIBLE);
            ballPlayer2.setVisibility(View.VISIBLE);
        }

        tieSet1Player1 = (TextView) findViewById(R.id.set_1_tie_player1);
        tieSet2Player1 = (TextView) findViewById(R.id.set_2_tie_player1);
        tieSet3Player1 = (TextView) findViewById(R.id.set_3_tie_player1);
        tieSet1Player2 = (TextView) findViewById(R.id.set_1_tie_player2);
        tieSet2Player2 = (TextView) findViewById(R.id.set_2_tie_player2);
        tieSet3Player2 = (TextView) findViewById(R.id.set_3_tie_player2);

        tieSetsInvisible();

        txtSet1Pl1 = (TextView) findViewById(R.id.set_1_score_player1);
        txtSet2Pl1 = (TextView) findViewById(R.id.set_2_score_player1);
        txtSet3Pl1 = (TextView) findViewById(R.id.set_3_score_player1);
        txtSet1Pl2 = (TextView) findViewById(R.id.set_1_score_player2);
        txtSet2Pl2 = (TextView) findViewById(R.id.set_2_score_player2);
        txtSet3Pl2 = (TextView) findViewById(R.id.set_3_score_player2);
        ;
        cardSet3Pl1 = (CardView) findViewById(R.id.card_3_set_player1);
        cardSet3Pl2 = (CardView) findViewById(R.id.card_3_set_player2);
        cardPointsPl1 = (CardView) findViewById(R.id.card_point_player1);
        cardPointsPl2 = (CardView) findViewById(R.id.card_point_player2);


        Button goToMainMenu = (Button) findViewById(R.id.btn_go_to_main_menu);
        goToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainMenu = new Intent(ThreeSetsActivity.this, MenuActivity.class);
                startActivity(backToMainMenu);
            }
        });
        Button goToStats = (Button) findViewById(R.id.btn_go_to_stats);
        goToStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statsIntent = new Intent(ThreeSetsActivity.this, StatsActivity.class);
                statsIntent.putExtra("points_won_player1", pointsWonPlayer1);
                statsIntent.putExtra("points_won_player2", pointsWonPlayer2);
                statsIntent.putExtra("ace_player1", acePlayer1);
                statsIntent.putExtra("ace_player2", acePlayer2);
                statsIntent.putExtra("win_player1", winPlayer1);
                statsIntent.putExtra("win_player2", winPlayer2);
                statsIntent.putExtra("err_player1", errPlayer1);
                statsIntent.putExtra("err_player2", errPlayer2);
                statsIntent.putExtra("name_player1", pl1);
                statsIntent.putExtra("name_player2", pl2);
                startActivity(statsIntent);
            }

        });
    }


 /*   @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s == editPl1.getText()) {
            String tx1 = s.toString();
            txtPl1.setText(tx1);
        } else if (s == editPl2.getText()) {
            String tx2 = s.toString();
            txtPl2.setText(tx2);
        }
    }*/

    /**
     * Add points methods
     */
    public void addFifteenForPlayer1(View view) {
        if ((scorePlayer1Set1 == 6 & scorePlayer2Set1 == 6) | (scorePlayer1Set2 == 6 & scorePlayer2Set2 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 6)) {
            tiePlayer1();
            game();
        } else if (scorePlayer1 < 30) {
            scorePlayer1 = scorePlayer1 + 15;
            gamePointsVisible();
            displayForPlayer1(scorePlayer1);
        } else if (scorePlayer1 == 40 & scorePlayer2 == 40 & Advantage1.equals("") & Advantage2.equals("")) {
            Advantage1 = "AD";
            Advantage2 = "";
            advantageVisible();
            displayAdvantage1(Advantage1);
            displayAdvantage2(Advantage2);
        } else if (Advantage2.equals("AD")) {
            scorePlayer1 = 40;
            scorePlayer2 = 40;
            Advantage1 = "";
            Advantage2 = "";
            gamePointsVisible();
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        } else if (Advantage1.equals("AD") | (scorePlayer1 == 40 && scorePlayer2 != 40)) {
            game();
        } else {
            scorePlayer1 = 40;
            displayForPlayer1(scorePlayer1);
        }
        pointsWonPlayer1 = pointsWonPlayer1 + 1;
        displayPointsPlayer1(pointsWonPlayer1);
    }

    public void addFifteenForPlayer2(View view) {
        if ((scorePlayer1Set1 == 6 & scorePlayer2Set1 == 6) | (scorePlayer1Set2 == 6 & scorePlayer2Set2 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 6)) {
            tiePlayer2();
            game();
        } else if (scorePlayer2 < 30) {
            scorePlayer2 = scorePlayer2 + 15;
            displayForPlayer2(scorePlayer2);
            gamePointsVisible();
        } else if (scorePlayer1 == 40 & scorePlayer2 == 40 & Advantage1.equals("") & Advantage2.equals("")) {
            Advantage2 = "AD";
            Advantage1 = "";
            advantageVisible();
            displayAdvantage1(Advantage1);
            displayAdvantage2(Advantage2);
        } else if (Advantage1.equals("AD")) {
            scorePlayer1 = 40;
            scorePlayer2 = 40;
            Advantage1 = "";
            Advantage2 = "";
            gamePointsVisible();
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        } else if (Advantage2.equals("AD") | (scorePlayer2 == 40 && scorePlayer1 != 40)) {
            game();
        } else {
            scorePlayer2 = 40;
            displayForPlayer2(scorePlayer2);
        }
        pointsWonPlayer2 = pointsWonPlayer2 + 1;
        displayPointsPlayer2(pointsWonPlayer2);
    }

    public void aceForPlayer1(View v) {
        acePlayer1 = acePlayer1 + 1;
        addFifteenForPlayer1(v);
        displayAcesPlayer1(acePlayer1);
    }

    public void aceForPlayer2(View v) {
        acePlayer2 = acePlayer2 + 1;
        addFifteenForPlayer2(v);
        displayAcesPlayer2(acePlayer2);
    }

    public void winnerPlayer1(View v) {
        winPlayer1 = winPlayer1 + 1;
        addFifteenForPlayer1(v);
        displayWinnersPlayer1(winPlayer1);
    }

    public void winnerPlayer2(View v) {
        winPlayer2 = winPlayer2 + 1;
        addFifteenForPlayer2(v);
        displayWinnersPlayer2(winPlayer2);
    }

    public void errorPlayer1(View v) {
        errPlayer1 = errPlayer1 + 1;
        addFifteenForPlayer2(v);
        displayErrorsPlayer1(errPlayer1);
    }

    public void errorPlayer2(View v) {
        errPlayer2 = errPlayer2 + 1;
        addFifteenForPlayer1(v);
        displayErrorsPlayer2(errPlayer2);
    }
    /**
     * Tie break methods
     */
    public void tiePlayer1() {
        Advantage1 = "";
        Advantage2 = "";
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        tie1 = tie1 + 1;
        tieBreakVisible();
        tieBreakCalculation();
        displayTiePlayer1(tie1);
    }

    public void tiePlayer2() {
        Advantage1 = "";
        Advantage2 = "";
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        tie2 = tie2 + 1;
        tieBreakVisible();
        tieBreakCalculation();
        displayTiePlayer2(tie2);

    }

    public void tieBreakCalculation() {
        if ((scorePlayer1Set1 == 6 & scorePlayer2Set1 == 6)) {
            player1TieSet1 = tie1;
            player2TieSet1 = tie2;
        } else if ((scorePlayer1Set1 == 7 & scorePlayer2Set1 == 6) | (scorePlayer1Set1 == 6 & scorePlayer2Set1 == 7) && (scorePlayer1Set2 != 6 & scorePlayer2Set2 != 6)) {
            tieSet1Player1.setVisibility(View.VISIBLE);
            tieSet1Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set1(player1TieSet1);
            displayTiePlayer2Set1(player2TieSet1);
            tie1 = 0;
            tie2 = 0;
        }
        if ((scorePlayer1Set2 == 6 & scorePlayer2Set2 == 6)) {
            player1TieSet2 = tie1;
            player2TieSet2 = tie2;
        } else if ((scorePlayer1Set2 == 7 & scorePlayer2Set2 == 6) | (scorePlayer1Set2 == 6 & scorePlayer2Set2 == 7) && (scorePlayer1Set3 != 6 & scorePlayer2Set3 != 6)) {
            tieSet2Player1.setVisibility(View.VISIBLE);
            tieSet2Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set2(player1TieSet2);
            displayTiePlayer2Set2(player2TieSet2);
            tie1 = 0;
            tie2 = 0;
        }
        if (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 6) {
            player1TieSet3 = tie1;
            player2TieSet3 = tie2;
        } else if ((scorePlayer1Set3 == 7 & scorePlayer2Set3 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 7)) {
            tieSet3Player1.setVisibility(View.VISIBLE);
            tieSet3Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set3(player1TieSet3);
            displayTiePlayer2Set3(player2TieSet3);
            tie1 = 0;
            tie2 = 0;
        }
    }

    /**
     * This method resets the score in the game
     */
    public void resetGame() {
        tieBreakCalculation();
        ballPlayer();
        Advantage1 = "";
        Advantage2 = "";
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        invPlayer1.setVisibility(View.VISIBLE);
        invPlayer2.setVisibility(View.VISIBLE);
        displayForPlayer1(scorePlayer1);
        displayForPlayer2(scorePlayer2);
        displayAdvantage1(Advantage1);
        displayAdvantage2(Advantage2);
        displayTiePlayer1(tie1);
        displayTiePlayer2(tie2);
        displayGamesPlayer1Set1(scorePlayer1Set1);
        displayGamesPlayer1Set2(scorePlayer1Set2);
        displayGamesPlayer1Set3(scorePlayer1Set3);
        displayGamesPlayer2Set1(scorePlayer2Set1);
        displayGamesPlayer2Set2(scorePlayer2Set2);
        displayGamesPlayer2Set3(scorePlayer2Set3);
        displayTiePlayer1Set1(player1TieSet1);
        displayTiePlayer1Set2(player1TieSet2);
        displayTiePlayer1Set3(player1TieSet3);
        displayTiePlayer2Set1(player2TieSet1);
        displayTiePlayer2Set2(player2TieSet2);
        displayTiePlayer2Set3(player2TieSet3);
    }

    /**
     * These methods check which player won the current game and add a point to the set
     */

    public void comparePointsSet1() {
        if ((scorePlayer1 > scorePlayer2 & scorePlayer1 == 40) | Advantage1.equals("AD") | (tie1 > 6 && (tie1 - tie2 > 1))) {
            scorePlayer1Set1 = scorePlayer1Set1 + 1;
            resetGame();
        } else if ((scorePlayer2 > scorePlayer1 & scorePlayer2 == 40) | Advantage2.equals("AD") | (tie2 > 6 && (tie2 - tie1 > 1))) {
            scorePlayer2Set1 = scorePlayer2Set1 + 1;
            resetGame();
        }
        if ((scorePlayer1Set1 > scorePlayer2Set1) && ((scorePlayer1Set1 >= 6 & scorePlayer2Set1 < 5) | (scorePlayer1Set1 == 7 & scorePlayer2Set1 >= 5))) {
            setsWonPlayer1 = setsWonPlayer1 + 1;
        } else if ((scorePlayer2Set1 > scorePlayer1Set1) && ((scorePlayer2Set1 >= 6) & scorePlayer1Set1 < 5) | (scorePlayer2Set1 == 7 & scorePlayer1Set1 >= 5)) {
            setsWonPlayer2 = setsWonPlayer2 + 1;
        }
        System.out.println(scorePlayer1Set1);
        System.out.println(scorePlayer2Set1);
        System.out.println(setsWonPlayer1);
        System.out.println(setsWonPlayer2);
    }

    public void comparePointsSet2() {
        if ((scorePlayer1 > scorePlayer2 & scorePlayer1 == 40) | Advantage1.equals("AD") | (tie1 > 6 && (tie1 - tie2 > 1))) {
            scorePlayer1Set2 = scorePlayer1Set2 + 1;
            resetGame();
        } else if ((scorePlayer2 > scorePlayer1 & scorePlayer2 == 40) | Advantage2.equals("AD") | (tie2 > 6 && (tie2 - tie1 > 1))) {
            scorePlayer2Set2 = scorePlayer2Set2 + 1;
            resetGame();
        }
        if ((scorePlayer1Set2 > scorePlayer2Set2) && ((scorePlayer1Set2 >= 6 & scorePlayer2Set2 < 5) | (scorePlayer1Set2 == 7 & scorePlayer2Set2 >= 5))) {
            setsWonPlayer1 = setsWonPlayer1 + 1;
        } else if ((scorePlayer2Set2 > scorePlayer1Set2) && ((scorePlayer2Set2 >= 6 & scorePlayer1Set2 < 5) | (scorePlayer2Set2 == 7 & scorePlayer1Set2 >= 5))) {
            setsWonPlayer2 = setsWonPlayer2 + 1;
        }
        if (setsWonPlayer1 == 2) {
            Toast.makeText(this, pl1 + "  won the match!", Toast.LENGTH_LONG).show();
            cardSet3Pl1.setVisibility(View.INVISIBLE);
            cardSet3Pl2.setVisibility(View.INVISIBLE);
            cardPointsPl1.setVisibility(View.INVISIBLE);
            cardPointsPl2.setVisibility(View.INVISIBLE);
            ballPlayer1.setVisibility(View.INVISIBLE);
            ballPlayer2.setVisibility(View.INVISIBLE);
        } else if (setsWonPlayer2 == 2) {
            Toast.makeText(this, pl2 + "  won the match!", Toast.LENGTH_LONG).show();
            cardSet3Pl1.setVisibility(View.INVISIBLE);
            cardSet3Pl2.setVisibility(View.INVISIBLE);
            cardPointsPl1.setVisibility(View.INVISIBLE);
            cardPointsPl2.setVisibility(View.INVISIBLE);
            ballPlayer1.setVisibility(View.INVISIBLE);
            ballPlayer2.setVisibility(View.INVISIBLE);
        }
    }

    public void comparePointsSet3() {
        if ((scorePlayer1 > scorePlayer2 & scorePlayer1 == 40) | Advantage1.equals("AD") | (tie1 > 6 && (tie1 - tie2 > 1))) {
            scorePlayer1Set3 = scorePlayer1Set3 + 1;
            resetGame();
        } else if ((scorePlayer2 > scorePlayer1 & scorePlayer2 == 40) | Advantage2.equals("AD") | (tie2 > 6 && (tie2 - tie1 > 1))) {
            scorePlayer2Set3 = scorePlayer2Set3 + 1;
            resetGame();
        }
        if ((scorePlayer1Set3 > scorePlayer2Set3) && ((scorePlayer1Set3 >= 6 & scorePlayer2Set3 < 5) | (scorePlayer1Set3 == 7 & scorePlayer2Set3 >= 5))) {
            setsWonPlayer1 = setsWonPlayer1 + 1;
        } else if ((scorePlayer2Set3 > scorePlayer1Set3) && ((scorePlayer2Set3 >= 6 & scorePlayer1Set3 < 5) | (scorePlayer2Set3 == 7 & scorePlayer1Set3 >= 5))) {
            setsWonPlayer2 = setsWonPlayer2 + 1;
        }
        System.out.println(scorePlayer1Set3);
        System.out.println(scorePlayer2Set3);
        System.out.println(setsWonPlayer1);
        System.out.println(setsWonPlayer2);
        if (setsWonPlayer1 == 2) {
            Toast.makeText(this, pl1 + "  won the match!", Toast.LENGTH_LONG).show();
            cardPointsPl1.setVisibility(View.INVISIBLE);
            cardPointsPl2.setVisibility(View.INVISIBLE);
            ballPlayer1.setVisibility(View.INVISIBLE);
            ballPlayer2.setVisibility(View.INVISIBLE);
        } else if (setsWonPlayer2 == 2) {
            Toast.makeText(this, pl2 + "  won the match!", Toast.LENGTH_LONG).show();
            cardPointsPl1.setVisibility(View.INVISIBLE);
            cardPointsPl2.setVisibility(View.INVISIBLE);
            ballPlayer1.setVisibility(View.INVISIBLE);
            ballPlayer2.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * This method checks if the point should be added to the current or to the next set
     */
    public void game() {
        if ((scorePlayer1Set1 < 6 & scorePlayer2Set1 < 6) | (scorePlayer1Set1 == 6 & scorePlayer2Set1 == 5) | (scorePlayer1Set1 == 5 & scorePlayer2Set1 == 6)
                | (scorePlayer1Set1 == 6 & scorePlayer2Set1 == 6)) {
            comparePointsSet1();
            displayGamesPlayer1Set1(scorePlayer1Set1);
            displayGamesPlayer2Set1(scorePlayer2Set1);

        } else if ((scorePlayer1Set1 >= 6 | scorePlayer2Set1 >= 6) & (scorePlayer1Set2 < 6 & scorePlayer2Set2 < 6) | (scorePlayer1Set2 == 6 & scorePlayer2Set2 == 5)
                | (scorePlayer1Set2 == 5 & scorePlayer2Set2 == 6) | (scorePlayer1Set2 == 6 & scorePlayer2Set2 == 6) & scorePlayer1Set3 == 0 & scorePlayer2Set3 == 0) {
            comparePointsSet2();
            displayGamesPlayer1Set2(scorePlayer1Set2);
            displayGamesPlayer2Set2(scorePlayer2Set2);
        } else if ((scorePlayer1Set2 >= 6 | scorePlayer2Set2 >= 6) & (scorePlayer1Set3 < 6 & scorePlayer2Set3 < 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 5)
                | (scorePlayer1Set3 == 5 & scorePlayer2Set3 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 6)) {
            comparePointsSet3();
            displayGamesPlayer1Set3(scorePlayer1Set3);
            displayGamesPlayer2Set3(scorePlayer2Set3);
        }
    }

    /**
     * These methods set the visibility to the current points type
     * Method ballPlayer change the ball to the player who is serving
     */

    public void tieBreakVisible() {
        invADvPlayer1.setVisibility(View.INVISIBLE);
        invAdvPlayer2.setVisibility(View.INVISIBLE);
        invPlayer1.setVisibility(View.INVISIBLE);
        invPlayer2.setVisibility(View.INVISIBLE);
        invTiePlayer1.setVisibility(View.VISIBLE);
        invTiePlayer2.setVisibility(View.VISIBLE);

    }

    public void gamePointsVisible() {
        invADvPlayer1.setVisibility(View.INVISIBLE);
        invAdvPlayer2.setVisibility(View.INVISIBLE);
        invTiePlayer1.setVisibility(View.INVISIBLE);
        invTiePlayer2.setVisibility(View.INVISIBLE);
        invPlayer1.setVisibility(View.VISIBLE);
        invPlayer2.setVisibility(View.VISIBLE);
    }

    public void advantageVisible() {
        invADvPlayer1.setVisibility(View.VISIBLE);
        invAdvPlayer2.setVisibility(View.VISIBLE);
        invPlayer1.setVisibility(View.INVISIBLE);
        invPlayer2.setVisibility(View.INVISIBLE);
        invTiePlayer1.setVisibility(View.INVISIBLE);
        invTiePlayer2.setVisibility(View.INVISIBLE);
    }

    public void tieSetsInvisible() {
        tieSet1Player1.setVisibility(View.INVISIBLE);
        tieSet2Player1.setVisibility(View.INVISIBLE);
        tieSet3Player1.setVisibility(View.INVISIBLE);
        tieSet1Player2.setVisibility(View.INVISIBLE);
        tieSet2Player2.setVisibility(View.INVISIBLE);
        tieSet3Player2.setVisibility(View.INVISIBLE);
    }

    public void setsVisibles() {
        cardSet3Pl1.setVisibility(View.VISIBLE);
        cardSet3Pl2.setVisibility(View.VISIBLE);
        cardPointsPl1.setVisibility(View.VISIBLE);
        cardPointsPl2.setVisibility(View.VISIBLE);
    }

    public void ballPlayer() {
        if (ball1) {
            ballPlayer1.setVisibility(View.INVISIBLE);
            ballPlayer2.setVisibility(View.VISIBLE);
            ball2 = true;
            ball1 = false;
        } else if (ball2) {
            ballPlayer1.setVisibility(View.VISIBLE);
            ballPlayer2.setVisibility(View.INVISIBLE);
            ball2 = false;
            ball1 = true;
        }

    }

    /**
     * Displays methods
     */
    public void displayForPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTiePlayer1(int score) {
        TextView scoreView = (TextView) findViewById(player_1_score_tie);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAdvantage1(String Adv) {
        TextView scoreView = (TextView) findViewById(R.id.advantage1);
        scoreView.setText(String.valueOf(Adv));
    }

    public void displayForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTiePlayer2(int score) {
        TextView scoreView = (TextView) findViewById(player_2_score_tie);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAdvantage2(String Adv) {
        TextView scoreView = (TextView) findViewById(R.id.advantage2);
        scoreView.setText(String.valueOf(Adv));
    }

    public void displayGamesPlayer1Set1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_1_score_player1);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesPlayer1Set2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_2_score_player1);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesPlayer1Set3(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_3_score_player1);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesPlayer2Set1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_1_score_player2);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesPlayer2Set2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_2_score_player2);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesPlayer2Set3(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_3_score_player2);
        scoreView.setText(String.valueOf(score));
    }
    public void displayPointsPlayer1(int score) {
        TextView txtPointsPlayer1 = (TextView) findViewById(R.id.txt_points_player1);
        txtPointsPlayer1.setText(String.valueOf(pointsWonPlayer1));
    }
    public void displayPointsPlayer2(int score) {
        TextView txtPointsPlayer2 = (TextView) findViewById(R.id.txt_points_player2);
        txtPointsPlayer2.setText(String.valueOf(pointsWonPlayer2));
    }
    public void displayAcesPlayer1(int score) {
        TextView txtAcesPlayer1 = (TextView) findViewById(R.id.txt_aces_player1);
        txtAcesPlayer1.setText(String.valueOf(acePlayer1));
    }
    public void displayAcesPlayer2(int score) {
        TextView txtAcesPlayer2 = (TextView) findViewById(R.id.txt_aces_player2);
        txtAcesPlayer2.setText(String.valueOf(acePlayer2));
    }
    public void displayWinnersPlayer1(int score) {
        TextView txtWinnersPlayer1 = (TextView) findViewById(R.id.txt_winners_player1);
        txtWinnersPlayer1.setText(String.valueOf(winPlayer1));
    }
    public void displayWinnersPlayer2(int score) {
        TextView txtWinnersPlayer2 = (TextView) findViewById(R.id.txt_winners_player2);
        txtWinnersPlayer2.setText(String.valueOf(winPlayer2));
    }
    public void displayErrorsPlayer1(int score) {
        TextView txtErrorsPlayer1 = (TextView) findViewById(R.id.txt_errors_player1);
        txtErrorsPlayer1.setText(String.valueOf(errPlayer1));
    }
    public void displayErrorsPlayer2(int score) {
        TextView txtErrorsPlayer2 = (TextView) findViewById(R.id.txt_errors_player2);
        txtErrorsPlayer2.setText(String.valueOf(errPlayer2));
    }
    public void displayTiePlayer1Set1(int score) {
        tieSet1Player1.setText(String.valueOf(score));
    }

    public void displayTiePlayer1Set2(int score) {
        tieSet2Player1.setText(String.valueOf(score));
    }

    public void displayTiePlayer1Set3(int score) {
        tieSet3Player1.setText(String.valueOf(score));
    }

    public void displayTiePlayer2Set1(int score) {
        tieSet1Player2.setText(String.valueOf(score));
    }

    public void displayTiePlayer2Set2(int score) {
        tieSet2Player2.setText(String.valueOf(score));
    }

    public void displayTiePlayer2Set3(int score) {
        tieSet3Player2.setText(String.valueOf(score));
    }

    /**
     * Resets all score
     */
    public void resetAll(View view) {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        Advantage1 = "";
        Advantage2 = "";
        tie1 = 0;
        tie2 = 0;
        scorePlayer1Set1 = 0;
        scorePlayer2Set1 = 0;
        scorePlayer1Set2 = 0;
        scorePlayer2Set2 = 0;
        scorePlayer1Set3 = 0;
        scorePlayer2Set3 = 0;
        player1TieSet1 = 0;
        player1TieSet2 = 0;
        player1TieSet3 = 0;
        player2TieSet1 = 0;
        player2TieSet2 = 0;
        player2TieSet3 = 0;
        pointsWonPlayer1 = 0;
        pointsWonPlayer2 = 0;
        acePlayer1 = 0;
        acePlayer2 = 0;
        winPlayer1 = 0;
        winPlayer2 = 0;
        errPlayer1 = 0;
        errPlayer2 = 0;
        displayForPlayer1(scorePlayer1);
        displayForPlayer2(scorePlayer2);
        displayAdvantage1(Advantage1);
        displayAdvantage2(Advantage2);
        displayTiePlayer1(tie1);
        displayTiePlayer2(tie2);
        displayGamesPlayer1Set1(scorePlayer1Set1);
        displayGamesPlayer2Set1(scorePlayer2Set1);
        displayGamesPlayer1Set2(scorePlayer1Set2);
        displayGamesPlayer2Set2(scorePlayer2Set2);
        displayGamesPlayer1Set3(scorePlayer1Set3);
        displayGamesPlayer2Set3(scorePlayer2Set3);
        tieSetsInvisible();
        setsVisibles();
    }


}