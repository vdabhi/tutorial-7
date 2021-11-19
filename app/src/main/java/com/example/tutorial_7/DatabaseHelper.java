package com.example.tutorial_7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME="student.db";
        public static final String TABLE_NAME="stud_table";
        public static final String COL_1="ID";
        public static final String COL_2="FNAME";
        public static final String COL_3="LNAME";
        public static final String COL_4="EMAIL";
        public static final String COL_5="PASSWORD";

        public DatabaseHelper(Context context) {
            super( context, DATABASE_NAME,null,1 );
            SQLiteDatabase db = this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL( "create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , FNAME TEXT, LNAME TEXT , EMAIL TEXT , PASSWORD TEXT)" );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL( "DROP TABLE IF EXISTS " +TABLE_NAME );
            onCreate( db );
        }
        public boolean insertData(String fname,String lname,String email,String password)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues=new ContentValues( );
            contentValues.put(COL_2,fname);
            contentValues.put(COL_3,lname);
            contentValues.put(COL_4,email);
            contentValues.put(COL_5,password);
            long result = db.insert( TABLE_NAME,null,contentValues );
            if(result == -1)
                return false;
            else
                return true;

        }
        public  boolean chekusername (String EMAIL)
        {
            SQLiteDatabase MYDB = this.getWritableDatabase();
            Cursor cursor = MYDB .rawQuery("select * from stud_table where EMAIL  = ?",new String[]{EMAIL} );
            if (cursor.getCount()>0)
                return  true;
            else
                return  false;



        }
        public  boolean chekusernamepass (String EMAIL, String  PASSWORD)
        {
            SQLiteDatabase MYDB = this.getWritableDatabase();
            Cursor cursor = MYDB .rawQuery("select * from stud_table where EMAIL = ? and PASSWORD = ?",new String[]{EMAIL,PASSWORD} );
            if (cursor.getCount()>0)
                return  true;
            else
                return  false;



        }
    }

