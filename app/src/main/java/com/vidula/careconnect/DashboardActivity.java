package com.vidula.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button symptomsDiagnosisButton;
    private Button findDoctorButton;
    private Button prescriptionManagerButton;
    private Button healthTipsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard); // Make sure this matches your layout name

        // Initialize the views
        videoView = findViewById(R.id.videoView2);
        symptomsDiagnosisButton = findViewById(R.id.button4);
        findDoctorButton = findViewById(R.id.button7);
        prescriptionManagerButton = findViewById(R.id.button8);
        healthTipsButton = findViewById(R.id.button9);

        // Set up button click listeners
        symptomsDiagnosisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Symptoms Diagnosis Activity
                Intent intent = new Intent(DashboardActivity.this, SymptomsActivity.class);
                startActivity(intent);
            }
        });

        findDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Find Doctor Activity
                Intent intent = new Intent(DashboardActivity.this, DoctorActivity.class);
                startActivity(intent);
            }
        });

        prescriptionManagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Prescription Manager Activity
                Intent intent = new Intent(DashboardActivity.this, PrescriptionManagerActivity.class);
                startActivity(intent);
            }
        });

        healthTipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Health Tips Activity
                Intent intent = new Intent(DashboardActivity.this, HealthTipsActivity.class);
                startActivity(intent);
            }
        });

        // Video View setup (example, setting a video file)
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.medicalanimation01; // Place a sample video in res/raw
        videoView.setVideoPath(videoPath);

        // Set listener for looping the video
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start(); // Restart the video when it finishes
            }
        });

        videoView.start(); // Start video automatically
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume video playback if necessary
        if (!videoView.isPlaying()) {
            videoView.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause video playback when the activity is paused
        if (videoView.isPlaying()) {
            videoView.pause();
        }
    }
}
