package com.example.classroom;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get RecyclerView from layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Set layout manager as GridLayoutManager with 3 columns
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        // Create a list of FruitModel objects to display in grid/list
        List<FruitModel> fruitModelList = new ArrayList<>();
        fruitModelList.add(new FruitModel("Apple",  R.drawable.inserted_image));
        fruitModelList.add(new FruitModel("Banana", R.drawable.inserted_image));
        fruitModelList.add(new FruitModel("Orange", R.drawable.inserted_image));

        // Create adapter and set it to the RecyclerView
        FruitAdapterForRecyclerView adapter = new FruitAdapterForRecyclerView(this, fruitModelList);
        recyclerView.setAdapter(adapter);

    }
}