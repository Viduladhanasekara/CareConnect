package com.vidula.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button signupButton;
    private Database db; // Declare the database instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);  // Set the correct layout

        // Initialize UI components
        usernameEditText = findViewById(R.id.editTextText2);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword2);
        confirmPasswordEditText = findViewById(R.id.editTextTextPassword3);
        signupButton = findViewById(R.id.button3);

        // Initialize the Database helper
        db = new Database(this);

        // Signup button click event
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input data
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Check if all fields are filled
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                }
                // Check if passwords match
                else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Insert the new user data into the database
                    boolean isInserted = db.insertUserData(username, email, password);

                    if (isInserted) {
                        // Show success message
                        Toast.makeText(SignupActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();

                        // Redirect to LoginActivity after successful signup
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();  // Finish the SignupActivity so the user cannot go back
                    } else {
                        // Show error message
                        Toast.makeText(SignupActivity.this, "Error signing up. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
