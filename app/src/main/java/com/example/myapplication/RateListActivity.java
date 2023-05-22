package com.example.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RateListActivity extends ListActivity {

    Handler handler;

    private static final String TAG = "Net";

    private String logDate = "";
    private final String DATE_SP_KEY = "lastRateDateStr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 准备数据项
        // setContentView(R.layout.activity_rate_list);

        SharedPreferences sp = getSharedPreferences("myrate", Context.MODE_PRIVATE);
        logDate = sp.getString(DATE_SP_KEY, "");
        Log.i("List","lastRateDateStr=" + logDate);
        String[] list_data = {"one","two","three","four"};
        List<String> mylist = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            mylist.add("Item " + i);
        }

        // 设置适配器
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylist);

        setListAdapter(adapter);

        handler = new Handler(Looper.myLooper())
        {
            @Override
            public void handleMessage(@NonNull Message msg)
            {
                if(msg.what == 7)
                {
                    Bundle bundle = (Bundle) msg.obj;
                    ArrayList<String> list2 = bundle.getStringArrayList("mylist");
                    ListAdapter adapter = new ArrayAdapter<String>(RateListActivity.this, android.R.layout.simple_list_item_1,list2);
                    setListAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };
        Thread t = new Thread(new MyTask(handler));
        t.start();
    }

}
