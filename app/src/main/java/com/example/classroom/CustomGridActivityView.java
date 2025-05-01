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

public class CustomGridActivityView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_grid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] fruits = {"Apple", "Banana", "Orange"};
        int[] images = {R.drawable.inserted_image, R.drawable.inserted_image, R.drawable.inserted_image};

        GridView gridView = findViewById(R.id.custom_grid_view);

        // Define Custom Adapter
        CustomGridAdapter customGridAdapter = new CustomGridAdapter(this, fruits, images);
        gridView.setAdapter(customGridAdapter);

        // For the click or handling click event on each item
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Clicked  " + fruits[position], Toast.LENGTH_SHORT).show();
        });


    }
}