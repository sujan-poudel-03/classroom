package com.example.classroom.api;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classroom.R;

import org.json.JSONArray;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

public class ApidDemoActivity extends AppCompatActivity {

    Button btnFetch;
    TextView txtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apid_demo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button sendToServerBtn = findViewById(R.id.btnSendToServer);
        btnFetch = findViewById(R.id.btnFetch);
        txtResponse = findViewById(R.id.txtResponse);

        btnFetch.setOnClickListener(v -> fetchUsersFromAPI());

        sendToServerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ApidDemoActivity.this, PostDemoActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Sending to Server Screen", Toast.LENGTH_SHORT).show();
        });
    }

    private void fetchUsersFromAPI() {
        String url = "https://jsonplaceholder.typicode.com/users";
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> parseUserData(response),
                error -> Toast.makeText(this, "Failed to load data", Toast.LENGTH_SHORT).show());

        queue.add(jsonArrayRequest);
    }

    private void parseUserData(JSONArray response) {
        StringBuilder builder = new StringBuilder();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject user = response.getJSONObject(i);
                String name = user.getString("name");
                String email = user.getString("email");

                builder.append("Name: ").append(name).append("\n");
                builder.append("Email: ").append(email).append("\n\n");
            }

            txtResponse.setText(builder.toString());
        } catch (Exception e) {
            txtResponse.setText("Error parsing data.");
            e.printStackTrace();
        }
    }
}