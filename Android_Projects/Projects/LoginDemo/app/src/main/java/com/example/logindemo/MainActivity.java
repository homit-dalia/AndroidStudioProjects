package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void login(View view){

        EditText editUsername = (EditText) findViewById(R.id.editUsername);
        EditText editPassword = (EditText) findViewById(R.id.editPassword);
        Log.i("Info", "Login confirmed!");
        Log.i("Username", editUsername.getText().toString());
        Log.i("Password", editPassword.getText().toString());
        Toast.makeText(this, "Hello there. How's your day?", Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}