package com.vidula.careconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PrescriptionManagerActivity extends AppCompatActivity {

    private EditText prescriptionId, medicationName, dosage, instructions;
    private Button savePrescriptionButton, clearPrescriptionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_manager);

        // Initialize the EditText fields
        prescriptionId = findViewById(R.id.prescriptionId);
        medicationName = findViewById(R.id.medicationName);
        dosage = findViewById(R.id.dosage);
        instructions = findViewById(R.id.instructions);

        // Initialize the buttons
        savePrescriptionButton = findViewById(R.id.savePrescriptionButton);
        clearPrescriptionButton = findViewById(R.id.clearPrescriptionButton2);

        // Set up the save prescription button click listener
        savePrescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePrescription();
            }
        });

        // Set up the clear prescription button click listener
        clearPrescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearPrescription();
            }
        });
    }

    private void savePrescription() {
        // Get the values from the EditText fields
        String prescriptionIdText = prescriptionId.getText().toString().trim();
        String medicationNameText = medicationName.getText().toString().trim();
        String dosageText = dosage.getText().toString().trim();
        String instructionsText = instructions.getText().toString().trim();

        // Check if any field is empty and display a message
        if (prescriptionIdText.isEmpty() || medicationNameText.isEmpty() || dosageText.isEmpty() || instructionsText.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Save the prescription (in this case, just display a toast)
            // You can replace this with actual logic to save the prescription in a database or file
            Toast.makeText(this, "Prescription Saved Successfully!", Toast.LENGTH_LONG).show();

            // Optionally, you could clear the fields after saving
            clearPrescription();
        }
    }

    private void clearPrescription() {
        // Clear all fields
        prescriptionId.setText("");
        medicationName.setText("");
        dosage.setText("");
        instructions.setText("");
    }
}
