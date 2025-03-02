// Name: Khoa Pham
// Project: Sprint 1 Java
// Group: Solo
// Date: 03/02/2025

import java.text.SimpleDateFormat;
import java.util.Date;

public class Medication {
    private int medID; // Unique identifier for the medication
    private String medName; // Name of the medication
    private String dose; // Dosage information
    private int quantity; // Quantity available
    private Date expiryDate; // Expiry date of the medication

    // Constructor to initialize a Medication object
    public Medication(int medID, String medName, String dose, int quantity, Date expiryDate) {
        this.medID = medID;
        this.medName = medName;
        this.dose = dose;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    // Getter and setter methods for medication attributes
    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Returns expiry date as a formatted string (YYYY-MM-DD)
    public String getExpiryDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(expiryDate);
    }

    // Returns a formatted string representation of the Medication object
    @Override
    public String toString() {
        return String.format(
            "Medication ID: %d%nMedication Name: %s%nDose: %s%nQuantity: %d%nExpiry Date: %s%n",
            medID, medName, dose, quantity, getExpiryDateString()
        );
    }
}
