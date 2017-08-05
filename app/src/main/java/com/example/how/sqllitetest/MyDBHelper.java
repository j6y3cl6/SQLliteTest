package com.example.how.sqllitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by How on 2017/8/5.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE main.exp"+
                "(str1 VARCHAR not null," +
                "info VARCHAR not null," +
                "cDate VARCHAR null)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  main.exp");
        db.execSQL("CREATE TABLE main.exp"+
                "(str1 VARCHAR not null," +
                "info VARCHAR not null," +
                "cDate VARCHAR null)"
        );
    }


}
