package com.example.braintimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button buttonGo, button1, button2, button3, button4, buttonPlayAgain;
    TextView appDescription, ready, set, score, timer, problem;

    boolean correctAnswerBoolean = true;
    long timeRemaining;
    int randomFirstNumberQuestion, randomSecondNumberQuestion,
            correctAnswer, correctAnswerButton,
            wrongAnswer1, wrongAnswer2, wrongAnswer3,
            randomOrderOfAnswer,
            randomOperatorForWrongAnswer1, randomOperatorForWrongAnswer2, randomOperatorForWrongAnswer3,
            wrongAnswerMargin1, wrongAnswerMargin2, wrongAnswerMargin3,
            currentScore = 0, totalNumberOfGamesPlayed = 0,
            buttonTag, defaultTime = 31000;

    CountDownTimer myCountdownTimer;

    String randomFirstNumberQuestionString, randomSecondNumberQuestionString,
            correctAnswerString, wrongAnswer1String, wrongAnswer2String, wrongAnswer3String;

    public void onGo(View view) {

        buttonGo.setVisibility(View.INVISIBLE);
        appDescription.setVisibility(View.INVISIBLE);
        ready.setVisibility(View.INVISIBLE);
        set.setVisibility(View.INVISIBLE);
        score.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        problem.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);

        generateAndAssignRandomNumberProblem();
    }

    public void answerClicked(View view) {

        buttonTag = Integer.parseInt(view.getTag().toString());
        myCountdownTimer.cancel();

        if (timer.getText() == "00s") {
            buttonPlayAgain.setVisibility(View.VISIBLE);
        }
        else {
            if (buttonTag == correctAnswerButton) {
                currentScore++;
                totalNumberOfGamesPlayed++;
                correctAnswerBoolean = true;

            } else {
                totalNumberOfGamesPlayed++;
                correctAnswerBoolean = false;
            }

            generateAndAssignRandomNumberProblem();
        }
        score.setText(currentScore + "/" + totalNumberOfGamesPlayed);
    }

    public void generateAndAssignRandomNumberProblem() {

        randomFirstNumberQuestion = new Random().nextInt(100) + 10;
        randomSecondNumberQuestion = new Random().nextInt(100) + 10;

        randomOrderOfAnswer = new Random().nextInt(4) + 1;

        correctAnswer = randomFirstNumberQuestion + randomSecondNumberQuestion;
        correctAnswerString = Integer.toString(correctAnswer);


        wrongAnswerGenerator();

        randomFirstNumberQuestionString = Integer.toString(randomFirstNumberQuestion);
        randomSecondNumberQuestionString = Integer.toString(randomSecondNumberQuestion);

        problem.setText(randomFirstNumberQuestionString + " + " + randomSecondNumberQuestionString);

        switch (randomOrderOfAnswer) {
            case 1:
                button1.setText(correctAnswerString);
                button2.setText(wrongAnswer1String);
                button3.setText(wrongAnswer2String);
                button4.setText(wrongAnswer3String);
                correctAnswerButton = 1;
                break;

            case 2:
                button1.setText(wrongAnswer1String);
                button2.setText(correctAnswerString);
                button3.setText(wrongAnswer2String);
                button4.setText(wrongAnswer3String);
                correctAnswerButton = 2;
                break;

            case 3:
                button1.setText(wrongAnswer2String);
                button2.setText(wrongAnswer1String);
                button3.setText(correctAnswerString);
                button4.setText(wrongAnswer3String);
                correctAnswerButton = 3;
                break;

            case 4:
                button1.setText(wrongAnswer3String);
                button2.setText(wrongAnswer1String);
                button3.setText(wrongAnswer2String);
                button4.setText(correctAnswerString);
                correctAnswerButton = 4;
                break;
        }
        timerResetOrDecrease();
    }

    public void wrongAnswerGenerator() {

        randomOperatorForWrongAnswer1 = new Random().nextInt(2) + 1;
        randomOperatorForWrongAnswer2 = new Random().nextInt(2) + 1;
        randomOperatorForWrongAnswer3 = new Random().nextInt(2) + 1;

        wrongAnswerMargin1 = new Random().nextInt(10) + 1;
        wrongAnswerMargin2 = new Random().nextInt(10) + 1;
        wrongAnswerMargin3 = new Random().nextInt(10) + 1;

        if (randomOperatorForWrongAnswer1 == 1) {
            wrongAnswer1 = correctAnswer - wrongAnswerMargin1;
        } else {
            wrongAnswer1 = correctAnswer + wrongAnswerMargin1;
        }

        if (randomOperatorForWrongAnswer2 == 1) {
            wrongAnswer2 = correctAnswer - wrongAnswerMargin2;
        } else {
            wrongAnswer2 = correctAnswer + wrongAnswerMargin2;
        }

        if (randomOperatorForWrongAnswer3 == 1) {
            wrongAnswer3 = correctAnswer - wrongAnswerMargin3;
        } else {
            wrongAnswer3 = correctAnswer + wrongAnswerMargin3;
        }

        wrongAnswer1String = Integer.toString(wrongAnswer1);
        wrongAnswer2String = Integer.toString(wrongAnswer2);
        wrongAnswer3String = Integer.toString(wrongAnswer3);
    }

    public void timerResetOrDecrease() {

        if (correctAnswerBoolean) {

            timeRemaining = defaultTime;

        } else {

            timeRemaining = timeRemaining - 5000;
        }

        startTimer();
    }

    public void startTimer() {

        myCountdownTimer = new CountDownTimer(timeRemaining, 1000) {
            public void onTick(long millisecondsUntilDone) {

                if (millisecondsUntilDone > 10000) {
                    timeRemaining = millisecondsUntilDone;
                    timer.setText((Long.toString(millisecondsUntilDone / 1000) + "s"));

                } else {
                    timeRemaining = millisecondsUntilDone;
                    timer.setText("0" + (Long.toString(millisecondsUntilDone / 1000) + "s"));

                }
            }

            public void onFinish() {
                timer.setText("00s");
                buttonPlayAgain.setVisibility(View.VISIBLE);
            }

        }.start();

    }

    public void playAgain(View view){

        score.setText("0/0");
        currentScore = 0;
        totalNumberOfGamesPlayed = 0;
        timeRemaining = 36000;

        generateAndAssignRandomNumberProblem();
        buttonPlayAgain.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGo = findViewById(R.id.buttonGo);
        button1 = findViewById(R.id.button1Answer);
        button2 = findViewById(R.id.button2Answer);
        button3 = findViewById(R.id.button3Answer);
        button4 = findViewById(R.id.button4Answer);

        appDescription = findViewById(R.id.textViewQuestion);
        ready = findViewById(R.id.textViewReady);
        set = findViewById(R.id.textViewSet);
        score = findViewById(R.id.textViewScore);
        timer = findViewById(R.id.textViewTimer);
        problem = findViewById(R.id.textViewProblem);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
    }
}