package com.example.android.activtiy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class DynamicregisterBroadstReceiver extends Activity {
    private static final String BATTERY_ACTION = Intent.ACTION_BATTERY_CHANGED;
    private TextView tcTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tcTextView = (TextView) findViewById(R.id.btnactivityreigster);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
//        动态注册广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BATTERY_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);
    }
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(BATTERY_ACTION)){
                int status=intent.getIntExtra("status",0);
                int health=intent.getIntExtra("health",1);
                boolean present=intent.getBooleanExtra("present",false);
                int level=intent.getIntExtra("level",0);
                int scale=intent.getIntExtra("scale",0);
                int plugged=intent.getIntExtra("plugged",0);
                int temperature =intent.getIntExtra("temperature",0);
                String technology =intent.getStringExtra("techmology");
                String statusString ="未知状态";
            }
        }
    };
}