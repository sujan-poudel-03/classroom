package com.example.classroom;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState == null) {
            if (findViewById(R.id.fragment_list_container) != null) {
                // LANDSCAPE MODE
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_list_container, new TaskListFragment())
                        .commit();

                // Optionally, preload empty TaskDetailsFragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_detail_container, new TaskDetailsFragment())
                        .commit();
            } else {
                // PORTRAIT MODE
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new TaskListFragment())
                        .commit();
            }
        }

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new TaskListFragment())
//                    .commit();
//        }
    }
}