package com.example.startservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/6/12.
 */
public class MainActivtiy extends Activity {
    private Button btnstartservice, btnbindservice;
    private ButtonListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener=new ButtonListener();
        FindView();
        OnClickListener();

    }

    private void FindView() {
        btnstartservice = (Button) findViewById(R.id.btnid);
        btnbindservice = (Button) findViewById(R.id.btnid1);
    }

    private void OnClickListener() {
        btnbindservice.setOnClickListener(listener);
        btnstartservice.setOnClickListener(listener);
    }

    protected class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnid:
                    Intent intent = new Intent(MainActivtiy.this, StartServiceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnid1:
                    Intent intent1=new Intent(MainActivtiy.this,BinservieActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    }

}
