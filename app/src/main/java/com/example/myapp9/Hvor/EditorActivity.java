/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.myapp9.Hvor;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.example.myapp9.Hvor.data.HvorContract.GemDineEntry;
import com.example.myapp9.Hvor.data.HvorDbHelper;
import com.example.myapp9.R;

public class EditorActivity extends AppCompatActivity {

    SQLiteDatabase wdb;
    SQLiteDatabase rdb;

    private EditText mKirkeEditText;

    private Spinner mSpinner;

    private int mBegravelse = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        HvorDbHelper gemDineDbHelper = new HvorDbHelper(this);
        wdb = gemDineDbHelper.getWritableDatabase();
        rdb = gemDineDbHelper.getReadableDatabase();

        mKirkeEditText = (EditText) findViewById(R.id.edit_kirke);
        mSpinner = (Spinner) findViewById(R.id.spinner);

        setupSpinner();
    }

    private void setupSpinner() {
        ArrayAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_begraves_options, android.R.layout.simple_spinner_item);

        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mSpinner.setAdapter(mSpinnerAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.begraves_begraves))) {
                        mBegravelse = GemDineEntry.BEGRAVES_BEGRAVES; // begraves
                    } else if (selection.equals(getString(R.string.begraves_bisaettes))) {
                        mBegravelse = GemDineEntry.BEGRAVES_BISAETTES; // bisættes
                    } else {
                        mBegravelse = GemDineEntry.BEGRAVES_UNKNOWN; // Ved ikke
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mBegravelse = 0; // Unknown
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save:
                insertGemdine();
                finish();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertGemdine() {
        String nameString = mKirkeEditText.getText().toString().trim();

        ContentValues values = new ContentValues();
        values.put(GemDineEntry.COLUMN_PERSON_HVOR, nameString);
        values.put(GemDineEntry.COLUMN_PERSON_BEGRAVES, mBegravelse);
        wdb.insert(GemDineEntry.TABLE_NAME, null, values);
    }
}