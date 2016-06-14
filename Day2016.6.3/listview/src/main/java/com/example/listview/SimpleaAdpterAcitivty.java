package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/14.
 */
public class SimpleaAdpterAcitivty extends Activity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleaadapter);
        lv = (ListView) findViewById(R.id.lvlistview);
//       准备listView数据
        List<Map<String,String >> date=new ArrayList<Map<String, String>>();

        Map<String,String> map=new HashMap<String,String >();
        map.put("name","张飞");
        map.put("phone","123456789");

        Map<String,String> map1=new HashMap<String,String >();
        map1.put("name","曹洪");
        map1.put("phone","987654321");

        Map<String,String> map2=new HashMap<String,String >();
        map2.put("name","赵云");
        map2.put("phone","110");

        Map<String,String> map3=new HashMap<String,String >();
        map3.put("name","小乔");
        map3.put("phone","120");

//        把map加入集合
         date.add(map);
         date.add(map1);
         date.add(map2);
         date.add(map3);
//        设置数据适配器
//        from>>>>[] map集合的键值，
        /**SimpleAdapter参数{
         *    *content :上下文
         *    adta :list<Map<T,T>> ?=new ArrayList<Map<T,T></>></>
         *    resource:item(view)的控件R.layout.?
         *    from: 要显示内容的属性名：
         *    to:item中控件的属性id
         *  }
         */
        SimpleAdapter adapter=new SimpleAdapter(getApplicationContext(),date,R.layout.items,
                new String[]{"name","phone"},new int[]{R.id.tv_name,R.id.tv_phone});
//    设置数据识别器
        lv.setAdapter(adapter);
    }
}
