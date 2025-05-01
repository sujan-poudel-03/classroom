package com.example.classroom;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        ListView listView;
        String[] countries = {"Nepal", "India", "China",
                "USA","Nepal", "India", "China",
                "USA","Nepal", "India", "China",
                "USA","Nepal", "India", "China",
                "USA","Nepal", "India", "China",
                "USA","Nepal", "India", "China",
                "USA"
        };

        ListView listView = findViewById(R.id.listView);

        // Step 1 : create a adapter to convert array to a listview items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        // Step 2 : set the adapter to the listview
        listView.setAdapter(adapter);


        // Step 3 : Handle the item clicks
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selected = countries[position];
            Toast.makeText(this, "Clicked " + selected, Toast.LENGTH_SHORT).show();
        });

    }
}