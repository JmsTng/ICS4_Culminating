/*
 * Child.java
 * James Tung
 * June 11th, 2024
 */

/**
 * This class represents a Child patient in a hospital management system.
 * It extends the Patient class and overrides some of its methods.
 */
public class Child extends Patient {
    // Constants //
    public final double BASE_COST = 200; // The base cost for a child patient's treatment
    public final int BASE_TRIAGE = 2; // The base triage level for a child patient

    // Constructor //

    /**
     * Constructs a Child object.
     * The name is passed to the superclass constructor.
     *
     * @param name the name of the Child
     */
    public Child(String name) {
        super(name);
    }

    // Methods //

    /**
     * Retrieve the "severity level"/priority of a child patient.
     * This is calculated as the sum of the triage points of each Symptom plus the base triage level for a child patient.
     *
     * @return the triage level of the Child
     */
    public int getTriage() {
        return super.getTriage() + BASE_TRIAGE;
    }

    /**
     * Calculates the total cost for the patient's treatment.
     *
     * @return the total cost
     */
    public double bill() {
        double cost = BASE_COST;
        for (Symptom s : this.getSymptoms()) {
            cost += s.getCost();
        }

        return cost;
    }
}