package com.example.myapp9.Hvor;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp9.Hvor.data.HvorContract;
import com.example.myapp9.Hvor.data.HvorDbHelper;
import com.example.myapp9.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HvorActivity extends AppCompatActivity {

    SQLiteDatabase wdb;
    SQLiteDatabase rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hvor);

        HvorDbHelper gemDineDbHelper = new HvorDbHelper(this);
        wdb = gemDineDbHelper.getWritableDatabase();
        rdb = gemDineDbHelper.getReadableDatabase();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HvorActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        read();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insert_dummy_data:
                insertDummy();
                read();
                return true;
            case R.id.action_delete_all_entries:
                deleteAllPets();
                read();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void insertDummy() {
        ContentValues values = new ContentValues();
        values.put(HvorContract.GemDineEntry.COLUMN_PERSON_HVOR, "Domkirken");
        values.put(HvorContract.GemDineEntry.COLUMN_PERSON_BEGRAVES, HvorContract.GemDineEntry.BEGRAVES_BEGRAVES);
        wdb.insert(HvorContract.GemDineEntry.TABLE_NAME, null, values);
    }

    private void read() {
        HvorDbHelper gemDineDbHelper = new HvorDbHelper(this);
        SQLiteDatabase db = gemDineDbHelper.getReadableDatabase();

        String[] projection = {
                HvorContract.GemDineEntry._ID,
                HvorContract.GemDineEntry.COLUMN_PERSON_HVOR,
                HvorContract.GemDineEntry.COLUMN_PERSON_BEGRAVES};

        Cursor cursor = db.query(
                HvorContract.GemDineEntry.TABLE_NAME, projection, null, null, null, null, null);

        TextView displayView = (TextView) findViewById(R.id.text_view_hvor);

        try {
            displayView.setText("Hvor vil du begraves " + cursor.getCount() + " gemdine.\n\n");
            displayView.append(HvorContract.GemDineEntry._ID + " - " +
                    HvorContract.GemDineEntry.COLUMN_PERSON_HVOR + " - " +
                    HvorContract.GemDineEntry.COLUMN_PERSON_BEGRAVES + " - " );

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(cursor.getColumnIndex(HvorContract.GemDineEntry._ID));
                String currentName = cursor.getString(cursor.getColumnIndex(HvorContract.GemDineEntry.COLUMN_PERSON_HVOR));
                int currentGender = cursor.getInt(cursor.getColumnIndex(HvorContract.GemDineEntry.COLUMN_PERSON_BEGRAVES));

                String gemdineText = "";
                switch(currentGender){
                    case 0:
                        gemdineText = "Ved ikke";
                        break;
                    case 1:
                        gemdineText = "Begraves";
                        break;
                    case 2:
                        gemdineText = "Bisættes";
                }

                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        gemdineText));
            }
        } finally {
            cursor.close();
        }
    }

    private void deleteAllPets() {
        wdb.delete(HvorContract.GemDineEntry.TABLE_NAME, null, null);
    }

}
