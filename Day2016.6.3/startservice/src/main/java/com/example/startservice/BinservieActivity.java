package com.example.startservice;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

/**
 * Created by Administrator on 2016/6/12.
 */
public class BinservieActivity  extends Activity{
    private BindService.MyBinds myBinds;
    protected ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            myBinds=(BindService.MyBinds)service;
            myBinds.StartDownLoad();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindservicr);
      this.findViewById(R.id.btnid).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(BinservieActivity.this,BindService.class);
              startService(intent);
          }
      });
        this.findViewById(R.id.btnid1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BinservieActivity.this,BindService.class);
                stopService(intent);
            }
        });
        this.findViewById(R.id.btndind).setOnClickListener(new View.OnClickListener() {
            @Override
//            绑定
            public void onClick(View v) {
                Intent intent=new Intent(BinservieActivity.this,BindService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);

            }
        });
        this.findViewById(R.id.btnlisdind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);

            }
        });
    }
}
