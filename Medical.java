import java.util.ArrayList; // Allows use of array lists


/**
 * Subclass of staff and a parent class of Doctor. This class
 * holds information for all staff who are trained in handling
 * patients and in medicine.
 * */
public class Medical extends Staff {

    private static int patientCap = 10;
    private int patientNum;
    private ArrayList<Patient> patients;
    private Ward ward;

    /**
     * Creates a new medical staff member and sets up a patient array list
     * that is now ready to hold any and all patients assigned to the medical
     * doctor.
     * */
    public Medical (String name, String employeeNum, double salary, double overtimeSalary) {
        super (name, employeeNum, salary, overtimeSalary);
        patientNum = 0;
        patients = new ArrayList<Patient>();
    }

    public void changePatientCap (int newCap) {
        patientCap = newCap;
    }

    public boolean addPatient (Patient p ) {
        if ((patientNum + 1) < patientCap) {
            patients.add(p);
            return true;
        }
        return false;
    }

    public boolean addPatient (String id, Patient[] patientList) {
        if ((patientNum + 1) < patientCap) {
            for (int i = 0; i < patientList.length; i++) {
                if (patientList[i].getId().equals(id)) {
                    patients.add(patientList[i]);
                    patientNum++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removePatient (String id) {
        for (int i = 0; i < patientNum; i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.remove(i);
                patientNum--;
                return true;
            }
        }
        return false;
    }

    public boolean setWard (Ward w) {
        if (w.addStaff(this)) {
            ward = w;
            return true;
        } else {
            return false;
        }
    }

    public boolean useEquipment(String name, int quant) {
        Equipment e = ward.getEquipment(name);
        if (e == null) return false;

        if ((e.getInUse() + quant) <= e.getQuantity()) {
            e.setInUse(e.getInUse()+quant);
            return true;
        }
        else return false;
    }

    public String toString() {
        return super.toString() + "\nWard: " + _getWardName() + "\nPatients: " + patientNum;
    }

    private String _getWardName() {
        String toReturn;
        if (ward instanceof Oncology) toReturn = "Oncology";
        else if (ward instanceof ICU) toReturn = "ICU";
        else if (ward instanceof Paedology) toReturn = "Paedology";
        else if (ward instanceof Emergency) toReturn = "Emergency";
        else toReturn = "General";
        return toReturn;
    }
}

class Doctor extends Medical {

    private String speciality;

    public static int patientCap = 5;

    public static double overTimeSalary = 0;

    public Doctor (String name, String employeeNum, double salary, double overtimeSalary, String speciality) {
        super (name, employeeNum, salary, overtimeSalary);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String s) {
        speciality = s;
    }

    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality;
    }

}
