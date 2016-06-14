package com.example.android.activtiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.R;

/**
 * Created by Administrator on 2016/6/3.
 */
public class AcitivityCycle extends Activity {
    private Button button;
    private EditText editTextmesssage;
    private int cout = 0;
//    定义一个静态变量int类型值
 private static final int RC_DATY_ACTIVITY=100;
    /**
     * acitivity 开始
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        控件
        setContentView(R.layout.acitivitycyle);

        button = (Button) findViewById(R.id.btnactivity);
        editTextmesssage = (EditText) findViewById(R.id.edittext);
        /**
         * 如果savedinstancestate传过来的值
         */
        if (savedInstanceState != null) {
            cout = savedInstanceState.getInt("cout");
            Toast.makeText(this, "cout=" + cout, Toast.LENGTH_SHORT).show();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                得到传来的数据
                String strmsg=editTextmesssage.getText().toString();
//                Intent intent=new Intent();
////                传值
////                intent.putExtra("msg",strmsg);
//                intent.setClass(AcitivityCycle.this,DateActivity.class);
////                startActivity(intent);
////                类似集合把数据绑定到Bundle
//                Bundle bundle=new Bundle();
//                bundle.putInt("year",2016);
//                bundle.putDouble("score",100.0);
//                bundle.putString("msg",strmsg);
//                intent.putExtras(bundle);
//                startActivity(intent);
//定义个Intent 从哪里来到哪里去
                Intent intent=new Intent(AcitivityCycle.this,DateActivity.class);
                intent.putExtra("joke",strmsg);
//                发送一个带有返回类型的startActivityForResult（内容，值》1）
                startActivityForResult(intent,RC_DATY_ACTIVITY);

            }
        });
        Log.i("Acitivitycyle", "onctreate>>>>执行1");
    }

    /**
     * acitivity 执行
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AcitivityCyle", "oncreate执行完后执行OnStart>>>>2");

    }

    /**
     * acitivity 运行
     * 保存用户信息
     */
    @Override
    protected void onResume() {
        super.onResume();
        cout++;
        Log.e("AcitivityCyle", "onResume执行啦>>>>3");
    }

    /**
     * acitivity 停止
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.w("AcitivityClye", "onStop被执行，现在Acitivity处于暂停>>>>5");
    }

    /**
     * acitivity 返回
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AcitivityCyle", "onRestart被执行>>>>6");
    }

    /**
     * acitivity 清除缓存e
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Acitivityclye", "ondestroy被执行");

    }


    /**
     * 在转换时被保存
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cout", cout);
    }

    /**
     * acitivity 判断
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Activity", "onpause执行，现在Activity暂停>>>4");
    }
//（请求的内容，返回的结果哦与两个要么成功。要么失败）
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        处理逻辑
        switch (requestCode){
            case RC_DATY_ACTIVITY:
//                成功
                if(resultCode==RESULT_OK){
                    String str=data.getStringExtra("ma");
                    Toast.makeText(AcitivityCycle.this,"精加工后："+str,Toast.LENGTH_SHORT).show();
                }else if(resultCode==RESULT_CANCELED){
//                    失败
                    Toast.makeText(AcitivityCycle.this,"未能返回结果",Toast.LENGTH_SHORT).show();
                }
               break;
            default:
                break;
        }
    }
}
