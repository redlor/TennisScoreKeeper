package com.example.android.tennisscorekeeper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Hp on 28/02/2017.
 */

public class MenuActivity extends AppCompatActivity {

    public class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }
    boolean tieBreakCheck;

    private RadioButton threeSets, fiveSets, servePlayer1, servePlayer2, tieBreakYes, tieBreakNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        final EditText editPlayer1;
        final EditText editPlayer2;
        editPlayer1 = (EditText) findViewById(R.id.edt_player1);
        editPlayer2 = (EditText) findViewById(R.id.edt_player2);
        threeSets = (RadioButton) findViewById(R.id.radio_button_3sets);
        fiveSets = (RadioButton) findViewById(R.id.radio_button_5sets);
        servePlayer1 = (RadioButton) findViewById(R.id.radio_button_serve_pl1);
        servePlayer2 = (RadioButton) findViewById(R.id.radio_button_serve_pl2);
        tieBreakYes = (RadioButton) findViewById(R.id.tieBreakYes);
        tieBreakNo = (RadioButton) findViewById(R.id.tieBreakNo);


        Button goToMatch = (Button) findViewById(R.id.btn_go_to_match);
        goToMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tx1 = editPlayer1.getText().toString();
                String tx2 = editPlayer2.getText().toString();
                if (tx1.equals("")){
                    tx1 = "Player 1";
                }
                if (tx2.equals("")){
                    tx2 = "Player 2";
                }
                Intent match5Intent = new Intent(MenuActivity.this, FiveSetsActivity.class);
                Intent match3Intent = new Intent(MenuActivity.this, ThreeSetsActivity.class);
                match5Intent.putExtra("name_player1", tx1);
                match5Intent.putExtra("name_player2", tx2);
                match3Intent.putExtra("name_player1", tx1);
                match3Intent.putExtra("name_player2", tx2);

                System.out.println(tx1);
                if (tieBreakYes.isChecked()){
                    tieBreakCheck = true;
                    match3Intent.putExtra("tieBreakCheck", tieBreakCheck);
                    match5Intent.putExtra("tieBreakCheck", tieBreakCheck);
                }
                else if (tieBreakNo.isChecked()){
                    tieBreakCheck = false;
                    match3Intent.putExtra("tieBreakCheck", tieBreakCheck);
                    match5Intent.putExtra("tieBreakCheck", tieBreakCheck);
                }
                if (servePlayer1.isChecked()) {
                    Boolean servePlayer = servePlayer1.isChecked();
                    servePlayer1.setChecked(true);
                    match5Intent.putExtra("serve_player_1", servePlayer);
                    match3Intent.putExtra("serve_player_1", servePlayer);
                } else if (servePlayer2.isChecked()) {
                    Boolean servePlayer = servePlayer2.isChecked();
                    servePlayer2.setChecked(true);
                    match5Intent.putExtra("serve_player_2", servePlayer);
                    match3Intent.putExtra("serve_player_2", servePlayer);
                }
                if (fiveSets.isChecked() && ((!tx1.equals("") & !tx2.equals("")) & (servePlayer1.isChecked() | servePlayer2.isChecked()) & (tieBreakYes.isChecked() | tieBreakNo.isChecked()))) {
                    startActivity(match5Intent);
                } else if (threeSets.isChecked()&& ((!tx1.equals("") & !tx2.equals("")) & (servePlayer1.isChecked() | servePlayer2.isChecked()) & (tieBreakYes.isChecked() | tieBreakNo.isChecked()))) {
                    startActivity(match3Intent);
                }
                else {
                    Context context = getBaseContext();
                    CharSequence text = "Please select all the options to start the match";
                    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}

