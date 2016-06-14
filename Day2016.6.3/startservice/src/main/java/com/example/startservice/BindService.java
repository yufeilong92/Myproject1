package com.example.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/12.
 */
public class BindService extends Service {
    private MyBinds myBinds =new MyBinds();
private static final String TAG="BindService";
    @Override
    public void onCreate() {
        Log.w(TAG, "BindService>>>>>onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.w(TAG, "BindService>>>>>onDestroy");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.w(TAG, "BindService>>>>>onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
  public class MyBinds extends Binder {
     public void StartDownLoad(){
       Log.i(TAG,"StartDownLoadStartDownLoad>>>");
     }
  }

}
