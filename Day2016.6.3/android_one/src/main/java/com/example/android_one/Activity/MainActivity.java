package com.example.android_one.Activity;




import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_one.R;

public class MainActivity extends AppCompatActivity {
private Button btnbroadcast,btndynanminreguset;
    private ButtonListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 监听事件
         */
        listener=new ButtonListener();
        /**
         * 按钮控件
         */
        FindView();
        /**
         * 设置监听
         */

        SetOnclickListener();
    }

    private void SetOnclickListener() {
        btndynanminreguset.setOnClickListener(listener);
        btnbroadcast.setOnClickListener(listener);
    }


    private void FindView() {
        btndynanminreguset= (Button) findViewById(R.id.btndynanminreguster);
        btnbroadcast= (Button) findViewById(R.id.btnMyBrocadCast);
    }


    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnMyBrocadCast:
                    Intent intent=new Intent(MainActivity.this,MyBroadCastActivity.class);
                    startActivity(intent);
                    Log.e("跳转查询", "跳转到mybroadcast");
                    System.out.print("你已经点击");
                break;
                case R.id.btndynanminreguster:
                    Intent intent1=new Intent(MainActivity.this,DynanminRegusterBroadcastReceiver.class);
                    startActivity(intent1);
                    Log.e("跳转查询", "跳转到dymainrtegusne" );
                    break;

            }
        }
    }
  private long exittime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);
//        if(keyCode==KeyEvent.KEYCODE_BACK){
//            AlertDialog.Builder alertDuakog=new AlertDialog.Builder(this);
//            alertDuakog.setTitle("姚晨");
//            alertDuakog.setMessage("确认退出马上学Android");
//            alertDuakog.setPositiveButton("确认",new DialogInterface.OnClickListener(){
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    finish();
//                }
//            });
//            alertDuakog.setNegativeButton("取消",new DialogInterface.OnClickListener(){
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                      return;
//                }
//            });
//            alertDuakog.show();
//        }
//     if (keyCode=KeyEvent.KEYCODE_BACK||event.getAction()==KeyEvent.ACTION_DOWN){
//         if({System.currentTimeMillis()-exittime}>2000){
//             Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
//         }else {
//             finish();
//             System.exit(0);
//         }
//     }
        return  super.onKeyDown(keyCode,event);
    }
}
