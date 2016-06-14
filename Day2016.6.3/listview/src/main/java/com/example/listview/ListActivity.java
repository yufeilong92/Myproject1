package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/6/13.
 */
public class ListActivity extends Activity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listacitivity);
        lv = (ListView) findViewById(R.id.lv1);
       lv.setAdapter(new MyListView());
    }
    private class MyListView extends BaseAdapter{

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
//            想办法把我们的自己等的布局装换一个view
            if(convertView==null){
//                新建一个view对象，可用过打气筒把一个布局资源转换成一个view对象
//                 resource 就是我们定义的布局
//                获取打气筒
                view = View.inflate(getApplicationContext(), R.layout.item, null);
// 第二种打气筒
//  LayoutInflater.from(getApplicationContext()).inflate(R.layout.item,null);
//                第三种打气筒
                LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
               inflater.inflate(R.layout.item,null);
            }else {
                view =convertView;
            }
            return view;
        }
    }
}
