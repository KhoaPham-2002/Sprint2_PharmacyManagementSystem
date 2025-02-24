import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedicationTrackingSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

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

    // Search patient
    public Patient searchPatientByName(String name) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }
    // Search doctor
    public Doctor searchDoctorByName(String name) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null; 
    }
    // Search medicine
    public Medication searchMedicationByName(String name) {
        for (int i = 0; i < medications.size(); i++) {
            Medication medication = medications.get(i);
            if (medication.getMedName().equalsIgnoreCase(name)) {
                return medication;
            }
        }
        return null; 
    }

    // Add patient
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
    // Add Doctor
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
    // Add Medicine
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

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Remove Patient
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
    // Remove doctor
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
    //Remove medicine
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

    // Edit Doctor
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
    // Edit Doctor
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
                    doctor.setName(newSpecialization);
                }                
                System.out.println("Doctor details updated successfully!");
                return;
            }
        }
        System.out.println("Error: Doctor with ID " + doctorId + " not found.");
    }
    //Edit Medicine
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
                    medication.setDose(newName);
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

    //Generate Report
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

        // System.out.println("Prescriptions:");
    }
    
    //Check if medicine is expired
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
    
}



