import java.util.ArrayList;

/**
 * Subclass of staff and a parent class of Doctor. This class
 * holds information for all staff who are trained in handling
 * patients and in medicine.
 */
public class Medical extends Staff {

    private int patientCap = 10;
    private int patientNum;
    private ArrayList<Patient> patients;
    private Ward ward;

    /**
     * Creates a new medical staff member and sets up a patient array list
     * that is now ready to hold any and all patients assigned to the medical
     * doctor.
     *
     * @param name           The name of the employee housed in a string
     * @param salary         Used to calculate cost to hospital
     * @param overtimeSalary Used to calculate cost to hospital
     */
    public Medical(String name, double salary, double overtimeSalary) {
        super(name, salary, overtimeSalary);
        patientNum = 0;
        patients = new ArrayList<Patient>();
    }

    /**
     * Changes the capacity of patients that the medical staff can hold. The cap
     * is automatically set to 10.
     *
     * @param newCap The new capacity for this doctor
     */
    public void changePatientCap(int newCap) {
        patientCap = newCap;
    }

    /**
     * Adds a patient to the medical practitioner's list and returns whether the
     * addition was successful.
     *
     * @param p The patient to add
     * @return Whether the patient was added
     */
    public boolean addPatient(Patient p) {
        if (patients.contains(p) || p.getWard() != ward) return false;
        if ((patientNum + 1) < patientCap) {
            patients.add(p);
            return true;
        }
        return false;
    }

    /**
     * Adds a patient to the medical practitioner's list and returns whether the
     * addition was successful.
     *
     * @param id          The id of the patient to add
     * @param patientList The list of patients to check for the patient to add
     * @return Whether the patient was added
     */
    public boolean addPatient(String id, ArrayList<Patient> patientList) {
        if ((patientNum + 1) < patientCap) {
            for (Patient patient : patientList) {
                if (patient.getId().equals(id)) {
                    if (patients.contains(patient) || patient.getWard() != ward) return false;
                    patients.add(patient);
                    patientNum++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes a patient from the medical staffs patient list through patient id.
     *
     * @param id The id of the patient to remove
     * @return Whether the patient has been successfully removed
     */
    public boolean removePatient(String id) {
        for (int i = 0; i < patientNum; i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.remove(i);
                patientNum--;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a patient from the medical staffs patient list through patient object.
     *
     * @param p The patient to remove
     * @return Whether the patient has been successfully removed
     */
    public boolean removePatient(Patient p) {
        return patients.remove(p);
    }

    /**
     * Places the medical staff into a specific ward.
     *
     * @param w The ward to be place in
     * @return Whether the assignment was successful
     */
    public boolean assignWard(Ward w) {
        if (w.addStaff(this)) {
            ward = w;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Allows the medical practitioner to use equipment and keep track
     * of how many pieces of equipment is open.
     *
     * @param name     The name of the equipment
     * @param quantity Number of equipment to use
     * @return Whether the staff can use it
     */
    public boolean useEquipment(String name, int quantity) {
        if (ward == null) return false;
        Equipment e = ward.getEquipment(name);
        if (e == null) return false;

        if ((e.getInUse() + quantity) <= e.getQuantity()) {
            e.setInUse(e.getInUse() + quantity);
            return true;
        } else return false;
    }


    /**
     * Returns a string with all the properties of the toString() in Staff
     * plus the ward where the staff member is place and the number of patients
     * they are servicing.
     *
     * @return A string with information on the staff member
     */
    public String toString() {
        return super.toString() + "\nWard: " + getWardName() + "\nPatients: " + patientNum;
    }

    /**
     * Returns the type of ward that the medical staff is in.
     *
     * @return Type of ward
     */
    public String getWardName() {
        String toReturn;
        if (ward instanceof Emergency) toReturn = "Oncology";
        else if (ward instanceof ICU) toReturn = "ICU";
        else if (ward instanceof Paedology) toReturn = "Paedology";
        else if (ward instanceof Oncology) toReturn = "Emergency";
        else if (ward instanceof Ward) toReturn = "General";
        else toReturn = "NO ASSIGNED WARD";
        return toReturn;
    }
}
