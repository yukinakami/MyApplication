package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RateLisActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_lis3);

        ListView listView = findViewById(R.id.mylist);

        List<String> mylist = new ArrayList<>(100);
        for(int i = 1;i<=100;i++)
        {

        }
    }
}