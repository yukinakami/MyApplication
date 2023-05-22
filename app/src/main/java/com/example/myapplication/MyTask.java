package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class MyTask implements Runnable
{
    private Handler handler;

    public MyTask(Handler handler){this.handler = handler;}

    private static final String TAG = "Net";

    @Override
    public void run() {
        Log.i(TAG,"run:线程已运行");
        //可以访问网络资源
        //延时，模拟操作
        String retStr = "";
        Bundle retbundle = new Bundle();
        ArrayList<String> retlist = new ArrayList<>();
        try{
            Thread.sleep(5000);
            Log.i(TAG,"run:正在工作......");
            //Thread.sleep(5000);
            // URL url = new URL("https://chl.cn/?jinri");
            //HttpURLConnection http = (HttpURLConnection) url.openConnection();
            //InputStream in = http.getErrorStream();

            //inputStream ==> String
            //String html = inputStream2String(in);
            //Log.i(TAG,"run: html=" + html);
            Document doc = Jsoup.connect("https://www.boc.cn/sourcedb/whpj/").get();
            Elements tables = doc.getElementsByTag("table");
            Element table1 = tables.get(1);

            Elements rows = table1.getElementsByTag("tr");
            rows.remove(0);
            Log.i(TAG,"run:table="+rows);
            for(Element row : rows)
            {
                //Log.i(TAG,"run:row="+row);
                Log.i(TAG, "run: row="+row);
                Elements tds = row.getElementsByTag("td");
                Log.i(TAG, "run: td="+tds);
                Element td1 = tds.first();
                Element td2 = tds.get(4);
                String str1 = td1.text().trim();
                String str2 = td2.text().trim();
                Log.i(TAG,"run:币种："+td1.text()+"价格"+td2.text());

                //结果-》retStr
                if(str1.contains("美元"))
                {
                    retbundle.putFloat("dollar",100/Float.parseFloat(str2));
                }
                else if (str1.contains("欧元"))
                {
                    retbundle.putFloat("euro",100/Float.parseFloat(str2));
                }
                else if(str1.contains("韩元"))
                {
                    retbundle.putFloat("won",100/Float.parseFloat(str2));
                }
                retlist.add(str1 + "==>" +str2);
                retStr += ("run:币种："+td1.text()+"价格"+td2.text()+"\n");
            }

        }
        catch(MalformedURLException e)
        {
           throw new RuntimeException(e);
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //发送数据给主线程
        retbundle.putString("html",retStr);
        retbundle.putStringArrayList("mylist",retlist);
        Message msg = handler.obtainMessage();
        msg.what = 7;
        msg.obj = retbundle;
        handler.sendMessage(msg);
    }
}
