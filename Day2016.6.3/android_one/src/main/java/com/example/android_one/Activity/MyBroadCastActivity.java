package com.example.android_one.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_one.BroadCastRecriver.MyBroadCastReceiver;
import com.example.android_one.R;

/**
 * Created by Administrator on 2016/6/8.
 */
public class MyBroadCastActivity extends Activity implements  MyBroadCastReceiver.BRInteraction{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mybroadcast);
        textView = (TextView) findViewById(R.id.tvview);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        MyBroadCastReceiver myBroadCastReceiver = new MyBroadCastReceiver();
        registerReceiver(myBroadCastReceiver,intentFilter);


    }

    @Override
    public void setText(String content) {
    if(content!=null){
        textView.setText(content);
        Log.i("broadcast","糊涂"+textView);
    }
    }
}
