package com.example.android.activtiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.R;

/**
 * Created by Administrator on 2016/6/4.
 */
public class DateActivity extends Activity {
    private Button btnbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datyactivity);
//        Intent intent=this.getIntent();
//        Bundle bundle=intent.getExtras();
//        int year=bundle.getInt("year");
//        double sore=bundle.getDouble("score");
//        String  strmsg=intent.getStringExtra("msg");
//        Toast.makeText(this,"消息的内容是："+strmsg+"今年是："+year+"你的岁数是："+sore,Toast.LENGTH_SHORT).show();

        btnbutton= (Button) findViewById(R.id.btnDatyactivity);
        btnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                得到传过来的数据
                String strmsg=getIntent().getStringExtra("joke");
//               setResult返回的是否失败或成功，并且加上 返回内容
                if(strmsg.equals("joke")){
                    Intent intent=new Intent();
                    intent.putExtra("ma","马云，马伊琍四文章");
                    setResult(RESULT_OK,intent);
//                    栈续结束才能返回
                    finish();
//                    失败给其结果
                }else {
                    Intent intent1=new Intent();
                    intent1.putExtra("ma","你已经失败了");
                    setResult(RESULT_CANCELED,intent1);
                    finish();
                }
            }
        });
    }
}
