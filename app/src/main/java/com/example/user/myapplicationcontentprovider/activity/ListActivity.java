package com.example.user.myapplicationcontentprovider.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.user.myapplicationcontentprovider.R;
import com.example.user.myapplicationcontentprovider.content_provider.Contract;


public class ListActivity extends ActionBarActivity
//        implements LoaderManager.LoaderCallbacks<Cursor>
{
// ЗДЕСЬ НЕДоДЕЛАНО осталось от предыдущего примера под ДБ непеределанно
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getLoaderManager().initLoader(0, null, this);


        listView = (ListView) findViewById(R.id.list_view);

        Cursor cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI,
                new String[] {BaseColumns._ID,ContactsContract.Data.DISPLAY_NAME},
                null,
                null,
                null);
        listView.setAdapter(new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[] {ContactsContract.Data.DISPLAY_NAME},
                new int[] {android.R.id.text1},
                0));

        getContentResolver().query(Contract.CONTENT_URI,
                null,
                null,
                null,
                null);
    }



//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        return new  CursorLoader(this, ContactsContract.Data.CONTENT_URI,
//                new String[] {BaseColumns._ID,ContactsContract.Data.DISPLAY_NAME},
//                null,
//                null,
//                null);
//
//
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
//        listView.setAdapter(new SimpleCursorAdapter(this,
//                android.R.layout.simple_list_item_1,
//                cursor,
//                new String[] {ContactsContract.Data.DISPLAY_NAME},
//                new int[] {android.R.id.text1},
//                0));
//
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//


}
