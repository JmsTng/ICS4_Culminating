import java.util.ArrayList;
import java.util.Objects;

public class ICU extends Ward {

    public ICU() {
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
        //if there are more than 3 severe symptoms, they are suitable
        return p.getNumSevere() > 3;
    }

    public String toString() {
        return "ICU Ward\nNumber of Staff: " + numMedical + "\nNumber of Patients: " + numPatient + "\nNumber of Equipment: " + this.totalEquipment();
    }
}