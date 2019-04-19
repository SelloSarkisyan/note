package com.example.lenovo.note;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TimeCursorAdapter extends CursorAdapter {
  public TimeCursorAdapter(Context context, Cursor c) {
    super( context, c );
  }

  @Override
  public View newView(Context context, Cursor cursor, ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.time_item_list, parent, false);
    return view;
  }

  @Override
  public void bindView(View view, Context context, Cursor cursor) {
    TextView nameTextView = (TextView) view.findViewById(R.id.time_view);
    String time =cursor.getString(cursor.getColumnIndex("time"));
    Log.i("adaptor", "time=" + time);
    Log.i("debug", "time: " + (nameTextView != null));
    {
      nameTextView.setText(time);
    }
    TextView valueTextView = (TextView) view.findViewById(R.id.note_view);
    String note = cursor.getString(cursor.getColumnIndex("notes"));
    Log.i("adaptor", "note=" + note);
    Log.i("debug", "note: " + (valueTextView != null));
    valueTextView.setText(note);
  }
}
