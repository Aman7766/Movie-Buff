package com.amandeep.moviebuff.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

   public static final String DB_NAME="Movie_buff";
    public static final String TABLE_NAME="User_details";
    public static final String Col_1="name";
    public static final String Col_2="mobile";
    public static final String Col_3="email_id";
    public static final String Col_4="password";



    public static final int DB_VERSION=1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        SQLiteDatabase db=this.getWritableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_query="CREATE TABLE "+TABLE_NAME+"("
                +Col_1+" TEXT, "
                +Col_2+" TEXT, "
                +Col_3+" TEXT PRIMARY KEY, "
                +Col_4+" TEXT)";
        db.execSQL(create_query);

    }

    public boolean addData(String name,String mobile,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col_1,name);
        cv.put(Col_2,mobile);
        cv.put(Col_3,email);
        cv.put(Col_4,password);
        long rs=db.insert(TABLE_NAME,null,cv);
        return rs != -1;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_query="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(drop_query);
        onCreate(db);

    }
}
