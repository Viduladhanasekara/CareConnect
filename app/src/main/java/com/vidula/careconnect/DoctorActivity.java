package com.vidula.careconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {

    private Spinner specialtySpinner, consultationTypeSpinner;
    private EditText locationInput, doctorNameInput;
    private SeekBar ratingSeekBar;
    private TextView ratingLabel;
    private Button selectDateButton, searchButton;
    private RecyclerView doctorResultsRecyclerView;
    private DoctorAdapter doctorAdapter;
    private List<String> doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        // Initialize UI components
        specialtySpinner = findViewById(R.id.specialty_spinner);
        consultationTypeSpinner = findViewById(R.id.consultation_type_spinner);
        locationInput = findViewById(R.id.location_input);
        doctorNameInput = findViewById(R.id.doctor_name_input);
        ratingSeekBar = findViewById(R.id.rating_seekbar);
        ratingLabel = findViewById(R.id.rating_label);
        selectDateButton = findViewById(R.id.select_date_button);
        searchButton = findViewById(R.id.search_button);
        doctorResultsRecyclerView = findViewById(R.id.doctor_results_recycler_view);

        // Setup RecyclerView
        doctorList = new ArrayList<>();
        doctorAdapter = new DoctorAdapter(doctorList);
        doctorResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        doctorResultsRecyclerView.setAdapter(doctorAdapter);

        // Populate Specialty Spinner
        String[] specialties = {"General Physician", "Dentist", "Cardiologist", "Dermatologist"};
        ArrayAdapter<String> specialtyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, specialties);
        specialtySpinner.setAdapter(specialtyAdapter);

        // Populate Consultation Type Spinner
        String[] consultationTypes = {"Online", "In-Person"};
        ArrayAdapter<String> consultationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, consultationTypes);
        consultationTypeSpinner.setAdapter(consultationAdapter);

        // Rating SeekBar Listener
        ratingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ratingLabel.setText("Filter by Rating: " + progress + " stars");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Search Button Click Listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performDoctorSearch();
            }
        });
    }

    private void performDoctorSearch() {
        String specialty = specialtySpinner.getSelectedItem().toString();
        String location = locationInput.getText().toString().trim();
        String doctorName = doctorNameInput.getText().toString().trim();
        int rating = ratingSeekBar.getProgress();
        String consultationType = consultationTypeSpinner.getSelectedItem().toString();

        // Simulate search result
        doctorList.clear();
        doctorList.add("Dr. John Doe - " + specialty + " - " + location);
        doctorList.add("Dr. Jane Smith - " + specialty + " - " + location);
        doctorAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Search completed!", Toast.LENGTH_SHORT).show();
    }
}
