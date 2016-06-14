package com.example.android.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
/**
 * Broadcast Receiver 广播接收器
 * 1.如何创建Briadcast Receiver
 *  a.新建一个集成Broadcast Receiver的类
 *  b.重写onReceiver（）方法
 *  c.注册广播.BroadcastReceiver 的生命周期
 *   调用广播执行完onReceive()结束，注意！！如果在onReceive()
 *   执行时间过长（10s）,系统报出应用用来响应（ANR）错误！1解决方案
 * 3.注册广播方法
 *   a.静态注册：androidManifest.xml
 *   b.动态注册：java代码注册
 * 4.广播类型
 *   a.普通广播：所有益听某个广播的接收者。都能收到广播
 *   b.有序广播：按接者优先顺序接收，优先在intent-finter中priority属性设置（-1000·100）
 */

/**
 * Created by Administrator on 2016/6/4.
 */
//广播接收器必须继承BroadcastReceiver类
public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
           String strmsg=intent.getExtras().getString("msg");
        Toast.makeText(context,"接收到广播消息是："+strmsg,Toast.LENGTH_SHORT).show();
    }
}
