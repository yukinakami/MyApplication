package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 准备数据项
        String[] list_data = {"one","two","three","four"};
        List<String> mylist = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            mylist.add("Item " + i);
        }
    }
}