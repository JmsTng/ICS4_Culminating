import java.util.ArrayList;

public class Paedology extends Ward {

    public Paedology() {
        super();
        this.baseOperatingCost = 100000;
    }

    public boolean determineSuitability(Patient p) {
        //if patient is a child, they are suitable
        return p instanceof Child;
    }

    public String toString() {
        return "Paedology Ward\nNumber of Staff: " + numMedical + "\nNumber of Patients: " + numPatient + "\nNumber of Equipment: " + this.totalEquipment();
    }
}