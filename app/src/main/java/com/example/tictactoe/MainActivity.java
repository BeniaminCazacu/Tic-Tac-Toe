package com.example.tictactoe;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button[][] buttons = new Button[3][3];
    private Button resetButton;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private boolean firstPlayerTurn = true;
    private boolean secondPlayerTurn = false;
    private boolean firstPlayerWins = false;
    private boolean secondPlayerWins = false;
    private int numberOfTurns = 0;
    private double playerOneScore = 0;
    private double playerTwoScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                String buttonId = "button_" + i + j;
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                buttons[i][j] = findViewById(resId);
                buttons[i][j].setOnClickListener(this);
            }
        }
        resetButton = findViewById(R.id.button_reset);
        resetButton.setOnClickListener(this);

        textViewPlayer1 = (TextView) findViewById(R.id.text_view_p1);
        textViewPlayer2 = (TextView) findViewById(R.id.text_view_p2);

        textViewPlayer1.setTextColor(Color.parseColor("#a4c639"));
    }

    //Functia se apeleaza in momentul cand este apasat unul dintre butoane
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_00:
                DetermineTheGameLogic(buttons[0][0]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_01:
                DetermineTheGameLogic(buttons[0][1]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_02:
                DetermineTheGameLogic(buttons[0][2]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_10:
                DetermineTheGameLogic(buttons[1][0]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_11:
                DetermineTheGameLogic(buttons[1][1]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_12:
                DetermineTheGameLogic(buttons[1][2]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_20:
                DetermineTheGameLogic(buttons[2][0]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_21:
                DetermineTheGameLogic(buttons[2][1]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_22:
                DetermineTheGameLogic(buttons[2][2]);
                ShowPlayerTurn();
                if(numberOfTurns >= 5){
                    DetermineTheWinner();
                }
                break;
            case R.id.button_reset:
                ResetTheGame();
                break;
        }
    }

    //Determinam castigatorul
    protected void DetermineTheWinner()
    {
        String[][] textButtons = new String[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                textButtons[i][j] = buttons[i][j].getText().toString();
            }
        }

        //Am luat in considerare optiunile de pe linii
        for(int i=0; i<3; i++){
            if(textButtons[i][0].equals(textButtons[i][1]) && textButtons[i][0].equals(textButtons[i][2]) && !textButtons[i][0].equals("")){
                if(textButtons[i][0].equals("X")){
                    Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                    firstPlayerWins = true;
                    secondPlayerWins = false;
                    PrepareForNextGame();
                }
                else {
                    Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                    firstPlayerWins = false;
                    secondPlayerWins = true;
                    PrepareForNextGame();
                }
            }
        }

        //Am luat in considerare optiunile de pe coloane
        for(int j=0; j<3; j++){
            if(textButtons[0][j].equals(textButtons[1][j]) && textButtons[0][j].equals(textButtons[2][j]) && !textButtons[0][j].equals("")){
                if(textButtons[0][j].equals("X")){
                    Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                    firstPlayerWins = true;
                    secondPlayerWins = false;
                    PrepareForNextGame();
                }
                else {
                    Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                    firstPlayerWins = false;
                    secondPlayerWins = true;
                    PrepareForNextGame();
                }
            }
        }

        //Am luat in considerare diagonala principala
        if(textButtons[0][0].equals(textButtons[1][1]) && textButtons[0][0].equals(textButtons[2][2]) && !textButtons[0][0].equals("")){
            if(textButtons[0][0].equals("X")){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                firstPlayerWins = true;
                secondPlayerWins = false;
                PrepareForNextGame();
            }
            else {
                Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                firstPlayerWins = false;
                secondPlayerWins = true;
                PrepareForNextGame();
            }
        }

        //Am luat in considerare diagonala secundara si cazul in care este remiza
        if(textButtons[2][0].equals(textButtons[1][1]) && textButtons[2][0].equals(textButtons[0][2]) && !textButtons[0][0].equals("")){
            if(textButtons[2][0].equals("X")){
                Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                firstPlayerWins = true;
                secondPlayerWins = false;
                PrepareForNextGame();
            }
            else{
                Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                firstPlayerWins = false;
                secondPlayerWins = true;
                PrepareForNextGame();
            }
        }
        else if(numberOfTurns == 9) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            firstPlayerWins = false;
            secondPlayerWins = false;
            PrepareForNextGame();
        }
    }

    //Determinam cand e X si cand e 0
    protected void DetermineTheGameLogic(Button button)
    {
        //Playerul care a castigat incepe cu X
        //Turele impare sunt pentru primul player
        //Turele pare sunt pentru al doilea player
        //Tot timpul al doilea player va avea ca optiune doar 0
        if(numberOfTurns == 0 && firstPlayerTurn){
            button.setText("X");
            button.setTextColor(Color.parseColor("#000000"));
        }
        else if(numberOfTurns == 0 && secondPlayerTurn){
            button.setText("X");
            button.setTextColor(Color.parseColor("#000000"));
        }
        else if((numberOfTurns%2) == 0)
        {
            button.setText("X");
            button.setTextColor(Color.parseColor("#000000"));
        }
        else if((numberOfTurns%2) != 0){
            button.setText("0");
            button.setTextColor(Color.parseColor("#a4c639"));
        }

        //blocam butonul pentru a nu mai fi apasat
        button.setEnabled(false);
        //incrementam numarul de ture
        numberOfTurns++;
    }

    //Indicam a cui player ii este randul
    protected void ShowPlayerTurn(){
        if(firstPlayerTurn) {
            firstPlayerTurn = false;
            secondPlayerTurn = true;
            textViewPlayer1.setTextColor(Color.parseColor("#808080"));
            textViewPlayer2.setTextColor(Color.parseColor("#a4c639"));
        } else {
            firstPlayerTurn = true;
            secondPlayerTurn = false;
            textViewPlayer1.setTextColor(Color.parseColor("#a4c639"));
            textViewPlayer2.setTextColor(Color.parseColor("#808080"));
        }
    }

    //Pregatim urmatorul joc
    protected void PrepareForNextGame(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttons[i][j].setText("");
            }
        }
        //Functie de rezultat, indicam cine este playerul care incepe primul jocul
        if(numberOfTurns == 9 && !firstPlayerWins && !secondPlayerWins) {
            //Remiza
            //incrementam scorul
            playerOneScore = playerOneScore + 0.5;
            playerTwoScore = playerTwoScore + 0.5;
            textViewPlayer1.setText("Player 1: " + playerOneScore);
            textViewPlayer2.setText("Player 2: " + playerTwoScore);

            firstPlayerTurn = true;
            secondPlayerTurn = false;
            textViewPlayer1.setTextColor(Color.parseColor("#a4c639"));
            textViewPlayer2.setTextColor(Color.parseColor("#808080"));
        }
        else if(firstPlayerWins)
        {
            //incrementam scorul
            playerOneScore = playerOneScore + 1;
            textViewPlayer1.setText("Player 1: " + playerOneScore);

            firstPlayerTurn = true;
            secondPlayerTurn = false;
            textViewPlayer1.setTextColor(Color.parseColor("#a4c639"));
            textViewPlayer2.setTextColor(Color.parseColor("#808080"));
        }
        else if(secondPlayerWins)
        {
            //incrementam scorul
            playerTwoScore = playerTwoScore + 1;
            textViewPlayer2.setText("Player 2: " + playerTwoScore);

            firstPlayerTurn = false;
            secondPlayerTurn = true;
            textViewPlayer1.setTextColor(Color.parseColor("#808080"));
            textViewPlayer2.setTextColor(Color.parseColor("#a4c639"));
        }

        //deblocam butoanele
        EnableTheButtons();
        //resetam la 0 numarul de ture
        numberOfTurns = 0;
    }

    //Resetam jocul
    protected void ResetTheGame(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttons[i][j].setText("");
            }
        }

        firstPlayerTurn = true;
        secondPlayerTurn = false;
        firstPlayerWins = false;
        secondPlayerWins = false;
        numberOfTurns = 0;
        playerOneScore = 0;
        playerTwoScore = 0;
        textViewPlayer1.setText("Player 1: 0");
        textViewPlayer2.setText("Player 2: 0");
        textViewPlayer1.setTextColor(Color.parseColor("#a4c639"));
        textViewPlayer2.setTextColor(Color.parseColor("#808080"));

        EnableTheButtons();
    }

    //Activam butoanele
    protected void EnableTheButtons()
    {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttons[i][j].setEnabled(true);
            }
        }
    }

    //Salvam culoarea butoanelor - UNDONE
    protected void SaveButtonsColor()
    {
        String[] colorStrings = new String[9];
        int counter = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                colorStrings[counter++] = (buttons[i][j].getTextColors().getDefaultColor() != Color.BLACK) ? "#a4c639" : "#000000";
            }
        }
        for(int i=0; i<counter; i++)
        {
            System.out.println(colorStrings[i] + " ");
        }
    }

    //Salvam starea instantei anterioare
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("firstPlayerTurn", firstPlayerTurn);
        outState.putBoolean("secondPlayerTurn", secondPlayerTurn);
        outState.putBoolean("firstPlayerWins", firstPlayerWins);
        outState.putBoolean("secondPlayerWins", secondPlayerWins);
        outState.putInt("numberOfTurns", numberOfTurns);
        outState.putDouble("playerOneScore", playerOneScore);
        outState.putDouble("playerTwoScore", playerTwoScore);

        //SaveButtonsColor(); UNDONE
    }

    //Recuperam instanta salvata
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        firstPlayerTurn = savedInstanceState.getBoolean("firstPlayerTurn");
        secondPlayerTurn = savedInstanceState.getBoolean("secondPlayerTurn");
        firstPlayerWins = savedInstanceState.getBoolean("firstPlayerWins");
        secondPlayerWins = savedInstanceState.getBoolean("secondPlayerWins");
        numberOfTurns = savedInstanceState.getInt("numberOfTurns");
        playerOneScore = savedInstanceState.getDouble("playerOneScore");
        playerTwoScore = savedInstanceState.getDouble("playerTwoScore");
    }
}