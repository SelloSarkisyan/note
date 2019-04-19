package com.example.lenovo.note;

public class TimeNoteLdo {
  String time;
  String note;

  public TimeNoteLdo(String time , String note) {
    this.time = time;
    this.note = note;
  }

  public TimeNoteLdo() {
    // TODO Auto-generated constructor stub
  }

  public String getTime() {
    return time;
  }
  public void setTime(String time) {
    this.time = time;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }
}
