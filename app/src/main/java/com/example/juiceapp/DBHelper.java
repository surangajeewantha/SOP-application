package com.example.juiceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "busines.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(Name TEXT primary key, Date TEXT, Total_Amount TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Userdetails");

    }


    // code for insert

    public Boolean insert(String Name, String Date, String Total_Amount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", Name);
        contentValues.put("Date", Date);
        contentValues.put("Total_Amount", Total_Amount);
        long result = db.insert("Userdetails", null, contentValues);
        if(result == -1)
        {
            return false;
        }

        else{
            return true;
        }
    }


    // code for update

    public Boolean update(String Name, String Date, String Total_Amount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", Date);
        contentValues.put("Total_Amount", Total_Amount);
        Cursor cursor = db.rawQuery("Select * from Userdetails where Name=?", new String[] {Name});
        if(cursor.getCount()>0)
        {
            long result = db.update("Userdetails", contentValues, "Name=?", new String[]{Name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }

        else
        {
            return false;
        }
    }



    // code for delete

    public Boolean delete(String Name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Userdetails where Name=?", new String[] {Name});
        if(cursor.getCount()>0)
        {
            long result = db.delete("Userdetails", "Name=?", new String[]{Name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }

        else
        {
            return false;
        }
    }


    public Cursor getdata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Userdetails", null );
        return cursor;


    }





}
