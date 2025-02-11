package com.vidula.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(ProgressBar.VISIBLE);

        // Simulate some work with the progress bar
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulate loading time
                    Thread.sleep(6000); // Adjust the delay as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // After the loading, navigate to the LoginActivity
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(ProgressBar.INVISIBLE); // Hide the progress bar

                        // Navigate to LoginActivity after the delay
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish(); // Close the SplashActivity
                    }
                });
            }
        }).start();
    }
}
