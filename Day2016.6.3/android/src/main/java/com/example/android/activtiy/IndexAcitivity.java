package com.example.android.activtiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.R;

/**
 * Created by Administrator on 2016/6/3.
 */
public class IndexAcitivity extends Activity {
    //    声明按钮变量
    private Button btnmainAcitivity, btnsecondAcitivity, btnbtn, btncapture, btnbroadcast,btnactivityregister;
    //    监听
    private ButtonListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indexacitivity);
//        声明对象
        /**
         * 监听对象一定创建
         * 否则没有用
         */
        listener = new ButtonListener();
        /**
         * 写函数方便下一次执行
         */
        FindView();
        /**
         * 绑定监听事件
         */
        SetClickListner();

    }
//提取出的方法名（ctrl+allt+m）

    /**
     * 把你要实现的按钮给其提取到一个方法里面
     */
    private void FindView() {
        btnmainAcitivity = (Button) findViewById(R.id.btnmain);
        btnsecondAcitivity = (Button) findViewById(R.id.btnsecondAcitivity);
        btnbtn = (Button) findViewById(R.id.btnacitivitycyle);
        btncapture = (Button) findViewById(R.id.btnacptureActivity);

        btnbroadcast = (Button) findViewById(R.id.btnbroadcast);
        btnactivityregister = (Button) findViewById(R.id.btnactivityreigster);

    }

    //实现对象方法
    private void SetClickListner() {
        btnmainAcitivity.setOnClickListener(listener);
        btnsecondAcitivity.setOnClickListener(listener);
        btnbtn.setOnClickListener(listener);
        btncapture.setOnClickListener(listener);

        btnbroadcast.setOnClickListener(listener);
        btnactivityregister.setOnClickListener(listener);

    }

    //写个类来继承监听（封装监听）
    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnmain:
//                    按mainacitivity
//                    功能（从一个acitivity到另一acitivitt）
                    Intent intent = new Intent(IndexAcitivity.this, MainActivity.class);
                    startActivity(intent);
                    Log.e("进程查询", "转到MainActivtiy");
                    break;
                case R.id.btnsecondAcitivity:
//                    按切换SecondAcitivity
//                    功能
                    Intent intent1 = new Intent(IndexAcitivity.this, SecondActivity.class);
                    startActivity(intent1);
                    Log.e("进程查询", "转到SecondActivtiy");
                    break;
                case R.id.btnacitivitycyle:
//                    判断按钮
//                    功能
                    Intent intent2 = new Intent(IndexAcitivity.this, AcitivityCycle.class);
                    startActivity(intent2);
                    Log.e("进程查询", "转到ActivtiyCyle");
                    break;
                case R.id.btnacptureActivity:
                    Intent intent3 = new Intent(IndexAcitivity.this, CaptureActivity.class);
                    startActivity(intent3);
                    Log.e("进程查询", "转到CaptureActivtiy");
                    break;
                case R.id.btnbroadcast:
                    Intent intent4 = new Intent(IndexAcitivity.this, SendBroadCastActivity.class);
                    startActivity(intent4);
                    Log.e("进程查询", "转到SendBroadCastActivity");
                    break;

                case R.id.btnactivityreigster:
                    Intent intent6 = new Intent(IndexAcitivity.this, DynamicregisterBroadstReceiver.class);
                    startActivity(intent6);
                    Log.e("进程查询", "转到电池查询");
            }
        }
    }
}
