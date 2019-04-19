package com.example.lenovo.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class TimeAndNote extends Activity {
  TimeCursorAdapter timeCurserAdapter;
  private DatabaseHelper databaseHelper;
  public static final int TIME_ENTRY_REQUEST_CODE = 1;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_time_and_note);
    ListView listView = (ListView)
      findViewById(R.id.time_list);
    databaseHelper = new DatabaseHelper(this);
    timeCurserAdapter = new TimeCursorAdapter(this,databaseHelper.getAllTimeRecords());
    listView.setAdapter(timeCurserAdapter);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.add_menu, menu);
    return true;
  }
  public boolean onMenuItemSelected(int featureId, MenuItem item)
  {
    if (item.getItemId() == R.id.add_time_note) {
     Intent intent = new Intent(this,MainActivity.class);
      startActivityForResult(intent, TIME_ENTRY_REQUEST_CODE);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == TIME_ENTRY_REQUEST_CODE) {
      if (resultCode == RESULT_OK) {
        String time = data.getStringExtra("time");
        String notes = data.getStringExtra("notes");
        databaseHelper.saveTimeRecord(time,notes);
        timeCurserAdapter.changeCursor(
          databaseHelper.getAllTimeRecords());
      }
    }
  }
}
