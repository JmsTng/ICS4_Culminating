/*
 * MedicalHistory.java
 * James Tung
 * June 10th, 2024
 */

import java.io.*;
import java.util.ArrayList;

/**
 * This class represents a Medical History for a Patient in a hospital management system.
 * It contains methods to save and print the medical history of a patient.
 */
public class MedicalHistory {
    private final String dir = "/medical-histories/"; // The directory where the medical histories are stored

    private String path; // The path to the file where the Patient's medical history is stored

    private Patient patient; // The patient whose medical history this object represents


    // Constructor //
    /**
     * Constructs a MedicalHistory object.
     * @param patient the patient whose medical history this object will represent
     */
    public MedicalHistory(Patient patient) {
        this.patient = patient;
        this.path = patient.getName() + patient.getId(); // The path is the patient's name and id
    }


    // Methods //
    /**
     * Saves a record of the patient's current state to their medical history.
     * @param date the date the record is being saved
     * @return whether the record was successfully saved or not
     */
    public boolean saveRecord(String date) {
        // Get patient data
        Ward ward = this.patient.getWard();
        ArrayList<Symptom> symptoms = this.patient.getSymptoms();
        ArrayList<Medical> staff = this.patient.getMedicalPersonnel();

        try (BufferedWriter fw = new BufferedWriter(new FileWriter(this.dir + this.path, true))) {
            fw.write(date + "\n"); // Begin file with the date
            fw.newLine();

            // Write the ward the patient is in
            if (ward instanceof Emergency) { fw.write("Emergency"); }
            else if (ward instanceof ICU) { fw.write("ICU"); }
            else if (ward instanceof Oncology) { fw.write("Oncology"); }
            else if (ward instanceof Paedology) { fw.write("Paedology"); }
            else if (ward instanceof Ward) { fw.write("General"); }
            else { fw.write("Not Yet Admitted"); }
            fw.newLine();

            // Output the number of symptoms, followed by the symptoms
            fw.write("%d".formatted(symptoms.size()));
            fw.newLine();
            for (Symptom s : symptoms) {
                fw.write(s.toString());
                fw.newLine();
            }

            // Output the number of staff, followed by the staff
            fw.write("%d".formatted(staff.size()));
            fw.newLine();
            for (Medical s : staff) {
                fw.write(s.getEmployeeNum() + "," + s.getName());
                fw.newLine();
            }

            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while in the process of writing the record.");

            return false;
        }
    }

    /**
     * Prints the patient's medical history to the console.
     */
    public void printRecord() {
        String line;
        String[] parts;
        StringBuilder entry = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(this.dir + this.path))) {
            while ((line = br.readLine()) != null) { // While there are more entries in the MedicalHistory
                entry.append("Date: %s%n".formatted(line)); // Print date
                entry.append("Admitted To: %s%n".formatted(br.readLine())); // Print ward

                // Print all Symptoms
                entry.append("Symptoms:\n");
                for (int i = 0; i < Integer.parseInt(br.readLine()); i++) {
                    parts = br.readLine().split(",");

                    switch (parts[0]) { // Map severity number to the severity label
                        case "1" -> entry.append(" - Mild Symptom: %s".formatted(parts[1]));
                        case "2" -> entry.append(" - Moderate Symptom: %s".formatted(parts[1]));
                        case "3" -> entry.append(" - Severe Symptom: %s".formatted(parts[1]));
                    }

                    if (parts.length == 3) { // Print description on a separate line if applicable
                        entry.append("%n   - %s".formatted(parts[2]));
                    }

                    entry.append("\n");
                }

                // Print all Staff for the Patient
                entry.append("Staff:");
                for (int i = 0; i < Integer.parseInt(br.readLine()); i++) {
                    parts = br.readLine().split(",");

                    if (i > 0) entry.append(", "); // If this is the second staff or later
                    entry.append("%s (%s)".formatted(parts[1], parts[0])); // Print name and employee number
                }

                // Output the record
                System.out.println(entry);

                // Prepare string for next loop if necessary
                entry = new StringBuilder();
                entry.append("\n= = = = = =\n");
            }
        } catch (IOException e) {
            System.out.println("There was an error printing the record.");
        }
    }
}
