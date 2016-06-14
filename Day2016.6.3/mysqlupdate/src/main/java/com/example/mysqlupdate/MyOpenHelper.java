package com.example.mysqlupdate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *  context 上下文
 *  name 说据库名字
 *  factory  游标默认null
 *  version 数据库的版本必须大一
 *  Created by Administrator on 2016/6/12.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(context, "itheima.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table info(_id integer primary key autoincrement," +
               "name varchar(20),phone varchar(20)) ");
    }

    /**
     *      called when the database needs to be upgraded
     *      当前系统升级使用
     *      这个方法使用升级
     * @param db
     * @param oldVersion
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//         System.out.println("哈哈");
        db.execSQL("alter table info add phone varchar(20)");
    }
}
