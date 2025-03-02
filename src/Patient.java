// Name: Khoa Pham
// Project: Sprint 1 Java
// Group: Solo
// Date: 03/02/2025

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<Medication> medications;  // List to store medications assigned to the patient
    private List<Prescription> prescriptions; // List to store prescriptions assigned to the patient

    // Constructor to initialize a Patient object
    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Adds a medication to the patient's medication list
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Adds a prescription to the patient's prescription list
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Returns the list of medications assigned to the patient
    public List<Medication> getMedications() {
        return medications;
    }

    // Returns the list of prescriptions assigned to the patient
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    // Returns a formatted string representation of the Patient object
    @Override
    public String toString() {
        return String.format("Patient ID: %d%nPatient name: %s%nPatient age: %d%nPatient phone number: %s%nMedications count: %d%nPrescriptions count: %d%n",
        getId(), getName(), getAge(), getPhoneNumber(), medications.size(), prescriptions.size());
    }
}
