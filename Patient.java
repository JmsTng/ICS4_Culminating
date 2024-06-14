import java.util.ArrayList;
import java.util.Objects;

public class Patient {
    // Constants //
    public final double BASE_COST = 300;

    // Static Variables //
    private static int idCount = 0;

    // Fields //
    private String name;
    private String id;
    private ArrayList<Symptom> symptoms;
    private ArrayList<Medical> medicalPersonnel;
    private Ward ward;


    // Constructor //
    /**
     * Constructs a Patient object.
     * Other than name, all other fields are automatically assigned at creation.
     * @param name the name of the Patient
     */
    public Patient(String name) {
        this.name = name;
        this.id = ("%0" + 5 + "x").formatted(idCount); // Stores 1048576 patients
        idCount++;
        symptoms = new ArrayList<Symptom>();
        medicalPersonnel = new ArrayList<Medical>();
    }


    // Accessors & Mutators //
    /**
     * Retrieve the Patient's name.
     * @return the name of the Patient
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name field.
     * @param name the new name for the Patient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the Patient's ID.
     * @return the ID of the Patient
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieve the Patient's list of assigned Medical staff.
     * @return the staff roster for that Patient
     */
    public ArrayList<Medical> getMedicalPersonnel() {
        return medicalPersonnel;
    }

    /**
     * Retrieve the Patient's list of current symptoms.
     * @return the list of current Symptoms for that Patient
     */
    public ArrayList<Symptom> getSymptoms() {
        return symptoms;
    }

    /**
     * Retrieve the Ward the Patient is in.
     * @return the Ward the Patient is assigned to
     */
    public Ward getWard() {
        return ward;
    }

    /**
     * Retrieve the "severity level"/priority of a patient
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
     * @return number of Symptoms which are Severe
     */
    public int getNumSevere() { // TODO: NEEDS EXTENSIVE TESTING (IDK HOW INSTANCEOF WILL WORK)
        int num = 0;

        for (Symptom s : symptoms) {
            if (s instanceof Severe) num++;
        }

        return num;
    }


    /**
     * Add a Symptom to the Patient's list of Symptoms.
     * @param severity determine which level of severity
     * @param name
     * @param description
     * @return
     */
    public boolean addSymptom(int severity, String name, String description) {
        switch (severity) {
            case 0 -> { symptoms.add(new Mild(name, description)); }
            case 1 -> { symptoms.add(new Moderate(name, description)); }
            case 2 -> { symptoms.add(new Severe(name, description)); }
            default -> {
                System.out.println("Invalid severity level.");
                return false;
            }
        }

        return true;
    }

    public boolean addSymptom(int severity, String name) {
        switch (severity) {
            case 0 -> { symptoms.add(new Mild(name)); }
            case 1 -> { symptoms.add(new Moderate(name)); }
            case 2 -> { symptoms.add(new Severe(name)); }
            default -> {
                System.out.println("Invalid severity level.");
                return false;
            }
        }

        return true;
    }

    public boolean removeSymptom(String name) {
        int i = searchSymptom(name);

        if (i != -1) {
            symptoms.remove(i);
            return true;
        }

        return false;
    }

    public boolean assignWard(Ward ward) {
        if (ward.addPatient(this)) {
            this.ward = ward;
            return true;
        }

        return false;
    }

    public boolean assignMedicalStaff(Medical staff) {
        if (staff.addPatient(this)) {
            this.medicalPersonnel.add(staff);
            return true;
        }

        return false;
    }

    public boolean removeMedicalStaff(Medical staff) {
        if (staff.removePatient(this)) {
            this.medicalPersonnel.remove(staff);
            return true;
        }

        return false;
    }

    public double bill() {
        double cost = BASE_COST;
        for (Symptom s : symptoms) {
            cost += s.getCost();
        }

        return cost;
    }


    public boolean equals(Object obj) {
        if (!(obj instanceof Patient)) return false;

        return this.id.equals(((Patient) obj).getId());
    }

    public boolean matchName(String name) { // addition: for searching
        if (name == null) return false;

        for (int i = 0; i < name.length() && i < this.name.length(); i++) {
            if (this.name.charAt(i) != name.charAt(i)) return false;
        }

        return true;
    }

    public boolean matchId(String id) { // addition: for searching
        return Objects.equals(this.id, id);
    }

    public int compareToName(Patient patient) { // addition: for sorting
        // negative if string precedes
        return this.name.compareToIgnoreCase(patient.getName());
    }

    public int compareToId(Patient patient) { // addition: for sorting
        return this.id.compareToIgnoreCase(patient.getId());
    }

    public int searchSymptom(String name) {
        // Added to assist in finding symptoms to delete and cancers
        for (int i = 0; i < symptoms.size(); i++) {
            if (symptoms.get(i).getName().equals(name)) return i;
        }

        return -1;
    }
}