package com.example.classroom.api;

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

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.classroom.R;

import org.json.JSONException;
import org.json.JSONObject;

public class PostDemoActivity extends AppCompatActivity {

    EditText editTitle, editBody;
    Button btnSend;
    TextView txtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_demo);

        // Setup window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Views
        editTitle = findViewById(R.id.editTitle);
        editBody = findViewById(R.id.editBody);
        btnSend = findViewById(R.id.btnSend);
        txtResponse = findViewById(R.id.txtResponse);

        // Button Click Listener
        btnSend.setOnClickListener(v -> sendDataToServer());
    }

    // Method to send data to server
    private void sendDataToServer() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        // Prepare JSON body
        JSONObject postData = new JSONObject();
        try {
            postData.put("title", editTitle.getText().toString());
            postData.put("body", editBody.getText().toString());
            postData.put("userId", 1);
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

        // Create POST request
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                postData,
                response -> {
                    txtResponse.setText("Response:\n" + response.toString());
                    Toast.makeText(this, "Data sent successfully!", Toast.LENGTH_SHORT).show();
                },
                error -> {
                    txtResponse.setText("Error occurred while sending data.");
                    error.printStackTrace();
                });

        // Add request to queue
        Volley.newRequestQueue(this).add(request);
    }
}
