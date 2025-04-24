package com.example.classroom;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView = findViewById(R.id.gridView);
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Fig", "Grape",
                "Apple", "Banana", "Cherry", "Date", "Fig", "Grape",
                "Apple", "Banana", "Cherry", "Date", "Fig", "Grape"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                fruits
        );

        gridView.setAdapter(adapter);

        // for handling click on item
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            String selected = fruits[position];
            Toast.makeText(this, "Selected: " + selected, Toast.LENGTH_SHORT).show();
        });
    }
}