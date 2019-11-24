package com.example.myapp9.Hvor.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapp9.Hvor.data.HvorContract.GemDineEntry;

public class HvorDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gemdine.db";
    private static final int DATABASE_VERSION = 1;

    public HvorDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + HvorContract.GemDineEntry.TABLE_NAME + " ("
                + HvorContract.GemDineEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GemDineEntry.COLUMN_PERSON_HVOR + " TEXT NOT NULL, "
                + GemDineEntry.COLUMN_PERSON_BEGRAVES + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
