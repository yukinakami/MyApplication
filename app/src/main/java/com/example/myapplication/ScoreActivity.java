package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class ScoreActivity extends AppCompatActivity {

    TextView score;
    int s1;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score = findViewById(R.id.textup);
        s1 = 0;
    }

    public void OnClick(View btn) {
        if (btn.getId() == R.id.button3) {
            s1 += 3;
        } else if (btn.getId() == R.id.button2) {
            s1 += 2;
        } else if (btn.getId() == R.id.button1) {
            s1++;
        }
        score.setText(String.valueOf(s1));
        }


    public void reset(View btn)
    {
        s1 = 0;
        score.setText(String.valueOf(s1));
    }
    }
