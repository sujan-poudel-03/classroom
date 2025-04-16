package com.example.classroom;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnOne = findViewById(R.id.btnFragment1);
        Button btnTwo = findViewById(R.id.btnFragment2);

        // Set an onClickListener on the first button
        btnOne.setOnClickListener(v -> {

            // Step 1: Get the FragmentManager to manage fragment operations
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Step 2: Begin a new fragment transaction
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Step 3: Replace the contents of the container with a new instance of FirstFragment
            transaction.replace(R.id.fragmentContainer, new FirstFragment());

            // Step 4: Add the transaction to the back stack so the user can navigate back
            transaction.addToBackStack(null);

            // Step 5: Commit the transaction to apply the changes
            transaction.commit();
        });

        btnTwo.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new SecondFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }
}