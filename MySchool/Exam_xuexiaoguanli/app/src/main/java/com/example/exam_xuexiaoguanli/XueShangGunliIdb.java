package com.example.exam_xuexiaoguanli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class XueShangGunliIdb  extends SQLiteOpenHelper {
    public XueShangGunliIdb( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Xueshang_Info(_id integer primary key autoincrement,STxingming,STnianling,STxiangguan,STyouxiang)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
