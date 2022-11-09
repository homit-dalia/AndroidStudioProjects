package com.example.toastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){

        EditText editName = (EditText) findViewById(R.id.editName);
        Log.i("Info", "Button Pressed");
        Log.i("Name", editName.getText().toString());
        String name = editName.getText().toString();
        Toast.makeText(this, "Hello " + name, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}