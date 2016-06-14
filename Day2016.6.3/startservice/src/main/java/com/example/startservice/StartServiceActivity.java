package com.example.startservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartServiceActivity extends AppCompatActivity {
 private Button btnid ,btnid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startservice);
//        服务
        btnid1= (Button) findViewById(R.id.btnid1);
        btnid= (Button) findViewById(R.id.btnid);
       btnid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                启动服务
                Intent intent=new Intent(StartServiceActivity.this,StartService.class);
                startService(intent);


            }
        });

        btnid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                停止服务
                Intent intent= new Intent(StartServiceActivity.this,StartService.class);
                stopService(intent);
            }
        });
    }
}
