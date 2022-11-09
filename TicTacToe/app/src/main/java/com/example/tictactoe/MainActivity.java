package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        int tappedCounter=Integer.parseInt(counter.getTag().toString());

        if (activePlayer == 0){
            counter.setImageResource(R.drawable.yellow);
            counter.setVisibility(View.VISIBLE); }

        else {
            counter.setImageResource(R.drawable.red);
            counter.setVisibility(View.VISIBLE);
            activePlayer = 1;
        }

        counter.animate().translationYBy(1500).setDuration(300);






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}