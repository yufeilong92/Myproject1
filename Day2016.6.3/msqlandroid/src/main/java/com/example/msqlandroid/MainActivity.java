package com.example.msqlandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myOpenHelper = new MyOpenHelper(getApplicationContext());
//       创建或打开数据库
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();
//        打开或创建数据库，如果第一次就是创建，如果磁盘满了返回只读的数据库
        SQLiteDatabase readableDatabase = myOpenHelper.getReadableDatabase();

    }
//    点击按钮增加一条记录
    public  void add(View v){
//        获取数据库对象
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
//       增加一条数据
        db.execSQL("insert into info(name,phone)values(?,?)",new Object[]{"张三","12345678922"});
//        数据库用完关闭
        db.close();
    }
//    删除
    public  void delete(View v){
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        db.execSQL("delete from  info where name=?",new Object[]{"张三"});
        db.close();
    }
//    更新
    public  void update(View v){
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
        db.execSQL("update info set phone=? where name='张三'；",new Object[]{"13888888888"} );
        db.close();
    }
//    查找
    public  void find(View v){
        SQLiteDatabase db = myOpenHelper.getReadableDatabase();
//    又返回记录
        Cursor cursor = db.rawQuery("select * from info", null);
       if(cursor!=null){
        while (cursor.moveToNext()){
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            System.out.println("name"+name+"phone"+phone);
        }
       }
    }

}
