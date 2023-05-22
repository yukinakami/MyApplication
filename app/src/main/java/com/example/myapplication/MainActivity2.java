package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView scorea;
    TextView scoreb;

    int sca = 0;
    int scb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        scorea = findViewById(R.id.scorea);
        scoreb = findViewById(R.id.scoreb);
    }


    public void OnClick(View btn)
    {
        if(btn.getId()==R.id.btna3)
        {
            sca += 3;
        }
        else if(btn.getId()==R.id.btna2)
        {
            sca += 2;
        }
        else if(btn.getId()==R.id.btna1)
        {
            sca ++;
        }
        scorea.setText(String.valueOf(sca));
    }
    public void OnClick1(View btn)
    {
        if(btn.getId()==R.id.btnb3)
        {
            scb += 3;
        }
        else if(btn.getId()==R.id.btnb2)
        {
            scb += 2;
        }
        else if(btn.getId()==R.id.btnb1)
        {
            scb ++;
        }
        scoreb.setText(String.valueOf(scb));
    }
    public void reset(View btn)
    {
        sca = 0;
        scb = 0;
        scorea.setText(String.valueOf(sca));
        scoreb.setText(String.valueOf(scb));
    }
}