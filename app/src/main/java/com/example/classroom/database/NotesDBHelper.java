package com.example.classroom.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "notes.db";
    public static final String TABLE_NAME = "notes";

    public NotesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    // Called when db is first created
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT)";

        db.execSQL(createTableQuery);
    }

    // called when db version is update
    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
    }

    // insert a note
    public boolean insertNote(String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("content", content);
        long result = db.insert(TABLE_NAME, null, values);
        return  result != -1;
    }

    // get all notes
    public Cursor getAllNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    // Update a note
    public boolean updateNote(int id, String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("content", content);
        int rows = db.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(id)});
        return  rows > 0;
    }

    // delete a note
    public boolean deleteNote(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rows = db.delete(TABLE_NAME, "id = ? ", new String[]{String.valueOf(id)});
        return rows > 0;
    }
}
