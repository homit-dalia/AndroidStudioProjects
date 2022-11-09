package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void familyNames() {

        ListView myFamilyList = findViewById(R.id.listView);

        ArrayList<String> myFamilyMembers = new ArrayList<String>();
        myFamilyMembers.add("Homit");
        myFamilyMembers.add("Hemant");
        myFamilyMembers.add("Parul");
        myFamilyMembers.add("Maitri");

        myFamilyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Item Pressed: ", myFamilyMembers.get(position));
                Toast.makeText(getApplicationContext(), myFamilyMembers.get(position), Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,myFamilyMembers);
        myFamilyList.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        familyNames();
    }
}