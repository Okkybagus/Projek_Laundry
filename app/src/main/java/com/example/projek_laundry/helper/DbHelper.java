package com.example.projek_laundry.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "laundry1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE laundry1 (/*0*/id INTEGER PRIMARY KEY AUTOINCREMENT, /*1*/nama VARCHAR(255), /*2*/harga varchar(10));";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void tulisData(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase(); // Database yang untuk menulis data --> INSERT, UPDATE, DELETE

        db.execSQL(sql);
    }

    // Membaca data dari database
    public Cursor bacaData(String sql)
    {
        SQLiteDatabase db = this.getReadableDatabase(); // Database untuk me READ --> SELECT

        Cursor hasil = db.rawQuery(sql, null);

        return hasil;
    }
}
