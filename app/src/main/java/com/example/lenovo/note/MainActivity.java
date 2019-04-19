package com.example.lenovo.note;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.add_note );
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate( R.menu.add,menu );
    return true;
  }
  public  void  onCancel(View view){
    finish();
  }
  public  void onSave(View view){
    Intent intent=getIntent();
    EditText timeView = (EditText)findViewById(R.id.time_view);
    intent.putExtra("time", timeView.getText().toString());
    EditText notesView = (EditText)findViewById(R.id.notes_view);
    intent.putExtra("notes", notesView.getText().toString());
    this.setResult(RESULT_OK, intent);
    finish();
  }
}
