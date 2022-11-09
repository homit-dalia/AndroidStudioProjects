package com.example.catswitcher2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void buttonClick(View view){

        Log.i("Info", "Button Click Successful");

        ImageView image = (ImageView) findViewById(R.id.imageViewCat1);
        image.setImageResource(R.drawable.cat2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}