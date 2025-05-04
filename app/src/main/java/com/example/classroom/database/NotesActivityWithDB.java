package com.example.classroom.database;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classroom.R;
import com.example.classroom.database.NotesDBHelper;
import android.database.Cursor;

public class NotesActivityWithDB extends AppCompatActivity {

    EditText editId, editTitle, editContent;
    TextView txtDisplay;
    NotesDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes_with_db);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        editId = findViewById(R.id.editId);
        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        txtDisplay = findViewById(R.id.txtDisplay);

        Button btnInsert = findViewById(R.id.btnInsert);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnDisplay = findViewById(R.id.btnDisplay);

        dbHelper = new NotesDBHelper(this);

        // Insert
        btnInsert.setOnClickListener(v -> {
            String title = editTitle.getText().toString();
            String content = editContent.getText().toString();

            if (dbHelper.insertNote(title, content)) {
                Toast.makeText(this, "Note inserted", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Insert failed", Toast.LENGTH_SHORT).show();
            }
        });

        // Update
        btnUpdate.setOnClickListener(v -> {
            String idStr = editId.getText().toString();
            String title = editTitle.getText().toString();
            String content = editContent.getText().toString();

            if (idStr.isEmpty()) {
                Toast.makeText(this, "Enter note ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idStr);

            if (dbHelper.updateNote(id, title, content)) {
                Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show();
            }
        });

        // Delete
        btnDelete.setOnClickListener(v -> {
            String idStr = editId.getText().toString();

            if (idStr.isEmpty()) {
                Toast.makeText(this, "Enter note ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idStr);

            if (dbHelper.deleteNote(id)) {
                Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Delete failed", Toast.LENGTH_SHORT).show();
            }
        });

        // Display
        btnDisplay.setOnClickListener(v -> displayNotes());
    }

    // Method to show all notes
    private void displayNotes() {
        Cursor cursor = dbHelper.getAllNotes();
        StringBuilder builder = new StringBuilder();

        while (cursor.moveToNext()) {
            builder.append("ID: ").append(cursor.getInt(0)).append("\n")
                    .append("Title: ").append(cursor.getString(1)).append("\n")
                    .append("Content: ").append(cursor.getString(2)).append("\n\n");
        }

        txtDisplay.setText(builder.toString());
    }

    // Clear form fields
    private void clearFields() {
            editId.setText("");
            editTitle.setText("");
            editContent.setText("");
    };

}