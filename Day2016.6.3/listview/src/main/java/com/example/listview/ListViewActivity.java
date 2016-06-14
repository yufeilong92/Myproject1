package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/13.
 */
public class ListViewActivity extends Activity {
   private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
//        控件
        lv = (ListView) findViewById(R.id.lv);
//
        lv.setAdapter(new MyAdaper());
    }
    private class  MyAdaper extends BaseAdapter{

        private TextView tv;

        @Override
        public int getCount() {
            return 6;
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

            System.out.println("getiview  --"+position);
            if(convertView==null){
                tv = new TextView(ListViewActivity.this);
            }else {
                tv= (TextView) convertView;
            }
            tv.setText("成功"+position);
            return tv;
        }


    }


}
