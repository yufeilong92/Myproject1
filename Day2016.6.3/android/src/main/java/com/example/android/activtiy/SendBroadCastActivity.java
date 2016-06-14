package com.example.android.activtiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.R;

/**
 * Created by Administrator on 2016/6/4.
 */
public class SendBroadCastActivity extends Activity {
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastactivity);

        button = (Button) findViewById(R.id.btnbroadcast);
        editText = (EditText) findViewById(R.id.ivbroadedi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                如何发送广播

                String strmsg = editText.getText().toString();

                Intent broadcastintent = new Intent();
//                发送广播setAction
                broadcastintent.setAction("com.example.android.broadcast.MyBroadCastReceiver");
//                使用putextra把消息发送
                broadcastintent.putExtra("msg", strmsg);
//              发送广播
                sendBroadcast(broadcastintent);
            }
        });
    }
}
