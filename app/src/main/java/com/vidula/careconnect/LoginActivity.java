package com.vidula.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView createAccountTextView;
    private Database database; // Declare database object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Set the correct layout file

        // Initialize UI elements from XML layout
        emailEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button);
        createAccountTextView = findViewById(R.id.textView3); // Create account link

        // Initialize Database object
        database = new Database(this);

        // Set up listeners for UI elements
        loginButton.setOnClickListener(v -> handleLogin()); // Login button click listener
        createAccountTextView.setOnClickListener(v -> navigateToSignup()); // Sign up click listener
    }

    // Method to handle login functionality
    private void handleLogin() {
        String email = emailEditText.getText().toString().trim(); // Get email input
        String password = passwordEditText.getText().toString().trim(); // Get password input

        // Validate user input (check for empty fields)
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if the email and password are correct using Database validation
        if (database.validateUser(email, password)) {
            // If login is successful, navigate to DashboardActivity
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent); // Start Dashboard activity
            finish(); // Close the login activity so the user can't go back to it
        } else {
            // If email or password is incorrect, show a toast
            Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to navigate to SignupActivity
    private void navigateToSignup() {
        // Navigate to SignupActivity
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}
