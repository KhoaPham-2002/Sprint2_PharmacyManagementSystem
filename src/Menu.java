//Name: Khoa Pham
//Project: Sprint 1 Java
//Group: Solo
//Date: 03/02/2025

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        boolean exit = false;

        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do?");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication To The Pharmacy");
            System.out.println("4: Print System Report");
            System.out.println("5: Check If Meds Are Expired");
            System.out.println("6: Process A New Prescription");
            System.out.println("7: Print All Scripts For Specific Doctor");
            System.out.println("8: Restock the drugs in the pharmacy");
            System.out.println("9: Print all scripts for specific patient");
            System.out.println("10: Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addANewPatient(scanner, system);
                    break;
                case 2:
                    addANewDoctor(scanner, system);
                    break;
                case 3:
                    addNewMedicationToPharmacy(scanner, system);
                    break;
                case 4:
                    printPharmacyReport(system);
                    break;
                case 5:
                    checkExpiredMeds(system);
                    break;
                case 6:
                    processANewScript(scanner, system);
                    break;
                case 7:
                    printScriptsForSpecificDoctor(scanner, system);
                    break;
                case 8:
                    restockPharmacyDrugs(scanner, system);
                    break;
                case 9:
                    printAllScriptsForPatientByName(scanner, system);
                    break;
                case 10:
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void addANewPatient(Scanner scanner, MedicationTrackingSystem system) {
        boolean continueManaging = true;
        while (continueManaging) {
            System.out.println("Enter patient details:"); 
            int id;
            while (true) {
                System.out.print("Patient ID: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer for ID.");
                    scanner.nextLine(); 
                }
            }
            System.out.print("Patient name: ");
            String name = scanner.nextLine();
            int age;
            while (true) {
                System.out.print("Patient age: ");
                if (scanner.hasNextInt()) {
                    age = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer for age.");
                    scanner.nextLine(); 
                }
            }
            System.out.print("Patient phone Number: ");
            String phoneNumber = scanner.nextLine();
            Patient newPatient = new Patient(id, name, age, phoneNumber);
            system.addPatient(newPatient); 
            while (true) {
                System.out.println("\nWhat would you like to do next?");
                System.out.println("1. Add another patient");
                System.out.println("2. Remove a patient");
                System.out.println("3. Edit a patient");
                System.out.println("4. Exit patient management");
                System.out.print("Choose an option: ");
                int choice;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); 
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }
                switch (choice) {
                    case 1:
                        break; 
                    case 2:
                        System.out.print("Enter the Patient ID to remove: ");
                        if (scanner.hasNextInt()) {
                            int removeId = scanner.nextInt();
                            scanner.nextLine();
                            system.removePatient(removeId);
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer ID.");
                            scanner.nextLine();
                        }
                        continue; 
                    case 3:
                        System.out.print("Enter the Patient ID to edit: ");
                        if (scanner.hasNextInt()) {
                            int editId = scanner.nextInt();
                            scanner.nextLine();
                            system.editPatient(editId, scanner);
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer ID.");
                            scanner.nextLine();
                        }
                        continue; 
                    case 4:
                        continueManaging = false; 
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1-4.");
                }
                break; 
            }
        }
    }
    
    private static void addANewDoctor(Scanner scanner, MedicationTrackingSystem system) {
        boolean continueManaging = true;
    
        while (continueManaging) {
            System.out.println("Enter doctor details:"); 
            int id;
            while (true) {
                System.out.print("Doctor ID: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer for ID.");
                    scanner.nextLine(); 
                }
            }
            System.out.print("Doctor name: ");
            String name = scanner.nextLine();
            int age;
            while (true) {
                System.out.print("Doctor age: ");
                if (scanner.hasNextInt()) {
                    age = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer for age.");
                    scanner.nextLine(); 
                }
            }
            System.out.print("Doctor phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Doctor specialization: ");
            String specialization = scanner.nextLine();
            Doctor newDoctor = new Doctor(id, name, age, phoneNumber, specialization);
            system.addDoctor(newDoctor); 
            while (true) {
                System.out.println("\nWhat would you like to do next?");
                System.out.println("1. Add another doctor");
                System.out.println("2. Remove a doctor");
                System.out.println("3. Edit a doctor");
                System.out.println("4. Exit doctor management");
                System.out.print("Choose an option: ");
                int choice;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }
                switch (choice) {
                    case 1:
                        break; 
                    case 2:
                        System.out.print("Enter the Doctor ID to remove: ");
                        if (scanner.hasNextInt()) {
                            int removeId = scanner.nextInt();
                            scanner.nextLine();
                            system.removeDoctor(removeId);
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer ID.");
                            scanner.nextLine();
                        }
                        continue; 
                    case 3:
                        System.out.print("Enter the Doctor ID to edit: ");
                        if (scanner.hasNextInt()) {
                            int editId = scanner.nextInt();
                            scanner.nextLine();
                            system.editDoctor(editId, scanner);
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer ID.");
                            scanner.nextLine();
                        }
                        continue; 
                    case 4:
                        continueManaging = false; 
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1-4.");
                }
                break; 
            }
        }
    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTrackingSystem system) {
        boolean continueManaging = true;
        while (continueManaging) {
            System.out.println("Enter medication details:"); 
            int id;
            while (true) {
                System.out.print("Medication ID: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer for ID.");
                    scanner.nextLine(); 
                }
            }
            System.out.print("Medication name: ");
            String name = scanner.nextLine();
            System.out.print("Medication dose: ");
            String dose = scanner.nextLine();
            int quantity;
            while (true) {
                System.out.print("Medication quantity: ");
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer for age.");
                    scanner.nextLine(); 
                }
            }
            Date expiryDate;
            while (true) {
                System.out.print("Medication expiry date (yyyy-MM-dd): ");
                String expiryDateInput = scanner.nextLine().trim();
                
                if (!expiryDateInput.isEmpty()) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        expiryDate = dateFormat.parse(expiryDateInput);
                        break; 
                    } catch (Exception e) {
                        System.out.println("Invalid date format! Please enter the date in the format yyyy-MM-dd.");
                    }
                } else {
                    System.out.println("Expiry date cannot be empty. Please enter a valid date.");
                }
            }            
            Medication newMedication = new Medication(id, name, dose, quantity, expiryDate);
            system.addMedication(newMedication); 
            while (true) {
                System.out.println("\nWhat would you like to do next?");
                System.out.println("1. Add another medication");
                System.out.println("2. Remove a medication");
                System.out.println("3. Edit a medication");
                System.out.println("4. Exit medication management");
                System.out.print("Choose an option: ");
                int choice;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); 
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }
                switch (choice) {
                    case 1:
                        break; 
                    case 2:
                        System.out.print("Enter the Medication ID to remove: ");
                        if (scanner.hasNextInt()) {
                            int removeId = scanner.nextInt();
                            scanner.nextLine();
                            system.removeMedication(removeId);
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer ID.");
                            scanner.nextLine();
                        }
                        continue; 
                    case 3:
                        System.out.print("Enter the Medication ID to edit: ");
                        if (scanner.hasNextInt()) {
                            int editId = scanner.nextInt();
                            scanner.nextLine();
                            system.editMedication(editId, scanner);
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer ID.");
                            scanner.nextLine();
                        }
                        continue; 
                    case 4:
                        continueManaging = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1-4.");
                }
                break; 
            }
        }
    }

    private static void printPharmacyReport(MedicationTrackingSystem system) {
        system.generateReport();
    }

    private static void checkExpiredMeds(MedicationTrackingSystem system) {
        system.checkExpiredMedications();
    }

    private static void processANewScript(Scanner scanner, MedicationTrackingSystem system) {
        // Step 1: Loop to keep asking until valid doctor is found
        Doctor doctor = null;
        while (doctor == null) {
            System.out.print("Enter Doctor's Name: ");
            String doctorName = scanner.nextLine().trim();
            doctor = system.searchDoctorByName(doctorName);  // Search for doctor by name
            if (doctor == null) {
                System.out.println("Error: Doctor not found. Please try again.");
            }
        }
        // Step 2: Loop to keep asking until valid patient is found
        Patient patient = null;
        while (patient == null) {
            System.out.print("Enter Patient's Name: ");
            String patientName = scanner.nextLine().trim();
            patient = system.searchPatientByName(patientName);  // Search for patient by name
            if (patient == null) {
                System.out.println("Error: Patient not found. Please try again.");
            }
        }
        // Step 3: Add Patient to Doctor's List
        system.addPatientToDoctor(doctor.getName(), patient.getName());  // Add patient to doctor's list
        // Step 4: Accept Prescription
        System.out.print("Enter Prescription ID: ");
        int prescriptionID = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter Medication Name: ");
        String medicationName = scanner.nextLine().trim();
        Medication medication = system.searchMedicationByName(medicationName);  // Search for medication
        while (medication == null) {
            System.out.println("Error: Medication not found. Please try again.");
            System.out.print("Enter Medication Name: ");
            medicationName = scanner.nextLine().trim();
            medication = system.searchMedicationByName(medicationName);  // Retry searching medication
        }
        System.out.print("Enter Prescription Expiry Date (yyyy-MM-dd): ");
        String expiryDate = scanner.nextLine().trim();
        // Step 5: Call the acceptPrescription function
        system.acceptPrescription(prescriptionID, doctor.getName(), patient.getName(), medicationName, expiryDate);
        //System.out.println("Prescription successfully added!");
    }
    
    private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTrackingSystem system) {
        Doctor doctor = null;    
        // Loop to keep asking until a valid doctor is found
        while (doctor == null) {
            System.out.print("Enter Doctor's Name: ");
            String doctorName = scanner.nextLine().trim();  
            // Search for the doctor by name
            doctor = system.searchDoctorByName(doctorName); 
            if (doctor == null) {
                System.out.println("Error: Doctor not found. Please try again.");
            }
        }
        // Print the report for the doctor if found
        system.DoctorScriptReport(doctor.getName());
    }
    

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTrackingSystem system) {
        system.restockMedication(scanner);
    }

    private static void printAllScriptsForPatientByName(Scanner scanner, MedicationTrackingSystem system) {
        Patient patient = null;
        // Loop to keep asking until valid patient is found
        while (patient == null) {
            System.out.print("Enter Patient's Name: ");
            String patientName = scanner.nextLine().trim();   
            // Search for the patient by name
            patient = system.searchPatientByName(patientName);   
            if (patient == null) {
                System.out.println("Error: Patient not found. Please try again.");
            }
        }
        // Print the report for the patient if found
        system.PatientScriptReport(patient.getName());
    }
    }
