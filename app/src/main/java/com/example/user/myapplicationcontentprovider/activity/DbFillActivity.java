package com.example.user.myapplicationcontentprovider.activity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.user.myapplicationcontentprovider.R;
import com.example.user.myapplicationcontentprovider.content_provider.Contract;
import com.example.user.myapplicationcontentprovider.content_provider.DBHelper;

public class DbFillActivity extends ActionBarActivity {


    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_fill);
        //jest
        etText = (EditText) findViewById(R.id.action_context_bar);
    }


    public void onClick(View view) {

        String text = etText.getText().toString();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME_FNAME,text);

        Uri uri = Contract.CONTENT_URI.buildUpon().appendPath(DBHelper.TABLE_NAME).build();

        switch (view.getId()) {
            case R.id.btn_add_text:




                getContentResolver().insert(uri, values);
                break;

            case R.id.btn_clear_db:
                getContentResolver().delete(uri, null, null);
                break;
            case R.id.btn_view_list:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_db_fill, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
