package com.example.lenovo.note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimeNoteDBHelper extends SQLiteOpenHelper {
  public static final String TIMETRACKER_COLUMN_ID = "_id";
  public static final String TIMETRACKER_COLUMN_TIME = "time";
  public static final String TIMETRACKER_COLUMN_NOTES = "notes";

  public TimeNoteDBHelper(Context context) {
    super( context, "god.db",null, 1 );
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(
      "CREATE TABLE "+ "timerecords" + "( "
        + TIMETRACKER_COLUMN_ID + " INTEGER PRIMARY KEY, "
        + TIMETRACKER_COLUMN_TIME + " TEXT, "
        + TIMETRACKER_COLUMN_NOTES + " TEXT )"

    );
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + "timerecords");
    onCreate(db);
  }
}
