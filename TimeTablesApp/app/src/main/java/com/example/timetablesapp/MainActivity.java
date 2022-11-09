package com.example.timetablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int i = 1, j = 1, n = 20, multiplication = 0;

    public void timeTable(int position) {

        ArrayList<Integer>[] timeTable = new ArrayList[n];

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= 10; j++) ;

            multiplication = i * j;
            timeTable[i].add(multiplication);

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView timeTableList = findViewById(R.id.timeTableListView);
        final SeekBar seekBarTimeTable = (SeekBar) findViewById(R.id.seekBar);

        seekBarTimeTable.setMax(n);
        seekBarTimeTable.setProgress(1);

        int startingposition = 1;

        timeTable();


        ArrayAdapter<Integer>[] arrayAdapter = new ArrayAdapter[n];
        seekBarTimeTable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress > 0) {
                    Log.i("SeekBar Changed", Integer.toString(progress));
                }
                else {
                    seekBar.setProgress(1);
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timeTable[progress]);

                timeTableList.setAdapter(arrayAdapter);


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