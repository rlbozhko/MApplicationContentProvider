package com.example.user.myapplicationcontentprovider.content_provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by user on 04.03.15.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATA_TYPE_TEXT = " TEXT";

    public static final String TABLE_NAME = "SampleTable";
    public static final String COLUMN_NAME_FNAME = "firstName";
    public static final String COLUMN_NAME_LNAME = "lastName";
    public static final String DELETE_QUERY = "DELETE TABLE IF EXISTS " + TABLE_NAME;


    public static final String CREATE_QUERY = "CREATE TABLE "
            + TABLE_NAME
            + " ("
            + BaseColumns._ID
            + " INTEGER PRIMARY KEY,"
            + COLUMN_NAME_FNAME
            + DATA_TYPE_TEXT + ','
            + COLUMN_NAME_LNAME
            + DATA_TYPE_TEXT + ')';





    public static int DB_VERSION = 1;
    public static final String DB_NAME = "sampleDB.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_QUERY);
        onCreate(db);
    }
}