// Name: Khoa Pham
// Project: Sprint 1 Java
// Group: Solo
// Date: 03/02/2025

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prescription {
    private int prescriptionID; // Unique identifier for the prescription
    private Doctor doctor; // Doctor who issued the prescription
    private Patient patient; // Patient receiving the prescription
    private Medication medication; // Medication prescribed
    private Date prescriptionExpiry; // Expiry date of the prescription

    // Constructor to initialize a Prescription object
    public Prescription(int prescriptionID, Doctor doctor, Patient patient, Medication medication, Date prescriptionExpiry) {
        this.prescriptionID = prescriptionID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = prescriptionExpiry;
    }

    // Getter and setter methods for prescription attributes
    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Date getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    public void setPrescriptionExpiry(Date prescriptionExpiry) {
        this.prescriptionExpiry = prescriptionExpiry;
    }

    // Returns prescription expiry date as a formatted string (YYYY-MM-DD)
    public String getPrescriptionExpiryString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(prescriptionExpiry);
    }

    // Returns a formatted string representation of the Prescription object
    @Override
    public String toString() {
        return String.format(
            "Prescription ID: %d%nDoctor: %s%nPatient: %s%nMedication: %s%nPrescription Expiry: %s%n",
            prescriptionID, doctor.getName(), patient.getName(), medication.getMedName(), getPrescriptionExpiryString()
        );
    }
}
