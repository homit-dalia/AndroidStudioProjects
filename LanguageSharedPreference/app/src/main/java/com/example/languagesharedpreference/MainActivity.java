package com.example.languagesharedpreference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onLanguageChange(){

        sharedPreferences = this.getSharedPreferences
                ("com.example.languagesharedpreference", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("language",currentLanguage).apply();


        if (currentLanguage == "English"){
            textView.setText("Hola Amigo");
            currentLanguage = "Español";
        }
        else {
            textView.setText("Hello Friend");
            currentLanguage = "English";

        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.language:
                onLanguageChange();
                Toast.makeText(this, "Language changed to " + currentLanguage, Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this,
                        "We will contact you soon", Toast.LENGTH_LONG).show();
                break;
            default:
                return false;

        }

        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String currentLanguage = sharedPreferences.getString("language", "Error");
        textView = findViewById(R.id.textView);

        if (currentLanguage.equals("Error")) {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Select your language")
                    .setMessage("This language will be displayed through the app.")

                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,
                                    "Language set to English", Toast.LENGTH_SHORT).show();
                            currentLanguage = "English";
                            textView.setText("Hello Friend");
                        }
                    })
                    .setNegativeButton("Español", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,
                                    "Language set to Español", Toast.LENGTH_SHORT).show();
                            currentLanguage = "Español";
                            textView.setText("Hola Amigo");
                        }
                    })
                    .show();
        }
        else
            textView.setText(currentLanguage);
    }
}