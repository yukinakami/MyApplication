package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecycle1Activity extends AppCompatActivity {

    ItemData[] itemData = new ItemData[]
            {
                    new ItemData("Email", android.R.drawable.ic_dialog_email),
                    new ItemData("Info", android.R.drawable.ic_dialog_info),
                    new ItemData("Delete", android.R.drawable.ic_delete),
                    new ItemData("Dialer", android.R.drawable.ic_dialog_dialer),
                    new ItemData("Alert", android.R.drawable.ic_dialog_alert),
                    new ItemData("Map", android.R.drawable.ic_dialog_map),
                    new ItemData("Email", android.R.drawable.ic_dialog_email),
                    new ItemData("Info", android.R.drawable.ic_dialog_info),
                    new ItemData("Delete", android.R.drawable.ic_delete),
                    new ItemData("Dialer", android.R.drawable.ic_dialog_dialer),
                    new ItemData("Alert", android.R.drawable.ic_dialog_alert),
                    new ItemData("Map", android.R.drawable.ic_dialog_map),

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycle1);
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(itemData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}