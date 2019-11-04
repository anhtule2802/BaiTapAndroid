package com.example.testthuchanh;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "qlSach", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Author(id_author integer primary key, name text,"+"address text,email text)");
        db.execSQL("create table Book(id_book integer primary key, title text,id_author " +
                "integer constraint id_author references Author(id_author) on delete cascade" +
                " on update cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Author");
        db.execSQL("drop table if exists Book");
    }
}
