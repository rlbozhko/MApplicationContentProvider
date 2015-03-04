package com.example.user.myapplicationcontentprovider.content_provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class NamesContentProvider extends ContentProvider {

    private DBHelper dbHelper;

    public NamesContentProvider() {
    }


    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        // TODO: Implement this to initialize your content provider on startup.
        return true;
    }


    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
       // throw new UnsupportedOperationException("Not yet implemented");
        String tableName = uri.getLastPathSegment();
        Log.d("NamesContentProvider", "Queried");
        // Select * from tableName
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(tableName,projection, selection, selectionArgs, null,null,sortOrder);
        return cursor;
    }



    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        String tableName = uri.getLastPathSegment();
        Log.d("Insert", "Insert2");
        // Select * from tableName
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        //Cursor cursor = database.query(tableName,projection, selection, selectionArgs, null,null,sortOrder);
        long rowId = database.insert(tableName,null,values);
        return uri.buildUpon().appendPath(String.valueOf(rowId)).build();
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        // TODO: Implement this to handle requests to insert a new row.
        String tableName = uri.getLastPathSegment();
        Log.d("Delete", "Delete2");
        // Select * from tableName
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        //Cursor cursor = database.query(tableName,projection, selection, selectionArgs, null,null,sortOrder);
        return database.delete(tableName,selection,selectionArgs);

    }






    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
