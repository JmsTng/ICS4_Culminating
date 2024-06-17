import java.util.ArrayList;
import java.util.Objects;

public class Emergency extends Ward {

    public Emergency() {
        super();
        this.baseOperatingCost = 100000;
    }

    public boolean addEquipment(Equipment e, int num) {
        if (this.totalEquipment() < maxEquipment) {
            for (int i = 0; i < numEquipment; i++) {
                if (Objects.equals(equipmentList.get(i).getName(), e.getName())) {
                    equipmentList.get(i).setQuantity(equipmentList.get(i).getQuantity() + num);
                    return true;
                    //return true if equipment was added to existing object within array
                }
            }
            equipmentList.add(new Equipment(this, e.getName(), num, e.getMaintenanceCost()));
            return true;
            //or, return true if new equipment was made and added to array
        }
        return false;
    }

    public boolean determineSuitability(Patient p) {
        //if triage is greater than or equal to 5, they are suitable for this ward
        return p.getTriage() >= 5;
    }

    public String toString() {
        return "Emergency Ward\nNumber of Staff: " + numMedical + "\nNumber of Patients: " + numPatient + "\nNumber of Equipment: " + this.totalEquipment();
    }
}