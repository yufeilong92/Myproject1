package com.example.listview;

import android.app.Activity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/6/14.
 */
public class ArrayAdapterActivity extends Activity {
    String objects[] = {"张三", "王五", "马六", "孙期", "悟空"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrayactivity);
//       找到控件
        lv = (ListView) findViewById(R.id.lvarray);
//        创建一个arrayadapter
        ArrayAdapter<String> aa = new ArrayAdapter<String>(ArrayAdapterActivity.this, R.layout.itema,R.id.textView, objects);

// 设置数据适配器
        lv.setAdapter(aa);
    }
}
