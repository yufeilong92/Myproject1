package com.example.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        控件
        lv = (ListView)  findViewById(R.id.lvid);
//        显示数据和其他的普通控件有点区别

           lv.setAdapter(new MyListAdapter());
    }
//    定义数据识别器
    private class MyListAdapter extends BaseAdapter{
//一共有多少条数据显示出来
        @Override
        public int getCount() {
            return 100;
//            返回多少！屏幕就显示几条数据
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * 获取一个view 用来显示listview的数据，会作为listview的一个条目出现
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            if (convertView==null) {

                tv = new TextView(MainActivity.this);
                System.out.println("创建新的view对象"+position);
            }else {
                System.out.println("复用历史缓存对象 "+position);
                tv= (TextView) convertView;
            }
            tv.setText("你好"+position);
            return tv;
        }
    }
//private  class MyListAdapter implements ListAdapter{
//
//    @Override
//    public boolean areAllItemsEnabled() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled(int position) {
//        return false;
//    }
//
//    @Override
//    public void registerDataSetObserver(DataSetObserver observer) {
//
//    }
//
//    @Override
//    public void unregisterDataSetObserver(DataSetObserver observer) {
//
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return 0;
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//}
}
