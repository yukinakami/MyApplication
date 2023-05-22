package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    TextView out;
    EditText edit;
    EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out = findViewById(R.id.textup2);
        edit = findViewById(R.id.textout);
        edit2 = findViewById(R.id.textout2);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View view){
        String str = edit.getText().toString();
        String strr = edit2.getText().toString();
        double d1 = Double.parseDouble (str);
        double d2 = Double.parseDouble (strr);
        double a;
        a = d2/(d1*d1);

        String a1 = String.format("%.2f", a);
        double a2 = Double.parseDouble(a1);

        if(a2>=18.5&&a2<=24) {
            out.setText("BMI是："+a2+"，你的身体身健康~");
        }
        else if(a2>24)
        {
            out.setText("BMI是："+a2+"，你有些超重啦！");
        }
        else if (a2>=24&&a2<28)
        {
            out.setText("BMI是："+a1+"，你处于肥胖的前期！");
        }
        else if(a2>=28&&a2<30)
        {
            out.setText("BMI是："+a2+"，你处于1级肥胖！");
        }
        else if(a2>=30&&a2<40)
        {
            out.setText("BMI是："+a2+"，你处于2级肥胖！");
        }
        else if(a2>=40)
        {
            out.setText("BMI是："+a2+"，你处于3级肥胖！");
        }
        else {
            out.setText("BMI是："+a2+"，你的体重太低啦！");
        }
    }
}
