package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mian3Activity extends AppCompatActivity {

    TextView change_rate;

    TextView now_rate;

    EditText chinese_rate;

    TextView printout;

    int s1;

    private static final String TAG = "Run";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian3);
        //接受参数
        Intent intent = getIntent();

        String title = intent.getStringExtra("Title");
        String  price = intent.getStringExtra("Price");

        Log.i(TAG,"run:title = "+title);
        Log.i(TAG,"run:price = "+price);

        change_rate = findViewById(R.id.changerate);
        now_rate = findViewById(R.id.nowrate);
        now_rate.setText(price);
        change_rate.setText(title);
        chinese_rate = findViewById(R.id.chineserate);
        printout = findViewById(R.id.print);

    }
    public void hhh(View btn)
    {
        String a = now_rate.getText().toString();
        float b = Float.parseFloat (a);
        float c = 100/b;
        String d = chinese_rate.getText().toString();
        float e = Float.parseFloat (d);
        float f = e * c;
        String g = Float.toString(f);
        printout.setText(g);
    }


}
