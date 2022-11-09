package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void buttonClick(View view){

        Log.i("Info", "Button Pressed");
        EditText editCurrency = (EditText) findViewById(R.id.editTextAmount);
        String currency = editCurrency.getText().toString();
        double dollar= Double.parseDouble(currency);
        double rupees = dollar*75;
        String rupeesInString = Double.toString(rupees);
        Toast.makeText(this, dollar + " $ in Rupees is " + "'" + rupeesInString + "' ₹", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}