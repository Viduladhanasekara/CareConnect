package com.vidula.careconnect;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HealthTipsActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set content view first
        setContentView(R.layout.activity_health_tips);

        // Enable edge-to-edge support
        EdgeToEdge.enable(this);

        // Initialize the video view
        videoView = findViewById(R.id.videoView);

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

        // Handle window insets for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
