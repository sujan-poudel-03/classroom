package com.example.classroom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // calls the superclass’s onCreate() method to ensure proper initialization of the activity
        super.onCreate(savedInstanceState);
        // This method enables the edge-to-edge feature for this activity. This feature ensures that the app uses the full screen, without leaving space for system UI components like the status bar or navigation bar. It allows the app to use the entire screen area, including areas that were previously reserved for system UI.
        EdgeToEdge.enable(this);
        // This sets the layout resource (activity_second.xml) as the content view of the activity. This is where you define your UI components (like buttons, text views, etc.).
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Retrieve the data passed via the Intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");  // Get the string value passed by the intent

        System.out.println(message);

//        // Display the received message in a TextView
//        TextView textView = findViewById(R.id.textView_message);
//        textView.setText(message);


        // Create an Intent to open a URL in a browser
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);

        // Set the URL using Uri.parse() to properly handle the URL format
        urlIntent.setData(Uri.parse("https://google.com"));

        // Start the activity (which will open the browser or any app that can handle URLs)
        startActivity(urlIntent);
    }
}