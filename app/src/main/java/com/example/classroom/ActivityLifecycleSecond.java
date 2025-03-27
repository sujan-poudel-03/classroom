    package com.example.classroom;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class ActivityLifecycleSecond extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_lifecycle_second);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            TextView textView = findViewById(R.id.wrap_activity);
            Button reverseBtn = findViewById(R.id.reverse_btn);

            // Get message from MainActivity
            Intent intent = getIntent();
            if (intent.hasExtra("message")) {
                String receivedMessage = intent.getStringExtra("message");
                textView.setText(receivedMessage);
            }
            // Send result back to MainActivity
            reverseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("result_message", "Hello from SecondActivity!");
                    setResult(RESULT_OK, resultIntent);
                    finish(); // Close activity
                }
            });


        }

    }