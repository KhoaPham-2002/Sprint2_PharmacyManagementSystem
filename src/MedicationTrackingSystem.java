// Name: Khoa Pham
// Project: Sprint 1 Java
// Group: Solo
// Date: 03/02/2025

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MedicationTrackingSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    // Constructor initializes empty lists for patients, doctors, medications, and prescriptions
    public MedicationTrackingSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    }

    // Getters for the lists
    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    // Search patient by name
    public Patient searchPatientByName(String name) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    // Search doctor by name
    public Doctor searchDoctorByName(String name) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

    // Search medication by name
    public Medication searchMedicationByName(String name) {
        for (int i = 0; i < medications.size(); i++) {
            Medication medication = medications.get(i);
            if (medication.getMedName().equalsIgnoreCase(name)) {
                return medication;
            }
        }
        return null;
    }

    // Add a new patient if the ID doesn't exist
    public void addPatient(Patient patient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == patient.getId()) {
                System.out.println("Error: A patient with this ID already exists. Patient not added.");
                return;
            }
        }
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    // Add a new doctor if the ID doesn't exist
    public void addDoctor(Doctor doctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == doctor.getId()) {
                System.out.println("Error: A doctor with this ID already exists. Doctor not added.");
                return;
            }
        }
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    // Add a new medication if the ID doesn't exist
    public void addMedication(Medication medication) {
        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getMedID() == medication.getMedID()) {
                System.out.println("Error: A medication with this ID already exists. Medication not added.");
                return;
            }
        }
        medications.add(medication);
        System.out.println("Medication added successfully!");
    }

    // Add a new prescription if the ID doesn't exist
    public void addPrescription(Prescription prescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getPrescriptionID() == prescription.getPrescriptionID()) {
                System.out.println("Error: A prescription with this ID already exists. Prescription not added.");
                return;
            }
        }
        prescriptions.add(prescription);
        System.out.println("Prescription added successfully!");
    }

    // Remove a patient by their ID
    public void removePatient(int patientId) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == patientId) {
                patients.remove(i);
                System.out.println("Patient with ID " + patientId + " has been removed.");
                return;
            }
        }
        System.out.println("Error: Patient with ID " + patientId + " not found.");
    }

    // Remove a doctor by their ID
    public void removeDoctor(int doctorId) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == doctorId) {
                doctors.remove(i);
                System.out.println("Doctor with ID " + doctorId + " has been removed.");
                return;
            }
        }
        System.out.println("Error: Doctor with ID " + doctorId + " not found.");
    }

    // Remove medication by its ID
    public void removeMedication(int medicationId) {
        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getMedID() == medicationId) {
                medications.remove(i);
                System.out.println("Medication with ID " + medicationId + " has been removed.");
                return;
            }
        }
        System.out.println("Error: Medication with ID " + medicationId + " not found.");
    }

    // Edit patient details by ID
    public void editPatient(int patientId, Scanner scanner) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == patientId) {
                Patient patient = patients.get(i);
                System.out.println("Editing details for patient: " + patient.getName());
                System.out.println("Press Enter to keep the current value.");
                // Edit Name
                System.out.print("New Name (" + patient.getName() + "): ");
                String newName = scanner.nextLine().trim();
                if (!newName.isEmpty()) {
                    patient.setName(newName);
                }
                // Edit Age
                System.out.print("New Age (" + patient.getAge() + "): ");
                String ageInput = scanner.nextLine().trim();
                if (!ageInput.isEmpty()) {
                    try {
                        int newAge = Integer.parseInt(ageInput);
                        patient.setAge(newAge);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age! Keeping previous value.");
                    }
                }
                // Edit Phone Number
                System.out.print("New Phone Number (" + patient.getPhoneNumber() + "): ");
                String newPhoneNumber = scanner.nextLine().trim();
                if (!newPhoneNumber.isEmpty()) {
                    patient.setPhoneNumber(newPhoneNumber);
                }
                System.out.println("Patient details updated successfully!");
                return;
            }
        }
        System.out.println("Error: Patient with ID " + patientId + " not found.");
    }

    // Edit doctor details by ID
    public void editDoctor(int doctorId, Scanner scanner) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == doctorId) {
                Doctor doctor = doctors.get(i);
                System.out.println("Editing details for doctor: " + doctor.getName());
                System.out.println("Press Enter to keep the current value.");
                // Edit Name
                System.out.print("New Name (" + doctor.getName() + "): ");
                String newName = scanner.nextLine().trim();
                if (!newName.isEmpty()) {
                    doctor.setName(newName);
                }
                // Edit Age
                System.out.print("New Age (" + doctor.getAge() + "): ");
                String ageInput = scanner.nextLine().trim();
                if (!ageInput.isEmpty()) {
                    try {
                        int newAge = Integer.parseInt(ageInput);
                        doctor.setAge(newAge);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age! Keeping previous value.");
                    }
                }
                // Edit Phone Number
                System.out.print("New Phone Number (" + doctor.getPhoneNumber() + "): ");
                String newPhoneNumber = scanner.nextLine().trim();
                if (!newPhoneNumber.isEmpty()) {
                    doctor.setPhoneNumber(newPhoneNumber);
                }
                // Edit Specialization
                System.out.print("New specialization (" + doctor.getSpecialization() + "): ");
                String newSpecialization = scanner.nextLine().trim();
                if (!newSpecialization.isEmpty()) {
                    doctor.setSpecialization(newSpecialization);
                }
                System.out.println("Doctor details updated successfully!");
                return;
            }
        }
        System.out.println("Error: Doctor with ID " + doctorId + " not found.");
    }

    // Edit medication details by ID
    public void editMedication(int medicationId, Scanner scanner) {
        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getMedID() == medicationId) {
                Medication medication = medications.get(i);
                System.out.println("Editing details for medication: " + medication.getMedName());
                System.out.println("Press Enter to keep the current value.");
                // Edit Name
                System.out.print("New Name (" + medication.getMedName() + "): ");
                String newName = scanner.nextLine().trim();
                if (!newName.isEmpty()) {
                    medication.setMedName(newName);
                }
                // Edit Dose
                System.out.print("New Dose (" + medication.getDose() + "): ");
                String newDose = scanner.nextLine().trim();
                if (!newDose.isEmpty()) {
                    medication.setDose(newDose);
                }
                // Edit Quantity
                System.out.print("New Quantity (" + medication.getQuantity() + "): ");
                String quantityInput = scanner.nextLine().trim();
                if (!quantityInput.isEmpty()) {
                    try {
                        int newQuantity = Integer.parseInt(quantityInput);
                        medication.setQuantity(newQuantity);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity! Keeping previous value.");
                    }
                }
                // Edit Expiry Date
                System.out.print("New Expiry Date (" + medication.getExpiryDateString() + ") [yyyy-MM-dd]: ");
                String expiryDateInput = scanner.nextLine().trim();
                if (!expiryDateInput.isEmpty()) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date newExpiryDate = dateFormat.parse(expiryDateInput);
                        medication.setExpiryDate(newExpiryDate);
                    } catch (Exception e) {
                        System.out.println("Invalid date format! Keeping previous value.");
                    }
                }

                System.out.println("Medication details updated successfully!");
                return;
            }
        }
        System.out.println("Error: Medication with ID " + medicationId + " not found.");
    }

    // Generate a system report of all entities (patients, doctors, medications)
    public void generateReport() {
        System.out.println("---------------SYSTEM REPORT---------------");
        System.out.println("PATIENTS");
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            System.out.println("Patient ID: " + patient.getId());
            System.out.println("Patient name: " + patient.getName());
            System.out.println("Patient age: " + patient.getAge());
            System.out.println("Patient phone number: " + patient.getPhoneNumber());
        }
        System.out.println("DOCTORS");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println("Doctor ID: " + doctor.getId());
            System.out.println("Doctor name: " + doctor.getName());
            System.out.println("Doctor age: " + doctor.getAge());
            System.out.println("Doctor phone number: " + doctor.getPhoneNumber());
            System.out.println("Doctor specialization: " + doctor.getSpecialization());
        }
        System.out.println("MEDICATION");
        for (int i = 0; i < medications.size(); i++) {
            Medication medication = medications.get(i);
            System.out.println("Medication ID: " + medication.getMedID());
            System.out.println("Medication name: " + medication.getMedName());
            System.out.println("Medication dose: " + medication.getDose());
            System.out.println("Medication quantity: " + medication.getQuantity());
            System.out.println("Medication expiry date: " + medication.getExpiryDateString());
        }
    }

    // Check if any medications are expired
    public void checkExpiredMedications() {
        System.out.println("\nChecking for expired medications...");
        boolean hasExpiredMeds = false;
        for (int i = 0; i < medications.size(); i++) {
            Medication medication = medications.get(i);
            if (medication.getExpiryDate().before(new Date())) {
                System.out.println("Expired Medication Found: " + medication.getMedName() + " (ID: " + medication.getMedID() + "), Expired on: " + medication.getExpiryDateString());
                hasExpiredMeds = true;
            }
        }
        if (!hasExpiredMeds) {
            System.out.println("No expired medications found.");
        }
    }

    // Add patient to doctor's list
    public void addPatientToDoctor(String doctorName, String patientName) {
        Doctor doctor = searchDoctorByName(doctorName);
        Patient patient = searchPatientByName(patientName);
        if (doctor == null) {
            System.out.println("Error: Doctor not found.");
            return;
        }
        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }
        doctor.addPatient(patient);
        System.out.println("Patient " + patientName + " has been added to Doctor " + doctorName + "'s list.");
    }

    // Accept a new prescription, validate input, and add to system
    public void acceptPrescription(int prescriptionID, String doctorName, String patientName, String medicationName, String expiryDate) {
        Doctor doctor = searchDoctorByName(doctorName);
        Patient patient = searchPatientByName(patientName);
        Medication medication = searchMedicationByName(medicationName);
        if (doctor == null) {
            System.out.println("Error: Doctor not found.");
            return;
        }
        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }
        if (medication == null) {
            System.out.println("Error: Medication not found.");
            return;
        }
        Date prescriptionExpiry = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            prescriptionExpiry = dateFormat.parse(expiryDate);
        } catch (ParseException e) {
            System.out.println("Error: Invalid expiry date.");
            return;
        }
        Prescription prescription = new Prescription(prescriptionID, doctor, patient, medication, prescriptionExpiry);
        addPrescription(prescription);
    }

    // Generate a report for a specific doctor
    public void DoctorScriptReport(String doctorName) {
        Doctor doctor = searchDoctorByName(doctorName);
        if (doctor == null) {
            System.out.println("Error: Doctor not found.");
            return;
        }
        System.out.println("---------------PRESCRIPTION REPORT FOR DOCTOR " + doctor.getName() + "---------------");
        System.out.println("DOCTOR INFORMATION");
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("Number of Patients: " + doctor.getPatients().size());
        System.out.println("\nPATIENTS UNDER " + doctor.getName() + ":");
        for (int i = 0; i < doctor.getPatients().size(); i++) {
            Patient patient = doctor.getPatients().get(i);
            System.out.println("Patient Name: " + patient.getName());
        }
        System.out.println("\nPRESCRIPTIONS ISSUED BY " + doctor.getName() + ":");
        boolean foundPrescription = false;
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getDoctor().equals(doctor)) {
                foundPrescription = true;
                System.out.println("Prescription ID: " + prescription.getPrescriptionID());
                System.out.println("Patient Name: " + prescription.getPatient().getName());
                System.out.println("Medication Name: " + prescription.getMedication().getMedName());
                System.out.println("Prescription Expiry Date: " + prescription.getPrescriptionExpiryString());
                System.out.println("---------------------------------------------------");
            }
        }
        if (!foundPrescription) {
            System.out.println("No prescriptions found for this doctor.");
        }
        System.out.println("---------------------------------------------------");
    }

    // Generate a report for a specific patient
    public void PatientScriptReport(String patientName) {
        Patient patient = searchPatientByName(patientName);
        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }
        System.out.println("---------------PRESCRIPTION REPORT FOR PATIENT " + patient.getName() + "---------------");
        System.out.println("PATIENT INFORMATION");
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Patient Age: " + patient.getAge());
        System.out.println("Patient Phone Number: " + patient.getPhoneNumber());
        System.out.println("\nPRESCRIPTIONS ISSUED TO " + patient.getName() + ":");
        boolean foundPrescription = false;
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getPatient().equals(patient)) {
                foundPrescription = true;
                System.out.println("Prescription ID: " + prescription.getPrescriptionID());
                System.out.println("Doctor Name: " + prescription.getDoctor().getName());
                System.out.println("Medication Name: " + prescription.getMedication().getMedName());
                System.out.println("Prescription Expiry Date: " + prescription.getPrescriptionExpiryString());
                System.out.println("---------------------------------------------------");
            }
        }
        if (!foundPrescription) {
            System.out.println("No prescriptions found for this patient.");
        }
        System.out.println("---------------------------------------------------");
    }

    // Restock medication by asking user for quantity or random amount
    public void restockMedication(Scanner scanner) {
    Medication medication = null;
    while (medication == null) {
        System.out.print("Enter Medication Name: ");
        String medicationName = scanner.nextLine().trim();
        medication = searchMedicationByName(medicationName);
        if (medication == null) {
            System.out.println("Error: Medication not found. Please try again.");
        }
    }
    System.out.println("How would you like to restock?");
    System.out.println("1. Enter a specific amount");
    System.out.println("2. Add a random amount (10-50 units)");
    System.out.print("Enter your choice (1 or 2): ");
    int choice = scanner.nextInt();
    scanner.nextLine(); 
    int restockAmount = 0;
    if (choice == 1) {
        System.out.print("Enter the amount to add: ");
        restockAmount = scanner.nextInt();
        scanner.nextLine(); 
    } else {
        restockAmount = new Random().nextInt(41) + 10;
        System.out.println("Random amount added: " + restockAmount);
    }
    medication.setQuantity(medication.getQuantity() + restockAmount);
    System.out.println("\nRestock successful!");
    System.out.println("Medication: " + medication.getMedName());
    System.out.println("New Quantity: " + medication.getQuantity());
}
        
}



