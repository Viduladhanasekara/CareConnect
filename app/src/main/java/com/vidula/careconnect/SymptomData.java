package com.vidula.careconnect;

public class SymptomData {

    private String symptom;
    private int severity;
    private String duration;

    public SymptomData(String symptom, int severity, String duration) {
        this.symptom = symptom;
        this.severity = severity;
        this.duration = duration;
    }

    public String getSymptom() {
        return symptom;
    }

    public int getSeverity() {
        return severity;
    }

    public String getDuration() {
        return duration;
    }
}
