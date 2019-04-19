package com.example.lenovo.note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper {


  public static final String TIMETRACKER_COLUMN_ID = "_id";
  public static final String TIMETRACKER_COLUMN_TIME = "time";
  public static final String TIMETRACKER_COLUMN_NOTES = "notes";
  private TimeNoteDBHelper openHelper;
  private SQLiteDatabase database;

  public DatabaseHelper(Context context) {
    openHelper = new TimeNoteDBHelper( context );
    database = openHelper.getWritableDatabase();
  }

  public void saveTimeRecord(String time, String notes) {
    ContentValues contentValues = new ContentValues();
    contentValues.put( TIMETRACKER_COLUMN_TIME, time );
    contentValues.put( TIMETRACKER_COLUMN_NOTES, notes );
    database.insert( "timerecords", null, contentValues );

  }

  public Cursor getAllTimeRecords() {
    return database.rawQuery(
      "select * from " + "timerecords",
      null
    );

  }
}
