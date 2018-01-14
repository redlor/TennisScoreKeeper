package com.example.android.tennisscorekeeper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
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


public class FiveSetsActivity extends AppCompatActivity {

    String pl1, pl2;

    boolean tieTrue;

    int scorePlayer1Set1 = 0;
    int scorePlayer1Set2 = 0;
    int scorePlayer1Set3 = 0;
    int scorePlayer1Set4 = 0;
    int scorePlayer1Set5 = 0;
    int scorePlayer2Set1 = 0;
    int scorePlayer2Set2 = 0;
    int scorePlayer2Set3 = 0;
    int scorePlayer2Set4 = 0;
    int scorePlayer2Set5 = 0;

    int scorePlayer1 = 0;
    String Advantage1 = "";

    int scorePlayer2 = 0;
    String Advantage2 = "";

    int tie1 = 0;
    int tie2 = 0;

    int player1TieSet1, player1TieSet2, player1TieSet3, player1TieSet4, player1TieSet5, player2TieSet1, player2TieSet2, player2TieSet3, player2TieSet4, player2TieSet5;

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
    private TextView tieSet1Player1, tieSet2Player1, tieSet3Player1, tieSet4Player1, tieSet5Player1, tieSet1Player2, tieSet2Player2, tieSet3Player2, tieSet4Player2, tieSet5Player2;
    private ImageView ballPlayer1, ballPlayer2;
    private boolean ball1, ball2;
//    private TextView txtSet1Pl1, txtSet2Pl1, txtSet3Pl1, txtSet4Pl1, txtSet5Pl1, txtSet1Pl2, txtSet2Pl2, txtSet3Pl2, txtSet4Pl2, txtSet5Pl2;
    private CardView cardSet4Pl1, cardSet4Pl2, cardSet5Pl1, cardSet5Pl2, cardPointsPl1, cardPointsPl2;
    private Button btnPointPlayer1, btnPointPlayer2, btnAcePlayer1, btnAcePlayer2, btnWinnerPlayer1, btnWinnerPlayer2, btnErrorPlayer1, btnErrorPlayer2;

    static final String SCORE_PLAYER1_SET1_SAVED = "scorePlayer1Set1";
    static final String SCORE_PLAYER1_SET2_SAVED = "scorePlayer1Set2";
    static final String SCORE_PLAYER1_SET3_SAVED = "scorePlayer1Set3";
    static final String SCORE_PLAYER1_SET4_SAVED = "scorePlayer1Set4";
    static final String SCORE_PLAYER1_SET5_SAVED = "scorePlayer1Set5";
    static final String SCORE_PLAYER2_SET1_SAVED = "scorePlayer2Set1";
    static final String SCORE_PLAYER2_SET2_SAVED = "scorePlayer2Set2";
    static final String SCORE_PLAYER2_SET3_SAVED = "scorePlayer2Set3";
    static final String SCORE_PLAYER2_SET4_SAVED = "scorePlayer2Set4";
    static final String SCORE_PLAYER2_SET5_SAVED = "scorePlayer2Set5";
    static final String SCORE_PLAYER1_SAVED = "scorePlayer1";
    static final String SCORE_PLAYER2_SAVED = "scorePlayer2";
    static final String TIE1_SAVED = "tie1";
    static final String TIE2_SAVED = "tie2";
    static final String ADVANTAGE1_SAVED = "Advantage1";
    static final String ADVANTAGE2_SAVED = "Advantage2";
    static final String TIE_PLAYER1_SET1_SAVED = "player1TieSet1";
    static final String TIE_PLAYER1_SET2_SAVED = "player1TieSet2";
    static final String TIE_PLAYER1_SET3_SAVED = "player1TieSet3";
    static final String TIE_PLAYER1_SET4_SAVED = "player1TieSet4";
    static final String TIE_PLAYER1_SET5_SAVED = "player1TieSet5";
    static final String TIE_PLAYER2_SET1_SAVED = "player2TieSet1";
    static final String TIE_PLAYER2_SET2_SAVED = "player2TieSet2";
    static final String TIE_PLAYER2_SET3_SAVED = "player2TieSet3";
    static final String TIE_PLAYER2_SET4_SAVED = "player2TieSet4";
    static final String TIE_PLAYER2_SET5_SAVED = "player2TieSet5";
    static final String POINTS_WON_PLAYER1_SAVED = "pointsWonPlayer1";
    static final String POINTS_WON_PLAYER2_SAVED = "pointsWonPlayer2";
    static final String ACE_PLAYER1_SAVED = "acePlayer1";
    static final String ACE_PLAYER2_SAVED = "acePlayer2";
    static final String WIN_PLAYER1_SAVED = "winPlayer1";
    static final String WIN_PLAYER2_SAVED = "winPlayer2";
    static final String ERR_PLAYER1_SAVED = "errPlayer1";
    static final String ERR_PLAYER2_SAVED = "errPlayer2";
    static final String SETS_WON_PLAYER1_SAVED = "setsWonPlayer1";
    static final String SETS_WON_PLAYER2_SAVED = "setsWonPlayer2";

    @Override
    protected void onSaveInstanceState(Bundle outState) {               // save variable to temporary variable
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_PLAYER1_SET1_SAVED, scorePlayer1Set1);
        outState.putInt(SCORE_PLAYER1_SET2_SAVED, scorePlayer1Set2);
        outState.putInt(SCORE_PLAYER1_SET3_SAVED, scorePlayer1Set3);
        outState.putInt(SCORE_PLAYER1_SET4_SAVED, scorePlayer1Set4);
        outState.putInt(SCORE_PLAYER1_SET5_SAVED, scorePlayer1Set5);
        outState.putInt(SCORE_PLAYER2_SET1_SAVED, scorePlayer2Set1);
        outState.putInt(SCORE_PLAYER2_SET2_SAVED, scorePlayer2Set2);
        outState.putInt(SCORE_PLAYER2_SET3_SAVED, scorePlayer2Set3);
        outState.putInt(SCORE_PLAYER2_SET4_SAVED, scorePlayer2Set4);
        outState.putInt(SCORE_PLAYER2_SET5_SAVED, scorePlayer2Set5);
        outState.putInt(SCORE_PLAYER1_SAVED, scorePlayer1);
        outState.putInt(SCORE_PLAYER2_SAVED, scorePlayer2);
        outState.putInt(TIE1_SAVED, tie1);
        outState.putInt(TIE2_SAVED, tie2);
        outState.putInt(TIE_PLAYER1_SET1_SAVED, player1TieSet1);
        outState.putInt(TIE_PLAYER2_SET1_SAVED, player2TieSet1);
        outState.putInt(TIE_PLAYER1_SET2_SAVED, player1TieSet2);
        outState.putInt(TIE_PLAYER2_SET2_SAVED, player2TieSet2);
        outState.putInt(TIE_PLAYER1_SET3_SAVED, player1TieSet3);
        outState.putInt(TIE_PLAYER2_SET3_SAVED, player2TieSet3);
        outState.putInt(TIE_PLAYER1_SET4_SAVED, player1TieSet4);
        outState.putInt(TIE_PLAYER2_SET4_SAVED, player2TieSet4);
        outState.putInt(TIE_PLAYER1_SET5_SAVED, player1TieSet5);
        outState.putInt(TIE_PLAYER2_SET5_SAVED, player2TieSet5);
        outState.putString(ADVANTAGE1_SAVED, Advantage1);
        outState.putString(ADVANTAGE2_SAVED, Advantage2);
        outState.putInt(POINTS_WON_PLAYER1_SAVED, pointsWonPlayer1);
        outState.putInt(POINTS_WON_PLAYER2_SAVED, pointsWonPlayer2);
        outState.putInt(ACE_PLAYER1_SAVED, acePlayer1);
        outState.putInt(ACE_PLAYER2_SAVED, acePlayer2);
        outState.putInt(WIN_PLAYER1_SAVED, winPlayer1);
        outState.putInt(WIN_PLAYER2_SAVED, winPlayer2);
        outState.putInt(ERR_PLAYER1_SAVED, errPlayer1);
        outState.putInt(ERR_PLAYER2_SAVED, errPlayer2);
        outState.putInt(SETS_WON_PLAYER1_SAVED, setsWonPlayer1);
        outState.putInt(SETS_WON_PLAYER2_SAVED, setsWonPlayer2);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {       //restore value
        scorePlayer1Set1 = savedInstanceState.getInt(SCORE_PLAYER1_SET1_SAVED);
        scorePlayer1Set2 = savedInstanceState.getInt(SCORE_PLAYER1_SET2_SAVED);
        scorePlayer1Set3 = savedInstanceState.getInt(SCORE_PLAYER1_SET3_SAVED);
        scorePlayer1Set4 = savedInstanceState.getInt(SCORE_PLAYER1_SET4_SAVED);
        scorePlayer1Set5 = savedInstanceState.getInt(SCORE_PLAYER1_SET5_SAVED);
        scorePlayer2Set1 = savedInstanceState.getInt(SCORE_PLAYER2_SET1_SAVED);
        scorePlayer2Set2 = savedInstanceState.getInt(SCORE_PLAYER2_SET2_SAVED);
        scorePlayer2Set3 = savedInstanceState.getInt(SCORE_PLAYER2_SET3_SAVED);
        scorePlayer2Set4 = savedInstanceState.getInt(SCORE_PLAYER2_SET4_SAVED);
        scorePlayer2Set5 = savedInstanceState.getInt(SCORE_PLAYER2_SET5_SAVED);
        scorePlayer1 = savedInstanceState.getInt(SCORE_PLAYER1_SAVED);
        scorePlayer2 = savedInstanceState.getInt(SCORE_PLAYER2_SAVED);
        Advantage1 = savedInstanceState.getString(ADVANTAGE1_SAVED);
        Advantage2 = savedInstanceState.getString(ADVANTAGE2_SAVED);
        tie1 = savedInstanceState.getInt(TIE1_SAVED);
        tie2 = savedInstanceState.getInt(TIE2_SAVED);
        player1TieSet1 = savedInstanceState.getInt(TIE_PLAYER1_SET1_SAVED);
        player2TieSet1 = savedInstanceState.getInt(TIE_PLAYER2_SET1_SAVED);
        player1TieSet2 = savedInstanceState.getInt(TIE_PLAYER1_SET2_SAVED);
        player2TieSet2 = savedInstanceState.getInt(TIE_PLAYER2_SET2_SAVED);
        player1TieSet3 = savedInstanceState.getInt(TIE_PLAYER1_SET3_SAVED);
        player2TieSet3 = savedInstanceState.getInt(TIE_PLAYER2_SET3_SAVED);
        player1TieSet4 = savedInstanceState.getInt(TIE_PLAYER1_SET4_SAVED);
        player2TieSet4 = savedInstanceState.getInt(TIE_PLAYER2_SET4_SAVED);
        player1TieSet5 = savedInstanceState.getInt(TIE_PLAYER1_SET5_SAVED);
        player2TieSet5 = savedInstanceState.getInt(TIE_PLAYER2_SET5_SAVED);
        pointsWonPlayer1 = savedInstanceState.getInt(POINTS_WON_PLAYER1_SAVED);
        pointsWonPlayer2 = savedInstanceState.getInt(POINTS_WON_PLAYER2_SAVED);
        acePlayer1 = savedInstanceState.getInt(ACE_PLAYER1_SAVED);
        acePlayer2 = savedInstanceState.getInt(ACE_PLAYER2_SAVED);
        winPlayer1 = savedInstanceState.getInt(WIN_PLAYER1_SAVED);
        winPlayer2 = savedInstanceState.getInt(WIN_PLAYER2_SAVED);
        errPlayer1 = savedInstanceState.getInt(ERR_PLAYER1_SAVED);
        errPlayer2 = savedInstanceState.getInt(ERR_PLAYER2_SAVED);
        setsWonPlayer1 = savedInstanceState.getInt(SETS_WON_PLAYER1_SAVED);
        setsWonPlayer2 = savedInstanceState.getInt(SETS_WON_PLAYER2_SAVED);

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
        if ((player1TieSet1 > 0 | player2TieSet1 > 0) & (scorePlayer1Set1 > 6 | scorePlayer2Set1 > 6)) {
            tieSet1Player1.setVisibility(View.VISIBLE);
            tieSet1Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set1(player1TieSet1);
            displayTiePlayer2Set1(player2TieSet1);
        }
        if ((player1TieSet2 > 0 | player2TieSet2 > 0) & (scorePlayer1Set2 > 6 | scorePlayer2Set2 > 6)) {
            tieSet2Player1.setVisibility(View.VISIBLE);
            tieSet2Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set2(player1TieSet2);
            displayTiePlayer2Set2(player2TieSet2);
        }
        if ((player1TieSet3 > 0 | player2TieSet3 > 0) & (scorePlayer1Set3 > 6 | scorePlayer2Set3 > 6))  {
            tieSet3Player1.setVisibility(View.VISIBLE);
            tieSet3Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set3(player1TieSet3);
            displayTiePlayer2Set3(player2TieSet3);
        }
        if ((player1TieSet4 > 0 | player2TieSet4 > 0) & (scorePlayer1Set4 > 6 | scorePlayer2Set4 > 6)) {
            tieSet4Player1.setVisibility(View.VISIBLE);
            tieSet4Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set4(player1TieSet4);
            displayTiePlayer2Set4(player2TieSet4);
        }
        if ((player1TieSet5 > 0 | player2TieSet5 > 0) & (scorePlayer1Set5 > 6 | scorePlayer2Set5 > 6)) {
            tieSet5Player1.setVisibility(View.VISIBLE);
            tieSet5Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set5(player1TieSet5);
            displayTiePlayer2Set5(player2TieSet5);
        }

        displayGamesPlayer1Set1(scorePlayer1Set1);
        displayGamesPlayer1Set2(scorePlayer1Set2);
        displayGamesPlayer1Set3(scorePlayer1Set3);
        displayGamesPlayer1Set4(scorePlayer1Set4);
        displayGamesPlayer1Set5(scorePlayer1Set5);
        displayGamesPlayer2Set1(scorePlayer2Set1);
        displayGamesPlayer2Set2(scorePlayer2Set2);
        displayGamesPlayer2Set3(scorePlayer2Set3);
        displayGamesPlayer2Set4(scorePlayer2Set4);
        displayGamesPlayer2Set5(scorePlayer2Set5);
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
            scorePlayer1Set1 = savedInstanceState.getInt(SCORE_PLAYER1_SET1_SAVED);
            scorePlayer1Set2 = savedInstanceState.getInt(SCORE_PLAYER1_SET2_SAVED);
            scorePlayer1Set3 = savedInstanceState.getInt(SCORE_PLAYER1_SET3_SAVED);
            scorePlayer1Set4 = savedInstanceState.getInt(SCORE_PLAYER1_SET4_SAVED);
            scorePlayer1Set5 = savedInstanceState.getInt(SCORE_PLAYER1_SET5_SAVED);
            scorePlayer2Set1 = savedInstanceState.getInt(SCORE_PLAYER2_SET1_SAVED);
            scorePlayer2Set2 = savedInstanceState.getInt(SCORE_PLAYER2_SET2_SAVED);
            scorePlayer2Set3 = savedInstanceState.getInt(SCORE_PLAYER2_SET3_SAVED);
            scorePlayer2Set4 = savedInstanceState.getInt(SCORE_PLAYER2_SET4_SAVED);
            scorePlayer2Set5 = savedInstanceState.getInt(SCORE_PLAYER2_SET5_SAVED);
            scorePlayer1 = savedInstanceState.getInt(SCORE_PLAYER1_SAVED);
            scorePlayer2 = savedInstanceState.getInt(SCORE_PLAYER2_SAVED);
            Advantage1 = savedInstanceState.getString(ADVANTAGE1_SAVED);
            Advantage2 = savedInstanceState.getString(ADVANTAGE2_SAVED);
            tie1 = savedInstanceState.getInt(TIE1_SAVED);
            tie2 = savedInstanceState.getInt(TIE2_SAVED);
            player1TieSet1 = savedInstanceState.getInt(TIE_PLAYER1_SET1_SAVED);
            player2TieSet1 = savedInstanceState.getInt(TIE_PLAYER2_SET1_SAVED);
            player1TieSet2 = savedInstanceState.getInt(TIE_PLAYER1_SET2_SAVED);
            player2TieSet2 = savedInstanceState.getInt(TIE_PLAYER2_SET2_SAVED);
            player1TieSet3 = savedInstanceState.getInt(TIE_PLAYER1_SET3_SAVED);
            player2TieSet3 = savedInstanceState.getInt(TIE_PLAYER2_SET3_SAVED);
            player1TieSet4 = savedInstanceState.getInt(TIE_PLAYER1_SET4_SAVED);
            player2TieSet4 = savedInstanceState.getInt(TIE_PLAYER2_SET4_SAVED);
            player1TieSet5 = savedInstanceState.getInt(TIE_PLAYER1_SET5_SAVED);
            player2TieSet5 = savedInstanceState.getInt(TIE_PLAYER2_SET5_SAVED);
            pointsWonPlayer1 = savedInstanceState.getInt(POINTS_WON_PLAYER1_SAVED);
            pointsWonPlayer2 = savedInstanceState.getInt(POINTS_WON_PLAYER2_SAVED);
            acePlayer1 = savedInstanceState.getInt(ACE_PLAYER1_SAVED);
            acePlayer2 = savedInstanceState.getInt(ACE_PLAYER2_SAVED);
            winPlayer1 = savedInstanceState.getInt(WIN_PLAYER1_SAVED);
            winPlayer2 = savedInstanceState.getInt(WIN_PLAYER2_SAVED);
            errPlayer1 = savedInstanceState.getInt(ERR_PLAYER1_SAVED);
            errPlayer2 = savedInstanceState.getInt(ERR_PLAYER2_SAVED);
            setsWonPlayer1 = savedInstanceState.getInt(SETS_WON_PLAYER1_SAVED);
            setsWonPlayer2 = savedInstanceState.getInt(SETS_WON_PLAYER2_SAVED);
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);


    /*    txtPl1 = (TextView) findViewById(R.id.player_bottom_1);
        txtPl2 = (TextView) findViewById(R.id.player_bottom_2);
        editPl1 = (EditText) findViewById(R.id.text_player_1);
        editPl1.addTextChangedListener(this);
        editPl2 = (EditText) findViewById(R.id.text_player_2);
        editPl2.addTextChangedListener(this);*/

        invPlayer1 = (TextView) findViewById(player_1_score);
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

        tieTrue = getIntent().getExtras().getBoolean("tieBreakCheck");
        System.out.println(tieTrue);

        tieSet1Player1 = (TextView) findViewById(R.id.set_1_tie_player1);
        tieSet2Player1 = (TextView) findViewById(R.id.set_2_tie_player1);
        tieSet3Player1 = (TextView) findViewById(R.id.set_3_tie_player1);
        tieSet4Player1 = (TextView) findViewById(R.id.set_4_tie_player1);
        tieSet5Player1 = (TextView) findViewById(R.id.set_5_tie_player1);
        tieSet1Player2 = (TextView) findViewById(R.id.set_1_tie_player2);
        tieSet2Player2 = (TextView) findViewById(R.id.set_2_tie_player2);
        tieSet3Player2 = (TextView) findViewById(R.id.set_3_tie_player2);
        tieSet4Player2 = (TextView) findViewById(R.id.set_4_tie_player2);
        tieSet5Player2 = (TextView) findViewById(R.id.set_5_tie_player2);
        tieSetsInvisible();


        cardSet4Pl1 = (CardView) findViewById(R.id.card_4_set_player1);
        cardSet5Pl1 = (CardView) findViewById(R.id.card_5_set_player1);
        cardSet4Pl2 = (CardView) findViewById(R.id.card_4_set_player2);
        cardSet5Pl2 = (CardView) findViewById(R.id.card_5_set_player2);
        cardPointsPl1 = (CardView) findViewById(R.id.card_point_player1);
        cardPointsPl2 = (CardView) findViewById(R.id.card_point_player2);

        btnPointPlayer1 = (Button) findViewById(R.id.btn_point_player1);
        btnPointPlayer2 = (Button) findViewById(R.id.btn_point_player2);
        btnAcePlayer1 = (Button) findViewById(R.id.btn_ace_player1);
        btnAcePlayer2 = (Button) findViewById(R.id.btn_ace_player2);
        btnWinnerPlayer1 = (Button) findViewById(R.id.btn_winner_player1);
        btnWinnerPlayer2 = (Button) findViewById(R.id.btn_winner_player2);
        btnErrorPlayer1 = (Button) findViewById(R.id.btn_error_player1);
        btnErrorPlayer2 = (Button) findViewById(R.id.btn_error_player2);

        Button goToMainMenu = (Button) findViewById(R.id.btn_go_to_main_menu);
        goToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainMenu = new Intent(FiveSetsActivity.this, MenuActivity.class);
                startActivity(backToMainMenu);
            }
        });
        Button goToStats = (Button) findViewById(R.id.btn_go_to_stats);
        goToStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statsIntent = new Intent(FiveSetsActivity.this, StatsActivity.class);
                Boolean threeSets = false;
                statsIntent.putExtra("threeSets", threeSets);
                statsIntent.putExtra("scorePlayer1Set1", scorePlayer1Set1);
                statsIntent.putExtra("scorePlayer1Set2", scorePlayer1Set2);
                statsIntent.putExtra("scorePlayer1Set3", scorePlayer1Set3);
                statsIntent.putExtra("scorePlayer1Set4", scorePlayer1Set4);
                statsIntent.putExtra("scorePlayer1Set5", scorePlayer1Set5);
                statsIntent.putExtra("scorePlayer2Set1", scorePlayer2Set1);
                statsIntent.putExtra("scorePlayer2Set2", scorePlayer2Set2);
                statsIntent.putExtra("scorePlayer2Set3", scorePlayer2Set3);
                statsIntent.putExtra("scorePlayer2Set4", scorePlayer2Set4);
                statsIntent.putExtra("scorePlayer2Set5", scorePlayer2Set5);
                statsIntent.putExtra("player1TieSet1", player1TieSet1);
                statsIntent.putExtra("player1TieSet2", player1TieSet2);
                statsIntent.putExtra("player1TieSet3", player1TieSet3);
                statsIntent.putExtra("player1TieSet4", player1TieSet4);
                statsIntent.putExtra("player1TieSet5", player1TieSet5);
                statsIntent.putExtra("player2TieSet1", player2TieSet1);
                statsIntent.putExtra("player2TieSet2", player2TieSet2);
                statsIntent.putExtra("player2TieSet3", player2TieSet3);
                statsIntent.putExtra("player2TieSet4", player2TieSet4);
                statsIntent.putExtra("player2TieSet5", player2TieSet5);
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
        if ((scorePlayer1Set1 == 6 & scorePlayer2Set1 == 6) | (scorePlayer1Set2 == 6 & scorePlayer2Set2 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 6)
                | (scorePlayer1Set4 == 6 & scorePlayer2Set4 == 6) | ((scorePlayer1Set5 == 6 & scorePlayer2Set5 == 6) & tieTrue)) {
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
        if ((scorePlayer1Set1 == 6 & scorePlayer2Set1 == 6) | (scorePlayer1Set2 == 6 & scorePlayer2Set2 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 6)
                | (scorePlayer1Set4 == 6 & scorePlayer2Set4 == 6) | ((scorePlayer1Set5 == 6 & scorePlayer2Set5 == 6) & tieTrue)) {
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
        } else if ((scorePlayer1Set3 == 7 & scorePlayer2Set3 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 7) && (scorePlayer1Set4 != 6 & scorePlayer2Set4 != 6)) {
            tieSet3Player1.setVisibility(View.VISIBLE);
            tieSet3Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set3(player1TieSet3);
            displayTiePlayer2Set3(player2TieSet3);
            tie1 = 0;
            tie2 = 0;
        }
        if ((scorePlayer1Set4 == 6 & scorePlayer2Set4 == 6)) {
            player1TieSet4 = tie1;
            player2TieSet4 = tie2;
        } else if ((scorePlayer1Set4 == 7 & scorePlayer2Set4 == 6) | (scorePlayer1Set4 == 6 & scorePlayer2Set4 == 7) && (scorePlayer1Set5 != 6 & scorePlayer2Set5 != 6)) {
            tieSet4Player1.setVisibility(View.VISIBLE);
            tieSet4Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set4(player1TieSet4);
            displayTiePlayer2Set4(player2TieSet4);
            tie1 = 0;
            tie2 = 0;
        }
        if ((scorePlayer1Set5 == 6 & scorePlayer2Set5 == 6) & tieTrue) {
            player1TieSet5 = tie1;
            player2TieSet5 = tie2;
        } else if (tieTrue & ((scorePlayer1Set5 == 7 & scorePlayer2Set5 == 6) | (scorePlayer1Set5 == 6 & scorePlayer2Set5 == 7))) {
            tieSet5Player1.setVisibility(View.VISIBLE);
            tieSet5Player2.setVisibility(View.VISIBLE);
            displayTiePlayer1Set5(player1TieSet5);
            displayTiePlayer2Set5(player2TieSet5);
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
        displayGamesPlayer1Set4(scorePlayer1Set4);
        displayGamesPlayer1Set5(scorePlayer1Set5);
        displayGamesPlayer2Set1(scorePlayer2Set1);
        displayGamesPlayer2Set2(scorePlayer2Set2);
        displayGamesPlayer2Set3(scorePlayer2Set3);
        displayGamesPlayer2Set4(scorePlayer2Set4);
        displayGamesPlayer2Set5(scorePlayer2Set5);
        displayTiePlayer1Set1(player1TieSet1);
        displayTiePlayer1Set2(player1TieSet2);
        displayTiePlayer1Set3(player1TieSet3);
        displayTiePlayer1Set4(player1TieSet4);
        displayTiePlayer1Set5(player1TieSet5);
        displayTiePlayer2Set1(player2TieSet1);
        displayTiePlayer2Set2(player2TieSet2);
        displayTiePlayer2Set3(player2TieSet3);
        displayTiePlayer2Set4(player2TieSet4);
        displayTiePlayer2Set5(player2TieSet5);
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
        if ((scorePlayer1Set1 > scorePlayer2Set1) & ((scorePlayer1Set1 >= 6 & scorePlayer2Set1 < 5) | (scorePlayer1Set1 == 7 & scorePlayer2Set1 >= 5))) {
            setsWonPlayer1 = setsWonPlayer1 + 1;
        } else if ((scorePlayer2Set1 > scorePlayer1Set1) & ((scorePlayer2Set1 >= 6 & scorePlayer1Set1 < 5) | (scorePlayer2Set1 == 7 & scorePlayer1Set1 >= 5))) {
            setsWonPlayer2 = setsWonPlayer2 + 1;
        }

    }

    public void comparePointsSet2() {
        if ((scorePlayer1 > scorePlayer2 & scorePlayer1 == 40) | Advantage1.equals("AD") | (tie1 > 6 && (tie1 - tie2 > 1))) {
            scorePlayer1Set2 = scorePlayer1Set2 + 1;
            resetGame();
        } else if ((scorePlayer2 > scorePlayer1 & scorePlayer2 == 40) | Advantage2.equals("AD") | (tie2 > 6 && (tie2 - tie1 > 1))) {
            scorePlayer2Set2 = scorePlayer2Set2 + 1;
            resetGame();
        }
        if ((scorePlayer1Set2 > scorePlayer2Set2) & ((scorePlayer1Set2 >= 6 & scorePlayer2Set2 < 5) | (scorePlayer1Set2 == 7 & scorePlayer2Set2 >= 5))) {
            setsWonPlayer1 = setsWonPlayer1 + 1;
        } else if ((scorePlayer2Set2 > scorePlayer1Set2) & ((scorePlayer2Set2 >= 6 & scorePlayer1Set2 < 5) | (scorePlayer2Set2 == 7 & scorePlayer1Set2 >= 5))) {
            setsWonPlayer2 = setsWonPlayer2 + 1;
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
        if ((scorePlayer1Set3 > scorePlayer2Set3) & ((scorePlayer1Set3 >= 6 & scorePlayer2Set3 < 5) | (scorePlayer1Set3 == 7 & scorePlayer2Set3 >= 5))) {
            setsWonPlayer1 = setsWonPlayer1 + 1;
        } else if ((scorePlayer2Set3 > scorePlayer1Set3) & ((scorePlayer2Set3 >= 6 & scorePlayer1Set3 < 5) | (scorePlayer2Set3 == 7 & scorePlayer1Set3 >= 5))) {
            setsWonPlayer2 = setsWonPlayer2 + 1;
        }
        matchWon();
    }

    public void comparePointsSet4() {
        if ((scorePlayer1 > scorePlayer2 & scorePlayer1 == 40) | Advantage1.equals("AD") | (tie1 > 6 && (tie1 - tie2 > 1))) {
            scorePlayer1Set4 = scorePlayer1Set4 + 1;
            resetGame();
        } else if ((scorePlayer2 > scorePlayer1 & scorePlayer2 == 40) | Advantage2.equals("AD") | (tie2 > 6 && (tie2 - tie1 > 1))) {
            scorePlayer2Set4 = scorePlayer2Set4 + 1;
            resetGame();
        }
        if ((scorePlayer1Set4 > scorePlayer2Set4) & ((scorePlayer1Set4 >= 6 & scorePlayer2Set4 < 5) | (scorePlayer1Set4 == 7 & scorePlayer2Set4 >= 5))) {
            setsWonPlayer1 = setsWonPlayer1 + 1;
        } else if ((scorePlayer2Set4 > scorePlayer1Set4) & ((scorePlayer2Set4 >= 6 & scorePlayer1Set4 < 5) | (scorePlayer2Set4 == 7 & scorePlayer1Set4 >= 5))) {
            setsWonPlayer2 = setsWonPlayer2 + 1;
        }
        System.out.println(scorePlayer1Set4);
        System.out.println(scorePlayer2Set4);
        System.out.println(setsWonPlayer1);
        System.out.println(setsWonPlayer2);
        matchWon();
    }

    public void comparePointsSet5() {
        if ((scorePlayer1 > scorePlayer2 & scorePlayer1 == 40) | Advantage1.equals("AD") | (tie1 > 6 && (tie1 - tie2 > 1))) {
            scorePlayer1Set5 = scorePlayer1Set5 + 1;
            resetGame();
        } else if ((scorePlayer2 > scorePlayer1 & scorePlayer2 == 40) | Advantage2.equals("AD") | (tie2 > 6 && (tie2 - tie1 > 1))) {
            scorePlayer2Set5 = scorePlayer2Set5 + 1;
            resetGame();
        }
        if (tieTrue) {
            if ((scorePlayer1Set5 > scorePlayer2Set5) & ((scorePlayer1Set5 >= 6 & scorePlayer2Set5 < 5) | (scorePlayer1Set5 == 7 & scorePlayer2Set5 >= 5))) {
                setsWonPlayer1 = setsWonPlayer1 + 1;
            } else if ((scorePlayer2Set5 > scorePlayer1Set5) & ((scorePlayer2Set5 >= 6 & scorePlayer1Set5 < 5) | (scorePlayer2Set5 == 7 & scorePlayer1Set5 >= 5))) {
                setsWonPlayer2 = setsWonPlayer2 + 1;
            }
            matchWon();
        }
        else if (!(tieTrue)) {
            if ((scorePlayer1Set5 - scorePlayer2Set5 == 2) & (scorePlayer1Set5 >= 6 & scorePlayer2Set5 >= 6)){
                setsWonPlayer1 = setsWonPlayer1 + 1;
            }
            else if ((scorePlayer2Set5 - scorePlayer1Set5 == 2) & (scorePlayer1Set5 >= 6 & scorePlayer2Set5 >= 6)){
                setsWonPlayer2 = setsWonPlayer2 + 1;
            }
            matchWon();
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
                | (scorePlayer1Set3 == 5 & scorePlayer2Set3 == 6) | (scorePlayer1Set3 == 6 & scorePlayer2Set3 == 6) & scorePlayer1Set4 == 0 & scorePlayer2Set4 == 0) {
            comparePointsSet3();
            displayGamesPlayer1Set3(scorePlayer1Set3);
            displayGamesPlayer2Set3(scorePlayer2Set3);
        } else if ((scorePlayer1Set3 >= 6 | scorePlayer2Set3 >= 6) & (scorePlayer1Set4 < 6 & scorePlayer2Set4 < 6) | (scorePlayer1Set4 == 6 & scorePlayer2Set4 == 5)
                | (scorePlayer1Set4 == 5 & scorePlayer2Set4 == 6) | (scorePlayer1Set4 == 6 & scorePlayer2Set4 == 6) & scorePlayer1Set5 == 0 & scorePlayer2Set5 == 0) {
            comparePointsSet4();
            displayGamesPlayer1Set4(scorePlayer1Set4);
            displayGamesPlayer2Set4(scorePlayer2Set4);
        } else if ((scorePlayer1Set4 >= 6 | scorePlayer2Set4 >= 6) & (scorePlayer1Set5 < 6 & scorePlayer2Set5 < 6) | (scorePlayer1Set5 == 6 & scorePlayer2Set5 == 5)
                | (scorePlayer1Set5 == 5 & scorePlayer2Set5 == 6) | (scorePlayer1Set5 >= 6 & scorePlayer2Set5 >= 6)) {
            comparePointsSet5();
            displayGamesPlayer1Set5(scorePlayer1Set5);
            displayGamesPlayer2Set5(scorePlayer2Set5);
        }
    }
    /**
     * This method checks if a player won the match and disable buttons.
     * Orientation is locked when the match is over.
     */
    public void matchWon(){
        if (setsWonPlayer1 == 3) {
            int currentOrientation = getResources().getConfiguration().orientation;
            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            }
            else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            }
            Toast.makeText(this, pl1 + "  won the match!", Toast.LENGTH_LONG).show();
            btnPointPlayer1.setEnabled(false);
            btnPointPlayer2.setEnabled(false);
            btnAcePlayer1.setEnabled(false);
            btnAcePlayer2.setEnabled(false);
            btnWinnerPlayer1.setEnabled(false);
            btnWinnerPlayer2.setEnabled(false);
            btnErrorPlayer1.setEnabled(false);
            btnErrorPlayer2.setEnabled(false);
        } else if (setsWonPlayer2 == 3) {
            int currentOrientation = getResources().getConfiguration().orientation;
            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            }
            else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            }
            Toast.makeText(this, pl2 + "  won the match!", Toast.LENGTH_LONG).show();
            btnPointPlayer1.setEnabled(false);
            btnPointPlayer2.setEnabled(false);
            btnAcePlayer1.setEnabled(false);
            btnAcePlayer2.setEnabled(false);
            btnWinnerPlayer1.setEnabled(false);
            btnWinnerPlayer2.setEnabled(false);
            btnErrorPlayer1.setEnabled(false);
            btnErrorPlayer2.setEnabled(false);
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
        tieSet4Player1.setVisibility(View.INVISIBLE);
        tieSet5Player1.setVisibility(View.INVISIBLE);
        tieSet1Player2.setVisibility(View.INVISIBLE);
        tieSet2Player2.setVisibility(View.INVISIBLE);
        tieSet3Player2.setVisibility(View.INVISIBLE);
        tieSet4Player2.setVisibility(View.INVISIBLE);
        tieSet5Player2.setVisibility(View.INVISIBLE);
    }

    public void setsVisible() {
        cardSet4Pl1.setVisibility(View.VISIBLE);
        cardSet4Pl2.setVisibility(View.VISIBLE);
        cardSet5Pl1.setVisibility(View.VISIBLE);
        cardSet5Pl2.setVisibility(View.VISIBLE);
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

    public void displayGamesPlayer1Set4(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_4_score_player1);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesPlayer1Set5(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_5_score_player1);
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

    public void displayGamesPlayer2Set4(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_4_score_player2);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGamesPlayer2Set5(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set_5_score_player2);
        scoreView.setText(String.valueOf(score));
    }
    public void displayPointsPlayer1(int score) {
        TextView txtPointsPlayer1 = (TextView) findViewById(R.id.txt_points_player1);
        txtPointsPlayer1.setText(String.valueOf(score));
    }
    public void displayPointsPlayer2(int score) {
        TextView txtPointsPlayer2 = (TextView) findViewById(R.id.txt_points_player2);
        txtPointsPlayer2.setText(String.valueOf(score));
    }
    public void displayAcesPlayer1(int score) {
        TextView txtAcesPlayer1 = (TextView) findViewById(R.id.txt_aces_player1);
        txtAcesPlayer1.setText(String.valueOf(score));
    }
    public void displayAcesPlayer2(int score) {
        TextView txtAcesPlayer2 = (TextView) findViewById(R.id.txt_aces_player2);
        txtAcesPlayer2.setText(String.valueOf(score));
    }
    public void displayWinnersPlayer1(int score) {
        TextView txtWinnersPlayer1 = (TextView) findViewById(R.id.txt_winners_player1);
        txtWinnersPlayer1.setText(String.valueOf(score));
    }
    public void displayWinnersPlayer2(int score) {
        TextView txtWinnersPlayer2 = (TextView) findViewById(R.id.txt_winners_player2);
        txtWinnersPlayer2.setText(String.valueOf(score));
    }
    public void displayErrorsPlayer1(int score) {
        TextView txtErrorsPlayer1 = (TextView) findViewById(R.id.txt_errors_player1);
        txtErrorsPlayer1.setText(String.valueOf(score));
    }
    public void displayErrorsPlayer2(int score) {
        TextView txtErrorsPlayer2 = (TextView) findViewById(R.id.txt_errors_player2);
        txtErrorsPlayer2.setText(String.valueOf(score));
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

    public void displayTiePlayer1Set4(int score) {
        tieSet4Player1.setText(String.valueOf(score));
    }

    public void displayTiePlayer1Set5(int score) {
        tieSet5Player1.setText(String.valueOf(score));
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

    public void displayTiePlayer2Set4(int score) {
        tieSet4Player2.setText(String.valueOf(score));
    }

    public void displayTiePlayer2Set5(int score) {
        tieSet5Player2.setText(String.valueOf(score));
    }

    /**
     * Resets all score
     */
    public void resetAll(View view) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
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
        scorePlayer1Set4 = 0;
        scorePlayer2Set4 = 0;
        scorePlayer1Set5 = 0;
        scorePlayer2Set5 = 0;
        player1TieSet1 = 0;
        player1TieSet2 = 0;
        player1TieSet3 = 0;
        player1TieSet4 = 0;
        player1TieSet5 = 0;
        player2TieSet1 = 0;
        player2TieSet2 = 0;
        player2TieSet3 = 0;
        player2TieSet4 = 0;
        player2TieSet5 = 0;
        pointsWonPlayer1 = 0;
        pointsWonPlayer2 = 0;
        acePlayer1 = 0;
        acePlayer2 = 0;
        winPlayer1 = 0;
        winPlayer2 = 0;
        errPlayer1 = 0;
        errPlayer2 = 0;
        setsWonPlayer1 = 0;
        setsWonPlayer2 = 0;
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
        displayGamesPlayer1Set4(scorePlayer1Set4);
        displayGamesPlayer2Set4(scorePlayer2Set4);
        displayGamesPlayer1Set5(scorePlayer1Set5);
        displayGamesPlayer2Set5(scorePlayer2Set5);
        displayPointsPlayer1(pointsWonPlayer1);
        displayPointsPlayer2(pointsWonPlayer2);
        displayAcesPlayer1(acePlayer1);
        displayAcesPlayer2(acePlayer2);
        displayWinnersPlayer1(winPlayer1);
        displayWinnersPlayer2(winPlayer2);
        displayErrorsPlayer1(errPlayer1);
        displayErrorsPlayer2(errPlayer2);
        tieSetsInvisible();
        setsVisible();
        btnPointPlayer1.setEnabled(true);
        btnPointPlayer2.setEnabled(true);
        btnAcePlayer1.setEnabled(true);
        btnAcePlayer2.setEnabled(true);
        btnWinnerPlayer1.setEnabled(true);
        btnWinnerPlayer2.setEnabled(true);
        btnErrorPlayer1.setEnabled(true);
        btnErrorPlayer2.setEnabled(true);
    }


}