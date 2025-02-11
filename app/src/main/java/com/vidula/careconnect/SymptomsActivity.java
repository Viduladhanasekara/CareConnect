package com.vidula.careconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SymptomsActivity extends AppCompatActivity {

    private AutoCompleteTextView symptomInput;
    private SeekBar symptomSeveritySlider;
    private EditText symptomDurationInput;
    private Button saveSymptomButton, exportDataButton;


    private ArrayList<SymptomData> symptomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        // Initialize Views
        symptomInput = findViewById(R.id.symptom_input);
        symptomSeveritySlider = findViewById(R.id.symptom_severity_slider);
        symptomDurationInput = findViewById(R.id.symptom_duration_input);
        saveSymptomButton = findViewById(R.id.save_symptom_button);
        exportDataButton = findViewById(R.id.export_data_button);


        // Initialize the ArrayList
        symptomList = new ArrayList<>();




        // Save Symptom Button OnClickListener
        saveSymptomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSymptomData();
            }
        });

        // Export Data Button OnClickListener
        exportDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exportSymptomData();
            }
        });
    }

    private void saveSymptomData() {
        String symptom = symptomInput.getText().toString();
        int severity = symptomSeveritySlider.getProgress();
        String duration = symptomDurationInput.getText().toString();

        if (symptom.isEmpty() || duration.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Create new SymptomData object
            SymptomData newSymptom = new SymptomData(symptom, severity, duration);

            // Add symptom to the list and notify the adapter to refresh the RecyclerView
            symptomList.add(newSymptom);


            Toast.makeText(this, "Symptom saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private void exportSymptomData() {
        // Implement your export logic here (e.g., save to file or upload to a server)
        Toast.makeText(this, "Data exported!", Toast.LENGTH_SHORT).show();
    }
}
