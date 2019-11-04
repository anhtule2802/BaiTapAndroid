package com.example.doanandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context,"cv_list", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table TableCongViec(maTable integer primary key,"+" nameTable text)");
        db.execSQL("create table DetailTable(maDetail integer primary key,"+" maTable integer, Day text,contentDetail text,time text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists TableCongViec");
        db.execSQL("drop table if exists DetailTable");
        onCreate(db);
    }

    public boolean insertCongViec(TableCongViec TableCongViec)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTable",TableCongViec.getMaTable());
        contentValues.put("nameTable",TableCongViec.getNameTable());
        db.insert("TableCongViec",null,contentValues);
        return true;
    }
    public boolean insertDetailTable(DetailTable detailTable){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maDetail",detailTable.getMaDetail());
        contentValues.put("maTable",detailTable.getMaTable());
        contentValues.put("Day",detailTable.getDay());
        contentValues.put("contentDetail",detailTable.getContentDetail());
        contentValues.put("time",detailTable.getTime());
        db.insert("DetailTable",null,contentValues);
        return true;
    }
    public ArrayList<DetailTable> getAllDeTailTable(){
        ArrayList<DetailTable> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from DetailTable",null);
        if(cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            list.add(new DetailTable( cursor.getInt(0), cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<TableCongViec> getAllTable(){
        ArrayList<TableCongViec> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from TableCongViec",null);
        if(cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            list.add(new TableCongViec( cursor.getInt(0), cursor.getString(1)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    public TableCongViec getTableCongViec(int maTable){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from TableCongViec where maTable = "+maTable, null);
        if(cursor!=null)
            cursor.moveToFirst();
        TableCongViec cv = new TableCongViec(cursor.getInt(0), cursor.getString(1));
        cursor.close();
        return cv;
    }
    public boolean deleteTable (int maTable){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "delete from TableCongViec where maTable =" + maTable;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor == null){
            return false;
        }
        else {
            cursor.moveToFirst();
            cursor.close();
        }
        return true;
    }
    public boolean deleteDetail (int maDetail){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "delete from DetailTable where maDetail="+maDetail;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor == null){
            return false;
        }
        else {
            cursor.moveToFirst();
            cursor.close();
        }
        return true;
    }
    public boolean updateDetail(int maDetail,int maTable,String day,String contentDetail,String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTable",maTable);
        contentValues.put("Day",day);
        contentValues.put("contentDetail",contentDetail);
        contentValues.put("time",time);
        db.update("DetailTable",contentValues,"maDetail="+maDetail,null);
        return true;
    }
    public boolean updateTable(int maTable,String nameTable){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameTable",nameTable);
        db.update("TableCongViec",contentValues, "maTable="+maTable,null);
        return true;
    }
}
