package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void imageChange(View view){

        ImageView imageView = (ImageView) findViewById(R.id.imageBart);
        ImageView imageView2 = (ImageView) findViewById(R.id.image);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}