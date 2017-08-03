package com.example.sandwind.onedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by sandwind on 2017/8/3.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table Book("
    +"id integer primary key autoincrement,"
    +"author text,"
    +"price real,"
    +"pages integer,"
    +"name text)";


    public static final String CREATE_CATEGORY = "create table Category("
    +" id integer primary key autoincrement,"
    +" category_name text,"
    +" category_code integer,"
    +" category_height integer)";


    public static final String CREATE_CATEGORY2 = "create table Category("
            +" id integer primary key autoincrement,"
            +" category_name text,"
            +" category_code integer)";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
//        sqLiteDatabase.execSQL(CREATE_CATEGORY2);
        Toast.makeText(mContext,"Create succeed",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists Categoty");
    }
}
