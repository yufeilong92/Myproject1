package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/6/13.
 */
public class IndexActivity extends Activity {
    private Button btnMainActivity,btnlistactivity ,btnlistview ,arrayadapter ,btnsimpler;
    private ButtonListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indexactivity);
        /**
         * 监听对象一定要创建否则没用
         */
        listener = new ButtonListener();
/**
 * 控件
 */
        FindView();
/**
 * 设置监听
 */
        OnSetClickListener();
    }

    private void OnSetClickListener() {
        btnsimpler.setOnClickListener(listener);
        btnMainActivity.setOnClickListener(listener);
        btnlistactivity.setOnClickListener(listener);
        btnlistview.setOnClickListener(listener);
        arrayadapter.setOnClickListener(listener);
    }

    private void FindView() {
        btnsimpler= (Button) findViewById(R.id.btnsimpler);
        btnlistview= (Button) findViewById(R.id.btnlistview);
        btnlistactivity= (Button) findViewById(R.id.btnlist);
        btnMainActivity = (Button) findViewById(R.id.btnmain);
        arrayadapter= (Button) findViewById(R.id.btnarry);
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnmain:
                    Intent intent = new Intent(IndexActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnlist:
                    Intent intent1 = new Intent(IndexActivity.this, ListViewActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.btnlistview:
                    Intent intent2 = new Intent(IndexActivity.this, ListActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.btnarry:
                    Intent intent3=new Intent(IndexActivity.this,ArrayAdapterActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.btnsimpler:
                    Intent intent4 =new Intent(IndexActivity.this,SimpleaAdpterAcitivty.class);
                    startActivity(intent4);
                    break;

            }
        }
    }
}
