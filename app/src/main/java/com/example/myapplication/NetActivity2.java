package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;

public class NetActivity2 extends AppCompatActivity implements Runnable {
    private static final String TAG = "Net";

    Handler handler;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net2);
        show=findViewById(R.id.html_out);
        handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg)
            {
                if(msg.what == 7)
                {
                    String str = (String) msg.obj;
                    //收到子线程返回数据
                    Log.i(TAG,"handleMessage: 收到str=" + str);
                    //Toast.makeText(NetActivity2.this, "str", Toast.LENGTH_SHORT).show();
                    show.setText(str);
                }
                super.handleMessage(msg);
            }
        };

    }

    public void onclick(View btn)
    {
        Log.i(TAG,"onclick: ");
        Thread t = new Thread(this);
        Log.i(TAG,"onCreate: 启动子线程");
        t.start();
    }

    @Override
    public void run() {
        Log.i(TAG,"run:线程已运行");
        //可以访问网络资源
        //延时，模拟操作
        String retStr = "";
        try{
            Log.i(TAG,"run:正在工作......");
            //Thread.sleep(5000);
           // URL url = new URL("https://chl.cn/?jinri");
            //HttpURLConnection http = (HttpURLConnection) url.openConnection();
            //InputStream in = http.getErrorStream();

            //inputStream ==> String
            //String html = inputStream2String(in);
            //Log.i(TAG,"run: html=" + html);
            Document doc = Jsoup.connect("https://chl.cn/?jinri").get();
            Elements tables = doc.getElementsByTag("table");
            Element table1 = tables.first();
            Log.i(TAG,"run:table="+table1);
            Elements rows = table1.getElementsByTag("tr");
            for(Element row : rows)
            {
                Log.i(TAG,"run:row="+row);

                Elements tds = row.getElementsByTag("td");
                Element td1 = tds.first();
                Element td2 = tds.get(4);
                Log.i(TAG,"run:币种："+td1.text()+"价格"+td2.text());
                Log.i(TAG,"run:币种2："+td1.html()+"价格"+td2.html());
                //结果-》retStr
                retStr += ("run:币种："+td1.text()+"价格"+td2.text()+"\n");
            }

        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        //发送数据给主线程
        Message msg = handler.obtainMessage();
        msg.what = 7;
        msg.obj = retStr;
        handler.sendMessage(msg);
    }

    private String inputStream2String(InputStream inputStream)
            throws IOException
    {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream,"gb2312");
        while(true)
        {
            int rsz = in.read(buffer,0,buffer.length);
            if(rsz < 0)
                break;
            out.append(buffer,0,rsz);
        }
        return out.toString();
    }


}