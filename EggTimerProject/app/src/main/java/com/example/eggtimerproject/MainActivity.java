package com.example.eggtimerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean buttonClicked = false;
    int currentTimer;
    TextView countdownTextView = (TextView) findViewById(R.id.timerCountdownText);
    String timeInString;
    String minutes, seconds;

    public void startTimer(View view) {

        if (!buttonClicked) {
            buttonClicked = true;
        } else {
            buttonClicked = true;
        }

        Button buttonStart = (Button) findViewById(R.id.timerButton);
        buttonStart.setText("STOP");


    }

    public void appControlInterface() {
        SeekBar seekBarTimer = findViewById(R.id.timerSeekBar);
        seekBarTimer.setMax(3600);


        seekBarTimer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 5;




                if (progress < min) {
                    currentTimer = min;
                    seekBarTimer.setProgress(currentTimer);
                } else {
                    currentTimer = progress;
                }

                timeInString = Integer.toString(currentTimer);

                minutes = Integer.toString(currentTimer / 60);
                seconds = Integer.toString(currentTimer % 60);

                if (minutes.length() == 1) {
                    minutes = "0" + minutes;
                }
                if (seconds.length() == 1) {
                    seconds = "0" + seconds;
                }

                countdownTextView.setText(minutes + ":" + seconds);
                Log.i("SeekBar Changed : ", timeInString);

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Button buttonStart = (Button) findViewById(R.id.timerButton);
                buttonStart.setText("START");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.airhorn);

        if (buttonClicked) {

            new CountDownTimer(currentTimer, 1000) {
                public void onTick(long millisecondsUntilDone) {
                    String millisecondsUntilDoneString = timeInString;

                    if (millisecondsUntilDoneString.length() == 1) {
                        minutes = "0" + minutes;
                    }
                    if (millisecondsUntilDoneString.length() == 1) {
                        seconds = "0" + seconds;
                    }

                    countdownTextView.setText(minutes + ":" + seconds);
                }

                public void onFinish() {
                    mediaPlayer.start();
                }
            }.start();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appControlInterface();

    }
}