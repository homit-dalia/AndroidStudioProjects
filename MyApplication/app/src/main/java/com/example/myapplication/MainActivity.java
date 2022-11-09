package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 10; j++) {
            timesTableContent.add(timesTableNumber + " x " + j + " =  " + Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);

        int max = 21, startingPosition = 5;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        generateTimesTable(5);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1, timesTableNumber;

                if (progress < min) {
                    seekBar.setProgress(min);
                    timesTableNumber = min;

                } else {
                    timesTableNumber = progress;
                }

                Log.i("SeekBar At : ", Integer.toString(progress));

                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}