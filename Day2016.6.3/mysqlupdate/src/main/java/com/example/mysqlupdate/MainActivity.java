package com.example.mysqlupdate;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private MyOpenHelper myOpenHelper;
    private ListView lv;
    private List<Person> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);

        myOpenHelper = new MyOpenHelper(getApplicationContext());
//    1               用来存list集合来存javabean
        lists = new ArrayList<Person>();
/**
 * 拿到数据库
 */

//       创建或打开数据库
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();

//        打开或创建数据库，如果第一次就是创建，如果磁盘满了返回只读的数据库
        SQLiteDatabase readableDatabase = myOpenHelper.getReadableDatabase();

    }

    //    点击按钮增加一条记录
    public void add(View v) {
//        获取数据库对象
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
//       增加一条数据
        /***
         * table 表名
         * contentValues 内部封装一个MAp
         */
        ContentValues values = new ContentValues();
        values.put("name", "王五");
        values.put("phone", "1110");
//            返回值代表插入新行id
        long insert = db.insert("info", null, values);
//        数据库用完关闭
        db.close();
        if (insert > 0) {
            Toast.makeText(getApplicationContext(), "啊添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "啊添加失败", Toast.LENGTH_SHORT).show();
        }
    }

    //    删除
    public void delete(View v) {
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
//            代表影响的行数
        int delete = db.delete("info", "name=?", new String[]{"王五"});
        db.close();
        Toast.makeText(getApplicationContext(), "删除多少行==" + delete, Toast.LENGTH_SHORT).show();
    }

    //    更新
    public void update(View v) {
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", "114");
        db.update("info", values, "name=?", new String[]{"王五"});
//            db.execSQL("update info set phone=? where name='张三'；",new Object[]{"13888888888"} );
        Toast.makeText(getApplicationContext(), "更新" + values + "行", Toast.LENGTH_SHORT).show();

        db.close();
    }

    //    查找
    public void find(View v) {
        SQLiteDatabase db = myOpenHelper.getReadableDatabase();
//    又返回记录
//            查询的类
//           db.query("info",null)

//            db.query("info",new String[]{"phone"},"name=?",new String[]{"王五"},null,null,null);
        db.query("info", null, null, null, null, null, null);
        Cursor cursor = db.rawQuery("select * from info", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {

//                    String phone = cursor.getString(0);
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                /**
                 * 顺序拿到数据封装到javabean
                 * 在放到list 集合里面
                 */
                Person person = new Person();
                person.setName(name);
                person.setPhone(phone);
                //bajavabean放到集合
                lists.add(person);

//                    System.out.println("phone:"+phone);
            }
            /**
             * 设置数据识别器
             */
        lv.setAdapter(new MyBaseAdapter());
        }
    }
//定义listview数据识别器
    private class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return lists.size();
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
            if(convertView==null){
                view = View.inflate(getApplicationContext(), R.layout.item, null);
            }else {
                view=convertView;
            }
            /**
             * 用控件显示数据
             * 不在一个布局里面应该view里面找因为view已经加载了
             * view = View.inflate(getApplicationContext(), R.layout.item, null);
             */
            TextView tvname = (TextView) view.findViewById(R.id.tv_name);
            TextView tvphone = (TextView) view.findViewById(R.id.tv_phone);
/**
 *  如何显示数据
 */
            Person person = lists.get(position);
            tvname.setText(person.getName());

            tvphone.setText(person.getPhone());
            return view;
        }
    }
}
