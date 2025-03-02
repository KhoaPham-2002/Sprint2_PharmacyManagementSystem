// Name: Khoa Pham
// Project: Sprint 1 Java
// Group: Solo
// Date: 03/02/2025

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization; // Field to store the doctor's specialization
    private List<Patient> patients; // List of patients assigned to the doctor

    // Constructor to initialize a Doctor object
    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Returns the list of patients assigned to the doctor
    public List<Patient> getPatients() {
        return patients;
    }
    
    // Adds a patient to the doctor's patient list
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Returns the doctor's specialization
    public String getSpecialization() {
        return specialization;
    }

    // Updates the doctor's specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Returns a formatted string representation of the Doctor object
    @Override
    public String toString() {
        return String.format(
            "Doctor ID: %d%nDoctor Name: %s%nDoctor Age: %d%nDoctor Phone Number: %s%nSpecialization: %s%nNumber of Patients: %d%n",
            getId(), getName(), getAge(), getPhoneNumber(), specialization, patients.size()
        );
    }
}
