package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public void startupAnimation() {

        ImageView imageView = (ImageView) findViewById(R.id.imageBart);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageHomer);
        imageView.animate().rotation(1800).translationXBy(0).setDuration(2000);

    }

    public void imageClick(View view) {

        ImageView imageView = (ImageView) findViewById(R.id.imageBart);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageHomer);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startupAnimation();

    }
}