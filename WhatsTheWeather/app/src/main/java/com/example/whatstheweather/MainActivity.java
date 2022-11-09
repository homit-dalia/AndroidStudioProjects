package com.example.whatstheweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView textViewWeather1,textViewWeather2, enteredCity;
    Button buttonWhatsTheWeather;
    String cityName,weatherInfo;

    public void downloadTask(){

        DownloadTask task = new DownloadTask();
        String weatherWebsiteFinal = "http://api.openweathermap.org/data/2.5/weather?q=" +
                cityName + "&appid=eba10ab837ea100dd76054977566d6e0";

        task.execute(weatherWebsiteFinal);
    }

    public void buttonClicked(View view){
        cityName = enteredCity.getText().toString();
        downloadTask();
        textViewWeather1.setText(weatherInfo);

        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(enteredCity.getWindowToken(),0);
    }

    public class DownloadTask extends AsyncTask<String, Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data!= -1){

                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {

                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONObject jsonObject = new JSONObject(s);
                weatherInfo = jsonObject.getString("main");

                Log.i("Weather Content",weatherInfo);

                JSONArray jsonArray = new JSONArray();

                for (int i = 0; i<jsonArray.length(); i++){

                    JSONObject jsonPart = jsonArray.getJSONObject(i);
                    Log.i("main", jsonPart.getString("feels_like"));

                }
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewWeather1 = findViewById(R.id.textViewWeatherDetails1);
        textViewWeather2 = findViewById(R.id.textViewWeatherDetails2);
        buttonWhatsTheWeather = findViewById(R.id.buttonWhatsTheWeather);
        enteredCity = findViewById(R.id.editTextTextCityName);

    }
}