/*
 * Patient.java
 * James Tung
 * June 6th, 2024
 */

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents a Patient in a hospital management system.
 * It contains information about the patient's name, id, symptoms, medical personnel assigned to them, and the ward they are in.
 */
public class Patient {
    // Constants //
    public final double BASE_COST = 300; // The base cost for a patient's treatment

    // Static Variables //
    private static int idCount = 0; // A counter to generate unique IDs for each patient

    // Fields //
    private String name; // The name of the patient
    private String id; // The unique ID of the patient
    private ArrayList<Symptom> symptoms; // A list of symptoms the patient has
    private ArrayList<Medical> medicalPersonnel; // A list of medical personnel assigned to the patient
    private Ward ward; // The ward the patient is in

    // Constructor //

    /**
     * Constructs a Patient object.
     * Other than name, all other fields are automatically assigned at creation.
     *
     * @param name the name of the Patient
     */
    public Patient(String name) {
        this.name = name;
        this.id = ("%0" + 5 + "x").formatted(idCount); // Stores 1048576 patients
        idCount++; // Increment global count for next patient
        symptoms = new ArrayList<Symptom>();
        medicalPersonnel = new ArrayList<Medical>();
    }

    // Methods //

    /**
     * Retrieve the Patient's name.
     *
     * @return the name of the Patient
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name field.
     *
     * @param name the new name for the Patient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the Patient's ID.
     *
     * @return the ID of the Patient
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieve the Patient's list of assigned Medical staff.
     *
     * @return the staff roster for that Patient
     */
    public ArrayList<Medical> getMedicalPersonnel() {
        return medicalPersonnel;
    }

    /**
     * Retrieve the Patient's list of current symptoms.
     *
     * @return the list of current Symptoms for that Patient
     */
    public ArrayList<Symptom> getSymptoms() {
        return symptoms;
    }

    /**
     * Retrieve the Ward the Patient is in.
     *
     * @return the Ward the Patient is assigned to
     */
    public Ward getWard() {
        return ward;
    }

    /**
     * Retrieve the "severity level"/priority of a patient
     *
     * @return the sum of the triage points of each Symptom
     */
    public int getTriage() {
        int triage = 0;

        for (Symptom s : symptoms) {
            triage += s.getTriage();
        }

        return triage;
    }

    /**
     * Retrieve the number of Severe Symptoms in the Symptom list.
     *
     * @return number of Symptoms which are Severe
     */
    public int getNumSevere() {
        int num = 0;

        for (Symptom s : symptoms) {
            if (s instanceof Severe) num++;
        }

        return num;
    }

    /**
     * String representation of a Patient object.
     *
     * @return the name and id of a Patient
     */
    public String toString() {
        return String.format("%s (%s)", this.name, this.id);
    }

    /**
     * Add a Symptom with a description to the Patient's list of Symptoms.
     *
     * @param severity    determine which level of severity
     * @param name        the name of the Symptom
     * @param description the description of the Symptom
     * @return whether the severity level is valid or not
     */
    public boolean addSymptom(int severity, String name, String description) {
        switch (severity) {
            case 0 -> symptoms.add(new Mild(name, description));
            case 1 -> symptoms.add(new Moderate(name, description));
            case 2 -> symptoms.add(new Severe(name, description));
            default -> {
                System.out.println("Invalid severity level.");
                return false;
            }
        }

        return true;
    }

    /**
     * Add a Symptom without a description to the Patient's list of Symptoms.
     *
     * @param severity determine which level of severity
     * @param name     the name of the Symptom
     * @return whether the severity level is valid or not
     */
    public boolean addSymptom(int severity, String name) {
        switch (severity) {
            case 0 -> symptoms.add(new Mild(name));
            case 1 -> symptoms.add(new Moderate(name));
            case 2 -> symptoms.add(new Severe(name));
            default -> {
                System.out.println("Invalid severity level.");
                return false;
            }
        }

        return true;
    }

    /**
     * Removes a Symptom from the Patient's Symptom list using a name.
     *
     * @param name the name of the Symptom to remove
     * @return whether the Symptom was removed or not
     */
    public boolean removeSymptom(String name) {
        int i = searchSymptom(name);

        if (i != -1) {
            symptoms.remove(i);
            return true;
        }

        return false;
    }

    /**
     * Admits a Patient to a ward.
     *
     * @param ward the Ward to be admitted to
     * @return whether the Patient was successfully admitted or not
     */
    public boolean assignWard(Ward ward) {
        if (this.ward != null) {
            this.ward.removePatient(this.id);
        }

        if (ward.addPatient(this)) {
            this.ward = ward;
            return true;
        }

        return false;
    }

    /**
     * Assigns a medical staff to the patient.
     *
     * @param staff the medical staff to be assigned
     * @return whether the medical staff was successfully assigned or not
     */
    public boolean assignMedicalStaff(Medical staff) {
        if (staff.addPatient(this)) {
            this.medicalPersonnel.add(staff);
            return true;
        }

        return false;
    }

    /**
     * Removes a medical staff from the patient's assigned medical personnel.
     *
     * @param staff the medical staff to be removed
     * @return whether the medical staff was successfully removed or not
     */
    public boolean removeMedicalStaff(Medical staff) {
        if (staff.removePatient(this)) {
            this.medicalPersonnel.remove(staff);
            return true;
        }

        return false;
    }

    /**
     * Calculates the total cost for the patient's treatment.
     *
     * @return the total cost
     */
    public double bill() {
        double cost = BASE_COST;
        for (Symptom s : symptoms) {
            cost += s.getCost();
        }

        return cost;
    }

    /**
     * Checks if the given object is equal to this patient.
     *
     * @param obj the object to be compared
     * @return whether the given object is equal to this patient or not
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Patient)) return false;

        return this.id.equals(((Patient) obj).getId());
    }

    /**
     * Checks if the given name matches the patient's name.
     *
     * @param name the name to be checked
     * @return whether the given name matches the patient's name or not
     */
    public boolean matchName(String name) {
        if (name == null) return false;

        for (int i = 0; i < name.length() && i < this.name.length(); i++) {
            if (this.name.charAt(i) != name.charAt(i)) return false;
        }

        return true;
    }

    /**
     * Checks if the given id matches the patient's id.
     *
     * @param id the id to be checked
     * @return whether the given id matches the patient's id or not
     */
    public boolean matchId(String id) {
        return Objects.equals(this.id, id);
    }

    /**
     * Compares this patient's name with the given patient's name.
     *
     * @param patient the patient to be compared
     * @return the result of the comparison
     */
    public int compareToName(Patient patient) {
        return this.name.compareToIgnoreCase(patient.getName());
    }

    /**
     * Compares this patient's id with the given patient's id.
     *
     * @param patient the patient to be compared
     * @return the result of the comparison
     */
    public int compareToId(Patient patient) {
        return this.id.compareToIgnoreCase(patient.getId());
    }

    /**
     * Searches for a symptom in the patient's symptom list using a name.
     *
     * @param name the name of the symptom to search for
     * @return the index of the symptom in the list, or -1 if not found
     */
    public int searchSymptom(String name) {
        for (int i = 0; i < symptoms.size(); i++) {
            if (symptoms.get(i).getName().toUpperCase().contains(name.toUpperCase())) return i;
        }

        return -1;
    }
}