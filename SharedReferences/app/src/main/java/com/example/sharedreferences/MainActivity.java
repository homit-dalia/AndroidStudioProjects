package com.example.sharedreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       SharedPreferences sharedPreferences = this.getSharedPreferences
                ("com.example.sharedreferences", Context.MODE_PRIVATE);

        ArrayList<String> friends =  new ArrayList<>();

        friends.addAll(Arrays.asList("Fido", "Mark", "Carl", "Mickey"));

        try {

            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
            Log.i("friends",ObjectSerializer.serialize(friends));

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<>();
        try {
            newFriends =(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("new friends", newFriends.toString());

       /*  sharedPreferences.edit().putString("username", "Rob McElhenny").apply();
       String username = sharedPreferences.getString(" username","Hey Man");


        Log.i("This is the username", username);
        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText(username);*/
    }
}