package com.example.classroom;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listView;
    String[] countries = {"Nepal", "India", "USA"};
    int[] flags = {R.drawable.inserted_image, R.drawable.inserted_image, R.drawable.inserted_image};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        CustomListAdapter adapter = new CustomListAdapter(this, countries, flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Selected: " + countries[position], Toast.LENGTH_SHORT).show();
        });


    }
}