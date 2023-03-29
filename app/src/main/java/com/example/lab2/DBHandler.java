package com.example.lab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login(id integer primary key autoincrement, " +
                "firstname text not null, " + "password text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists login");
    }


    public void insert(String fn,String pass) {
        ContentValues cv = new ContentValues();
        cv.put("firstname",fn);
        cv.put("password", pass);
        this.getWritableDatabase().insert("login", null, cv);
        this.close();
    }
    public boolean search(String firstname, String password) {
        String[] args = new String[]{firstname, password};

        Cursor c = this.getWritableDatabase().query("login",
                        new String[]{"firstname", "password"},
                        "firstname = ? and password=?",
                        args,
                        null, null, null);
        return c.moveToNext();
    }
}
